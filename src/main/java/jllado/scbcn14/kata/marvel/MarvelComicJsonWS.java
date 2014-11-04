package jllado.scbcn14.kata.marvel;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.URL;

/**
 * Created by jllado on 2/11/14.
 */
public class MarvelComicJsonWS implements MarvelComicsWS {

    private static final String URL_COMICS_NEXTWEEK = "http://gateway.marvel.com/v1/public/comics?dateDescriptor=nextWeek&ts=987&apikey=97f295907072a970c5df30d73d1f3816&hash=abfa1c1d42a73a5eab042242335d805d";

    @Override
    public String getComicsByNextWeek() throws IOException {
        return IOUtils.toString(new URL(URL_COMICS_NEXTWEEK), "UTF-8");
    }
}
