package com.solvians.showcase;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ISINGeneratorTest {

    @Test
    void generateISIN() {
        String isin = ISINGenerator.generateISIN();
        assertNotNull(isin, "ISIN not be null");
        assertEquals(12, isin.length(), "ISIN should be 12 characters long");
        assertTrue(isin.matches("^[A-Z]{2}[A-Z0-9]{9}\\d$"), "format is incorrect");
    }
}