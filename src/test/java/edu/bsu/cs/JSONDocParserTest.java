package edu.bsu.cs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class JSONDocParserTest {
    @Test
    public void hospitalDocParserTest() throws IOException, URISyntaxException {
        JSONDocParser jsonDocParser = new JSONDocParser();
        String result = jsonDocParser.hospitalDocParser("10","tot_revenue");
        String expected = "[\"96811570\",\"94278053\",\"94237556\",\"100194542\",\"102952138\",\"113112423\",\"121444840\",\"121143011\",\"129530714\",\"137784557\",\"165872359\",\"184887968\"]";
        assertEquals(expected,result);
    }
}