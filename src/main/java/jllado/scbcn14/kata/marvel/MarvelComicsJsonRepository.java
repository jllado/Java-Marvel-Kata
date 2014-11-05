package jllado.scbcn14.kata.marvel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MarvelComicsJsonRepository implements MarvelRepository {
    private final MarvelComicsWS marvelComicsWS;
    private final ComicFactory comicFactory;

    public MarvelComicsJsonRepository(MarvelComicsWS marvelComicsWS) {
        this.marvelComicsWS = marvelComicsWS;
        this.comicFactory = new ComicFactory();
    }


    @Override
    public List<Comic> getComicsByNextWeek() {
        try {
            return getComicsFrom(marvelComicsWS.getComicsByNextWeek());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    private List<Comic> getComicsFrom(String comicsNextWeek) throws IOException {
        final List<Comic> comics = new ArrayList<>();
        JSONArray marvelComics = extractMarvelComicsFrom(comicsNextWeek);
        for (int i = 0; i < marvelComics.length(); i++) {
            comics.add(comicFactory.createComic(marvelComics.getJSONObject(i)));
        }

        return comics;
    }

    private JSONArray extractMarvelComicsFrom(String comicsNextWeek) {
        JSONObject marvelData = new JSONObject(comicsNextWeek);
        return marvelData.getJSONObject("data").getJSONArray("results");
    }
}