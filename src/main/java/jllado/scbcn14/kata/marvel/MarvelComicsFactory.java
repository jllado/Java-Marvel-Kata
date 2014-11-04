package jllado.scbcn14.kata.marvel;

/**
 * Created by jllado on 2/11/14.
 */
public class MarvelComicsFactory {
    public static MarvelComicsService createMarvelComicsService() {
        MarvelComicsWS marvelComicsWS = new MarvelComicJSONWS();
        MarvelRepository marvelRepository = new MarvelComicsJsonRepository(marvelComicsWS);
        MarvelComicsService service = new MarvelComicsService(marvelRepository);
        return service;
    }
}
