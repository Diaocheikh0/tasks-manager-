package sn.groupeisi.service.Impl;

import sn.groupeisi.entity.Category;
import sn.groupeisi.entity.Task;
import sn.groupeisi.entity.User;
import sn.groupeisi.repository.TaskRepository;
import sn.groupeisi.service.TaskService;

import java.time.LocalDate;
import java.util.List;

public abstract class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // Pour Créer un task
    @Override
    public Task createTask(String title, String description, LocalDate dueDate) {
        Task task = new Task(title, description, dueDate);
        return taskRepository.save(task);
    }

    // Assigne un utilisateur à une tâche
    @Override
    public void assignTaskToUser(Task task, User user) {
        task.setUser(user);
        taskRepository.update(task);
    }

    // Associe une catégorie à la tâche
    @Override
    public void assignTaskToCategory(Task task, Category category) {
        task.setCategory(category);
        taskRepository.update(task);
    }

    // Marque la tâche comme terminée
    @Override
    public void markTaskAsCompleted(Task task) {
        task.setCompleted(true);
        taskRepository.update(task);
    }

    // Recupère l'ensemble des tâches
    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Recupère l'ensemble des tâches en attente, ce qui renvoie false
    @Override
    public List<Task> getPendingTasks() {
        return taskRepository.findByCompletedVersion1(false);
    }

    // Recupère l'ensemble des tâches effectués, ce qui renvoie true
    @Override
    public List<Task> getCompletedTasks() {
        return taskRepository.findByCompletedVersion1(true);
    }

    // Récupère toutes les tâches en retard (dont la date d'échéance est avant aujourd'hui)
    @Override
    public List<Task> getOverdueTasks() {
        return taskRepository.findByDueDateBefore(LocalDate.now());
    }

    // Récupère toutes les tâches appartenant à une catégorie spécifique
    @Override
    public List<Task> getTasksByCategory(Category category) {
        return taskRepository.findByCategory(category);
    }

    // Récupère toutes les tâches assignées à un utilisateur spécifique
    @Override
    public List<Task> getTasksAssignedToUser(User user) {
        return taskRepository.findByAssignedUser(user);
    }
}
