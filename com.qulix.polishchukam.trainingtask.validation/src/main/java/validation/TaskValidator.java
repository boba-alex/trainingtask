package validation;

import entity.Task;
import exception.ValidationException;

import java.util.ResourceBundle;

public class TaskValidator implements Validator {
    private static final String BUNDLE_NAME = "validation";
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);

    private final String MESSAGE_NULL_TASK = "MESSAGE_NULL_TASK";
    private final String MESSAGE_NULL_FIELDS = "MESSAGE_NULL_FIELDS";

    private final String PATTERN_TASK_NAME = "PATTERN_TASK_NAME";
    private final int MAX_WORK_IN_HOURS_VALUE = 10000;

    private final String MESSAGE_TASK_NAME = "MESSAGE_TASK_NAME";
    private final String MESSAGE_TASK_WORK_IN_HOURS = "MESSAGE_TASK_WORK_IN_HOURS";

    @Override
    public boolean validate(Object object) throws ValidationException {
        if (object == null) {
            throw new ValidationException(resourceBundle.getString(MESSAGE_NULL_TASK));
        }
        Task task = (Task) object;
        if (task.getName() == null || task.getBeginTime() == null || task.getEndTime() == null || task.getTaskStatus() == null) {
            throw new ValidationException(resourceBundle.getString(MESSAGE_NULL_FIELDS));
        }
        if (!task.getName().matches(resourceBundle.getString(PATTERN_TASK_NAME))) {
            throw new ValidationException(resourceBundle.getString(MESSAGE_TASK_NAME));
        }
        if (task.getWorkInHours() > MAX_WORK_IN_HOURS_VALUE || task.getWorkInHours() < 0) {
            throw new ValidationException(resourceBundle.getString(MESSAGE_TASK_WORK_IN_HOURS));
        }
        return true;
    }
}
