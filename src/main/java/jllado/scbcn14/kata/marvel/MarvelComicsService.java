package jllado.scbcn14.kata.marvel;

import java.util.List;

public class MarvelComicsService {
    private final ComicRepository comicRepository;

    public MarvelComicsService(ComicRepository comicRepository) {
        this.comicRepository = comicRepository;
    }

    public List<Comic> getComicsNextWeek() {
        return comicRepository.getComicsNextWeek();
    }
}