package command.task;

import command.Command;
import controller.PathManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddTaskCommand implements Command {

    private static final String PARAM_NAME_COMMAND = "command";
    private static final String ATTRIBUTE_NAME_COMMAND = "command";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getSession().setAttribute(ATTRIBUTE_NAME_COMMAND, request.getParameter(PARAM_NAME_COMMAND));
        return PathManager.getInstance().getProperty(PathManager.ADD_TASK_URL_PATH);
    }
}
