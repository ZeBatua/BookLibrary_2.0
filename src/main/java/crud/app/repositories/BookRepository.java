package crud.app.repositories;

import crud.app.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
//    Optional<Member> findByOwner();
}
