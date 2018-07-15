package dao;

import entity.Project;
import entity.Task;

import java.util.List;

public interface TaskDAO {

    List<Task> getTasks();

    void addTask(Task task);

    void updateTask(Task task, Task newTask);

    void deleteTaskById(int id);

    Task getTaskById(int id);

    List<Task> getTasksByProject(Project project);
}
