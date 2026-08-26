package tp05_supp;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class PerishableArticle extends Article {
    
    private LocalDate deadline;

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public PerishableArticle(String idRef, String label, double purchasePrice, double salePrice, LocalDate deadline) {
        super(idRef, label, purchasePrice, salePrice);
        this.deadline = deadline;
    }

    public PerishableArticle(String idRef, String label, double purchasePrice, LocalDate deadline) {
        super(idRef, label, purchasePrice);
        this.deadline = deadline;
    }

    public PerishableArticle(String idRef, String label, double purchasePrice, double salePrice) {
        this(idRef, label, purchasePrice, salePrice, LocalDate.now().plus(10, ChronoUnit.DAYS));
    }

    public PerishableArticle(String idRef, String label, double purchasePrice) {
        super(idRef, label, purchasePrice);
        this.deadline = LocalDate.now().plus(10, ChronoUnit.DAYS);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Perishable" + super.toString());
        sb.deleteCharAt(sb.length()-1);
        sb.append("-->" + this.deadline + ']');
        return sb.toString();
    }

    @Override
    public boolean isPerishable() {
        return true;
    }


}
