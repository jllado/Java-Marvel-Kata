package jllado.scbcn14.kata.marvel;

import java.util.List;

/**
 * Created by jllado on 2/11/14.
 */
public class Main {
    public static void main(String[] args) {
        MarvelComicsService service = MarvelComicsFactory.createMarvelComicsService();
        List<Comic> comics = service.getComicsNextWeek();
        for (Comic comic : comics) {
            System.out.println(comic);
        }
    }
}
