package jllado.scbcn14.kata.marvel;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;

/**
 * Created by jllado on 2/11/14.
 */
public class MarvelComicJsonWS implements MarvelComicsWS {

    private static final String BASEURL_COMICS_NEXTWEEK = "http://gateway.marvel.com/v1/public/comics?dateDescriptor=nextWeek";
    private final MarvelMD5Info marvelMD5Info;

    public MarvelComicJsonWS(MarvelMD5Info marvelMD5Info) {
        this.marvelMD5Info = marvelMD5Info;
    }

    @Override
    public String getComicsByNextWeek() throws IOException, NoSuchAlgorithmException {
        return IOUtils.toString(new URL(generateUrl()), "UTF-8");
    }

    private String generateUrl() throws NoSuchAlgorithmException {
        final StringBuilder url = new StringBuilder();
        url.append(BASEURL_COMICS_NEXTWEEK)
                .append("&ts=").append(marvelMD5Info.getTs())
                .append("&apikey=").append(marvelMD5Info.getPublicKey())
                .append("&hash=").append(marvelMD5Info.generateHash());
        return url.toString();
    }
}
