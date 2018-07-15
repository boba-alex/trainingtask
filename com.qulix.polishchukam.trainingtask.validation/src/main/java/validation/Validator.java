package validation;

import exception.ValidationException;

public interface Validator {
    boolean validate(Object o) throws ValidationException;
}
