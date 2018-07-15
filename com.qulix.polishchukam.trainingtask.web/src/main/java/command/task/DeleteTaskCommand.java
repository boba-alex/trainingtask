package command.task;

import command.Command;
import controller.PathManager;
import entity.Task;
import service.TaskService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class DeleteTaskCommand implements Command {

    private static final String PARAM_NAME_TASK_ID = "task-id";
    private static final String PARAM_NAME_PROJECT_IS_NEW = "project-is-new";
    private static final String PARAM_NAME_FROM_PROJECT_FORM = "from-project-form";

    private static final String ATTRIBUTE_NAME_TASKS_OF_PROJECT = "tasksOfProject";

    private TaskService taskService = new TaskService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path;
        int taskId = Integer.parseInt(request.getParameter(PARAM_NAME_TASK_ID));

        if (request.getParameter(PARAM_NAME_FROM_PROJECT_FORM) != null) {
            ArrayList<Task> tasks = (ArrayList<Task>) request.getSession().getAttribute(ATTRIBUTE_NAME_TASKS_OF_PROJECT);
            Task task = new Task();
            task.setId(taskId);
            tasks.remove(task);
        } else {
            taskService.deleteTaskById(taskId);
        }

        if (request.getParameter(PARAM_NAME_FROM_PROJECT_FORM) != null) {
            path = PathManager.getInstance().getProperty(PathManager.ADD_PROJECT_URL_PATH);
        } else {
            path = PathManager.getInstance().getProperty(PathManager.LIST_OF_TASKS_URL_PATH);
        }
        return path;
    }
}
