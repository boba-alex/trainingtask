package service;

import dao.CollaboratorDAOImpl;
import entity.Collaborator;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CollaboratorService {

    private CollaboratorDAOImpl collaboratorDAO = new CollaboratorDAOImpl();

    public ArrayList<Collaborator> getCollaborators() {
        return (ArrayList<Collaborator>) collaboratorDAO.getCollaborators();
    }

    public void addCollaborator(Collaborator collaborator) {
        collaboratorDAO.addCollaborator(collaborator);
    }

    public void updateCollaborator(Collaborator collaborator, Collaborator newCollaborator) {
        collaboratorDAO.updateCollaborator(collaborator, newCollaborator);
    }

    public void deleteCollaboratorById(int id) {
        collaboratorDAO.deleteCollaboratorById(id);
    }

    public Collaborator getCollaboratorById(int id) {
        return collaboratorDAO.getCollaboratorById(id);
    }

    public boolean checkCollaborator(Collaborator collaborator) {
        if (collaborator.getSurname() == null || collaborator.getName() == null || collaborator.getPatronymic() == null || collaborator.getPosition() == null) {
            return false;
        }

        Pattern pattern = Pattern.compile("[a-zA-Z\u0400-\u044F]+");
        Matcher matcher = pattern.matcher(collaborator.getSurname());

        if (!matcher.matches()) {
            return false;
        }

        matcher = pattern.matcher(collaborator.getName());
        if (!matcher.matches()) {
            return false;
        }

        matcher = pattern.matcher(collaborator.getPatronymic());
        if (!matcher.matches()) {
            return false;
        }

        matcher = pattern.matcher(collaborator.getPosition());
        if (!matcher.matches()) {
            return false;
        }

        return true;
    }
}
