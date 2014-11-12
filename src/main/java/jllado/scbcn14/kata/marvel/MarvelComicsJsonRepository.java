package jllado.scbcn14.kata.marvel;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.List;

public class MarvelComicsJsonRepository implements ComicRepository {
    private final MarvelComicsWS marvelComicsWS;
    private final ComicListMapper comicListMapper;

    public MarvelComicsJsonRepository(MarvelComicsWS marvelComicsWS) {
        this.marvelComicsWS = marvelComicsWS;
        this.comicListMapper = new ComicListMapper();
    }


    @Override
    public List<Comic> getComicsNextWeek() {
        try {
            return comicListMapper.getFrom(marvelComicsWS.getComicsNextWeek());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

}