package crud.app.dao;

import crud.app.models.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MemberDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MemberDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Member> index() {
        return jdbcTemplate.query("SELECT * FROM Member", new BeanPropertyRowMapper<>(Member.class));
    }

    public Optional<Member> show(String id) {
        return jdbcTemplate.query("SELECT * FROM Member WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Member.class))
                .stream().findAny();
    }

    public void create(Member member) {
        jdbcTemplate.update("INSERT INTO member(name, birthDay) VALUES (?, ?)", member.getName(), member.getBirthDay());
    }

    public void update(int id, Member memberToUpdate) {
        jdbcTemplate.update("UPDATE member SET name=?, birthDay=? WHERE id=?", memberToUpdate.getName(),
                memberToUpdate.getBirthDay(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM member WHERE id=?", id);
    }


}
