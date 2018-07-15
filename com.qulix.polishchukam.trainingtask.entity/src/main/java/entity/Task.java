package entity;

import java.time.LocalDate;
import java.util.Objects;

public class Task extends BaseEntity {
    private String name;
    private int workInHours;
    private LocalDate beginTime;
    private LocalDate endTime;
    private TaskStatus taskStatus;
    private Collaborator collaborator;
    private Project project;

    public Task() {
    }

    public Task(String name, int workInHours, LocalDate beginTime, LocalDate endTime, TaskStatus taskStatus) {
        this.name = name;
        this.workInHours = workInHours;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.taskStatus = taskStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWorkInHours() {
        return workInHours;
    }

    public void setWorkInHours(int workInHours) {
        this.workInHours = workInHours;
    }

    public LocalDate getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(LocalDate beginTime) {
        this.beginTime = beginTime;
    }

    public LocalDate getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDate endTime) {
        this.endTime = endTime;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Collaborator getCollaborator() {
        return collaborator;
    }

    public void setCollaborator(Collaborator collaborator) {
        this.collaborator = collaborator;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        if(this.getId() == task.getId())
            return true;
        return workInHours == task.workInHours &&
                Objects.equals(name, task.name) &&
                Objects.equals(beginTime, task.beginTime) &&
                Objects.equals(endTime, task.endTime) &&
                taskStatus == task.taskStatus &&
                Objects.equals(collaborator, task.collaborator) &&
                Objects.equals(project, task.project);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, workInHours, beginTime, endTime, taskStatus, collaborator, project);
    }

    @Override
    public String toString() {
        return "entity.Task{" + super.toString() +
                "name='" + name + '\'' +
                ", workInHours=" + workInHours +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", taskStatus=" + taskStatus +
                ", projectID=" + project.getId() +
                '}';
    }
}

