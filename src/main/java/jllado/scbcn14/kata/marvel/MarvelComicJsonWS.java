package jllado.scbcn14.kata.marvel;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;

/**
 * Created by jllado on 2/11/14.
 */
public class MarvelComicJsonWS implements MarvelComicsWS {

    private final String url;
    private final MarvelMD5Info marvelMD5Info;

    public MarvelComicJsonWS(String url, MarvelMD5Info marvelMD5Info) {
        this.url = url;
        this.marvelMD5Info = marvelMD5Info;
    }

    @Override
    public String getComicsNextWeek() throws IOException, NoSuchAlgorithmException {
        return IOUtils.toString(new URL(generateUrl()), "UTF-8");
    }

    private String generateUrl() throws NoSuchAlgorithmException {
        final StringBuilder urlWithKeyInfo = new StringBuilder();
        urlWithKeyInfo.append(this.url)
                .append("&ts=").append(marvelMD5Info.getTs())
                .append("&apikey=").append(marvelMD5Info.getPublicKey())
                .append("&hash=").append(marvelMD5Info.generateHash());
        return urlWithKeyInfo.toString();
    }
}
