package edu.bsu.cs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTest {
    @Test
    void testIsNumeric_validNumericString() {
        assertTrue(StringUtils.isNumeric("123"));
    }

    @Test
    void testIsNumeric_negativeNumber() {
        assertTrue(StringUtils.isNumeric("-123"));
    }

    @Test
    void testIsNumeric_invalidString() {
        assertFalse(StringUtils.isNumeric("abc"));
    }

    @Test
    void testIsNumeric_emptyString() {
        assertFalse(StringUtils.isNumeric(""));
    }

    @Test
    void testIsNumeric_nullString() {
        assertFalse(StringUtils.isNumeric(null));
    }


    @Test
    void testExtractFirstNumber_validString() {
        assertEquals("123", StringUtils.extractFirstNumber("abc123def"));
    }

    @Test
    void testExtractFirstNumber_multipleNumbers() {
        assertEquals("123", StringUtils.extractFirstNumber("123abc456"));
    }

    @Test
    void testExtractFirstNumber_noNumbers() {
        assertNull(StringUtils.extractFirstNumber("abcdef"));
    }

    @Test
    void testExtractFirstNumber_emptyString() {
        assertNull(StringUtils.extractFirstNumber(""));
    }

    @Test
    void testExtractFirstNumber_nullString() {
        assertNull(StringUtils.extractFirstNumber(null));
    }

    @Test
    void testExtractFirstNumber_leadingSpaces() {
        assertEquals("456", StringUtils.extractFirstNumber("   456abc"));
    }
}
