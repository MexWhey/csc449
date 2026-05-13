package com.soloBrew;
 
/**
 * Encapsulates user-selected brew preferences.
 * Validates cup count on construction — enforces 1–12 cup range.
 *
 * Covers User Story US02 (brew strength) and US03 (cup quantity).
 */
public class BrewSettings {
 
    private final BrewStrength strength;
    private final int cupQuantity;
 
    /**
     * @param strength    Desired brew strength (MILD, MEDIUM, STRONG)
     * @param cupQuantity Number of cups to brew (1–12)
     * @throws IllegalArgumentException if cupQuantity is outside 1–12
     */
    public BrewSettings(BrewStrength strength, int cupQuantity) {
        if (cupQuantity < 1 || cupQuantity > 12) {
            throw new IllegalArgumentException(
                "Cup quantity must be between 1 and 12. Received: " + cupQuantity
            );
        }
        this.strength = strength;
        this.cupQuantity = cupQuantity;
    }
 
    public BrewStrength getStrength() {
        return strength;
    }
 
    public int getCupQuantity() {
        return cupQuantity;
    }
}
 
