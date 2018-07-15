package command.project;

import command.Command;
import controller.MessageManager;
import controller.PathManager;
import entity.Project;
import entity.Task;
import exception.ValidationException;
import logger.SimpleLogger;
import service.ProjectService;
import service.TaskService;
import validation.ValidatorSelector;
import validation.ValidatorType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class SaveProjectCommand implements Command {

    private static final String PARAM_NAME_ID = "id";
    private static final String PARAM_NAME_NAME = "name";
    private static final String PARAM_NAME_SHORT_NAME = "short-name";
    private static final String PARAM_NAME_DESCRIPTION = "description";

    private static final String ATTRIBUTE_NAME_COMMAND = "command";
    private static final String ATTRIBUTE_NAME_PROJECT = "project";

    private static final String ATTRIBUTE_NAME_TASKS_OF_PROJECT = "tasksOfProject";

    private ProjectService projectService = new ProjectService();
    private TaskService taskService = new TaskService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ValidationException {
        String path;

        String name = request.getParameter(PARAM_NAME_NAME);
        String shortName = request.getParameter(PARAM_NAME_SHORT_NAME);
        String description = request.getParameter(PARAM_NAME_DESCRIPTION);
        Project project = new Project(name, shortName, description);

        if (ValidatorSelector.getValidator(ValidatorType.PROJECT_VALIDATOR).validate(project)) {
            if ("edit-project".equals(request.getSession().getAttribute(ATTRIBUTE_NAME_COMMAND))) {
                SimpleLogger.getLogger().fine("edit-project");
                int id = Integer.parseInt(request.getParameter(PARAM_NAME_ID));
                Project oldProject = new Project();
                oldProject.setId(id);
                projectService.updateProject(oldProject, project);
                ArrayList<Task> oldTasks = taskService.getTasksByProject(oldProject);
                SimpleLogger.getLogger().fine("oldTasks: " + oldTasks);
                ArrayList<Task> newTasks = (ArrayList<Task>) request.getSession().getAttribute(ATTRIBUTE_NAME_TASKS_OF_PROJECT);
                SimpleLogger.getLogger().fine("newTasks: " + newTasks);
                for (Task oldTask : oldTasks) {
                    if (newTasks.contains(oldTask)) {
                        taskService.updateTask(oldTask, newTasks.get(newTasks.indexOf(oldTask)));
                        newTasks.remove(oldTask);
                    } else {
                        taskService.deleteTaskById(oldTask.getId());
                    }
                }
                for (Task task : newTasks) {
                    taskService.addTask(task);
                }
            } else {
                projectService.addProject(project);
                for (Task task : (ArrayList<Task>) request.getSession().getAttribute(ATTRIBUTE_NAME_TASKS_OF_PROJECT)) {
                    taskService.addTask(task);
                }
            }
            request.getSession().removeAttribute(ATTRIBUTE_NAME_PROJECT);
            request.getSession().removeAttribute(ATTRIBUTE_NAME_TASKS_OF_PROJECT);
            path = PathManager.getInstance().getProperty(PathManager.LIST_OF_PROJECTS_URL_PATH);
        } else {
            request.getSession().setAttribute("errorMessage", MessageManager.getInstance().getProperty(MessageManager.SAVE_PROJECT_ERROR_MESSAGE));
            path = PathManager.getInstance().getProperty(PathManager.ERROR_PAGE_PATH);
        }
        return path;
    }
}
