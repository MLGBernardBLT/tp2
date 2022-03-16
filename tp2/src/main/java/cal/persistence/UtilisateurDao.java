package cal.persistence;

import cal.model.Bibliotheque;
import cal.model.Emprunt;
import cal.model.utilisateur.Emprunteur;
import cal.model.utilisateur.Utilisateur;

import java.util.List;

public interface UtilisateurDao {
    <T> void save(T t);

    <T> void merge(T t);

    Utilisateur getUtilisateur(long id);

    Utilisateur createUtilisateur(String nom, String prenom);

    void addUtilisateurToBibliotheque(Utilisateur utilisateur, Bibliotheque bibliotheque);

    List<Emprunt> getListeEmprunts(long id);
}
