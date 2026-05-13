package com.soloBrew;
 
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
 
import static org.junit.jupiter.api.Assertions.*;
 
/**
 * Unit tests for BrewSettings.
 *
 * User Story US02: As a user, I want to select brew strength (Mild/Medium/Strong).
 * User Story US03: As a user, I want to select cup quantity (1–12 cups).
 *
 * These two tests verify that BrewSettings correctly accepts valid input
 * and rejects invalid cup counts.
 */
class BrewSettingsTest {
 
    // -----------------------------------------------------------------
    // Test 1 — US02 + US03
    // -----------------------------------------------------------------
 
    @Test
    @DisplayName("BrewSettings stores strength and cup quantity correctly for valid input")
    void testValidSettings_storesCorrectValues() {
        // ARRANGE + ACT
        BrewSettings settings = new BrewSettings(BrewStrength.STRONG, 6);
 
        // ASSERT
        assertEquals(BrewStrength.STRONG, settings.getStrength(),
            "Strength should be STRONG as set");
        assertEquals(6, settings.getCupQuantity(),
            "Cup quantity should be 6 as set");
    }
 
    // -----------------------------------------------------------------
    // Test 2 — US03 (boundary / validation)
    // -----------------------------------------------------------------
 
    @Test
    @DisplayName("BrewSettings throws IllegalArgumentException when cup quantity is out of range")
    void testInvalidCupQuantity_throwsException() {
        // ARRANGE + ACT + ASSERT
        // 0 cups — below minimum
        assertThrows(IllegalArgumentException.class,
            () -> new BrewSettings(BrewStrength.MILD, 0),
            "Cup quantity of 0 should throw IllegalArgumentException");
 
        // 13 cups — above maximum
        assertThrows(IllegalArgumentException.class,
            () -> new BrewSettings(BrewStrength.MILD, 13),
            "Cup quantity of 13 should throw IllegalArgumentException");
    }
}
 
