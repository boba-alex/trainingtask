package service;

import dao.ProjectDAO;
import dao.ProjectDAOImpl;
import entity.Project;

import java.util.ArrayList;

public class ProjectService {

    private ProjectDAO projectDAO = new ProjectDAOImpl();

    public ArrayList<Project> getProjects() {
        return (ArrayList<Project>) projectDAO.getProjects();
    }

    public void addProject(final Project project) {
        projectDAO.addProject(project);
    }

    public void updateProject(Project project, Project newProject) {
        projectDAO.updateProject(project, newProject);
    }

    public void deleteProjectById(int id) {
        projectDAO.deleteProjectById(id);
    }

    public Project getProjectById(int id) {
        return projectDAO.getProjectById(id);
    }
}
