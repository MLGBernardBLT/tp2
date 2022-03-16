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
public class CD extends Document {
    public CD(String titre, String auteur, String editeur, LocalDate anneePublication, String genre) {
        super(titre, auteur, editeur, anneePublication, genre);
    }
}
