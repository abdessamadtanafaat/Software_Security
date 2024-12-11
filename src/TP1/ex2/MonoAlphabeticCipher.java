package TP1.ex2;

import java.util.HashMap;
import java.util.Map;

public class MonoAlphabeticCipher {

    // Méthode pour chiffrer un texte en utilisant un chiffrement mono-alphabétique
    public static String encrypt(String cipherText, String key) {
        // Création d'une carte de substitution pour le chiffrement
        Map<Character, Character> encryptionMap = new HashMap<>();
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray(); // L'alphabet de référence

        // Remplir la map de chiffrement avec les correspondances entre l'alphabet et la clé
        for (int i = 0; i < 26; i++) {
            encryptionMap.put(alphabet[i], key.charAt(i)); // L'alphabet original est mappé à la clé
        }

        // Construction du texte chiffré
        StringBuilder encrypted = new StringBuilder();
        for (char c : cipherText.toCharArray()) {
            if (Character.isLetter(c)) { // Si le caractère est une lettre
                char base = Character.isLowerCase(c) ? 'a' : 'A';  // Détecte si c'est une lettre minuscule ou majuscule
                // Substitue la lettre par la lettre correspondante dans la clé, en respectant la casse
                encrypted.append(encryptionMap.get(Character.toLowerCase(c)));
            } else {
                // Si ce n'est pas une lettre, on l'ajoute tel quel (pour les espaces, chiffres, etc.)
                encrypted.append(c);
            }
        }
        return encrypted.toString(); // Retourne le texte chiffré sous forme de chaîne
    }

    // Méthode pour déchiffrer un texte en utilisant un chiffrement mono-alphabétique
    public static String decrypt(String cipherText, String key) {
        // Création d'une carte de substitution pour le déchiffrement
        Map<Character, Character> decryptionMap = new HashMap<>();
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray(); // L'alphabet de référence

        // Construire la table de déchiffrement : clé -> alphabet
        for (int i = 0; i < 26; i++) {
            decryptionMap.put(key.charAt(i), alphabet[i]);  // Inverser la substitution par rapport à l'encryption
        }

        // Construction du texte déchiffré
        StringBuilder decrypted = new StringBuilder();
        for (char c : cipherText.toCharArray()) {
            if (Character.isLetter(c)) { // Si le caractère est une lettre
                char base = Character.isLowerCase(c) ? 'a' : 'A';  // Détecte la casse (minuscule ou majuscule)
                // Substitue la lettre chiffrée par la lettre correspondante dans l'alphabet original
                decrypted.append(decryptionMap.get(Character.toLowerCase(c)));
            } else {
                // Si ce n'est pas une lettre, on l'ajoute tel quel
                decrypted.append(c);  // Conserver les caractères non alphabétiques comme des espaces, des chiffres, etc.
            }
        }
        return decrypted.toString(); // Retourne le texte déchiffré sous forme de chaîne
    }

    public static void main(String[] args) {
        // Exemple d'utilisation du chiffrement mono-alphabétique
        String key = "qwertyuiopasdfghjklzxcvbnm"; // Clé de substitution (un alphabet mélangé)
        String plainText = "hello world"; // Texte en clair à chiffrer

        // Chiffrement du texte en utilisant la clé
        String cipherText = encrypt(plainText, key);
        System.out.println("Encrypted: " + cipherText);  // Affiche le texte chiffré

        // Déchiffrement du texte en utilisant la même clé
        String decryptedText = decrypt(cipherText, key);
        System.out.println("Decrypted: " + decryptedText);  // Affiche le texte déchiffré (devrait être "hello world")
    }
}
