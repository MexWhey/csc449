package com.soloBrew;
 
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
 
import static org.junit.jupiter.api.Assertions.*;
 
/**
 * Unit tests for BrewController.
 *
 * User Story US13: As a developer, I want to implement the BrewController Java class
 * so that core brewing logic is functional and testable.
 *
 * These two tests verify the two most critical branches of startBrew():
 *   1. A successful brew when water is sufficient.
 *   2. A failed brew when water is insufficient.
 */
class BrewControllerTest {
 
    private WaterReservoir reservoir;
    private BrewController controller;
 
    /**
     * Runs before each test to give us a clean controller and a full reservoir.
     * This prevents state from one test from leaking into the next.
     */
    @BeforeEach
    void setUp() {
        // 72 oz = a full 12-cup reservoir
        reservoir = new WaterReservoir(72.0);
        controller = new BrewController(reservoir);
    }
 
    // -----------------------------------------------------------------
    // Test 1 — US13 / US02 / US03
    // -----------------------------------------------------------------
 
    @Test
    @DisplayName("startBrew() returns true and consumes correct water when reservoir is full")
    void testSuccessfulBrew_consumesCorrectWater() {
        // ARRANGE
        // 4 cups × 6 oz = 24 oz should be consumed; 72 - 24 = 48 oz should remain
        BrewSettings settings = new BrewSettings(BrewStrength.MEDIUM, 4);
        double expectedWaterAfter = 72.0 - (4 * WaterReservoir.OUNCES_PER_CUP);
 
        // ACT
        boolean result = controller.startBrew(settings);
 
        // ASSERT
        assertTrue(result,
            "startBrew() should return true when there is enough water");
        assertEquals(expectedWaterAfter, reservoir.getWaterLevel(), 0.001,
            "Reservoir should have exactly " + expectedWaterAfter + " oz remaining after brew");
    }
 
    // -----------------------------------------------------------------
    // Test 2 — US13 / US16 (low-water warning)
    // -----------------------------------------------------------------
 
    @Test
    @DisplayName("startBrew() returns false and does NOT consume water when reservoir is too low")
    void testFailedBrew_insufficientWater() {
        // ARRANGE
        // Give the reservoir only 5 oz — not enough for even 1 cup (6 oz)
        WaterReservoir lowReservoir = new WaterReservoir(5.0);
        BrewController lowController = new BrewController(lowReservoir);
        BrewSettings settings = new BrewSettings(BrewStrength.MILD, 1);
        double waterBefore = lowReservoir.getWaterLevel();
 
        // ACT
        boolean result = lowController.startBrew(settings);
 
        // ASSERT
        assertFalse(result,
            "startBrew() should return false when there is not enough water");
        assertEquals(waterBefore, lowReservoir.getWaterLevel(), 0.001,
            "Water level should be unchanged when brew is rejected");
    }
}
