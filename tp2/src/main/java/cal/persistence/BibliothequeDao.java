package cal.persistence;
import cal.model.Bibliotheque;
import cal.model.document.Livre;
import cal.model.utilisateur.Emprunteur;
import cal.model.utilisateur.Utilisateur;

import java.time.LocalDate;

public interface BibliothequeDao {
    <T> void save(T t);
    <T> void merge(T t);
    Bibliotheque createBibliotheque(String nom);
    long createEmprunteur(String nom, String prenom);
    Bibliotheque getBibliothequeAvecUtilisateur(long id);
    long createLivre(String titre, String auteur, String editeur, LocalDate anneePublication, int nbrePage, int exemplaires);
    void addEmprunteurToBibliotheque(Emprunteur emprunteur, Bibliotheque bibliotheque);
    Bibliotheque getBibliotheque(long bibliothequeId);
}
