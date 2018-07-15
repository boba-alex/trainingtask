package controller;

import command.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public class CommandManager {
    private static CommandManager instance = null;

    HashMap<String, Command> commands = new HashMap<>();

    private CommandManager() {
        commands.put("add-collaborator", new AddCollaboratorCommand());
        commands.put("save-collaborator", new SaveCollaboratorCommand());
        commands.put("edit-collaborator", new EditCollaboratorCommand());
        commands.put("delete-collaborator", new DeleteCollaboratorCommand());

        commands.put("add-task", new AddTaskCommand());
        commands.put("save-task", new SaveTaskCommand());
        commands.put("edit-task", new EditTaskCommand());
        commands.put("delete-task", new DeleteTaskCommand());

        commands.put("add-project", new AddProjectCommand());
        commands.put("save-project", new SaveProjectCommand());
        commands.put("edit-project", new EditProjectCommand());
        commands.put("delete-project", new DeleteProjectCommand());
    }

    public Command getCommand(HttpServletRequest request) {
        String action = request.getParameter("command");

        Command command = commands.get(action);
        if (command == null) {
            command = new NoCommand();
        }
        return command;
    }

    //Singleton
    public static CommandManager getInstance() {
        if (instance == null) {
            instance = new CommandManager();
        }
        return instance;
    }
}
