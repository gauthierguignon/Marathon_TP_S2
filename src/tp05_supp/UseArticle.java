package tp05_supp;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class UseArticle {
    
    public static void main(String[] args) {

        Shop shop = new Shop();
        shop.addArticle(new Article("A001", "chaise", 20.00));
        shop.addArticle(new Article("A002", "table", 50.00, 65.00));
        shop.addArticle(new Article("A003", "lampe", 15.00));

        ArrayList<Article> magasin = new ArrayList<>();
        magasin.add(new PerishableArticle("P001", "yaourt", 0.80, LocalDate.now().plusDays(5)));
        magasin.add(new PerishableArticle("P002", "fromage", 3.50, 5.00, LocalDate.now().plusDays(15)));
        shop.addArticle(magasin);

        System.out.println("Magasin : \n" + shop);
        System.out.println("Articles périssables: \n" + shop.getPerishables());
       
        System.out.println("On applique une réduction aux produits qui périment avant le " + LocalDate.now().plus(10, ChronoUnit.DAYS));
        shop.discountPerishable(LocalDate.now().plus(10, ChronoUnit.DAYS), 0.50);
        System.out.println("Articles périssables: \n" + shop.getPerishables());

        System.out.println("On applique une réduction à tout les produits non périssables ");
        shop.discountNotPerishable(0.20);
        System.out.println("Articles en soldes: \n" + shop);
    
        
    
    }
}
