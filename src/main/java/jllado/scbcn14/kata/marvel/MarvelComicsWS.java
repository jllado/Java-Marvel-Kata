package jllado.scbcn14.kata.marvel;

import java.io.IOException;
import java.net.MalformedURLException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by jllado on 26/10/14.
 */
public interface MarvelComicsWS {
    String getComicsNextWeek() throws IOException, NoSuchAlgorithmException;
}
