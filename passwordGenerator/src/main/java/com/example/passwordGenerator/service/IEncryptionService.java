package com.example.passwordGenerator.service;

public interface IEncryptionService {
    String AES_ENCRYPT(String plainText);
    String AES_DECRYPT(String cipherText);
}
