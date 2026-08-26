package tp05_supp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Shop {
    
    private ArrayList<Article> catalog = new ArrayList<>();

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Article a : catalog) {
            sb.append(a + "\n");
        }
        return sb.toString();
    }

    public boolean addArticle(Article a) {
        return catalog.add(a);
    }

    public boolean addArticle(ArrayList<Article> l) {
        return catalog.addAll(l);
    }

    public List<PerishableArticle> getPerishables() {
        List<PerishableArticle> output = new ArrayList<>();
        for(Article a : catalog) {
            if(a.isPerishable()) {
                output.add((PerishableArticle) a);
            }
        }
        return output;
    }

    public int getNbArticle() {
        return catalog.size();
    }

    public int getNbPerishableArticle() {
        return this.getPerishables().size();
    }

    public void discountPerishable(LocalDate threshold, double rate) {
        for(Article a : catalog) {
            if(a.isPerishable()) {
                PerishableArticle p = (PerishableArticle) a;
                if(p.getDeadline().isBefore(threshold)) {
                    p.setSalePrice(p.getSalePrice() - p.getSalePrice()*rate);
                }
            }
        }
    }

    public void discountNotPerishable(double rate) {
        for(Article a : catalog) {
            if(!a.isPerishable()) {
                a.setSalePrice(a.getSalePrice() - a.getSalePrice()*rate);
            }
        }
    }

    public Article mostProfitable() {
        if(catalog.size() == 0) {
            throw new IllegalStateException("Le catalogue est vide");
        }
        Article mostProfitable = catalog.get(0);
        for(Article a : catalog) {
            if(a.getMargin() > mostProfitable.getMargin()) {
                mostProfitable = a;
            }
        }
        return mostProfitable;
    }

}
