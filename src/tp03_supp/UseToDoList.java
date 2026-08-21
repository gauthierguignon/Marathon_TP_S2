package tp03_supp;

import java.time.LocalDate;

import tp03.Task;

public class UseToDoList {

    public static void main(String[] args) {

        // 1. Création des deux listes
        ToDoList alice = new ToDoList();
        ToDoList bruno = new ToDoList();

        LocalDate today = LocalDate.now();

        // 2. Ajout des tâches d'Alice
        alice.addTask(new Task("a1", today, today.plusDays(3), 2));
        alice.addTask(new Task("a2", today, today.plusDays(4), 5));
        alice.addTask(new Task("a3", today, today.plusDays(5), 3));

        // 3. Ajout des tâches de Bruno
        bruno.addTask(new Task("b1", today, today.plusDays(1), 4));
        bruno.addTask(new Task("b2", today, today.plusDays(5), 2));
        bruno.addTask(new Task("b3", today, today.plusDays(9), 7));

        // 4. Affichage des listes respectives
        System.out.println("=== Listes initiales ===");

        System.out.println("Liste d'Alice :");
        System.out.println(alice);

        System.out.println("Liste de Bruno :");
        System.out.println(bruno);

        // 5. Bruno est malade :
        // Alice récupère les tâches de Bruno
        Task[] tachesBruno = bruno.dueTasks();

        for (Task t : tachesBruno) {
            alice.addTask(t);
            bruno.removeTask(t);
        }

        // 6. Affichage après transfert
        System.out.println("=== Après le départ de Bruno ===");

        System.out.println("Liste d'Alice :");
        System.out.println(alice);

        System.out.println("Liste de Bruno :");
        System.out.println(bruno);

        // 7. Alice reporte sa tâche la plus longue
        // et sa tâche la plus ancienne

        alice.durationSort();

        Task plusLongue = alice.dueTasks()[alice.getNbTask() - 1];
        plusLongue.delay(1);

        alice.senioritySort();

        Task plusAncienne = alice.dueTasks()[alice.getNbTask() - 1];
        plusAncienne.delay(1);

        // 8. Affichage final
        System.out.println("=== Liste finale d'Alice ===");
        System.out.println(alice);
    }
}
