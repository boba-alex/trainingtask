package command.project;

import command.Command;
import controller.PathManager;
import entity.Task;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class AddProjectCommand implements Command {

    private static final String PARAM_NAME_COMMAND = "command";
    private static final String ATTRIBUTE_NAME_COMMAND = "command";

    private static final String ATTRIBUTE_NAME_PROJECT = "project";
    private static final String ATTRIBUTE_NAME_TASKS_OF_PROJECT = "tasksOfProject";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().removeAttribute(ATTRIBUTE_NAME_PROJECT);
        request.getSession().setAttribute(ATTRIBUTE_NAME_COMMAND, request.getParameter(PARAM_NAME_COMMAND));
        request.getSession().setAttribute(ATTRIBUTE_NAME_TASKS_OF_PROJECT, new ArrayList<Task>());
        return PathManager.getInstance().getProperty(PathManager.ADD_PROJECT_URL_PATH);
    }
}
