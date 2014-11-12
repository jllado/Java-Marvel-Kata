package jllado.scbcn14.kata.marvel;

import java.util.ResourceBundle;

/**
 * Created by jllado on 2/11/14.
 */
public class MarvelComicsFactory {
    public static MarvelComicsService createMarvelComicsService() {
        ResourceBundle properties = ResourceBundle.getBundle("marvelkata");

        String privateKey = properties.getString("marvel.privatekey");
        String publicKey = properties.getString("marvel.publickey");
        MarvelMD5Info marvelMD5Info = new MarvelMD5Info(987, privateKey, publicKey);
        MarvelComicsWS marvelComicsWS = new MarvelComicJsonWS(properties.getString("marvel.url"), marvelMD5Info);
        ComicRepository comicRepository = new MarvelComicsJsonRepository(marvelComicsWS);
        MarvelComicsService service = new MarvelComicsService(comicRepository);
        return service;
    }
}
