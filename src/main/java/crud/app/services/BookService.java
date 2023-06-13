package crud.app.services;

import crud.app.models.Book;
import crud.app.models.Member;
import crud.app.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findById(int id) {
        Optional<Book> foundBook = bookRepository.findById(id);
        return foundBook.orElse(null);
    }

//    public Member findByOwner() {
//        Optional<Member> findOwner = bookRepository.findByOwner();
//        return findOwner.orElse(null);
//    }

    @Transactional
    public void save(Book person) {
        bookRepository.save(person);
    }

    @Transactional
    public void delete(int id) {
        bookRepository.deleteById(id);
    }

    public Member getBookOwner(int id) {
        return bookRepository.findById(id).map(Book::getOwner).orElse(null);
    }

    @Transactional
    public void release(int id) {
        bookRepository.findById(id).ifPresent(book -> book.setOwner(null));
    }

    @Transactional
    public void assign(int id, Member selectedMember) {
        bookRepository.findById(id).ifPresent(
                book -> book.setOwner(selectedMember)
        );
    }


}
