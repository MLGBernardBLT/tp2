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

import java.time.LocalDate;

public class MainTP2 {
    public static void main(String[] args) {
        ClientService clientService = new ClientService(new UserDaoH2(), new BibliothequeDaoH2());
        BibliothequeService bibliothequeService = new BibliothequeService(new BibliothequeDaoH2());
        EmpruntService empruntService = new EmpruntService(new EmpruntDaoH2());

        Bibliotheque bibliotheque = bibliothequeService.createBibliotheque("JavaTown");
        Utilisateur user = clientService.createUser("Thomas Laforest", "Bernard");
        System.out.println(user);

        clientService.addUserToBibliotheque(user.getId(), bibliotheque.getId());

        Document livre = bibliothequeService.createLivre("Red Eyes Sword", "Takahiro", "Kurokawa", LocalDate.of(2010,8,21 ), 235, 2);
    }
}
