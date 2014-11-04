package jllado.scbcn14.kata.marvel;

import org.joda.time.DateTime;

import java.math.BigDecimal;

/**
 * Created by jllado on 26/10/14.
 */
public class Comic {
    private BigDecimal prize;
    private String thumbnail;
    private String title;
    private DateTime releaseDate;

    public Comic() {
    }

    public Comic(String title, String thumbnail, BigDecimal prize, DateTime releaseDate) {
        this.title = title;
        this.thumbnail = thumbnail;
        this.prize = prize;
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Comic{" +
                "prize=" + prize +
                ", thumbnail='" + thumbnail + '\'' +
                ", title='" + title + '\'' +
                ", releaseDate=" + releaseDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comic comic = (Comic) o;

        if (prize != null ? !prize.equals(comic.prize) : comic.prize != null) return false;
        if (releaseDate != null ? !releaseDate.equals(comic.releaseDate) : comic.releaseDate != null) return false;
        if (thumbnail != null ? !thumbnail.equals(comic.thumbnail) : comic.thumbnail != null) return false;
        if (title != null ? !title.equals(comic.title) : comic.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = prize != null ? prize.hashCode() : 0;
        result = 31 * result + (thumbnail != null ? thumbnail.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (releaseDate != null ? releaseDate.hashCode() : 0);
        return result;
    }

    public boolean betweenReleaseDate(DateTime start, DateTime end) {
        return releaseDate.getMillis() >= start.getMillis() && releaseDate.getMillis() <= end.getMillis();
    }
}
