package tp03;

import java.time.LocalDate;

public class UseTask {

    public static void main(String[] args) {

        // Création de t1 : "finir exo1", durée de 1 journée
        Task t1 = new Task("finir exo1", 1);

        // Création de t2 : créée le 01/02/2026,
        // deadline le 01/03/2026, durée de 2 journées
        Task t2 = new Task(
            "finir exo2",
            LocalDate.of(2026, 2, 1),
            LocalDate.of(2026, 3, 1),
            2
        );

        // Affichage des tâches
        System.out.println("Avant changement de status :");
        System.out.println(t1);
        System.out.println(t2);

        // Changer le status de t1
        t1.changeStatus();

        // Changer le status de t2 pour FINISHED
        t2.changeStatus(TaskStatus.FINISHED);

        // Nouvel affichage
        System.out.println("\nAprès changement de status :");
        System.out.println(t1);
        System.out.println(t2);


        // Création de t3
        Task t3 = new Task(
            "finir exo3",
            LocalDate.of(2026, 2, 1),
            LocalDate.of(2026, 2, 10),
            5
        );

        // Création de t4
        Task t4 = new Task(
            "finir exo4",
            LocalDate.of(2026, 2, 1),
            LocalDate.of(2026, 2, 10),
            5
        );

        // Affichage des tâches et de leur retard
        System.out.println("Avant modification :");
        System.out.println(t3 + " - En retard : " + t3.isLate());
        System.out.println(t4 + " - En retard : " + t4.isLate());

        // Changer le status de t3 pour FINISHED
        t3.changeStatus(TaskStatus.FINISHED);

        // Accorder un délai de 300 jours à t4
        t4.delay(300);

        // Nouvel affichage
        System.out.println("\nAprès modification :");
        System.out.println(t3 + " - En retard : " + t3.isLate());
        System.out.println(t4 + " - En retard : " + t4.isLate());


    }
}

