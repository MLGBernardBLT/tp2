import cal.model.Bibliotheque;
import cal.model.document.Document;
import cal.model.document.Livre;
import cal.model.utilisateur.Emprunteur;
import cal.model.utilisateur.Utilisateur;
import cal.persistence.BibliothequeDaoH2;
import cal.persistence.EmpruntDaoH2;
import cal.persistence.UserDaoH2;
import cal.service.BibliothequeService;
import cal.service.ClientService;
import cal.service.EmpruntService;

import javax.print.Doc;
import java.time.LocalDate;
import java.util.List;

public class MainTP2 {
    public static void main(String[] args) {
        ClientService clientService = new ClientService(new UserDaoH2(), new BibliothequeDaoH2());
        BibliothequeService bibliothequeService = new BibliothequeService(new BibliothequeDaoH2());
        EmpruntService empruntService = new EmpruntService(new EmpruntDaoH2());

        Bibliotheque bibliotheque = bibliothequeService.createBibliotheque("JavaTown");
        Utilisateur user = clientService.createUser("Thomas Laforest", "Bernard");

        clientService.addUserToBibliotheque(user.getId(), bibliotheque.getId());

        Document livre = bibliothequeService.createLivre("Red Eyes Sword", "Takahiro", "Kurokawa", LocalDate.of(2010,8,21 ), 235);

        bibliothequeService.addLivreToBibliotheque(livre.getId(), bibliotheque.getId());
        //Test avec un deuxième livre
        bibliothequeService.addLivreToBibliotheque(livre.getId(), bibliotheque.getId());

        List<Document> livreRechercherTitre = bibliothequeService.rechercheLivreTitre("Red");
        System.out.println(livreRechercherTitre);

        //Test pour voir ce que fait la recherche si il n'y a pas de livre avec la recherche.
        List<Document> livresNonExistant = bibliothequeService.rechercheLivreTitre("PasSuposerFonctionner");
        System.out.println(livresNonExistant);

        List<Document> livreRechercherAuteur = bibliothequeService.rechercheLivreAuteur("Takahiro");
        System.out.println(livreRechercherAuteur);

        List<Document> livreRechercheAuteurNonExistant = bibliothequeService.rechercheLivreAuteur("Nope");
        System.out.println(livreRechercheAuteurNonExistant);
    }
}
