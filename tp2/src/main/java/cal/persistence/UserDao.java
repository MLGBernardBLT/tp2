package cal.persistence;

import cal.model.Bibliotheque;
import cal.model.utilisateur.Emprunteur;
import cal.model.utilisateur.Utilisateur;

public interface UserDao {
    Utilisateur save(Utilisateur user);
    <T> void merge(T t);
    Utilisateur getUser(long id);

    void addUserToBibliotheque(Utilisateur utilisateur, Bibliotheque bibliotheque);
}
