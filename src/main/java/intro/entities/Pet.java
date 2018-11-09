package intro.entities;

import intro.enums.Animal;
import lombok.Data;

@Data
public class Pet {

    private long id;

    private String name;

    private Animal type;

    private int age;
}