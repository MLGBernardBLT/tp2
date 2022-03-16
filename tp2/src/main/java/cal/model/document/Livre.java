package cal.model.document;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class Livre extends Document {
    private int nbrePage;

    public Livre(String titre, String auteur, String editeur, LocalDate anneePublication, String genre, int nbrePage) {
        super(titre, auteur, editeur, anneePublication, genre);
        this.nbrePage = nbrePage;
    }
}
