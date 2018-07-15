package controller;

import command.Command;
import exception.ValidationException;
import logger.SimpleLogger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {

    public Controller() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String path = null;
        try {
            SimpleLogger.getLogger().fine(request.getParameter("command"));
            Command command = CommandManager.getInstance().getCommand(request);
            path = command.execute(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
            request.getSession().setAttribute("errorMessage", MessageManager.getInstance().getProperty(MessageManager.SERVLET_EXCEPTION_ERROR_MESSAGE));
            path = PathManager.getInstance().getProperty(PathManager.ERROR_PAGE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
            request.getSession().setAttribute("errorMessage", MessageManager.getInstance().getProperty(MessageManager.IO_EXCEPTION_ERROR_MESSAGE));
            path = PathManager.getInstance().getProperty(PathManager.ERROR_PAGE_PATH);
        } catch (ValidationException e) {
            request.getSession().setAttribute("errorMessage", e.getMessage());
            path = PathManager.getInstance().getProperty(PathManager.ERROR_PAGE_PATH);
        }

        if (request.getParameter("buttonSave") != null) {
            response.sendRedirect(path);
        } else {
            request.getRequestDispatcher(path).forward(request, response);
        }
    }
}
