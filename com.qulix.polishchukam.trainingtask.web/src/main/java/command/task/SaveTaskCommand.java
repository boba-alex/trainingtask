package command.task;

import command.Command;
import controller.MessageManager;
import controller.PathManager;
import entity.Project;
import entity.Task;
import entity.TaskStatus;
import exception.ValidationException;
import logger.SimpleLogger;
import service.CollaboratorService;
import service.ProjectService;
import service.TaskService;
import validation.ValidatorSelector;
import validation.ValidatorType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class SaveTaskCommand implements Command {

    private static final String PARAM_NAME_ID = "id";
    private static final String PARAM_NAME_PROJECT_ID = "project-id";
    private static final String PARAM_NAME_NAME = "name";
    private static final String PARAM_NAME_WORK_IN_HOURS = "work-in-hours";
    private static final String PARAM_NAME_BEGIN_TIME = "begin-time";
    private static final String PARAM_NAME_END_TIME = "end-time";
    private static final String PARAM_NAME_TASK_STATUS = "task-status";
    private static final String PARAM_NAME_COLLABORATOR_ID = "collaborator-id";

    private static final String ATTRIBUTE_NAME_COMMAND = "command";
    private static final String ATTRIBUTE_NAME_PROJECT = "project";

    private static final String PARAM_NAME_PROJECT_IS_NEW = "project-is-new";
    private static final String PARAM_NAME_FROM_PROJECT_FORM = "from-project-form";

    private static final String PARAM_NAME_PROJECT_NAME = "project-name";
    private static final String PARAM_NAME_PROJECT_SHORT_NAME = "project-short-name";
    private static final String PARAM_NAME_PROJECT_DESCRIPTION = "project-description";

    private static final String ATTRIBUTE_NAME_TASKS_OF_PROJECT = "tasksOfProject";

    private TaskService taskService = new TaskService();
    private ProjectService projectService = new ProjectService();
    private CollaboratorService collaboratorService = new CollaboratorService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ValidationException {
        String path;

        SimpleLogger.getLogger().fine("projectId: " + request.getParameter(PARAM_NAME_PROJECT_ID));
        int projectId = Integer.parseInt(request.getParameter(PARAM_NAME_PROJECT_ID));
        String name = request.getParameter(PARAM_NAME_NAME);
        int workInHours = Integer.parseInt(request.getParameter(PARAM_NAME_WORK_IN_HOURS));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
        LocalDate beginTime = LocalDate.parse(request.getParameter(PARAM_NAME_BEGIN_TIME), formatter);
        LocalDate endTime = LocalDate.parse(request.getParameter(PARAM_NAME_END_TIME), formatter);
        TaskStatus taskStatus = TaskStatus.valueOf(request.getParameter(PARAM_NAME_TASK_STATUS));
        SimpleLogger.getLogger().fine("collaboratorId: " + request.getParameter(PARAM_NAME_COLLABORATOR_ID));
        int collaboratorId = Integer.parseInt(request.getParameter(PARAM_NAME_COLLABORATOR_ID));

        String projectName = request.getParameter(PARAM_NAME_PROJECT_NAME);
        String projectShortNamee = request.getParameter(PARAM_NAME_PROJECT_SHORT_NAME);
        String projectDescription = request.getParameter(PARAM_NAME_PROJECT_DESCRIPTION);
        Project project = new Project(projectName, projectShortNamee, projectDescription);
        project.setId(projectId);

        Task task = new Task(name, workInHours, beginTime, endTime, taskStatus);
        task.setCollaborator(collaboratorService.getCollaboratorById(collaboratorId));

        if (ValidatorSelector.getValidator(ValidatorType.TASK_VALIDATOR).validate(task)) {
            if (request.getParameter(PARAM_NAME_FROM_PROJECT_FORM) != null) {
                if (request.getParameter(PARAM_NAME_PROJECT_IS_NEW) != null) {
                    SimpleLogger.getLogger().fine("From new project");
                } else {
                    SimpleLogger.getLogger().fine("From existing project");
                }
                task.setProject(project);
                ArrayList<Task> tasksOfProject = (ArrayList<Task>) request.getSession().getAttribute(ATTRIBUTE_NAME_TASKS_OF_PROJECT);
                if ("edit-task".equals(request.getSession().getAttribute(ATTRIBUTE_NAME_COMMAND))) {
                    Task oldTask = new Task();
                    oldTask.setId(Integer.parseInt(request.getParameter(PARAM_NAME_ID)));
                    tasksOfProject.remove(oldTask);
                    task.setId(Integer.parseInt(request.getParameter(PARAM_NAME_ID)));
                    tasksOfProject.add(task);
                    SimpleLogger.getLogger().fine("tasksOfProject from edit-task: " + tasksOfProject);
                } else {
                    task.setId(taskService.getMaxTaskId() + tasksOfProject.size());
                    tasksOfProject.add(task);
                    SimpleLogger.getLogger().fine("tasksOfProject from add-task: " + tasksOfProject);
                }
                request.getSession().setAttribute(ATTRIBUTE_NAME_TASKS_OF_PROJECT, tasksOfProject);
            } else {
                SimpleLogger.getLogger().fine("From add-task from list-of-tasks");
                task.setProject(projectService.getProjectById(projectId));
                if ("edit-task".equals(request.getSession().getAttribute(ATTRIBUTE_NAME_COMMAND))) {
                    int id = Integer.parseInt(request.getParameter(PARAM_NAME_ID));
                    Task oldTask = new Task();
                    oldTask.setId(id);
                    taskService.updateTask(oldTask, task);
                    SimpleLogger.getLogger().fine("Task is updated");
                } else {
                    taskService.addTask(task);
                    SimpleLogger.getLogger().fine("Task is added");
                }
            }
            if (request.getParameter(PARAM_NAME_FROM_PROJECT_FORM) != null && request.getParameter(PARAM_NAME_PROJECT_IS_NEW) == null) {
                request.getSession().setAttribute(ATTRIBUTE_NAME_COMMAND, "edit-project");
            }
            if (request.getParameter(PARAM_NAME_FROM_PROJECT_FORM) != null) {
                String addParams = "?";
                if (request.getParameter(PARAM_NAME_PROJECT_IS_NEW) != null) {
                    addParams += PARAM_NAME_PROJECT_IS_NEW + "=" + PARAM_NAME_PROJECT_IS_NEW + "&&";
                }
                if (request.getParameter(PARAM_NAME_FROM_PROJECT_FORM) != null) {
                    addParams += PARAM_NAME_FROM_PROJECT_FORM + "=" + PARAM_NAME_FROM_PROJECT_FORM;
                }
                request.getSession().setAttribute(ATTRIBUTE_NAME_PROJECT, project);
                path = PathManager.getInstance().getProperty(PathManager.ADD_PROJECT_URL_PATH) + addParams;
            } else {
                path = PathManager.getInstance().getProperty(PathManager.LIST_OF_TASKS_URL_PATH);
            }
        } else {
            request.getSession().setAttribute("errorMessage", MessageManager.getInstance().getProperty(MessageManager.SAVE_TASK_ERROR_MESSAGE));
            path = PathManager.getInstance().getProperty(PathManager.ERROR_PAGE_PATH);
        }
        return path;
    }
}
