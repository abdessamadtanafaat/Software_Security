package TP3_JCA;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;
import java.util.Base64;

public class CryptoTP {

    public static void main(String[] args) throws Exception {
        // **AES Key Generation**
        // Generate a symmetric AES key with 128-bit key size.
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128); // 128-bit key size
        SecretKey aesKey = keyGen.generateKey(); // Generate the AES key
        System.out.println("AES Key (Base64): " + Base64.getEncoder().encodeToString(aesKey.getEncoded()));

        // **AES Encryption and Decryption**
        // Create an Initialization Vector (IV) for AES encryption in CBC mode.
        byte[] ivBytes = new byte[16]; // AES IV is 16 bytes
        SecureRandom random = new SecureRandom(); // Secure random generator
        random.nextBytes(ivBytes); // Fill IV with random bytes
        IvParameterSpec iv = new IvParameterSpec(ivBytes); // Create the IV spec

        // Define the plaintext message to encrypt
        String message = "Message secret";
        System.out.println("Original Message: " + message);

        // Encrypt the message using AES
        String encryptedMessage = encryptAES(message, aesKey, iv);
        System.out.println("Encrypted Message (AES): " + encryptedMessage);

        // Decrypt the encrypted message back to plaintext
        String decryptedMessage = decryptAES(encryptedMessage, aesKey, iv);
        System.out.println("Decrypted Message (AES): " + decryptedMessage);

        // **RSA Key Pair Generation**
        // Generate an RSA key pair (public and private keys)
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(2048); // Use 2048-bit key size for RSA
        KeyPair keyPair = keyPairGen.generateKeyPair(); // Generate the key pair
        PublicKey publicKey = keyPair.getPublic(); // Retrieve the public key
        PrivateKey privateKey = keyPair.getPrivate(); // Retrieve the private key

        System.out.println("Public Key (Base64): " + Base64.getEncoder().encodeToString(publicKey.getEncoded()));
        System.out.println("Private Key generated (not displayed for security).");

        // **Encrypting and Decrypting AES Key with RSA**
        // Encrypt the AES key using the RSA public key
        byte[] encryptedAESKey = encryptRSA(aesKey.getEncoded(), publicKey);
        System.out.println("Encrypted AES Key (RSA): " + Base64.getEncoder().encodeToString(encryptedAESKey));

        // Decrypt the AES key using the RSA private key
        byte[] decryptedAESKey = decryptRSA(encryptedAESKey, privateKey);
        SecretKey recoveredAESKey = new SecretKeySpec(decryptedAESKey, "AES"); // Recreate AES key from decrypted bytes
        System.out.println("Recovered AES Key (Base64): " + Base64.getEncoder().encodeToString(recoveredAESKey.getEncoded()));

        // Compare the original AES key with the recovered key to verify correctness
        if (Base64.getEncoder().encodeToString(aesKey.getEncoded())
                .equals(Base64.getEncoder().encodeToString(recoveredAESKey.getEncoded()))) {
            System.out.println("AES Key successfully recovered!");
        } else {
            System.out.println("Error recovering AES Key.");
        }
    }

    // **AES Encryption**
    // Encrypts a plaintext string using AES in CBC mode with PKCS5Padding.
    public static String encryptAES(String plaintext, SecretKey key, IvParameterSpec iv) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding"); // Use AES with CBC mode and padding
        cipher.init(Cipher.ENCRYPT_MODE, key, iv); // Initialize cipher for encryption
        byte[] encrypted = cipher.doFinal(plaintext.getBytes()); // Perform encryption
        return Base64.getEncoder().encodeToString(encrypted); // Return Base64-encoded encrypted text
    }

    // **AES Decryption**
    // Decrypts a Base64-encoded ciphertext string using AES in CBC mode.
    public static String decryptAES(String ciphertext, SecretKey key, IvParameterSpec iv) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding"); // Use AES with CBC mode and padding
        cipher.init(Cipher.DECRYPT_MODE, key, iv); // Initialize cipher for decryption
        byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(ciphertext)); // Perform decryption
        return new String(decrypted); // Return the plaintext
    }

    // **RSA Encryption**
    // Encrypts data using an RSA public key.
    public static byte[] encryptRSA(byte[] data, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA"); // Use RSA encryption
        cipher.init(Cipher.ENCRYPT_MODE, publicKey); // Initialize cipher for encryption
        return cipher.doFinal(data); // Perform encryption
    }

    // **RSA Decryption**
    // Decrypts data using an RSA private key.
    public static byte[] decryptRSA(byte[] data, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA"); // Use RSA decryption
        cipher.init(Cipher.DECRYPT_MODE, privateKey); // Initialize cipher for decryption
        return cipher.doFinal(data); // Perform decryption
    }
}
