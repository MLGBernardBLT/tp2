import cal.model.Bibliotheque;
import cal.model.utilisateur.Emprunteur;
import cal.model.utilisateur.Utilisateur;
import cal.persistence.BibliothequeDaoH2;
import cal.persistence.UserDaoH2;
import cal.service.BibliothequeService;
import cal.service.ClientService;

import java.time.LocalDate;

public class MainTP2 {
    public static void main(String[] args) {
        ClientService clientService = new ClientService(new UserDaoH2());
        Utilisateur user = clientService.createUser("Thomas Laforest", "Bernard");
        System.out.println(user);

    }
}
