package dao;

import constants.ConstantsSQL;
import db.DBHelper;
import entity.Collaborator;
import entity.Project;
import entity.Task;
import entity.TaskStatus;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskDAOImpl implements TaskDAO {
    @Override
    public List<Task> getTasks() {
        Connection connection = DBHelper.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        List<Task> tasks = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(ConstantsSQL.SQL_QUERY_GET_TASKS);
            tasks = initTasks(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeResultSet(resultSet);
            DBHelper.closeStatement(statement);
            DBHelper.closeConnection(connection);
        }
        return tasks;
    }

    @Override
    public void addTask(Task task) {
        Connection connection = DBHelper.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(ConstantsSQL.SQL_QUERY_ADD_TASK);
            preparedStatement.setString(1, task.getName());
            preparedStatement.setInt(2, task.getWorkInHours());
            preparedStatement.setObject(3, Date.valueOf(task.getBeginTime()));
            preparedStatement.setObject(4, Date.valueOf(task.getEndTime()));
            preparedStatement.setString(5, task.getTaskStatus().toString());
            preparedStatement.setInt(6, task.getCollaborator().getId());
            preparedStatement.setInt(7, task.getProject().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBHelper.closePreparedStatement(preparedStatement);
            DBHelper.closeConnection(connection);
        }
    }

    @Override
    public void updateTask(Task task, Task newTask) {
        Connection connection = DBHelper.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(ConstantsSQL.SQL_QUERY_UPDATE_TASK_BY_ID);
            preparedStatement.setInt(8, task.getId());
            preparedStatement.setString(1, newTask.getName());
            preparedStatement.setInt(2, newTask.getWorkInHours());
            preparedStatement.setObject(3, Date.valueOf(newTask.getBeginTime()));
            preparedStatement.setObject(4, Date.valueOf(newTask.getEndTime()));
            preparedStatement.setString(5, newTask.getTaskStatus().toString());
            preparedStatement.setInt(6, newTask.getCollaborator().getId());
            preparedStatement.setInt(7, newTask.getProject().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBHelper.closePreparedStatement(preparedStatement);
            DBHelper.closeConnection(connection);
        }
    }

    @Override
    public void deleteTaskById(int id) {
        Connection connection = DBHelper.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(ConstantsSQL.SQL_QUERY_DELETE_TASK_BY_ID);
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
    public Task getTaskById(int id) {
        Connection connection = DBHelper.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Task> tasks = null;
        try {
            preparedStatement = connection.prepareStatement(ConstantsSQL.SQL_QUERY_GET_TASK_BY_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            tasks = initTasks(resultSet);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBHelper.closeResultSet(resultSet);
            DBHelper.closePreparedStatement(preparedStatement);
            DBHelper.closeConnection(connection);
        }
        return tasks.get(0);
    }

    @Override
    public List<Task> getTasksByProject(Project project) {
        Connection connection = DBHelper.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Task> tasks = null;
        try {
            preparedStatement = connection.prepareStatement(ConstantsSQL.SQL_QUERY_GET_TASKS_BY_PROJECT_ID);
            preparedStatement.setInt(1, project.getId());
            resultSet = preparedStatement.executeQuery();
            tasks = initTasks(resultSet);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBHelper.closeResultSet(resultSet);
            DBHelper.closePreparedStatement(preparedStatement);
            DBHelper.closeConnection(connection);
        }
        return tasks;
    }

    @Override
    public int getMaxTaskId() {
        Connection connection = DBHelper.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        int maxTaskId = 0;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(ConstantsSQL.SQL_QUERY_MAX_TASK_ID);
            resultSet.next();
            maxTaskId = resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeResultSet(resultSet);
            DBHelper.closeStatement(statement);
            DBHelper.closeConnection(connection);
        }
        return maxTaskId;
    }

    private List<Task> initTasks(ResultSet resultSet) throws SQLException {
        List<Task> tasks = new ArrayList<>();
        while (resultSet.next()) {
            Task task = new Task();
            Collaborator collaborator = new Collaborator();
            Project project = new Project();

            task.setId(resultSet.getInt(1));
            task.setName(resultSet.getString(2));
            task.setWorkInHours(resultSet.getInt(3));
            task.setBeginTime(resultSet.getObject(4, LocalDate.class));
            task.setEndTime(resultSet.getObject(5, LocalDate.class));
            task.setTaskStatus(TaskStatus.valueOf(resultSet.getString(6)));

            collaborator.setId(resultSet.getInt(7));
            project.setId(resultSet.getInt(8));

            collaborator.setSurname(resultSet.getString(9));
            collaborator.setName(resultSet.getString(10));
            collaborator.setPatronymic(resultSet.getString(11));
            collaborator.setPosition(resultSet.getString(12));

            project.setName(resultSet.getString(13));
            project.setShortName(resultSet.getString(14));
            project.setDescription(resultSet.getString(15));
            task.setCollaborator(collaborator);
            task.setProject(project);
            tasks.add(task);
        }
        return tasks;
    }
}
