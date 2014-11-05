package jllado.scbcn14.kata.marvel;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by jllado on 4/11/14.
 */
public class MarvelMD5Generator {
    public String generate(int ts, String privateKey, String apiKey) throws NoSuchAlgorithmException {
        String key = ts + privateKey + apiKey;
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(key.getBytes());

        byte byteData[] = md.digest();

        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
    }
}
