package command;

import controller.PathManager;
import entity.Task;
import service.TaskService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditTaskCommand implements Command {

    private static final String PARAM_NAME_TASK_ID = "task-id";
    private static final String PARAM_NAME_COMMAND = "command";

    private static final String ATTRIBUTE_NAME_TASK = "task";
    private static final String ATTRIBUTE_NAME_COMMAND = "command";

    private TaskService taskService = new TaskService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;

        int taskId = Integer.parseInt(request.getParameter(PARAM_NAME_TASK_ID));
        Task task = taskService.getTaskById(taskId);

        request.getSession().setAttribute(ATTRIBUTE_NAME_TASK, task);
        request.getSession().setAttribute(ATTRIBUTE_NAME_COMMAND, request.getParameter(PARAM_NAME_COMMAND));

        page = PathManager.getInstance().getProperty(PathManager.ADD_TASK_PAGE_PATH);
        return page;
    }
}
