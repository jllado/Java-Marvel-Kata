package jllado.scbcn14.kata.marvel;

import java.security.NoSuchAlgorithmException;

/**
 * Created by jllado on 4/11/14.
 */
public class MarvelMD5Info {
    private final int ts;
    private final String privateKey;
    private final String publicKey;
    private String hash = "";

    private MarvelMD5Generator marvelMD5Generator;

    public MarvelMD5Info(int ts, String privateKey, String publicKey) {
        this.ts = ts;
        this.privateKey = privateKey;
        this.publicKey = publicKey;
        marvelMD5Generator = new MarvelMD5Generator();
    }

    public String generateHash() throws NoSuchAlgorithmException {
        if ("".equals(hash)) {
            hash = marvelMD5Generator.generate(ts,privateKey, publicKey);
        }
        return hash;
    }

    public int getTs() {
        return ts;
    }

    public String getPublicKey() {
        return publicKey;
    }
}
