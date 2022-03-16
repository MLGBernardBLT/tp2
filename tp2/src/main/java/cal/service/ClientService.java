package cal.service;

import cal.model.Bibliotheque;
import cal.model.Emprunt;
import cal.model.utilisateur.Emprunteur;
import cal.model.utilisateur.Utilisateur;
import cal.persistence.BibliothequeDao;
import cal.persistence.BibliothequeDaoH2;
import cal.persistence.UserDao;

import java.util.List;

public class ClientService {

    private UserDao userDao;
    private BibliothequeDao bibliothequeDao;

    public ClientService(UserDao userDao, BibliothequeDao bibliothequeDao) {
        this.userDao = userDao;
        this.bibliothequeDao = bibliothequeDao;
    }


    public Utilisateur createUser(String nom, String prenom) {
        return userDao.createUtilisateur(nom, prenom);
    }

    public void addUserToBibliotheque(long utilisateurId, long bibliothequeId) {
        Bibliotheque bibliotheque = bibliothequeDao.getBibliotheque(bibliothequeId);
        Utilisateur utilisateur = userDao.getUser(utilisateurId);

        utilisateur.setBibliotheque(bibliotheque);
        bibliotheque.getUtilisateurs().add(utilisateur);

        userDao.addUserToBibliotheque(utilisateur, bibliotheque);
    }

    public List<Emprunt> getListeEmprunts(long id) {
        return userDao.getListeEmprunts(id);
    }
}
