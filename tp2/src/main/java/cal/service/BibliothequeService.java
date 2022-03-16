package cal.service;

import cal.model.Bibliotheque;
import cal.model.document.Document;
import cal.model.document.Livre;
import cal.persistence.BibliothequeDao;
import cal.persistence.BibliothequeDaoH2;

import java.time.LocalDate;
import java.util.List;


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

    public Document createLivre(String titre, String auteur, String editeur, LocalDate anneePublication, String genre, int nbrePage){
        return dao.createLivre(titre, auteur, editeur, anneePublication, genre, nbrePage);
    }

    public void addLivreToBibliotheque(long livreId, long bibliothequeId) {
            Bibliotheque bibliotheque = dao.getBibliotheque(bibliothequeId);
            Document livre = dao.getLivre(livreId);

            livre.setBibliotheque(bibliotheque);
            bibliotheque.getDocuments().add(livre);

            dao.addLivreToBibliotheque((Livre) livre, bibliotheque);
    }

    public List<Document> rechercheLivreTitre(String titre) {
        return dao.rechercheLivreTitre(titre);
    }

    public List<Document> rechercheLivreAuteur(String auteur) {
        return dao.rechercheLivreAuteur(auteur);
    }

    public List<Document> rechercheLivreDate(LocalDate date) {
        return dao.rechercheLivreDate(date);
    }
}
