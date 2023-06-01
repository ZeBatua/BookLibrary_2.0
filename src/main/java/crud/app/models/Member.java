package crud.app.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Member {
    private int member_id;

    @NotEmpty(message = "Имя не может быть пустым")
    @Size(min = 2, max = 100, message = "Имя должно содержать от 2 до 100 символов")
    private String name;

    @Pattern(regexp = "[0-9]{2}\\.[0-9]{2}\\.[0-9]{4}", message = "Используйте формат MM.DD.YYYY")
    private String birthDay;

    public Member() {
    }

    public Member(int member_id, String name, String birthDay) {
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

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }
}
