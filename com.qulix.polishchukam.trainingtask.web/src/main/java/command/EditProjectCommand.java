package command;

import controller.PathManager;
import entity.Project;
import service.ProjectService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditProjectCommand implements Command {

    private static final String PARAM_NAME_PROJECT_ID = "project-id";
    private static final String PARAM_NAME_COMMAND = "command";

    private static final String ATTRIBUTE_NAME_PROJECT = "project";
    private static final String ATTRIBUTE_NAME_COMMAND = "command";

    private ProjectService projectService = new ProjectService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;

        int projectId = Integer.parseInt(request.getParameter(PARAM_NAME_PROJECT_ID));
        Project project = projectService.getProjectById(projectId);

        request.getSession().setAttribute(ATTRIBUTE_NAME_PROJECT, project);
        request.getSession().setAttribute(ATTRIBUTE_NAME_COMMAND, request.getParameter(PARAM_NAME_COMMAND));

        page = PathManager.getInstance().getProperty(PathManager.ADD_PROJECT_PAGE_PATH);
        return page;
    }
}
