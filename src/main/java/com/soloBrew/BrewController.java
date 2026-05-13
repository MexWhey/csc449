ackage com.soloBrew;
 
/**
 * Top-level class representing the Mr. Coffee coffee maker device.
 * Manages power state and coordinates the reservoir and brew controller.
 *
 * Covers User Story US01 (power on/off).
 */
public class CoffeeMaker {
 
    private boolean poweredOn = false;
    private final WaterReservoir reservoir;
    private final BrewController brewController;
 
    public CoffeeMaker() {
        this.reservoir = new WaterReservoir(0);
        this.brewController = new BrewController(reservoir);
    }
 
    /** Powers on the coffee maker. */
    public void powerOn() {
        poweredOn = true;
        System.out.println("[CoffeeMaker] Powered ON.");
    }
 
    /** Powers off the coffee maker. */
    public void powerOff() {
        poweredOn = false;
        System.out.println("[CoffeeMaker] Powered OFF.");
    }
 
    /** @return true if the machine is currently powered on. */
    public boolean isPoweredOn() {
        return poweredOn;
    }
 
    /**
     * Initiates a brew cycle if the machine is on.
     * @param settings Brew preferences
     * @return true if brewing started; false if machine is off or water is low
     */
    public boolean brew(BrewSettings settings) {
        if (!poweredOn) {
            System.out.println("[CoffeeMaker] Cannot brew — machine is off.");
            return false;
        }
        return brewController.startBrew(settings);
    }
 
    /** @return The water reservoir (for refilling / inspection). */
    public WaterReservoir getReservoir() {
        return reservoir;
    }
}
