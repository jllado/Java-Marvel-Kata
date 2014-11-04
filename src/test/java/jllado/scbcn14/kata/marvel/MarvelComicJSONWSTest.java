package jllado.scbcn14.kata.marvel;

import org.junit.Test;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.*;

public class MarvelComicJSONWSTest {
    private MarvelComicJSONWS jsonWS = new MarvelComicJSONWS();

    @Test
    public void get_data() throws Exception {
        assertThat(jsonWS.getComicsByNextWeek().length(), greaterThan(0));

    }
}