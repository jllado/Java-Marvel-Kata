package jllado.scbcn14.kata.marvel;

import org.apache.commons.io.IOUtils;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MarvelComicsJsonRepositoryTest {


    private MarvelRepository marvelRepository;
    @Mock
    private MarvelComicsWS marvelComicsWS;

    @Before
    public void setUp() throws Exception {
        marvelRepository = new MarvelComicsJsonRepository(marvelComicsWS);
        String jsonMarvelComics = IOUtils.toString(this.getClass().getResourceAsStream("/marvelcomics.json"), "UTF-8");
        when(marvelComicsWS.getComicsByNextWeek()).thenReturn(jsonMarvelComics);
    }

    @Test
    public void get_all_comics() throws Exception {
        List<Comic> comics = marvelRepository.getComicsByNextWeek();

        assertThat(comics.size(), greaterThan(0));
        assertThat(
                comics,
                hasItem(
                        new Comic(
                                "New Warriors (2014) #12",
                                "http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available.jpg",
                                new BigDecimal("3.99"),
                                new DateTime("2014-11-01T00:00:00-0400"))));
    }
}