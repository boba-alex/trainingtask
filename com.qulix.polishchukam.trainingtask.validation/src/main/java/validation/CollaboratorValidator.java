package validation;

import entity.Collaborator;
import exception.ValidationException;

import java.util.ResourceBundle;

public class CollaboratorValidator implements Validator {
    private static final String BUNDLE_NAME = "validation";
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);

    private final String MESSAGE_NULL_COLLABORATOR = "MESSAGE_NULL_COLLABORATOR";
    private final String MESSAGE_NULL_FIELDS = "MESSAGE_NULL_FIELDS";

    private final String MESSAGE_COLLABORATOR_SURNAME = "MESSAGE_COLLABORATOR_SURNAME";
    private final String MESSAGE_COLLABORATOR_NAME = "MESSAGE_COLLABORATOR_NAME";
    private final String MESSAGE_COLLABORATOR_PATRONYMIC = "MESSAGE_COLLABORATOR_PATRONYMIC";
    private final String MESSAGE_COLLABORATOR_POSITION = "MESSAGE_COLLABORATOR_POSITION";

    private final String PATTERN_COLLABORATOR_SURNAME = "PATTERN_COLLABORATOR_SURNAME";
    private final String PATTERN_COLLABORATOR_NAME = "PATTERN_COLLABORATOR_NAME";
    private final String PATTERN_COLLABORATOR_PATRONYMIC = "PATTERN_COLLABORATOR_PATRONYMIC";
    private final String PATTERN_COLLABORATOR_POSITION = "PATTERN_COLLABORATOR_POSITION";

    @Override
    public boolean validate(Object object) throws ValidationException {
        if (object == null) {
            throw new ValidationException(resourceBundle.getString(MESSAGE_NULL_COLLABORATOR));
        }
        Collaborator collaborator = (Collaborator) object;
        if (collaborator.getSurname() == null || collaborator.getName() == null || collaborator.getPatronymic() == null || collaborator.getPosition() == null) {
            throw new ValidationException(resourceBundle.getString(MESSAGE_NULL_FIELDS));
        }
        if (!collaborator.getSurname().matches(resourceBundle.getString(PATTERN_COLLABORATOR_SURNAME))) {
            throw new ValidationException(resourceBundle.getString(MESSAGE_COLLABORATOR_SURNAME));
        }
        if (!collaborator.getName().matches(resourceBundle.getString(PATTERN_COLLABORATOR_NAME))) {
            throw new ValidationException(resourceBundle.getString(MESSAGE_COLLABORATOR_NAME));
        }
        if (!collaborator.getPatronymic().matches(resourceBundle.getString(PATTERN_COLLABORATOR_PATRONYMIC))) {
            throw new ValidationException(resourceBundle.getString(MESSAGE_COLLABORATOR_PATRONYMIC));
        }
        if (!collaborator.getPosition().matches(resourceBundle.getString(PATTERN_COLLABORATOR_POSITION))) {
            throw new ValidationException(resourceBundle.getString(MESSAGE_COLLABORATOR_POSITION));
        }
        return true;
    }
}
