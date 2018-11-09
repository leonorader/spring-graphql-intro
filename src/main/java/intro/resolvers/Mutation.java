package intro.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import intro.entities.Author;
import intro.entities.Book;
import intro.entities.BookInput;
import intro.repositories.AuthorRepository;
import intro.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public Long addBook(BookInput bookInput) {
        Author author = authorRepository.getOne(bookInput.getAuthorId());
        Book book = bookRepository.saveAndFlush(new Book(bookInput.getTitle(), bookInput.getIsbn(), bookInput.getGenre(), author));
        return book.getId();
    }

}