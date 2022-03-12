package cal.model;

import cal.model.document.Document;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Bibliotheque {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nom;

    @OneToMany(mappedBy = "bibliotheque")
    private List<Document> documents = new ArrayList<>();

    public Bibliotheque(String nom) {
        this.nom = nom;
    }

}
