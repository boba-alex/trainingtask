package command.collaborator;

import command.Command;
import controller.PathManager;
import service.CollaboratorService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteCollaboratorCommand implements Command {

    private static final String PARAM_NAME_COLLABORATOR_ID = "collaborator-id";

    private CollaboratorService collaboratorService = new CollaboratorService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int collaboratorId = Integer.parseInt(request.getParameter(PARAM_NAME_COLLABORATOR_ID));
        collaboratorService.deleteCollaboratorById(collaboratorId);

        return PathManager.getInstance().getProperty(PathManager.LIST_OF_COLLABORATORS_URL_PATH);
    }
}
