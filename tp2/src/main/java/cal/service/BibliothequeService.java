package cal.service;

import cal.persistent.BibliothequeDao;
import cal.persistent.BibliothequeDaoH2;

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
}
