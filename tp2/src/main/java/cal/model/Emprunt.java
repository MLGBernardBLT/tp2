package cal.model;

import cal.model.document.Document;
import cal.model.utilisateur.Emprunteur;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToMany
    private List<Document> documents = new ArrayList<>();

    @OneToMany(mappedBy = "emprunt")
    private List<Emprunteur> emprunteurs = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "id")
    private Bibliotheque bibliotheque;

    private LocalDateTime dateRemise;

    public Emprunt(LocalDateTime dateRemise) {
        this.dateRemise = dateRemise;
    }

    public List<Emprunteur> getEmprunteurs(){
        return Collections.unmodifiableList(emprunteurs);
    }
}
