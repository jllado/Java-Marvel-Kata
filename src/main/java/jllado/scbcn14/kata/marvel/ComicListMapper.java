package jllado.scbcn14.kata.marvel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ComicListMapper {

    private ComicMapper comicMapper;

    public ComicListMapper() {
        this.comicMapper = new ComicMapper();
    }

    public List<Comic> getFrom(String comicsNextWeek) throws IOException {
        final List<Comic> comics = new ArrayList<>();
        JSONArray marvelComics = getJSONArrayFrom(comicsNextWeek);
        for (int i = 0; i < marvelComics.length(); i++) {
            comics.add(comicMapper.getFrom(marvelComics.getJSONObject(i)));
        }

        return comics;
    }

    private JSONArray getJSONArrayFrom(String comicsNextWeek) {
        JSONObject marvelData = new JSONObject(comicsNextWeek);
        return marvelData.getJSONObject("data").getJSONArray("results");
    }

}