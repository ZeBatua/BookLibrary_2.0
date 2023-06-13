package crud.app.dao;

import org.springframework.stereotype.Component;

@Component
public class BookDAO {
//    private final JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public BookDAO(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public List<Book> listBook() {
//        return jdbcTemplate.query("SELECT id, name, author, year FROM Book", new BeanPropertyRowMapper<>(Book.class));
//    }
//
//    public Book info(int book_id) {
//        return jdbcTemplate.query("SELECT * FROM Book WHERE id=?", new Object[]{book_id}, new BeanPropertyRowMapper<>(Book.class))
//                .stream().findAny().orElse(null);
//    }
//
//    public void create(Book book) {
//        jdbcTemplate.update("INSERT INTO Book(name, author, year) VALUES (?, ?, ?)", book.getName(), book.getAuthor(), book.getYear());
//    }
//
//    public void update(int book_id, Book bookToUpdate) {
//        jdbcTemplate.update("UPDATE Book SET name=?, author=?, year=? WHERE id=?",
//                bookToUpdate.getName(), bookToUpdate.getAuthor(), bookToUpdate.getYear(), book_id);
//    }
//
//    public void delete(int book_id) {
//        jdbcTemplate.update("DELETE FROM Book WHERE id=?", book_id);
//    }
//
//    public void assign(int book_id, Member selectedPerson) {
//        jdbcTemplate.update("UPDATE Book SET member_id=? WHERE id=?", selectedPerson.getMember_id(), book_id);
//    }
//
//    public void release(int book_id) {
//        jdbcTemplate.update("UPDATE Book SET member_id=NULL WHERE id=?", book_id);
//    }
//
//    public List<Book> listOwnerBook(int member_id) {
//        return jdbcTemplate.query("SELECT * FROM Book WHERE member_id=?", new Object[]{member_id}, new BeanPropertyRowMapper<>(Book.class));
//    }
//
//    public Optional<Member> getBookOwner(int book_id) {
//        return jdbcTemplate.query("SELECT Member.* FROM Book JOIN Member ON Book.member_id = Member.member_id WHERE Book.id = ?",
//                new Object[]{book_id}, new BeanPropertyRowMapper<>(Member.class)).stream().findAny();
//    }

}
