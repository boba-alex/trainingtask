package dao;

import entity.Collaborator;

import java.util.List;

public interface CollaboratorDAO {
    List<Collaborator> getCollaborators();

    void addCollaborator(Collaborator collaborator);

    void updateCollaborator(Collaborator collaborator, Collaborator newCollaborator);

    void deleteCollaboratorById(int id);

    Collaborator getCollaboratorById(int id);

}
