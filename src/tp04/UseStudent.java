package tp04;

public class UseStudent {
    
    public static void main (String[] args) {
        
        Student s1 = new Student("Gauthier", "Guignon", 12.5);
        Student s2 = new Student("Hugo", "Noel", new double[]{18.5, 16.4});
        Student s3 = new Student("Jules", "Goddefroy", new double[]{11.5});
        Student s4 = new Student("Hugo", "Noel", new double[]{18.5, 16.4});
    
        System.out.println("false : " + s1.equals(s2));
        System.out.println("false: " + s1.equals(null));
        System.out.println("false: " + s2.equals(s4)); // L'Id est différent
        System.out.println("true : " + s1.equals(s1));

        System.out.println(s3);
        System.out.println(s4);

    }

}
