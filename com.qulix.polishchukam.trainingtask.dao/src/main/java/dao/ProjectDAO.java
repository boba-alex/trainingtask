package dao;

import entity.Project;

import java.util.List;

public interface ProjectDAO {

    List<Project> getProjects();

    void addProject(final Project project);

    void updateProject(Project project, Project newProject);

    void deleteProjectById(int id);

    Project getProjectById(int id);

    int getMaxProjectId();


}
