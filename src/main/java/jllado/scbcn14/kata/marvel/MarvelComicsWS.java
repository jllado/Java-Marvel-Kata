package jllado.scbcn14.kata.marvel;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Created by jllado on 26/10/14.
 */
public interface MarvelComicsWS {
    String getComicsByNextWeek() throws IOException;
}
