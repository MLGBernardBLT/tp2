package cal.model.document;

import lombok.Data;
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
public class CD extends Document {
    public CD(String titre, String auteur, String editeur, LocalDate anneePublication, String genre) {
        super(titre, auteur, editeur, anneePublication, genre);
    }
}
