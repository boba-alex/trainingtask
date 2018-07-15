package service;

import dao.CollaboratorDAOImpl;
import entity.Collaborator;

import java.util.ArrayList;

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
}
