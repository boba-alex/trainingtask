package command;

import controller.PathManager;
import entity.Project;
import service.ProjectService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SaveProjectCommand implements Command {

    private static final String PARAM_NAME_NAME = "name";
    private static final String PARAM_NAME_SHORT_NAME = "short-name";
    private static final String PARAM_NAME_DESCRIPTION = "description";

    private static final String ATTRIBUTE_NAME_COMMAND = "command";
    private static final String ATTRIBUTE_NAME_PROJECT = "project";

    private ProjectService projectService = new ProjectService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;

        String name = request.getParameter(PARAM_NAME_NAME);
        String shortName = request.getParameter(PARAM_NAME_SHORT_NAME);
        String description = request.getParameter(PARAM_NAME_DESCRIPTION);

        Project project = new Project(name, shortName, description);
        if ("edit-project".equals(request.getSession().getAttribute(ATTRIBUTE_NAME_COMMAND))) {
            Project oldProject = (Project) request.getSession().getAttribute(ATTRIBUTE_NAME_PROJECT);
            projectService.updateProject(oldProject, project);
        } else {
            projectService.addProject(project);
        }
        request.getSession().removeAttribute(ATTRIBUTE_NAME_PROJECT);

        page = PathManager.getInstance().getProperty(PathManager.LIST_OF_PROJECTS_PAGE_PATH);
        return page;
    }
}
