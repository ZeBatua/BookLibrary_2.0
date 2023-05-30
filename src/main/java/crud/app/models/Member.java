package crud.app.models;

public class Member {
    private int member_id;
    private String name;
    private int birthDay;

    public Member(){}

    public Member(int member_id, String name, int birthDay) {
        this.member_id = member_id;
        this.name = name;
        this.birthDay = birthDay;
    }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(int birthDay) {
        this.birthDay = birthDay;
    }
}
