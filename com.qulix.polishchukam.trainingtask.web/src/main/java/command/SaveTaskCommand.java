package command;

import controller.PathManager;
import entity.Task;
import entity.TaskStatus;
import service.CollaboratorService;
import service.ProjectService;
import service.TaskService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SaveTaskCommand implements Command {

    private static final String PARAM_NAME_PROJECT_ID = "project-id";
    private static final String PARAM_NAME_NAME = "name";
    private static final String PARAM_NAME_WORK_IN_HOURS = "work-in-hours";
    private static final String PARAM_NAME_BEGIN_TIME = "begin-time";
    private static final String PARAM_NAME_END_TIME = "end-time";
    private static final String PARAM_NAME_TASK_STATUS = "task-status";
    private static final String PARAM_NAME_COLLABORATOR_ID = "collaborator-id";

    private static final String ATTRIBUTE_NAME_COMMAND = "command";
    private static final String ATTRIBUTE_NAME_TASK = "task";

    private TaskService taskService = new TaskService();
    private ProjectService projectService = new ProjectService();
    private CollaboratorService collaboratorService = new CollaboratorService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;

        int projectId = Integer.parseInt(request.getParameter(PARAM_NAME_PROJECT_ID));
        String name = request.getParameter(PARAM_NAME_NAME);
        int workInHours = Integer.parseInt(request.getParameter(PARAM_NAME_WORK_IN_HOURS));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
        LocalDate beginTime = LocalDate.parse(request.getParameter(PARAM_NAME_BEGIN_TIME), formatter);
        LocalDate endTime = LocalDate.parse(request.getParameter(PARAM_NAME_END_TIME), formatter);
        TaskStatus taskStatus = TaskStatus.valueOf(request.getParameter(PARAM_NAME_TASK_STATUS));
        int collaboratorId = Integer.parseInt(request.getParameter(PARAM_NAME_COLLABORATOR_ID));

        Task task = new Task(name, workInHours, beginTime, endTime, taskStatus);
        task.setProject(projectService.getProjectById(projectId));
        task.setCollaborator(collaboratorService.getCollaboratorById(collaboratorId));
        if ("edit-task".equals(request.getSession().getAttribute(ATTRIBUTE_NAME_COMMAND))) {
            Task oldTask = (Task) request.getSession().getAttribute(ATTRIBUTE_NAME_TASK);
            taskService.updateTask(oldTask, task);
        } else {
            taskService.addTask(task);
        }
        request.getSession().removeAttribute(ATTRIBUTE_NAME_TASK);

        page = PathManager.getInstance().getProperty(PathManager.LIST_OF_TASKS_PAGE_PATH);
        return page;
    }
}
