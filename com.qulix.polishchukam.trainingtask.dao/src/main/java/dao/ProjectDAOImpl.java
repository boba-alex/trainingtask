package dao;

import constants.ConstantsSQL;
import db.DBHelper;
import entity.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectDAOImpl implements ProjectDAO {
    @Override
    public List<Project> getProjects() {
        Connection connection = DBHelper.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        List<Project> projects = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(ConstantsSQL.SQL_QUERY_GET_PROJECTS);
            projects = initProjects(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeResultSet(resultSet);
            DBHelper.closeStatement(statement);
            DBHelper.closeConnection(connection);
        }
        return projects;
    }

    @Override
    public void addProject(Project project) {
        Connection connection = DBHelper.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(ConstantsSQL.SQL_QUERY_ADD_PROJECT);
            preparedStatement.setString(1, project.getName());
            preparedStatement.setString(2, project.getShortName());
            preparedStatement.setString(3, project.getDescription());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBHelper.closePreparedStatement(preparedStatement);
            DBHelper.closeConnection(connection);
        }
    }

    @Override
    public void updateProject(Project project, Project newProject) {
        Connection connection = DBHelper.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(ConstantsSQL.SQL_QUERY_UPDATE_PROJECT_BY_ID);
            preparedStatement.setInt(4, project.getId());
            preparedStatement.setString(1, newProject.getName());
            preparedStatement.setString(2, newProject.getShortName());
            preparedStatement.setString(3, newProject.getDescription());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBHelper.closePreparedStatement(preparedStatement);
            DBHelper.closeConnection(connection);
        }
    }

    @Override
    public void deleteProjectById(int id) {
        Connection connection = DBHelper.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(ConstantsSQL.SQL_QUERY_DELETE_PROJECT_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBHelper.closePreparedStatement(preparedStatement);
            DBHelper.closeConnection(connection);
        }
    }

    @Override
    public Project getProjectById(int id) {
        Connection connection = DBHelper.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Project> projects = null;
        try {
            preparedStatement = connection.prepareStatement(ConstantsSQL.SQL_QUERY_GET_PROJECT_BY_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            projects = initProjects(resultSet);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBHelper.closeResultSet(resultSet);
            DBHelper.closePreparedStatement(preparedStatement);
            DBHelper.closeConnection(connection);
        }
        return projects.get(0);
    }

    private List<Project> initProjects(ResultSet resultSet) throws SQLException {
        List<Project> projects = new ArrayList<>();
        while (resultSet.next()) {
            Project project = new Project();
            project.setId(resultSet.getInt(1));
            project.setName(resultSet.getString(2));
            project.setShortName(resultSet.getString(3));
            project.setDescription(resultSet.getString(4));
            projects.add(project);
        }
        return projects;
    }
}
