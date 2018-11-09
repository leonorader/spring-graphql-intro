package intro.entities;

import intro.enums.Genre;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255)
    private String title;

    @Column(length = 20)
    private String isbn;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @ManyToOne
    private Author author;

    public Book(String title, String isbn, Genre genre, Author author) {
        this.title = title;
        this.isbn = isbn;
        this.genre = genre;
        this.author = author;
    }

}