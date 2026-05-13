package com.soloBrew;
 
/**
 * Models the water reservoir of the coffee maker.
 * Tracks water level in fluid ounces and warns when critically low.
 *
 * Covers User Story US04 (water level indicator) and US16 (low-water warning).
 */
public class WaterReservoir {
 
    /** Each cup requires 6 fl oz of water. */
    public static final double OUNCES_PER_CUP = 6.0;
 
    /** Warn the user if water falls below this threshold. */
    public static final double LOW_WATER_THRESHOLD = 6.0;
 
    /** Maximum reservoir capacity in fl oz (12 cups). */
    public static final double MAX_CAPACITY = 72.0;
 
    private double waterLevel;
 
    /**
     * Creates a reservoir with the specified starting water level.
     * @param initialLevel Starting water level in fl oz (0–72)
     */
    public WaterReservoir(double initialLevel) {
        this.waterLevel = Math.max(0, Math.min(initialLevel, MAX_CAPACITY));
    }
 
    /** @return Current water level in fl oz. */
    public double getWaterLevel() {
        return waterLevel;
    }
 
    /**
     * Consumes water during a brew cycle.
     * @param ounces Amount to consume; silently clamps to available level.
     */
    public void consumeWater(double ounces) {
        waterLevel = Math.max(0, waterLevel - ounces);
    }
 
    /**
     * Refills the reservoir to maximum capacity.
     */
    public void refill() {
        waterLevel = MAX_CAPACITY;
    }
 
    /**
     * @return true if water level is at or below the low-water threshold.
     */
    public boolean isLow() {
        return waterLevel <= LOW_WATER_THRESHOLD;
    }
 
    /**
     * @return true if there is enough water for the requested number of cups.
     */
    public boolean hasEnoughWater(int cups) {
        return waterLevel >= cups * OUNCES_PER_CUP;
    }
}
 
