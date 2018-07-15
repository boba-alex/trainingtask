package command.task;

import command.Command;
import controller.PathManager;
import entity.Task;
import logger.SimpleLogger;
import service.TaskService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class EditTaskCommand implements Command {

    private static final String PARAM_NAME_TASK_ID = "task-id";
    private static final String PARAM_NAME_COMMAND = "command";

    private static final String ATTRIBUTE_NAME_TASK = "task";
    private static final String ATTRIBUTE_NAME_COMMAND = "command";

    private static final String PARAM_NAME_PROJECT_IS_NEW = "project-is-new";
    private static final String PARAM_NAME_FROM_PROJECT_FORM = "from-project-form";

    private static final String ATTRIBUTE_NAME_TASKS_OF_PROJECT = "tasksOfProject";

    private TaskService taskService = new TaskService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path;
        int taskId = Integer.parseInt(request.getParameter(PARAM_NAME_TASK_ID));
        Task curTask = new Task();
        try {
            if (request.getParameter(PARAM_NAME_FROM_PROJECT_FORM) != null) {
                ArrayList<Task> tasksOfProject = (ArrayList<Task>) request.getSession().getAttribute(ATTRIBUTE_NAME_TASKS_OF_PROJECT);
                for (Task eachTask : tasksOfProject) {
                    if (eachTask.getId() == taskId) {
                        curTask = eachTask;
                        if (request.getParameter(PARAM_NAME_PROJECT_IS_NEW) != null) {
                            SimpleLogger.getLogger().fine("Task is found in tasksOfProject in new project");
                        } else {
                            SimpleLogger.getLogger().fine("Task is found in tasksOfProject in existing project");
                        }
                        break;
                    }
                }
            } else {
                curTask = taskService.getTaskById(taskId);
                SimpleLogger.getLogger().fine("Task is found in table in database");
            }
            request.setAttribute(ATTRIBUTE_NAME_TASK, curTask);
            request.getSession().setAttribute(ATTRIBUTE_NAME_COMMAND, request.getParameter(PARAM_NAME_COMMAND));
            path = PathManager.getInstance().getProperty(PathManager.ADD_TASK_URL_PATH);
        } catch (NumberFormatException e) {
            path = PathManager.getInstance().getProperty(PathManager.ERROR_PAGE_PATH);
        }
        return path;
    }
}
