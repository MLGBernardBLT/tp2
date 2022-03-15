package cal.model.document;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class Livre extends Document{
    private int nbrePage;
    private int exemplaires;

    public Livre(String titre, String auteur, String editeur, LocalDate anneePublication, int nbrePage) {
        super(titre, auteur, editeur, anneePublication);
        this.nbrePage = nbrePage;
    }

    public void ajoutExemplaire(){
        exemplaires++;
    }
}
