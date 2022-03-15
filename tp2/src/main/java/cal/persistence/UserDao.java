package cal.persistence;

import cal.model.utilisateur.Emprunteur;
import cal.model.utilisateur.Utilisateur;

public interface UserDao {
    Utilisateur save(Utilisateur user);

}
