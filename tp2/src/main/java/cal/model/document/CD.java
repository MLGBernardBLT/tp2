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
public class CD extends Document {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public CD(String titre, String auteur, String editeur, LocalDate anneePublication) {
        super(titre, auteur, editeur, anneePublication);
    }
}
