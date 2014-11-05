package jllado.scbcn14.kata.marvel;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MarvelComicJsonWSTest {
    private MarvelComicJsonWS jsonWS;

    @Mock
    private MarvelMD5Info marvelMD5Info;
    @Before
    public void setUp() throws Exception {
        when(marvelMD5Info.getTs()).thenReturn(987);
        when(marvelMD5Info.getPublicKey()).thenReturn("97f295907072a970c5df30d73d1f3816");
        when(marvelMD5Info.generateHash()).thenReturn("abfa1c1d42a73a5eab042242335d805d");
        jsonWS = new MarvelComicJsonWS(marvelMD5Info);

    }

    @Test
    public void get_data() throws Exception {
        assertThat(jsonWS.getComicsByNextWeek().length(), greaterThan(0));

    }
}