package S3329;

import java.util.Arrays;

public class Reproducer_FP_S3329 {

    public void case_nextBytes() {
        java.security.SecureRandom random = new java.security.SecureRandom();
        byte[] iv = new byte[16];
        random.nextBytes(iv); // "iv" is random thanks to SecureRandom

        try {
            javax.crypto.Cipher c = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5PADDING",
                    java.security.Security.getProvider("SunJCE"));

            javax.crypto.SecretKey key = javax.crypto.KeyGenerator.getInstance("AES").generateKey();
            java.security.spec.AlgorithmParameterSpec paramSpec = new javax.crypto.spec.IvParameterSpec(iv); // Compliant
        } catch (Exception e) {
            // empty on purpose
        }
    }

    public void case_generateSeed() {
        java.security.SecureRandom random = new java.security.SecureRandom();
        byte[] iv = random.generateSeed(16); // "iv" is random thanks to SecureRandom

        try {
            javax.crypto.Cipher c = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5PADDING",
                    java.security.Security.getProvider("SunJCE"));

            javax.crypto.SecretKey key = javax.crypto.KeyGenerator.getInstance("AES").generateKey();
            java.security.spec.AlgorithmParameterSpec paramSpec = new javax.crypto.spec.IvParameterSpec(iv); // Compliant
                                                                                                             // but an
                                                                                                             // issue is
                                                                                                             // raised
        } catch (Exception e) {
            // empty on purpose
        }
    }

}