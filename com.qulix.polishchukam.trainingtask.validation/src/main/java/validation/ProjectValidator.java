package validation;

import entity.Project;
import exception.ValidationException;

import java.util.ResourceBundle;

public class ProjectValidator implements Validator {
    private static final String BUNDLE_NAME = "validation";
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);

    private final String MESSAGE_NULL_PROJECT = "MESSAGE_NULL_PROJECT";
    private final String MESSAGE_NULL_FIELDS = "MESSAGE_NULL_FIELDS";

    private final String MESSAGE_PROJECT_NAME = "MESSAGE_PROJECT_NAME";
    private final String MESSAGE_PROJECT_SHORT_NAME = "MESSAGE_PROJECT_SHORT_NAME";

    private final String PATTERN_PROJECT_NAME = "PATTERN_PROJECT_NAME";
    private final String PATTERN_PROJECT_SHORT_NAME = "PATTERN_PROJECT_SHORT_NAME";


    @Override
    public boolean validate(Object object) throws ValidationException {
        if (object == null) {
            throw new ValidationException(resourceBundle.getString(MESSAGE_NULL_PROJECT));
        }
        Project project = (Project) object;
        if (project.getName() == null || project.getShortName() == null) {
            throw new ValidationException(resourceBundle.getString(MESSAGE_NULL_FIELDS));
        }
        if (!project.getName().matches(resourceBundle.getString(PATTERN_PROJECT_NAME))) {
            throw new ValidationException(resourceBundle.getString(MESSAGE_PROJECT_NAME));
        }
        if (!project.getShortName().matches(resourceBundle.getString(PATTERN_PROJECT_SHORT_NAME))) {
            throw new ValidationException(resourceBundle.getString(MESSAGE_PROJECT_SHORT_NAME));
        }
        return true;
    }
}
