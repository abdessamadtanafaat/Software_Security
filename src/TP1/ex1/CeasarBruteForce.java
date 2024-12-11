package TP1.ex1;

public class CeasarBruteForce {
    // Méthode qui effectue une attaque par force brute pour déchiffrer un texte chiffré avec un chiffrement de César
    public static void bruteForce(String cipherText) {
        System.out.println("Possible decryptions:");

        // Teste toutes les clés possibles, de 1 à 26 (pour un chiffrement de César avec un alphabet de 26 lettres)
        for (int key = 1; key <= 26; key++) {
            // Pour chaque clé, appelle la méthode decrypt de la classe CeasarCipher pour déchiffrer le texte
            String decrypted = CeasarCipher.decrypt(cipherText, key);
            // Affiche le résultat du déchiffrement avec la clé correspondante
            System.out.println("Key " + key + ": " + decrypted);
        }
    }

    public static void main(String[] args) {
        // Exemple de texte chiffré (texte "hello world" avec un chiffrement de César et une clé de 3)
        String cipherText = "khoor zruog";

        // Appelle la méthode bruteForce pour essayer de déchiffrer le texte avec toutes les clés possibles
        bruteForce(cipherText);
    }
}
