package command.task;

import command.Command;
import controller.PathManager;
import logger.SimpleLogger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CancelTaskCommand implements Command {

    private static final String PARAM_NAME_FROM_PROJECT_FORM = "from-project-form";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path;
        SimpleLogger.getLogger().fine("from-project-form: " + request.getParameter(PARAM_NAME_FROM_PROJECT_FORM));
        if (request.getParameter(PARAM_NAME_FROM_PROJECT_FORM) != null) {
            path = PathManager.getInstance().getProperty(PathManager.ADD_PROJECT_URL_PATH);
        } else {
            path = PathManager.getInstance().getProperty(PathManager.LIST_OF_TASKS_URL_PATH);
        }
        return path;
    }
}
