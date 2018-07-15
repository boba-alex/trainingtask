package command;

import controller.MessageManager;
import controller.PathManager;
import entity.Collaborator;
import service.CollaboratorService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SaveCollaboratorCommand implements Command {

    private static final String PARAM_NAME_SURNAME = "surname";
    private static final String PARAM_NAME_NAME = "name";
    private static final String PARAM_NAME_PATRONYMIC = "patronymic";
    private static final String PARAM_NAME_POSITION = "position";

    private static final String ATTRIBUTE_NAME_COMMAND = "command";
    private static final String ATTRIBUTE_NAME_COLLABORATOR = "collaborator";

    private CollaboratorService collaboratorService = new CollaboratorService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;

        String surname = request.getParameter(PARAM_NAME_SURNAME);
        String name = request.getParameter(PARAM_NAME_NAME);
        String patronymic = request.getParameter(PARAM_NAME_PATRONYMIC);
        String position = request.getParameter(PARAM_NAME_POSITION);

        Collaborator collaborator = new Collaborator(surname, name, patronymic, position);

        if (collaboratorService.checkCollaborator(collaborator)) {

            if ("edit-collaborator".equals(request.getSession().getAttribute(ATTRIBUTE_NAME_COMMAND))) {
                Collaborator oldCollaborator = (Collaborator) request.getSession().getAttribute(ATTRIBUTE_NAME_COLLABORATOR);
                collaboratorService.updateCollaborator(oldCollaborator, collaborator);
            } else {
                collaboratorService.addCollaborator(collaborator);
            }
            request.getSession().removeAttribute(ATTRIBUTE_NAME_COLLABORATOR);

            page = PathManager.getInstance().getProperty(PathManager.LIST_OF_COLLABORATORS_PAGE_PATH);
        } else {
            request.setAttribute("errorMessage", MessageManager.getInstance().getProperty(MessageManager.SAVE_COLLABORATOR_ERROR_MESSAGE));
            page = PathManager.getInstance().getProperty(PathManager.ERROR_PAGE_PATH);
        }
        return page;
    }
}
