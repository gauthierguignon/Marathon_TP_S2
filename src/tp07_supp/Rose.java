package tp07_supp;

/*
javac -d bin -cp bin src/tp07_supp/*.java
javac -d bin -cp bin:/usr/share/java/junit-platform-console-standalone.jar test/tp07_supp/RoseTest.java 
java -jar /usr/share/java/junit-platform-console-standalone.jar execute -cp bin -c tp07_supp.RoseTest
*/


public class Rose extends Plant implements IPremiumCare {
    
    public static double pricePerUnit = 2;
    public static double harvestThreshold = 50;

    public static double getHarvestThreshold() {
        return harvestThreshold;
    }

    public Rose(int identity, double size) {
        super(identity, size);
    }

    @Override
    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public static void setPricePerUnit(double p) {
        Rose.pricePerUnit = p;
    }

    public static void setHarvestThreshold(double h) {
        Rose.harvestThreshold = h;
    }
    
    public boolean isMature() {
        return this.getSize() >= Rose.harvestThreshold;
    }

    public double potentialPremiumProfit() {
        return this.getPrice() * 2;
    }

}
