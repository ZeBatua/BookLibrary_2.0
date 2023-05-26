package crud.app.dao;

import crud.app.models.Book;
import crud.app.models.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BookDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> listBook() {
        return jdbcTemplate.query("SELECT book_id, name, author, year FROM Book", new BeanPropertyRowMapper<>(Book.class));
    }

    public Book info(int book_id) {
        return jdbcTemplate.query("SELECT book_id, name, author, year FROM Book WHERE book_id=?", new Object[]{book_id}, new BeanPropertyRowMapper<>(Book.class))
                .stream().findAny().orElse(null);
    }

    public void create(Book book) {
        jdbcTemplate.update("INSERT INTO Book(name, author, year) VALUES (?, ?, ?)", book.getName(), book.getAuthor(), book.getYear());
    }

    public void update(int book_id, Book bookToUpdate) {
        jdbcTemplate.update("UPDATE Book SET name=?, author=?, year=? WHERE book_id=?",
                bookToUpdate.getName(), bookToUpdate.getAuthor(), bookToUpdate.getYear(), book_id);
    }

    public void delete(int book_id) {
        jdbcTemplate.update("DELETE FROM Book WHERE book_id=?", book_id);
    }

}
