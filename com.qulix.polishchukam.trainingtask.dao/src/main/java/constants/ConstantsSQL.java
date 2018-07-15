package constants;

public class ConstantsSQL {

    public static final String SQL_QUERY_GET_COLLABORATORS = "SELECT * FROM collaborator";
    public static final String SQL_QUERY_GET_COLLABORATOR_BY_ID = SQL_QUERY_GET_COLLABORATORS + " WHERE id = ?";
    public static final String SQL_QUERY_ADD_COLLABORATOR = "INSERT INTO collaborator (surname, name, patronymic, position) VALUES (?,?,?,?)";
    public static final String SQL_QUERY_UPDATE_COLLABORATOR_BY_ID = "UPDATE collaborator SET surname = ?, name = ?, patronymic = ?, position = ? WHERE id = ?";
    public static final String SQL_QUERY_DELETE_COLLABORATOR_BY_ID = "DELETE FROM collaborator WHERE id = ?";

    public static final String SQL_QUERY_GET_TASKS = "SELECT t.id, t.name, t.work_in_hours, t.begin_time, t.end_time, t.status, t.collaborator_id, t.project_id, " +
            "c.surname, c.name, c.patronymic, c.position, p.name, p.short_name, p.description " +
            "FROM task t INNER JOIN collaborator c ON t.collaborator_id = c.id " +
            "INNER JOIN project p ON t.project_id = p.id";
    public static final String SQL_QUERY_GET_TASK_BY_ID = SQL_QUERY_GET_TASKS + " WHERE t.id = ?";
    public static final String SQL_QUERY_GET_TASKS_BY_PROJECT_ID = SQL_QUERY_GET_TASKS + " WHERE t.project_id = ?";
    public static final String SQL_QUERY_ADD_TASK = "INSERT INTO task (name, work_in_hours, begin_time, end_time, status, collaborator_id, project_id) VALUES (?,?,?,?,?,?,?)";
    public static final String SQL_QUERY_UPDATE_TASK_BY_ID = "UPDATE task SET name = ?, work_in_hours = ?, begin_time = ?, end_time = ?, status = ?, collaborator_id = ?, project_id = ? WHERE id = ?";
    public static final String SQL_QUERY_DELETE_TASK_BY_ID = "DELETE FROM task WHERE id = ?";

    public static final String SQL_QUERY_GET_PROJECTS = "SELECT id, name, short_name, description FROM project";
    public static final String SQL_QUERY_GET_PROJECT_BY_ID = SQL_QUERY_GET_PROJECTS + " WHERE id = ?";
    public static final String SQL_QUERY_ADD_PROJECT = "INSERT INTO project (name, short_name, description) VALUES (?,?,?)";
    public static final String SQL_QUERY_UPDATE_PROJECT_BY_ID = "UPDATE project SET name = ?, short_name = ?, description = ? WHERE id = ?";
    public static final String SQL_QUERY_DELETE_PROJECT_BY_ID = "DELETE FROM project WHERE id = ?";


}
