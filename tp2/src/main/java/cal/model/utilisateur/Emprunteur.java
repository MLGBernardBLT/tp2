package cal.model.utilisateur;

import cal.model.Emprunt;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class Emprunteur extends Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emprunteur_id")
    long id;
    @OneToMany(mappedBy = "emprunteur", cascade = CascadeType.ALL)
    private List<Emprunt> emprunts = new ArrayList<>();

    public Emprunteur(String nom, String prenom) {
        super(nom, prenom);
    }
}
