package crud.app.models;

public class Member {
    public String name;
    public String BirthDay;

    public Member(){}

    public Member(String name, String birthDay) {
        this.name = name;
        BirthDay = birthDay;
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
