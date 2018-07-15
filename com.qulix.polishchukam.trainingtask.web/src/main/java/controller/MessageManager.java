package controller;

import java.util.ResourceBundle;

public class MessageManager {

    private static MessageManager instance;
    private ResourceBundle resourceBundle;
    private static final String BUNDLE_NAME = "messages";

    public static final String SERVLET_EXCEPTION_ERROR_MESSAGE = "SERVLET_EXCEPTION_ERROR_MESSAGE";
    public static final String IO_EXCEPTION_ERROR_MESSAGE = "IO_EXCEPTION_ERROR_MESSAGE";

    public static final String SAVE_COLLABORATOR_ERROR_MESSAGE = "SAVE_COLLABORATOR_ERROR_MESSAGE";
    public static final String SAVE_TASK_ERROR_MESSAGE = "SAVE_TASK_ERROR_MESSAGE";
    public static final String SAVE_PROJECT_ERROR_MESSAGE = "SAVE_PROJECT_ERROR_MESSAGE";

    public static MessageManager getInstance() {
        if (instance == null) {
            instance = new MessageManager();
            instance.resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);
        }
        return instance;
    }

    public String getProperty(String key) {
        return (String) resourceBundle.getObject(key);
    }
}
