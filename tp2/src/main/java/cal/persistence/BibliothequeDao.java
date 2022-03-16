package cal.persistence;
import cal.model.Bibliotheque;
import cal.model.document.Document;
import cal.model.document.Livre;


import java.time.LocalDate;
import java.util.List;

public interface BibliothequeDao {
    <T> void save(T t);
    <T> void merge(T t);
    Bibliotheque createBibliotheque(String nom);
    Document createLivre(String titre, String auteur, String editeur, LocalDate anneePublication, int nbrePage);
    Bibliotheque getBibliotheque(long bibliothequeId);

    Document getLivre(long livreId);

    void addLivreToBibliotheque(Livre livre, Bibliotheque bibliotheque);

    List<Document> rechercheLivreTitre(String recherche);
}
