package command.project;

import command.Command;
import controller.PathManager;
import entity.Project;
import entity.Task;
import logger.SimpleLogger;
import service.ProjectService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class AddTaskToProjectCommand implements Command {

    private static final String PARAM_NAME_ID = "id";
    private static final String PARAM_NAME_NAME = "name";
    private static final String PARAM_NAME_SHORT_NAME = "short-name";
    private static final String PARAM_NAME_DESCRIPTION = "description";

    private static final String ATTRIBUTE_NAME_PROJECT = "project";
    private static final String PARAM_NAME_COMMAND = "command";

    private static final String ATTRIBUTE_NAME_COMMAND = "command";
    private static final String ATTRIBUTE_NAME_TASKS_OF_PROJECT = "tasksOfProject";

    private static final String PARAM_NAME_PROJECT_IS_NEW = "project-is-new";
    private static final String PARAM_NAME_FROM_PROJECT_FORM = "from-project-form";


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path;

        int id = 0;
        String name = request.getParameter(PARAM_NAME_NAME);
        String shortName = request.getParameter(PARAM_NAME_SHORT_NAME);
        String description = request.getParameter(PARAM_NAME_DESCRIPTION);
        Project project = new Project(name, shortName, description);

        SimpleLogger.getLogger().fine("project-is-new" + request.getParameter(PARAM_NAME_PROJECT_IS_NEW));
        if (request.getParameter(PARAM_NAME_PROJECT_IS_NEW) != null) {
            id = new ProjectService().getMaxProjectId() + 1;
            project.setId(id);
        } else {
            SimpleLogger.getLogger().fine("Project exists in database");
            id = Integer.parseInt(request.getParameter(PARAM_NAME_ID));
            project.setId(id);
        }
        request.getSession().setAttribute(ATTRIBUTE_NAME_PROJECT, project);
        request.getSession().setAttribute(ATTRIBUTE_NAME_COMMAND, request.getParameter(PARAM_NAME_COMMAND));

        if (request.getSession().getAttribute(ATTRIBUTE_NAME_TASKS_OF_PROJECT) == null && request.getParameter(PARAM_NAME_PROJECT_IS_NEW) != null) {
            request.getSession().setAttribute(ATTRIBUTE_NAME_TASKS_OF_PROJECT, new ArrayList<Task>());
        }

        String addParams = "?";
        if (request.getParameter(PARAM_NAME_PROJECT_IS_NEW) != null) {
            addParams += PARAM_NAME_PROJECT_IS_NEW + "=" + PARAM_NAME_PROJECT_IS_NEW + "&&";
        }
        if (request.getParameter(PARAM_NAME_FROM_PROJECT_FORM) != null) {
            addParams += PARAM_NAME_FROM_PROJECT_FORM + "=" + PARAM_NAME_FROM_PROJECT_FORM;
        }
        path = PathManager.getInstance().getProperty(PathManager.ADD_TASK_URL_PATH) + addParams;
        return path;
    }


}
