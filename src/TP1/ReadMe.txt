README - TP1 : Cryptographie
Introduction
Ce TP vise à explorer et à implémenter plusieurs méthodes de chiffrement classique en cryptographie, principalement le Chiffrement de César et le Chiffrement Mono-Alphabétique. Ces méthodes sont des techniques de chiffrement par substitution où chaque lettre du texte clair est remplacée par une autre lettre suivant une règle spécifique. Vous allez voir comment les implémenter en Java et comprendre leur fonctionnement.

Contenu du TP :
Caesar Cipher (Chiffrement de César) : Une méthode de chiffrement simple qui déplace les lettres de l'alphabet d'un nombre fixe de positions.
Brute Force Caesar Cipher : Une technique de déchiffrement basée sur la recherche exhaustive de toutes les clés possibles dans le cas du chiffrement de César.
Analyse de fréquence (Caesar Frequency Analysis) : Méthode d'attaque du chiffrement de César en utilisant les fréquences de lettres typiques dans la langue (ici l'anglais).
Mono-Alphabetic Cipher (Chiffrement Mono-Alphabétique) : Un autre type de chiffrement de substitution, où chaque lettre de l'alphabet est remplacée par une lettre d'un autre alphabet fixe (généralement défini par une clé).
Exercice 1 : Caesar Cipher (Chiffrement de César)
Le Chiffrement de César est l'une des méthodes les plus anciennes de chiffrement. Il remplace chaque lettre d'un texte par une lettre qui se trouve à un certain nombre de positions plus loin dans l'alphabet. Par exemple, avec une clé de 3, 'A' devient 'D', 'B' devient 'E', et ainsi de suite.

Fonctionnement :
Méthode encrypt : Prend un texte en clair et une clé, et applique un décalage à chaque lettre de l'alphabet.
Méthode decrypt : Prend un texte chiffré et la clé, puis applique l'inverse du décalage pour récupérer le texte en clair.
Exemple :
Texte en clair : "hello world"
Clé : 3
Texte chiffré : "khoor zruog"
Remarque :
Le déchiffrement peut aussi être réalisé avec une clé inverse en utilisant la méthode decrypt.
Exercice 2 : Brute Force Caesar Cipher
L'attaque par Brute Force consiste à tester toutes les clés possibles dans le cas du Chiffrement de César. Étant donné qu'il n'y a que 26 clés possibles (une pour chaque décalage de 0 à 25), cette méthode est très simple à implémenter.

Fonctionnement :
Méthode bruteForce : Effectue un test de déchiffrement pour chaque clé possible (de 1 à 26) et affiche le résultat.
Exemple :
Texte chiffré : "khoor zruog"
Par test exhaustif des 26 clés possibles, le programme affiche tous les textes possibles et nous permet de trouver celui qui est lisible.
Exercice 3 : Caesar Frequency Analysis (Analyse de fréquence pour le Chiffrement de César)
Dans cet exercice, on tente de décrypter un texte chiffré sans connaître la clé en utilisant l'analyse de fréquence. En anglais, certaines lettres apparaissent plus fréquemment que d'autres (par exemple, 'e' est la lettre la plus fréquente). En comparant les fréquences des lettres dans le texte chiffré avec les fréquences connues de l'anglais, on peut estimer la clé.

Fonctionnement :
Méthode calculateFrequencies : Calcule la fréquence des lettres dans le texte chiffré.
Méthode findKey : Compare la fréquence des lettres dans le texte chiffré avec les fréquences standards de l'anglais pour estimer la clé de chiffrement.
Méthode decrypt : Une fois la clé estimée, on peut déchiffrer le texte en appliquant le décalage inverse.
Exercice 4 : Mono-Alphabetic Cipher (Chiffrement Mono-Alphabétique)
Le Chiffrement Mono-Alphabétique est une forme plus complexe de chiffrement de substitution. Contrairement au chiffrement de César, chaque lettre de l'alphabet peut être mappée sur n'importe quelle autre lettre de manière arbitraire, généralement définie par une clé. Cela rend l'attaque par fréquence plus difficile car il n'y a pas de décalage constant.

Fonctionnement :
Méthode encrypt : Prend un texte en clair et une clé pour appliquer une substitution lettre par lettre.
Méthode decrypt : Utilise la clé pour créer une table de déchiffrement et remplacer les lettres chiffrées par leurs correspondances dans l'alphabet original.
Exemple :
Clé : "qwertyuiopasdfghjklzxcvbnm"
Texte en clair : "hello world"
Texte chiffré : "irppw ypfro"
Concepts clés
1. Chiffrement par substitution :
C’est la base des exercices. Chaque lettre du texte est remplacée par une autre lettre selon une règle (décalage fixe dans le chiffrement de César, ou substitution arbitraire dans le chiffrement mono-alphabétique).
2. Analyse de fréquence :
C’est une méthode utilisée pour briser des chiffrages mono-alphabétiques en analysant la fréquence d’apparition des lettres dans le texte chiffré et en la comparant avec les fréquences typiques de la langue cible (ici l'anglais).
3. Brute Force :
L'attaque par brute force consiste à tester toutes les solutions possibles (par exemple, toutes les clés possibles pour un chiffrement de César). Cela fonctionne bien pour les chiffrages simples comme celui de César, où le nombre de clés possibles est limité.