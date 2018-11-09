package intro.resolvers;

import java.util.ArrayList;
import java.util.List;

import intro.entities.Book;
import intro.enums.Animal;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import intro.enums.Genre;
import intro.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import intro.entities.Pet;

@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    private BookRepository bookRepository;

    public List<Pet> pets() {
        List<Pet> pets = new ArrayList<>();
        Pet aPet = new Pet();
        aPet.setId(1l);
        aPet.setName("Bill");
        aPet.setAge(9);
        aPet.setType(Animal.MAMMOTH);
        pets.add(aPet);
        return pets;
    }

    public List<Book> books() {
        return bookRepository.findAll();
    }

    public List<Book> booksByGenre(Genre genre) {
        return bookRepository.findByGenre(genre);
    }

}