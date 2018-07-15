package command;

import controller.PathManager;
import service.TaskService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteTaskCommand implements Command {

    private static final String PARAM_NAME_TASK_ID = "task-id";

    private TaskService taskService = new TaskService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;

        int taskId = Integer.parseInt(request.getParameter(PARAM_NAME_TASK_ID));
        taskService.deleteTaskById(taskId);

        page = PathManager.getInstance().getProperty(PathManager.LIST_OF_TASKS_PAGE_PATH);
        return page;


    }
}
