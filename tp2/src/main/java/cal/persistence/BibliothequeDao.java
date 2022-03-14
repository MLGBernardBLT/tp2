package cal.persistence;
import cal.model.Bibliotheque;
import cal.model.utilisateur.Emprunteur;
import cal.model.utilisateur.Utilisateur;

public interface BibliothequeDao {
    <T> void save(T t);
    <T> void merge(T t);
    long createBibliotheque(String nom);
    long createEmprunteur(String nom, String prenom);

    Emprunteur getEmprunteur(long id);

    Bibliotheque getBibliothequeAvecUtilisateur(long id);
}
