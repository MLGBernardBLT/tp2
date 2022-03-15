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

    public long createBibliotheque(String nom) {
        return dao.createBibliotheque(nom);
    }

    public long createEmprunteur(String nom, String prenom) {
        return dao.createEmprunteur(nom, prenom);
    }

    public void addEmprunteurToBibliotheque(long emprunteurId, long bibliothequeId) {
        var emprunteur = dao.getEmprunteur(emprunteurId);
        var bibliotheque = dao.getBibliothequeAvecUtilisateur(bibliothequeId);

        bibliotheque.getUtilisateurs().add(emprunteur);
        System.out.println(bibliotheque.getUtilisateurs());

        dao.addEmprunteurToBibliotheque(emprunteur, bibliotheque);

    }

    public Emprunteur getEmprunteurAvecBibliotheque(long emprunteurId) {
        return dao.getEmprunteur(emprunteurId);
    }

    public Bibliotheque getBibliotheque(long bibliothequeId) {
        return dao.getBibliothequeAvecUtilisateur(bibliothequeId);
    }

    public long createLivre(String titre, String auteur, String editeur, LocalDate anneePublication, int nbrePage, int exemplaires){
        return dao.createLivre(titre, auteur, editeur, anneePublication, nbrePage, exemplaires);
    }
}
