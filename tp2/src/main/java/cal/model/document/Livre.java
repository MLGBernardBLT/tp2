package cal.model.document;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Livre extends Document{
    private int nbrePage;
    private int exemplaires;

    public Livre(String titre, String auteur, String editeur, LocalDate anneePublication, int nbrePage, int exemplaires) {
        super(titre, auteur, editeur, anneePublication);
        this.nbrePage = nbrePage;
        this.exemplaires = exemplaires;
    }
}
