package tp07_supp;

public class Tulip extends Plant {
    
    public static double pricePerUnit = 1;
    public static double harvestThreshold = 30;

    public static double getHarvestThreshold() {
        return harvestThreshold;
    }

    public Tulip(int identity, double size) {
        super(identity, size);
    }

    @Override
    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public static void setPricePerUnit(double p) {
        Tulip.pricePerUnit = p;
    }

    public static void setHarvestThreshold(double h) {
        Tulip.harvestThreshold = h;
    }

    public boolean isMature() {
        return this.getSize() >= Tulip.harvestThreshold;
    }
}
