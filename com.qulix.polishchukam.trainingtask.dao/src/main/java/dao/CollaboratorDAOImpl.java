package dao;

import constants.ConstantsSQL;
import db.DBHelper;
import entity.Collaborator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CollaboratorDAOImpl implements CollaboratorDAO {
    @Override
    public List<Collaborator> getCollaborators() {
        Connection connection = DBHelper.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        List<Collaborator> collaborators = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(ConstantsSQL.SQL_QUERY_GET_COLLABORATORS);
            collaborators = initCollaborators(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeResultSet(resultSet);
            DBHelper.closeStatement(statement);
            DBHelper.closeConnection(connection);
        }
        return collaborators;
    }

    @Override
    public void addCollaborator(Collaborator collaborator) {
        Connection connection = DBHelper.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(ConstantsSQL.SQL_QUERY_ADD_COLLABORATOR);
            preparedStatement.setString(1, collaborator.getSurname());
            preparedStatement.setString(2, collaborator.getName());
            preparedStatement.setString(3, collaborator.getPatronymic());
            preparedStatement.setString(4, collaborator.getPosition());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBHelper.closePreparedStatement(preparedStatement);
            DBHelper.closeConnection(connection);
        }
    }

    @Override
    public void updateCollaborator(Collaborator collaborator, Collaborator newCollaborator) {
        Connection connection = DBHelper.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(ConstantsSQL.SQL_QUERY_UPDATE_COLLABORATOR_BY_ID);
            preparedStatement.setInt(5, collaborator.getId());
            preparedStatement.setString(1, newCollaborator.getSurname());
            preparedStatement.setString(2, newCollaborator.getName());
            preparedStatement.setString(3, newCollaborator.getPatronymic());
            preparedStatement.setString(4, newCollaborator.getPosition());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBHelper.closePreparedStatement(preparedStatement);
            DBHelper.closeConnection(connection);
        }
    }

    @Override
    public void deleteCollaboratorById(int id) {
        Connection connection = DBHelper.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(ConstantsSQL.SQL_QUERY_DELETE_COLLABORATOR_BY_ID);
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
    public Collaborator getCollaboratorById(int id) {
        Connection connection = DBHelper.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Collaborator> collaborators = null;
        try {
            preparedStatement = connection.prepareStatement(ConstantsSQL.SQL_QUERY_GET_COLLABORATOR_BY_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            collaborators = initCollaborators(resultSet);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBHelper.closeResultSet(resultSet);
            DBHelper.closePreparedStatement(preparedStatement);
            DBHelper.closeConnection(connection);
        }
        return collaborators.get(0);
    }

    private List<Collaborator> initCollaborators(ResultSet resultSet) throws SQLException {
        List<Collaborator> collaborators = new ArrayList<>();
        while (resultSet.next()) {
            Collaborator collaborator = new Collaborator();
            collaborator.setId(resultSet.getInt(1));
            collaborator.setSurname(resultSet.getString(2));
            collaborator.setName(resultSet.getString(3));
            collaborator.setPatronymic(resultSet.getString(4));
            collaborator.setPosition(resultSet.getString(5));

            collaborators.add(collaborator);
        }
        return collaborators;
    }

}
