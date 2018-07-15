package service;

import dao.TaskDAO;
import dao.TaskDAOImpl;
import entity.Project;
import entity.Task;

import java.util.ArrayList;

public class TaskService {

    private TaskDAO taskDAO = new TaskDAOImpl();

    public ArrayList<Task> getTasks() {
        return (ArrayList<Task>) taskDAO.getTasks();
    }

    public void addTask(Task task) {
        taskDAO.addTask(task);
    }

    public void updateTask(Task task, Task newTask) {
        taskDAO.updateTask(task, newTask);
    }

    public void deleteTaskById(int id) {
        taskDAO.deleteTaskById(id);
    }

    public Task getTaskById(int id) {
        return taskDAO.getTaskById(id);
    }

    public ArrayList<Task> getTasksByProject(Project project) {
        return (ArrayList<Task>) taskDAO.getTasksByProject(project);
    }
}
