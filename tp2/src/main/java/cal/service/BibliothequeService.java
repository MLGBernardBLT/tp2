package cal.service;

import cal.model.Bibliotheque;
import cal.model.document.Livre;
import cal.model.utilisateur.Emprunteur;
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

    public long createEmprunteur(String nom, String prenom) {
        return dao.createEmprunteur(nom, prenom);
    }


    public Bibliotheque getBibliotheque(long bibliothequeId) {
        return dao.getBibliotheque(bibliothequeId);
    }

    public long createLivre(String titre, String auteur, String editeur, LocalDate anneePublication, int nbrePage, int exemplaires){
        return dao.createLivre(titre, auteur, editeur, anneePublication, nbrePage, exemplaires);
    }
}
