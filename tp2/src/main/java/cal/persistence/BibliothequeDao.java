package cal.persistence;
import cal.model.Bibliotheque;
import cal.model.document.Document;


import java.time.LocalDate;

public interface BibliothequeDao {
    <T> void save(T t);
    <T> void merge(T t);
    Bibliotheque createBibliotheque(String nom);
    Document createLivre(String titre, String auteur, String editeur, LocalDate anneePublication, int nbrePage, int exemplaires);
    Bibliotheque getBibliotheque(long bibliothequeId);

    Document getLivre(long livreId);

    void addLivreToBibliotheque(Document livre, Bibliotheque bibliotheque);
}
