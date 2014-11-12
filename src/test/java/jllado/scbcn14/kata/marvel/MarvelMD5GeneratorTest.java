package jllado.scbcn14.kata.marvel;

import org.junit.Before;
import org.junit.Test;

import java.util.ResourceBundle;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MarvelMD5GeneratorTest {
    private ResourceBundle marvelKataProperties;


    @Before
    public void setUp() throws Exception {
        marvelKataProperties = ResourceBundle.getBundle("marvelkata");
    }

    @Test
    public void generate_MarvelMD5Info() throws Exception {
        int ts = 987;
        String privateKey = marvelKataProperties.getString("marvel.privatekey");
        String publicKey = marvelKataProperties.getString("marvel.publickey");
        MarvelMD5Info marvelMD5Info = new MarvelMD5Info(ts, privateKey, publicKey);
        assertThat(marvelMD5Info.generateHash(), is("feb31cfde2a16643a425c53d183aee16"));
    }
}