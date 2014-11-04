package jllado.scbcn14.kata.marvel;

import java.util.ArrayList;
import java.util.List;

public class MarvelComicsService {
    private final MarvelRepository marvelRepository;

    public MarvelComicsService(MarvelRepository marvelRepository) {
        this.marvelRepository = marvelRepository;
    }

    public List<Comic> getComicsByNextWeek() {
        List<Comic> comicsNextWeek = new ArrayList<>();
        for (Comic comic : marvelRepository.getComicsByNextWeek()) {
            comicsNextWeek.add(comic);
        }
        return comicsNextWeek;
    }
}