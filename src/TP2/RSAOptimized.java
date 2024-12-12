package TP2;

import java.math.BigInteger;

public class RSAOptimized {

    public static void main(String[] args) {
        // Paramètres
        BigInteger p = new BigInteger("104949691472584306351383377199727217487311333083411914914136289336783920577553");
        BigInteger q = new BigInteger("80775074982235463458609054542857236493313137845555861791713025687048052270693");
        BigInteger n = new BigInteger("8477319198060475160183539032069226121316444081247023149946203919427888362496348115375073148197287152599692049776502383464992055145291874997553389655554229");
        BigInteger e = new BigInteger("65537");
        BigInteger d = new BigInteger("2816632215966047371911997229401824904888316063737338130980645899957921007878815570677673132757195403553063149173717309338171166325143975300014970452430273");
        BigInteger c = new BigInteger("4248188385085356308322489425877806133622874303989299423204611058399618329920982253627896503468887288674996346882050427896000671824255845659615662733493991");

        // Déchiffrement naïf
        long startNaive = System.nanoTime();
        BigInteger decryptedNaive = decryptNaive(c, d, n);
        long endNaive = System.nanoTime();
        System.out.println("Message déchiffré (naïf) : " + decryptedNaive);
        System.out.println("Temps d'exécution (naïf) : " + (endNaive - startNaive) + " ns");

        // Déchiffrement optimisé avec CRT
        long startCRT = System.nanoTime();
        BigInteger decryptedCRT = decryptCRT(c, d, p, q);
        long endCRT = System.nanoTime();
        System.out.println("Message déchiffré (CRT) : " + decryptedCRT);
        System.out.println("Temps d'exécution (CRT) : " + (endCRT - startCRT) + " ns");
    }

    public static BigInteger decryptNaive(BigInteger c, BigInteger d, BigInteger n) {
        return c.modPow(d, n);
    }

    public static BigInteger decryptCRT(BigInteger c, BigInteger d, BigInteger p, BigInteger q) {
        BigInteger dp = d.mod(p.subtract(BigInteger.ONE));
        BigInteger dq = d.mod(q.subtract(BigInteger.ONE));

        BigInteger m1 = c.modPow(dp, p);
        BigInteger m2 = c.modPow(dq, q);

        BigInteger qInverse = q.modInverse(p);
        BigInteger h = (m1.subtract(m2)).multiply(qInverse).mod(p);

        return m2.add(h.multiply(q));
    }
}
