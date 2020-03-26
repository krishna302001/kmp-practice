package com.kmp.security;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class AES_Encryption {

    static String plainText = "This is a plain text which need to be encrypted by Java AES 256 Algorithm in CBC Mode";

    public static void main(String[] args) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256);

        SecretKey key = keyGenerator.generateKey();

        /*The IV stands for Initialization Vector, it is an arbitrary number which will be used along with
        SecretKey during encryption. The IV adds randomness to the start of the encryption process,
        it is also called as nonce as it will be used only once.
         */
        byte[] IV = new byte[16];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(IV);

        System.out.println("Original Text: " + plainText);

        byte[] cipherText = encrypt(plainText.getBytes(), key, IV);
        System.out.println("Cipher Text: " + cipherText);

        String decryptedText = decrypt(cipherText, key, IV);
        System.out.println("Decrypted Text: " + decryptedText);

    }

    private static byte[] encrypt(byte[] plaintext, SecretKey key, byte[] IV) throws InvalidAlgorithmParameterException,
            InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException,
            IllegalBlockSizeException {
        //Get Cipher Instance
        /*
        Cipher name is composed of 3 parts
            The first part is the name of the algorithm – AES
            The second part is the mode in which the algorithm should be used – CBC
            The third part is the padding scheme which is going to be used – PKCS5Padding */
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

        //Create SecretKeySpec
        SecretKeySpec keySpec = new SecretKeySpec(key.getEncoded(), "AES");

        //Create IvParameterSpec
        IvParameterSpec ivSpec = new IvParameterSpec(IV);

        //Initialize Cipher for ENCRYPT_MODE
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);

        //Perform Encryption
        byte[] cipherText = cipher.doFinal(plaintext);

        return cipherText;
    }

    public static String decrypt(byte[] cipherText, SecretKey key, byte[] IV) throws Exception {
        //Get Cipher Instance
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

        //Create SecretKeySpec
        SecretKeySpec keySpec = new SecretKeySpec(key.getEncoded(), "AES");

        //Create IvParameterSpec
        IvParameterSpec ivSpec = new IvParameterSpec(IV);

        //Initialize Cipher for DECRYPT_MODE
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);

        //Perform Decryption
        byte[] decryptedText = cipher.doFinal(cipherText);

        return new String(decryptedText);
    }
}
