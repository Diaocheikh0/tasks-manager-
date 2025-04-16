package sn.groupeisi.service.Impl;

import sn.groupeisi.entity.Category;
import sn.groupeisi.entity.Task;
import sn.groupeisi.entity.User;
import sn.groupeisi.service.TaskService;

import java.time.LocalDate;
import java.util.List;

public class TaskServiceImpl implements TaskService {
    @Override
    public Task createTask(String title, String description, LocalDate dueDate) {
        return null;
    }

    @Override
    public Category createCategory(String name, String description) {
        return null;
    }

    @Override
    public User createUser(String username, String email) {
        return null;
    }

    @Override
    public void assignTaskToUser(Task task, User user) {

    }

    @Override
    public void assignTaskToCategory(Task task, Category category) {

    }

    @Override
    public void markTaskAsCompleted(Task task) {

    }

    @Override
    public List<Task> getAllTasks() {
        return List.of();
    }

    @Override
    public List<Task> getPendingTasks() {
        return List.of();
    }

    @Override
    public List<Task> getCompletedTasks() {
        return List.of();
    }

    @Override
    public List<Task> getOverdueTasks() {
        return List.of();
    }

    @Override
    public List<Task> getTasksByCategory(Category category) {
        return List.of();
    }

    @Override
    public List<Task> getTasksAssignedToUser(User user) {
        return List.of();
    }
}
