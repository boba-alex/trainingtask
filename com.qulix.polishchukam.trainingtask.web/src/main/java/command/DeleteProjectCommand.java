package command;

import controller.PathManager;
import service.ProjectService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteProjectCommand implements Command {

    private static final String PARAM_NAME_PROJECT_ID = "project-id";

    private ProjectService projectService = new ProjectService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;

        int projectId = Integer.parseInt(request.getParameter(PARAM_NAME_PROJECT_ID));
        projectService.deleteProjectById(projectId);

        page = PathManager.getInstance().getProperty(PathManager.LIST_OF_PROJECTS_PAGE_PATH);
        return page;
    }
}
