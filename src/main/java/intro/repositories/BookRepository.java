package intro.repositories;

import intro.entities.Book;
import intro.enums.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByGenre(Genre genre);

}
