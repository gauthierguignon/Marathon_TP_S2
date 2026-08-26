package tp05_supp;

public class Article {
    
    private String idRef;
    private String label;
    private final double PURCHASE_PRICE;    
    private double salePrice;
    private static double marginProfit = 0.2;
    
    public double getPURCHASE_PRICE() {
        return PURCHASE_PRICE;
    }
    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }


    public Article(String idRef, String label, double purchasePrice, double salePrice) {
        this.idRef = idRef;
        this.label = label;
        this.PURCHASE_PRICE = purchasePrice;
        this.salePrice = salePrice;
    }

    public Article(String idRef, String label, double purchasePrice) {
        this(idRef, label, purchasePrice, purchasePrice * (1 + marginProfit));
    }

    public double getMargin() {
        return salePrice - PURCHASE_PRICE;
    }

    public String toString() {
        return "Article"+" ["+ idRef+":"+label+"="+PURCHASE_PRICE+"€/"+salePrice+"€]";
    }

    public boolean isPerishable() {
        return false;
    }

}
