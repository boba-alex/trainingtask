package command.project;

import command.Command;
import controller.PathManager;
import entity.Project;
import entity.Task;
import service.ProjectService;
import service.TaskService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class EditProjectCommand implements Command {

    private static final String PARAM_NAME_PROJECT_ID = "project-id";
    private static final String PARAM_NAME_COMMAND = "command";

    private static final String ATTRIBUTE_NAME_PROJECT = "project";
    private static final String ATTRIBUTE_NAME_COMMAND = "command";

    private static final String ATTRIBUTE_NAME_TASKS_OF_PROJECT = "tasksOfProject";

    private ProjectService projectService = new ProjectService();
    private TaskService taskService = new TaskService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path;
        try {
            int projectId = Integer.parseInt(request.getParameter(PARAM_NAME_PROJECT_ID));
            Project project = projectService.getProjectById(projectId);
            request.getSession().setAttribute(ATTRIBUTE_NAME_PROJECT, project);
            ArrayList<Task> tasks = taskService.getTasksByProject(project);
            request.getSession().setAttribute(ATTRIBUTE_NAME_TASKS_OF_PROJECT, tasks);

            request.getSession().setAttribute(ATTRIBUTE_NAME_COMMAND, request.getParameter(PARAM_NAME_COMMAND));
            path = PathManager.getInstance().getProperty(PathManager.ADD_PROJECT_URL_PATH);
        } catch (NumberFormatException e) {
            path = PathManager.getInstance().getProperty(PathManager.ERROR_PAGE_PATH);
        }
        return path;
    }
}
