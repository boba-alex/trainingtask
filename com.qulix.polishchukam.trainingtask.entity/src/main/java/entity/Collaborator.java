package entity;

public class Collaborator extends BaseEntity {

    private String surname;
    private String name;
    private String patronymic;
    private String position;

    public Collaborator() {
    }

    public Collaborator(String surname, String name, String patronymic, String position) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.position = position;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "entity.Collaborator{" + super.toString() +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
