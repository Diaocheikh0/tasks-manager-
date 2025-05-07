package sn.groupeisi;

import sn.groupeisi.entity.Category;
import sn.groupeisi.entity.Task;
import sn.groupeisi.entity.User;
import sn.groupeisi.repository.TaskRepository;
import sn.groupeisi.service.Impl.TaskServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("taskjpa");
        EntityManager entitymanager = emf.createEntityManager();

        TaskRepository taskRepository = new TaskRepository(entitymanager);
        TaskServiceImpl taskService = new TaskServiceImpl(taskRepository, entitymanager);

        /*User user = taskService.createUser("Diop Alioune", "diopalioune@groupeisi.com");
        System.out.println("Utilisateur créé avec succès: " + user.getName() + " (" + user.getEmail() + ")");

        Category category = taskService.createCategory("Études", "Révisions, devoirs, projets et préparation aux examens");
        System.out.println("catégorie créer avec succés: " + category.getName() + "(" + category.getDescription() + ")");*/

        /*Task task = taskService.createTask(
                "Projet de Java",
                "Faire le projet de Java task manger jpa",
                LocalDate.of(2025, 5, 20)
                );
        System.out.println("Task créer avec succès: " + task);*/

        /*Task task = taskRepository.findById(1L);

        Category category = entitymanager.find(Category.class, 3L);

        task.setCategory(category);

        taskRepository.update(task);

        System.out.println("Tâche assignée à la catégorie avec succès !");*/

        Task task = taskRepository.findById(1L);

        User user = entitymanager.find(User.class, 2L);

        task.setUser(user);

        taskRepository.update(task);

        System.out.println("Tâche assignée à un utilisateur avec succès !");
    }
}