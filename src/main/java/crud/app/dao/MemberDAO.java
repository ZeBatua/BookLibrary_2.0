package crud.app.dao;

import crud.app.models.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MemberDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MemberDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Member> listMember() {
        return jdbcTemplate.query("SELECT * FROM Member", new BeanPropertyRowMapper<>(Member.class));
    }

    public Member info(int member_id) {
        return jdbcTemplate.query("SELECT * FROM Member WHERE member_id=?", new Object[]{member_id}, new BeanPropertyRowMapper<>(Member.class))
                .stream().findAny().orElse(null);
    }

    public void create(Member member) { // same
        jdbcTemplate.update("INSERT INTO member(name, birthDay) VALUES (?, ?)", member.getName(), member.getBirthDay());
    }

    public void update(int member_id, Member memberToUpdate) {
        jdbcTemplate.update("UPDATE Member SET name=?, birthday=? WHERE member_id=?", memberToUpdate.getName(),
                memberToUpdate.getBirthDay(), member_id);
    }

    public void delete(int member_id) {
        jdbcTemplate.update("DELETE FROM member WHERE member_id=?", member_id);
    }

}
