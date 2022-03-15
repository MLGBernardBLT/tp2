package cal.service;

import cal.model.Bibliotheque;
import cal.model.document.Document;
import cal.persistence.BibliothequeDao;
import cal.persistence.BibliothequeDaoH2;

import java.time.LocalDate;


public class BibliothequeService {
    private BibliothequeDao dao;

    public BibliothequeService(BibliothequeDaoH2 dao) {
        this.dao = dao;
    }

    public Bibliotheque createBibliotheque(String nom) {
        return dao.createBibliotheque(nom);
    }

    public Bibliotheque getBibliotheque(long bibliothequeId) {
        return dao.getBibliotheque(bibliothequeId);
    }

    public Document createLivre(String titre, String auteur, String editeur, LocalDate anneePublication, int nbrePage, int exemplaires){
        return dao.createLivre(titre, auteur, editeur, anneePublication, nbrePage, exemplaires);
    }

    public void addLivreToBibliotheque(long livreId, long bibliothequeId) {
        Bibliotheque bibliotheque = dao.getBibliotheque(bibliothequeId);
        Document livre = dao.getLivre(livreId);

        livre.setBibliotheque(bibliotheque);
        bibliotheque.getDocuments().add(livre);

        dao.addLivreToBibliotheque(livre, bibliotheque);
    }
}
