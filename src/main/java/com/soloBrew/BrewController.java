package com.soloBrew;

public class BrewController {

    private final WaterReservoir reservoir;
    private boolean brewing = false;

    public BrewController(WaterReservoir reservoir) {
        this.reservoir = reservoir;
    }

    public boolean startBrew(BrewSettings settings) {
        if (!reservoir.hasEnoughWater(settings.getCupQuantity())) {
            System.out.println("[BrewController] Not enough water to brew "
                + settings.getCupQuantity() + " cups.");
            return false;
        }
        brewing = true;
        double waterNeeded = settings.getCupQuantity() * WaterReservoir.OUNCES_PER_CUP;
        reservoir.consumeWater(waterNeeded);
        System.out.println("[BrewController] Brewing " + settings.getCupQuantity()
            + " cup(s) at " + settings.getStrength() + " strength.");
        brewing = false;
        return true;
    }

    public boolean isBrewing() {
        return brewing;
    }
}
