package cal.model.utilisateur;

import cal.model.Emprunt;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Emprunteur extends Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(mappedBy = "emprunteur")
    private List<Emprunt> emprunts = new ArrayList<>();

    public Emprunteur(String nom, String prenom) {
        super(nom, prenom);
    }

    public List<Emprunt> getEmprunts() {
        return Collections.unmodifiableList(emprunts);
    }
}
