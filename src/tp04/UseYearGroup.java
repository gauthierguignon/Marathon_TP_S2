package tp04;

import java.util.ArrayList;

public class UseYearGroup {

    private static final int THRESHOLD_ABS = 5;
    private static final double THRESHOLD_AVG = 10.0;

    public static void main(String[] args) {

        // ---------- 1. Construction des 4 étudiants ----------
        StudentAbs a = new StudentAbs(new Student("Alice", "A", new double[]{15.0, 16.0}), 2);
        StudentAbs b = new StudentAbs(new Student("Bob", "B", new double[]{8.0, 7.0}), 1);
        StudentAbs c = new StudentAbs(new Student("Chloe", "C", new double[]{14.0, 13.0}), 6);
        StudentAbs d = new StudentAbs(new Student("David", "D", new double[]{5.0, 6.0}), 7);

        System.out.println("=== Etudiants crees ===");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);

        // ---------- 2. Test equals (encapsulation en chaine) ----------
        // Reflexivite : un objet est egal a lui-meme
        System.out.println("\n=== Tests equals ===");
        System.out.println("a.equals(a)  attendu true  -> " + a.equals(a));
        System.out.println("a.equals(b)  attendu false -> " + a.equals(b));

        // Deux StudentAbs avec le meme etudiant sous-jacent mais nbAbsence different
        // doivent etre differents (equals se base sur TOUS les champs
        StudentAbs aClone = new StudentAbs(new Student("Alice", "A", new double[]{15.0, 16.0}), 3);
        System.out.println("a.equals(aClone) [meme notes, abs differente] attendu false -> "
                + a.equals(aClone));

        // ---------- 3. Test addGrade / getAverage avant integration en promo ----------
        System.out.println("\n=== Test addGrade sur A ===");
        System.out.println("Moyenne avant ajout : " + a.getAverage()); // attendu 15.5
        a.addGrade(20.0);
        System.out.println("Moyenne apres ajout d'un 20 : " + a.getAverage() + "\n" + a);

        // ---------- 4. Test warning / validation individuels ----------
        System.out.println("\n=== Test warning/validation individuels ===");
        StudentAbs[] tous = {a, b, c, d};
        String[] noms = {"A", "B", "C", "D"};
        for (int i = 0; i < tous.length; i++) {
            StudentAbs s = tous[i];
            System.out.printf("%s : abs=%d moy=%.2f | warning=%b | validation=%b%n",
                    noms[i], s.getNbAbsence(), s.getAverage(),
                    s.warning(THRESHOLD_ABS, THRESHOLD_AVG),
                    s.validation(THRESHOLD_ABS, THRESHOLD_AVG));
        }
        // Attendu : A -> validation true ; B, C, D -> validation false

        // ---------- 5. Construction de la promotion (YearGroup) ----------
        System.out.println("\n=== Construction YearGroup ===");
        YearGroup promo = new YearGroup();

        // ajout unitaire
        promo.addStudent(a);

        // ajout par lot
        ArrayList<StudentAbs> reste = new ArrayList<>();
        reste.add(b);
        reste.add(c);
        reste.add(d);
        promo.addStudent(reste);

        System.out.println("Taille de la promo (attendu 4) : " + promo.getStudents().size());

        // ---------- 6. Test addGrades sur toute la promo ----------
        System.out.println("\n=== Test addGrades ===");
        double[] notesPartiel = {12.0, 9.0, 11.0, 4.0}; // meme ordre que A, B, C, D
        promo.addGrades(notesPartiel);
        for (int i = 0; i < promo.getStudents().size(); i++) {
            System.out.println(noms[i] + " -> " + promo.getStudents().get(i));
        }

        // ---------- 7. Test validation() sur la promo ----------
        // Doit afficher uniquement les etudiants qui valident: A
        System.out.println("\n=== Etudiants valides (YearGroup.validation) ===");
        promo.validation(THRESHOLD_ABS, (int) THRESHOLD_AVG);

        System.out.println("\n=== Fin des tests ===");
    }
}
