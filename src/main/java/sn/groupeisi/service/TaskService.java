package sn.groupeisi.service;

import sn.groupeisi.entity.Category;
import sn.groupeisi.entity.Task;
import sn.groupeisi.entity.User;

import java.time.LocalDate;
import java.util.List;

public interface TaskService {
    Task createTask(String title, String description, LocalDate dueDate);
    Category createCategory(String name, String description);
    User createUser(String username, String email);
    void assignTaskToUser(Task task, User user);
    void assignTaskToCategory(Task task, Category category);
    void markTaskAsCompleted(Task task);
    List<Task> getAllTasks();
    List<Task> getPendingTasks();
    List<Task> getCompletedTasks();
    List<Task> getOverdueTasks();
    List<Task> getTasksByCategory(Category category);
    List<Task> getTasksAssignedToUser(User user);
}
