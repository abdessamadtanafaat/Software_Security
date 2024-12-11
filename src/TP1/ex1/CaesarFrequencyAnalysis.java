package TP1.ex1;

public class CaesarFrequencyAnalysis {
    // Tableau des fréquences des lettres en anglais, utilisé pour comparer avec les fréquences dans le texte chiffré.
    private static final double[] ENGLISH_FREQUENCY = {
            0.082, 0.015, 0.028, 0.043, 0.13, 0.022, 0.02, 0.061,
            0.07, 0.0015, 0.0077, 0.04, 0.024, 0.067, 0.075, 0.019,
            0.00095, 0.06, 0.063, 0.091, 0.028, 0.0098, 0.024, 0.0015,
            0.02, 0.00074
    };

    public static void main(String[] args) {
        // Texte chiffré (texte à analyser)
        String cipherText = "aolylhyladvrpukzvmjyfwavnyhwofpuaopzdvyskjyfwavnyhwofaohadpsszavfv"
                + "byrpkzpzalymyvtylhkpunfvbympsizhukjyfwavnyhwofaohadpsszavwthqvynvcly"
                + "utluazmyvtylhkpunfvbymps|zhufdhfaolrifvmaolulealelyjpz|pzaoly/clyzlvmaolhs"
                + "wohila";

        // Trouve la clé de chiffrement (le décalage dans le chiffrement de César)
        int key = findKey(cipherText);
        System.out.println("Found Key: " + key);

        // Décrypte le texte avec la clé trouvée
        String decryptedText = decrypt(cipherText, key);
        System.out.println("Decrypted Text: " + decryptedText);
    }

    // Fonction qui calcule les fréquences des lettres dans le texte chiffré
    public static double[] calculateFrequencies(String cipherText) {
        double[] frequencies = new double[26]; // Tableau pour stocker les fréquences des 26 lettres
        int totalLetters = 0; // Compteur pour le nombre total de lettres

        // Parcours du texte chiffré pour compter les lettres
        for (char c : cipherText.toCharArray()) {
            if (Character.isLetter(c)) { // Vérifie si le caractère est une lettre
                frequencies[Character.toLowerCase(c) - 'a']++; // Incrémente la fréquence pour la lettre
                totalLetters++; // Incrémente le nombre total de lettres
            }
        }

        // Calcul des fréquences relatives
        for (int i = 0; i < 26; i++) {
            frequencies[i] /= totalLetters; // Divise la fréquence de chaque lettre par le nombre total de lettres
        }

        return frequencies; // Retourne le tableau des fréquences relatives
    }

    // Fonction pour trouver la clé de chiffrement en comparant les fréquences
    public static int findKey(String cipherText) {
        // Calcule les fréquences des lettres dans le texte chiffré
        double[] cipherFrequencies = calculateFrequencies(cipherText);

        // Initialisation des variables pour la comparaison des fréquences
        double closestDifference = Double.MAX_VALUE; // Distance la plus proche, initialisée à une valeur très grande
        int bestKey = 0; // Variable pour stocker la meilleure clé

        // Test de toutes les clés possibles (de 0 à 25, correspondant à un décalage de 0 à 25)
        for (int key = 0; key < 26; key++) {
            double sum = 0.0;

            // Comparaison des fréquences du texte chiffré avec celles de l'anglais
            for (int i = 0; i < 26; i++) {
                // Calcule l'indice décalé en fonction de la clé
                int shiftedIndex = (i + key) % 26;
                sum += ENGLISH_FREQUENCY[i] * cipherFrequencies[shiftedIndex]; // Calcul du produit des fréquences
            }

            // On évalue la différence entre la somme obtenue et la fréquence attendue pour la lettre la plus fréquente (en anglais, 0.065)
            double difference = Math.abs(sum - 0.065); // La valeur attendue pour une bonne correspondance est 0.065

            // Si la différence est plus petite que celle précédemment trouvée, on met à jour la meilleure clé
            if (difference < closestDifference) {
                closestDifference = difference;
                bestKey = key; // Met à jour la clé qui donne la meilleure correspondance
            }
        }

        return bestKey; // Retourne la meilleure clé trouvée
    }

    // Fonction pour déchiffrer le texte avec la clé trouvée
    public static String decrypt(String cipherText, int key) {
        StringBuilder result = new StringBuilder(); // Pour construire le texte déchiffré

        // Parcours de chaque caractère du texte chiffré
        for (char c : cipherText.toCharArray()) {
            if (Character.isLetter(c)) { // Si le caractère est une lettre
                char base = Character.isUpperCase(c) ? 'A' : 'a'; // Si la lettre est en majuscule ou minuscule
                // Applique le décalage inverse pour déchiffrer la lettre
                result.append((char) ((c - base - key + 26) % 26 + base));
            } else {
                result.append(c); // Si ce n'est pas une lettre (par exemple un espace), on l'ajoute tel quel
            }
        }

        return result.toString(); // Retourne le texte déchiffré
    }
}
