package jllado.scbcn14.kata.marvel;

import org.joda.time.DateTime;
import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigDecimal;

/**
 * Created by jllado on 1/11/14.
 */
public class ComicFactory {

    public Comic createComic(JSONObject marvelComic) {
        return new Comic(
                marvelComic.getString("title"),
                getThumbnailFrom(marvelComic),
                getPriceFrom(marvelComic),
                getReleaseDateFrom(marvelComic));
    }

    private DateTime getReleaseDateFrom(JSONObject marvelComic) {
        JSONArray dates = marvelComic.getJSONArray("dates");
        for (int i = 0; i < dates.length(); i++) {
            JSONObject date = dates.getJSONObject(i);
            if ("onsaleDate".equals(date.getString("type"))) {
                return new DateTime(date.getString("date"));
            }
        }
        return null;
    }

    private BigDecimal getPriceFrom(JSONObject marvelComic) {
        return new BigDecimal(Double.valueOf(marvelComic.getJSONArray("prices").getJSONObject(0).getDouble("price")).toString());
    }

    private String getThumbnailFrom(JSONObject marvelComic) {
        JSONObject thumbnail = marvelComic.getJSONObject("thumbnail");
        return new StringBuilder().append(thumbnail.getString("path")).append(".").append(thumbnail.getString("extension")).toString();
    }
}
