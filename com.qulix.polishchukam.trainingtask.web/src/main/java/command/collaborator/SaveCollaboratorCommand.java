package command.collaborator;

import command.Command;
import controller.MessageManager;
import controller.PathManager;
import entity.Collaborator;
import exception.ValidationException;
import service.CollaboratorService;
import validation.CollaboratorValidator;
import validation.ValidatorSelector;
import validation.ValidatorType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SaveCollaboratorCommand implements Command {

    private static final String PARAM_NAME_ID = "id";
    private static final String PARAM_NAME_SURNAME = "surname";
    private static final String PARAM_NAME_NAME = "name";
    private static final String PARAM_NAME_PATRONYMIC = "patronymic";
    private static final String PARAM_NAME_POSITION = "position";

    private static final String ATTRIBUTE_NAME_COMMAND = "command";

    private CollaboratorService collaboratorService = new CollaboratorService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ValidationException {
        String path;

        String surname = request.getParameter(PARAM_NAME_SURNAME);
        String name = request.getParameter(PARAM_NAME_NAME);
        String patronymic = request.getParameter(PARAM_NAME_PATRONYMIC);
        String position = request.getParameter(PARAM_NAME_POSITION);
        Collaborator collaborator = new Collaborator(surname, name, patronymic, position);

        if (ValidatorSelector.getValidator(ValidatorType.COLLABORATOR_VALIDATOR).validate(collaborator)) {
            if ("edit-collaborator".equals(request.getSession().getAttribute(ATTRIBUTE_NAME_COMMAND))) {
                int id = Integer.parseInt(request.getParameter(PARAM_NAME_ID));
                Collaborator oldCollaborator = new Collaborator();
                oldCollaborator.setId(id);
                collaboratorService.updateCollaborator(oldCollaborator, collaborator);
            } else {
                collaboratorService.addCollaborator(collaborator);
            }
            path = PathManager.getInstance().getProperty(PathManager.LIST_OF_COLLABORATORS_URL_PATH);
        } else {
            request.getSession().setAttribute("errorMessage", MessageManager.getInstance().getProperty(MessageManager.SAVE_COLLABORATOR_ERROR_MESSAGE));
            path = PathManager.getInstance().getProperty(PathManager.ERROR_PAGE_PATH);
        }
        return path;
    }
}
