package com.bitebuddies.util;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Cypher {

    private static final String secretKeyString = "this-is-dummy-secret-key";
    private static final SecretKey secretKey = new SecretKeySpec(secretKeyString.getBytes(), "AES");

    public static String encrypt(String plaintext) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String decrypt(String encryptedText) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
            return new String(decryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        try {
            // Generate a secret key
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128); // You can use 128, 192, or 256 bits key size
            SecretKey secretKey = keyGenerator.generateKey();
            System.out.println("secretKey: " + secretKey);

            String originalText = "12345";

            // Encrypt the data
            String encryptedText = encrypt(originalText);
            System.out.println("Encrypted Text: " + encryptedText);

            // Decrypt the data
            String decryptedText = decrypt(encryptedText);
            System.out.println("Decrypted Text: " + decryptedText);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
