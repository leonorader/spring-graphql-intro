package intro;

import intro.entities.Author;
import intro.entities.Book;
import intro.enums.Genre;
import intro.repositories.AuthorRepository;
import intro.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public void run(String...args) throws Exception {
        Author w = new Author("Writer Wayne");
        Author p = new Author("Poet Peter");

        w = authorRepository.save(w);
        p = authorRepository.save(p);

        Book b1 = new Book("Good Book", "12345", Genre.MYSTERY, w);
        Book b2 = new Book("Even Better Book", "54321", Genre.MYSTERY, w);
        Book b3 = new Book("Great Poems", "64789", Genre.POETRY, p);

        bookRepository.save(b1);
        bookRepository.save(b2);
        bookRepository.save(b3);
    }

}