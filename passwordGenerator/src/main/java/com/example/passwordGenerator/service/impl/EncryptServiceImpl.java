package com.example.passwordGenerator.service.impl;

import com.example.passwordGenerator.service.IEncryptionService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.SecureRandom;
import java.util.Base64;

@Service
@RequiredArgsConstructor
public class EncryptServiceImpl implements IEncryptionService {

    @Value("${api.aes_gcm.key}")
    private String key;

    @Override
    public String AES_ENCRYPT(String plainText) {
        String result = "";
        try {
            SecureRandom random = new SecureRandom();
            byte[] iv = new byte[12]; // 96-bit IV
            random.nextBytes(iv);

            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
            GCMParameterSpec gcmParams = new GCMParameterSpec(128, iv);

            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, gcmParams);

            byte[] plaintextBytes = plainText.getBytes();
            byte[] ciphertext = cipher.doFinal(plaintextBytes);

            // Concatenate the IV and ciphertext
            ByteBuffer byteBuffer = ByteBuffer.allocate(iv.length + ciphertext.length);
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
            byteBuffer.put(iv);
            byteBuffer.put(ciphertext);
            result = Base64.getEncoder().encodeToString(byteBuffer.array());
        }catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public String AES_DECRYPT(String cipherText) {
        String result = "";
        try {
            // Convert the base64 encoded string back to bytes
            System.out.println(cipherText);
            byte[] rawBytes = Base64.getDecoder().decode(cipherText.replace(" ", "+"));

            // Split the IV and ciphertext
            ByteBuffer byteBuffer = ByteBuffer.wrap(rawBytes);
            byte[] iv = new byte[12];
            byteBuffer.get(iv);
            byte[] ciphertext = new byte[rawBytes.length - iv.length];
            byteBuffer.get(ciphertext);

            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
            GCMParameterSpec gcmParams = new GCMParameterSpec(128, iv);

            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(Cipher.DECRYPT_MODE, keySpec, gcmParams);

            byte[] plaintextBytes = cipher.doFinal(ciphertext);
            result = new String(plaintextBytes);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
