package com.example.passwordGenerator.service.impl;
import com.example.passwordGenerator.service.IPasswordService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PasswordServiceImpl implements IPasswordService {

    private EncryptServiceImpl encryptService;

    @Override
    public String generatePassword(String name,String dob) {
        return encryptService.AES_ENCRYPT(name+dob);
    }

    @Override
    public String decryptPassword(String cipherText) {
        return encryptService.AES_DECRYPT(cipherText);
    }


}
