package junia.lab.core.entity;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public long id;

    public long getId() {
        return id;
    }

}
