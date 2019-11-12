package com.example.concord.services;

import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.stereotype.Component;

@Component
public class Encryptor {

    private String password = "Here is the password";
    private String salt = KeyGenerators.string().generateKey();
    private TextEncryptor encryptor = Encryptors.text(password, salt);

    public String encryptText (String textToEncrypt) {
        return encryptor.encrypt(textToEncrypt);
    }

    public String decryptText (String cipherText) {
        return encryptor.decrypt(cipherText);
    }

}
