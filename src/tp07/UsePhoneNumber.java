package tp07;

import tdOO.td01.PhoneNumber;

// javac -d bin -cp bin:lib/tp07-res.jar src/tp07/UsePhoneNumber.java 
// java -cp bin:lib/tp07-res.jar tp07.UsePhoneNumber


public class UsePhoneNumber {

    public static void main(String[] args) {
        
        PhoneNumber pn = new PhoneNumber(33, 02, 33, 31, 78, 44);

        System.out.println(pn.toString());              // 02.33.31.78.44
        System.out.println(pn.standardFormat());        // 02.33.31.78.44
        System.out.println(pn.internationalFormat());   // +33.2.33.31.78.44


    }

}

