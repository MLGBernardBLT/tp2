package cal.service;

import cal.model.Bibliotheque;
import cal.model.Emprunt;
import cal.model.utilisateur.Utilisateur;
import cal.persistence.BibliothequeDao;
import cal.persistence.UtilisateurDao;

import java.util.List;

public class UtilisateurService {

    private UtilisateurDao utilisateurDao;
    private BibliothequeDao bibliothequeDao;

    public UtilisateurService(UtilisateurDao userDao, BibliothequeDao bibliothequeDao) {
        this.utilisateurDao = userDao;
        this.bibliothequeDao = bibliothequeDao;
    }


    public Utilisateur createUser(String nom, String prenom) {
        return utilisateurDao.createUtilisateur(nom, prenom);
    }

    public void addUtilisateurToBibliotheque(long utilisateurId, long bibliothequeId) {
        Bibliotheque bibliotheque = bibliothequeDao.getBibliotheque(bibliothequeId);
        Utilisateur utilisateur = utilisateurDao.getUtilisateur(utilisateurId);

        utilisateur.setBibliotheque(bibliotheque);
        bibliotheque.getUtilisateurs().add(utilisateur);

        utilisateurDao.addUtilisateurToBibliotheque(utilisateur, bibliotheque);
    }

    public List<Emprunt> getListeEmprunts(long id) {
        return utilisateurDao.getListeEmprunts(id);
    }
}
