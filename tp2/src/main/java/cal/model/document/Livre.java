package cal.model.document;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Livre extends Document{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int nbrePage;
    private int exemplaires;

    public Livre(String titre, String auteur, String editeur, LocalDate anneePublication, int nbrePage, int exemplaires) {
        super(titre, auteur, editeur, anneePublication);
        this.nbrePage = nbrePage;
        this.exemplaires = exemplaires;
    }
}
