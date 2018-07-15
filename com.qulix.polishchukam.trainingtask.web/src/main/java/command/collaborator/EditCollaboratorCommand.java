package command.collaborator;

import command.Command;
import controller.PathManager;
import entity.Collaborator;
import service.CollaboratorService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditCollaboratorCommand implements Command {

    private static final String PARAM_NAME_COLLABORATOR_ID = "collaborator-id";
    private static final String PARAM_NAME_COMMAND = "command";

    private static final String ATTRIBUTE_NAME_COLLABORATOR = "collaborator";
    private static final String ATTRIBUTE_NAME_COMMAND = "command";

    private CollaboratorService collaboratorService = new CollaboratorService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path;
        try {
            int collaboratorId = Integer.parseInt(request.getParameter(PARAM_NAME_COLLABORATOR_ID));
            Collaborator collaborator = collaboratorService.getCollaboratorById(collaboratorId);
            request.setAttribute(ATTRIBUTE_NAME_COLLABORATOR, collaborator);

            request.getSession().setAttribute(ATTRIBUTE_NAME_COMMAND, request.getParameter(PARAM_NAME_COMMAND));
            path = PathManager.getInstance().getProperty(PathManager.ADD_COLLABORATOR_URL_PATH);
        } catch (NumberFormatException e) {
            path = PathManager.getInstance().getProperty(PathManager.ERROR_PAGE_PATH);
        }
        return path;
    }
}
