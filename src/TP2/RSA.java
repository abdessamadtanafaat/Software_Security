package TP2;

import java.math.BigInteger;

public class RSA {
    public static void main(String[] args) {
        // Données de test
        BigInteger p = BigInteger.valueOf(3);
        BigInteger q = BigInteger.valueOf(11);
        BigInteger n = p.multiply(q); // n = p * q
        BigInteger e = BigInteger.valueOf(7); // Clé publique
        BigInteger d = BigInteger.valueOf(3); // Clé privée
        BigInteger m = BigInteger.valueOf(2); // Message clair
        BigInteger C = BigInteger.valueOf(29); // Chiffre donné

        // Chiffrement
        BigInteger ciphertext = encrypt(m, e, n);
        System.out.println("Chiffrement : " + ciphertext); // Résultat attendu : 29

        // Déchiffrement
        BigInteger decryptedMessage = decrypt(C, d, n);
        System.out.println("Déchiffrement : " + decryptedMessage); // Résultat attendu : 2
    }

    public static BigInteger encrypt(BigInteger m, BigInteger e, BigInteger n) {
        return m.modPow(e, n);
    }

    public static BigInteger decrypt(BigInteger c, BigInteger d, BigInteger n) {
        return c.modPow(d, n);
    }
}
