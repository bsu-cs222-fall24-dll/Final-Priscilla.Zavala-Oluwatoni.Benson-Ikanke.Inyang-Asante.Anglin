package edu.bsu.cs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class JSONReaderFormatterTest {
    @Test
    public void hospitalDocParserTest() throws IOException, URISyntaxException {
        JSONDocParser parser = new JSONDocParser();
        String result = parser.hospitalDocParser("10","tot_revenue");
        String expected = "[\"96811570\",\"94278053\",\"94237556\",\"100194542\",\"102952138\",\"113112423\",\"121444840\",\"121143011\",\"129530714\",\"137784557\",\"165872359\",\"184887968\"]";
        assertEquals(expected,result);
    }

    @Test
    public void stateDocParserTest() throws IOException, URISyntaxException {
        JSONDocParser parser = new JSONDocParser();
        String result = parser.stateDocParser("AL", "name");
        String expected = "[\"Mizell Memorial Hospital\",\"St Vincents East\",\"Shelby Baptist Medical Center\",\"Callahan Eye Foundation Hosp\",\"Cherokee Medical Center\",\"Jackson Hospital And Clinic  Inc\",\"George H Lanier Memorial Hospital\",\"Tanner Medical Center-East Alabama\",\"Community Hospital Inc\",\"Cullman Regional\",\"Stringfellow Memorial Hospital\",\"Marion Regional Medical Center\",\"St Vincents Blount\",\"St Vincents Birmingham\",\"Russell Medical Center\",\"Northeast Alabama Regional Med Ctr\",\"Northwest Medical Center\",\"Walker Baptist Medical Center\",\"Providence Hospital\",\"Thomas Hospital\",\"Citizens Baptist Medical Center\",\"Princeton Baptist Medical Center\",\"Pickens County Medical Center\",\"Mobile Infirmary Medical Center\",\"Lakeland Community Hospital\",\"North Baldwin Infirmary\",\"St Vincents St Clair\",\"Brookwood Baptist Medical Center\",\"Jacksonville Medical Center\",\"Infirmary West\",\"Russellville Hospital\",\"Atmore Community Hospital\",\"St Vincents Chilton\",\"Choctaw General Hospital\",\"St Vincents Blount\",\"Tanner Medical Center Alabama  Inc\",\"The Childrens Hospital Of Alabama\"]";
        assertEquals(expected,result);
    }
}