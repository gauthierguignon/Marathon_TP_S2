package tp07_supp;

public class Shrub extends Plant implements IPremiumCare {
    
    public static double pricePerUnit = 5;
    public static double harvestThreshold = 100;

    public static double getHarvestThreshold() {
        return harvestThreshold;
    }

    public Shrub(int identity, double size) {
        super(identity, size);
    }

    @Override
    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public static void setPricePerUnit(double p) {
        Shrub.pricePerUnit = p;
    }

    public static void setHarvestThreshold(double h) {
        Shrub.harvestThreshold = h;
    }

    public boolean isMature() {
        return this.getSize() >= Shrub.harvestThreshold;
    }

    public double potentialPremiumProfit() {
        return this.getPrice() * 2;
    }



}
