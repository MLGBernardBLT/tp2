package cal.service;

import cal.model.utilisateur.Emprunteur;
import cal.model.utilisateur.Utilisateur;
import cal.persistence.UserDao;

public class ClientService {

    private UserDao userDao;

    public ClientService(UserDao userDao) {
        this.userDao = userDao;
    }

    public Utilisateur createUser(String nom, String prenom) {
        return userDao.save(new Emprunteur(nom, prenom));
    }

}
