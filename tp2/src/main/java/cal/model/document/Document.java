package cal.model.document;

import cal.model.Bibliotheque;
import cal.model.Emprunt;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@SuperBuilder
public abstract class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "document_id")
    private long id;
    private String titre;
    private String auteur;
    private String editeur;
    private LocalDate anneePublication;

    @ManyToOne
    @JoinColumn(name = "bibliotheque_id")
    @ToString.Exclude
    private Bibliotheque bibliotheque;

    @ManyToMany
    private List<Emprunt> emprunts = new ArrayList<>();

    public Document(String titre, String auteur, String editeur, LocalDate anneePublication) {
        this.titre = titre;
        this.auteur = auteur;
        this.editeur = editeur;
        this.anneePublication = anneePublication;
    }
}
