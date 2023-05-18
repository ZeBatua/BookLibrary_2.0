package crud.app.models;

public class Member {
    private int id;
    public String name;
    public String BirthDay;

    public Member(){}

    public Member(int id, String name, String birthDay) {
        this.id = id;
        this.name = name;
        BirthDay = birthDay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return BirthDay;
    }

    public void setBirthDay(String birthDay) {
        BirthDay = birthDay;
    }
}
