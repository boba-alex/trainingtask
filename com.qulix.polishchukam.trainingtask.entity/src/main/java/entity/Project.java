package entity;

import java.util.ArrayList;

public class Project extends BaseEntity {

    private String name;

    private String shortName;

    private String description;

    public Project() {
    }

    public Project(String name, String shortName, String description) {
        this.name = name;
        this.shortName = shortName;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "entity.Project{" + super.toString() +
                "name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
