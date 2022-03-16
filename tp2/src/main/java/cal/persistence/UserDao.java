package cal.persistence;

import cal.model.Bibliotheque;
import cal.model.utilisateur.Emprunteur;
import cal.model.utilisateur.Utilisateur;

public interface UserDao {
    <T> void save(T t);
    <T> void merge(T t);
    Utilisateur getUser(long id);
    Utilisateur createUtilisateur(String nom, String prenom);

    void addUserToBibliotheque(Utilisateur utilisateur, Bibliotheque bibliotheque);
}
