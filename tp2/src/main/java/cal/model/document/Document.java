package cal.model.document;

import cal.model.Bibliotheque;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public abstract class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String titre;
    private String auteur;
    private String editeur;
    private LocalDate anneePublication;

    @ManyToOne
    @JoinColumn(name = "documents")
    private Bibliotheque bibliotheque;

    public Document(String titre, String auteur, String editeur, LocalDate anneePublication) {
        this.titre = titre;
        this.auteur = auteur;
        this.editeur = editeur;
        this.anneePublication = anneePublication;
    }

    public long getId() {
        return id;
    }
}
