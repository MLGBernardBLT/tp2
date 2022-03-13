package cal.persistent;
import cal.model.Bibliotheque;
import cal.model.utilisateur.Emprunteur;

public interface BibliothequeDao {
    <T> void save(T t);
    <T> void merge(T t);
    long createBibliotheque(String nom);
    long createEmprunteur(String nom, String prenom);

    Emprunteur getEmprunteurAvecBibliotheque(long id);

    Bibliotheque getBibliotheque(long id);
}
