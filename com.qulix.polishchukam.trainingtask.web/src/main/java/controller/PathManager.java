package controller;

import java.util.ResourceBundle;

public class PathManager {

    private static PathManager instance;
    private ResourceBundle resourceBundle;
    private static final String BUNDLE_NAME = "config";

    public static final String INDEX_URL_PATH = "INDEX_URL_PATH";
    public static final String ERROR_PAGE_PATH = "ERROR_PAGE_PATH";

    public static final String LIST_OF_COLLABORATORS_URL_PATH = "LIST_OF_COLLABORATORS_URL_PATH";
    public static final String LIST_OF_TASKS_URL_PATH = "LIST_OF_TASKS_URL_PATH";
    public static final String LIST_OF_PROJECTS_URL_PATH = "LIST_OF_PROJECTS_URL_PATH";

    public static final String ADD_COLLABORATOR_URL_PATH = "ADD_COLLABORATOR_URL_PATH";
    public static final String ADD_TASK_URL_PATH = "ADD_TASK_URL_PATH";
    public static final String ADD_PROJECT_URL_PATH = "ADD_PROJECT_URL_PATH";

    public static PathManager getInstance() {
        if (instance == null) {
            instance = new PathManager();
            instance.resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);
        }
        return instance;
    }

    public String getProperty(String key) {
        return (String) resourceBundle.getObject(key);
    }
}
