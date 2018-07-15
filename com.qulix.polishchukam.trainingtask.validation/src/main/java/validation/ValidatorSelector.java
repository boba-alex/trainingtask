package validation;

public class ValidatorSelector {
    public static Validator getValidator(ValidatorType validatorType) {
        Validator validator = null;
        switch (validatorType) {
            case COLLABORATOR_VALIDATOR:
                validator = new CollaboratorValidator();
                break;
            case TASK_VALIDATOR:
                validator = new TaskValidator();
                break;
            case PROJECT_VALIDATOR:
                validator = new ProjectValidator();
                break;
        }
        return validator;
    }
}
