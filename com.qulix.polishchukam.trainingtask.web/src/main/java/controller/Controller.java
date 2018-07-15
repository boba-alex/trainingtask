package controller;

import command.Command;

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
        String page = null;
        try {
            Command command = CommandManager.getInstance().getCommand(request);
            page = command.execute(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", MessageManager.getInstance().getProperty(MessageManager.SERVLET_EXCEPTION_ERROR_MESSAGE));
            page = PathManager.getInstance().getProperty(PathManager.ERROR_PAGE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", MessageManager.getInstance().getProperty(MessageManager.IO_EXCEPTION_ERROR_MESSAGE));
            page = PathManager.getInstance().getProperty(PathManager.ERROR_PAGE_PATH);
        }
        response.sendRedirect(page);
    }
}
