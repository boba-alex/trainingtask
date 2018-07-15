package command.project;

import command.Command;
import controller.PathManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CancelProjectCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return PathManager.getInstance().getProperty(PathManager.LIST_OF_PROJECTS_URL_PATH);
    }
}
