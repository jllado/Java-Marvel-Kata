package jllado.scbcn14.kata.marvel;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MarvelComicsServiceTest {


    private MarvelComicsService marvelService;
    @Mock
    private ComicRepository comicRepository;
    private static final Comic comic1 = new Comic("Titulo2", "Thumbnail2", new BigDecimal("20"), new DateTime(2014, 11, 4, 12, 0, 0, 0));
    private static final Comic comic2 = new Comic("Titulo1", "Thumbnail1", new BigDecimal("20"), new DateTime(2014, 11, 1, 12, 0, 0, 0));

    @Before
    public void setUp() throws Exception {
        marvelService = new MarvelComicsService(comicRepository);
    }

    @Test
    public void get_comics_by_week() throws Exception {
        when(comicRepository.getComicsNextWeek()).thenReturn(createComics());

        List<Comic> comics = marvelService.getComicsNextWeek();

        assertThat(comics.size(), greaterThan(0));
        assertThat(comics, containsInAnyOrder(comic1, comic2));
    }

    private List<Comic> createComics() {
        return Arrays.asList(comic1, comic2);
    }
}