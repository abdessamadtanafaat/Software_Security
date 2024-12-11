package TP1.ex1;

public class CeasarCipher {

    // Méthode pour chiffrer un texte avec un chiffrement de César
    public static String encrypt(String text , int key){
        StringBuilder encrypted = new StringBuilder();  // Utilisation de StringBuilder pour construire le texte chiffré
        key = key % 26;  // Assure que la clé est dans la plage de 0 à 25 (puisque l'alphabet a 26 lettres)

        // Parcourt chaque caractère du texte
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {  // Vérifie si le caractère est une lettre
                // Détermine si la lettre est en minuscule ou majuscule
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                // Applique le décalage (chiffrement) : (c - base) donne la position dans l'alphabet,
                // on ajoute la clé, puis on applique % 26 pour revenir dans l'intervalle de 0 à 25,
                // puis on réajuste pour la position de la lettre ('a' ou 'A').
                encrypted.append((char) ((c - base + key) % 26 + base));
            } else {
                // Si ce n'est pas une lettre (par exemple un espace ou un chiffre), on le laisse tel quel
                encrypted.append(c);
            }
        }

        return encrypted.toString(); // Retourne le texte chiffré sous forme de chaîne
    }

    // Méthode pour déchiffrer un texte en utilisant un chiffrement de César
    public static String decrypt(String text , int key){
        // Le déchiffrement est simplement l'inverse du chiffrement. On applique la clé inverse en soustrayant
        // la clé de 26 pour obtenir un décalage inverse.
        return encrypt(text, 26 - (key % 26));  // On utilise la méthode encrypt avec la clé inverse pour déchiffrer
    }

    public static void main(String[] args) {
        // Exemple de texte en clair à chiffrer et clé de chiffrement
        String plainText = "hell8o world";  // Texte avec un chiffre et un espace
        int key = 3;  // Clé de chiffrement (décalage de 3)

        // Chiffrement du texte en utilisant la méthode encrypt
        String cipherText = encrypt(plainText, key);
        System.out.println("Encrypted: " + cipherText);  // Affiche le texte chiffré

        // Déchiffrement du texte en utilisant la méthode decrypt
        String decryptedText = decrypt(cipherText, key);
        System.out.println("Decrypted: " + decryptedText);  // Affiche le texte déchiffré
    }
}
