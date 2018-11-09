package intro.entities;

import intro.enums.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookInput {

    private Long id;

    private String title;

    private String isbn;

    private Genre genre;

    private Long authorId;
}