package com.example.passwordGenerator.service;

public interface IPasswordService {

    String generatePassword(String name,String dob);

    String decryptPassword(String cipherText);

}
