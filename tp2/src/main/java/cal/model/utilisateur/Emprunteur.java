package cal.model.utilisateur;

import cal.model.Emprunt;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Emprunteur extends Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "id")
    private Emprunt emprunt;


    public Emprunteur(String nom, String prenom) {
        super(nom, prenom);
    }
}
