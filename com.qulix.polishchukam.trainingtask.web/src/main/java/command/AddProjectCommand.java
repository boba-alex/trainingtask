package command;

import controller.PathManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddProjectCommand implements Command {
    private static final String ATTRIBUTE_NAME_PROJECT = "project";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;

        request.getSession().removeAttribute(ATTRIBUTE_NAME_PROJECT);

        page = PathManager.getInstance().getProperty(PathManager.ADD_PROJECT_PAGE_PATH);
        return page;
    }
}
