package cal.service;

import cal.model.utilisateur.Utilisateur;
import cal.persistent.BibliothequeDao;
import cal.persistent.BibliothequeDaoH2;
import com.sun.xml.bind.v2.TODO;

import java.util.Arrays;
import java.util.List;

public class BibliothequeService {
    private BibliothequeDao dao;

    public BibliothequeService(BibliothequeDaoH2 dao) {
        this.dao = dao;
    }

    public long createBibliotheque(String nom) {
        return dao.createBibliotheque(nom);
    }

    public long createEmprunteur(String nom, String prenom) {
        return dao.createEmprunteur(nom, prenom);
    }

    public void addEmprunteurToBibliotheque(long emprunteurId, long bibliothequeId) {
        var emprunteur = dao.getEmprunteurAvecBibliotheque(emprunteurId);
        var bibliotheque = dao.getBibliotheque(bibliothequeId);

        bibliotheque.getUtilisateurs().add(emprunteur);

        dao.merge(emprunteur);
        dao.merge(bibliotheque);
    }
}
