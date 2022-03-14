package cal.model;

import cal.model.document.Document;
import cal.model.utilisateur.Emprunteur;
import cal.model.utilisateur.Utilisateur;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emprunt_id")
    private long id;

    @ManyToMany
    private List<Document> documents = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "emprunteur_id")
    private Utilisateur emprunteur = new Emprunteur();
    

    private LocalDateTime dateRemise;

    public Emprunt(LocalDateTime dateRemise) {
        this.dateRemise = dateRemise;
    }
}
