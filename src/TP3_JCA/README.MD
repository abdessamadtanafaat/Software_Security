1.. Overview

CryptoTP is a Java application that demonstrates encryption and decryption using:

AES (Advanced Encryption Standard) - A symmetric encryption algorithm.

RSA (Rivest-Shamir-Adleman) - An asymmetric encryption algorithm for securing the AES key.

2.. This project showcases:

Generating AES and RSA keys.

Encrypting and decrypting a message with AES.

Securing the AES key with RSA encryption and recovery.

3.. Prerequisites

Java Development Kit (JDK) 8 or higher

A Java IDE or text editor

4.. How It Works

AES Key Generation:

A 128-bit AES key is generated.

The key is used to encrypt and decrypt a message.

5.. Initialization Vector (IV):

An IV ensures randomness in AES encryption (CBC mode).

Message Encryption & Decryption (AES):

The plaintext message is encrypted using AES.

The encrypted message is then decrypted back to plaintext.

RSA Key Pair Generation:

A 2048-bit RSA key pair is generated.

The RSA public key encrypts the AES key, and the private key decrypts it.

6.. Key Recovery Verification:

The decrypted AES key is compared with the original to ensure accuracy.

7.. Important Concepts

AES (Advanced Encryption Standard)

Symmetric Encryption: Same key for encryption and decryption.

128-bit Key: Provides high security with relatively fast performance.

8.. Modes of Operation:

CBC (Cipher Block Chaining): Requires an Initialization Vector (IV) for each encryption.

PKCS5Padding: Ensures the data length matches the block size.

RSA (Rivest-Shamir-Adleman)

Asymmetric Encryption: Uses a key pair (public and private keys).

Public Key: Used for encryption.

Private Key: Used for decryption.

RSA is ideal for securing small data (like AES keys) rather than large messages.

Base64 Encoding

Converts binary data into a text format for readability.

Ensures data (like encrypted keys or ciphertext) is displayable in logs.

Key Classes and Methods

Main Class: CryptoTP

Methods:

encryptAES(String plaintext, SecretKey key, IvParameterSpec iv)

Encrypts plaintext using AES.

Returns Base64-encoded ciphertext.

decryptAES(String ciphertext, SecretKey key, IvParameterSpec iv)

Decrypts Base64-encoded ciphertext using AES.

Returns the original plaintext.

encryptRSA(byte[] data, PublicKey publicKey)

Encrypts data using RSA public key.

Returns encrypted byte array.

decryptRSA(byte[] data, PrivateKey privateKey)

Decrypts data using RSA private key.

Returns decrypted byte array.

9.. Explication of the output :
Summary of Output
AES Key Generation:

A 128-bit AES key is generated and displayed in Base64.
Message Encryption & Decryption (AES):

Original message ("Message secret") is encrypted using AES, producing a Base64-encoded ciphertext.
The ciphertext is decrypted back to the original plaintext.
RSA Key Pair Generation:

A 2048-bit RSA key pair is generated.
Public key is displayed in Base64; the private key is securely kept.
Encrypting AES Key with RSA:

AES key is encrypted using the RSA public key and encoded in Base64.
Decrypting AES Key with RSA:

Encrypted AES key is decrypted using the RSA private key.
The recovered AES key matches the original.
Verification:

AES key encryption and decryption are successful, ensuring proper cryptographic functionality.
