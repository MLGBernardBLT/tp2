package cal.model;

import java.sql.Date;


public class Document {
    private String titre;
    private String auteur;
    private String editeur;
    // TODO: 2022-03-12 Quel classe utiliser pour la date ?
    private Date anneePublication;

    public Document(String titre, String auteur, String editeur, Date anneePublication) {
        this.titre = titre;
        this.auteur = auteur;
        this.editeur = editeur;
        this.anneePublication = anneePublication;
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public String getEditeur() {
        return editeur;
    }

    public Date getAnneePublication() {
        return anneePublication;
    }
}
