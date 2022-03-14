package cal.service;

import cal.model.utilisateur.Emprunteur;
import cal.persistence.BibliothequeDao;
import cal.persistence.BibliothequeDaoH2;


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

    public Emprunteur getEmprunteurAvecBibliotheque(long emprunteurId) {
        return dao.getEmprunteurAvecBibliotheque(emprunteurId);
    }
}
