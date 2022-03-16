import cal.model.Bibliotheque;
import cal.model.Emprunt;
import cal.model.document.Document;
import cal.model.utilisateur.Emprunteur;
import cal.model.utilisateur.Utilisateur;
import cal.persistence.BibliothequeDaoH2;
import cal.persistence.EmpruntDaoH2;
import cal.persistence.UserDaoH2;
import cal.service.BibliothequeService;
import cal.service.ClientService;
import cal.service.EmpruntService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class MainTP2 {
    public static void main(String[] args) {
        ClientService clientService = new ClientService(new UserDaoH2(), new BibliothequeDaoH2());
        BibliothequeService bibliothequeService = new BibliothequeService(new BibliothequeDaoH2());
        EmpruntService empruntService = new EmpruntService(new EmpruntDaoH2(), new UserDaoH2());

        Bibliotheque bibliotheque = bibliothequeService.createBibliotheque("JavaTown");
        Utilisateur user = clientService.createUser("Thomas Laforest", "Bernard");

        clientService.addUserToBibliotheque(user.getId(), bibliotheque.getId());

        Document livre = bibliothequeService.createLivre("Red Eyes Sword", "Takahiro", "Kurokawa", LocalDate.of(2010,8,21 ), "roman", 235);

        bibliothequeService.addLivreToBibliotheque(livre.getId(), bibliotheque.getId());
        //Test avec un deuxième livre
        bibliothequeService.addLivreToBibliotheque(livre.getId(), bibliotheque.getId());

        List<Document> livreRechercherTitre = bibliothequeService.rechercheLivreTitre("Red");
        System.out.println(livreRechercherTitre);
        List<Document> livresNonExistant = bibliothequeService.rechercheLivreTitre("PasSuposerFonctionner");
        System.out.println(livresNonExistant);

        List<Document> livreRechercherAuteur = bibliothequeService.rechercheLivreAuteur("Takahiro");
        System.out.println(livreRechercherAuteur);
        List<Document> livreRechercheAuteurNonExistant = bibliothequeService.rechercheLivreAuteur("Nope");
        System.out.println(livreRechercheAuteurNonExistant);

        List<Document> livreRechercheDate = bibliothequeService.rechercheLivreDate(LocalDate.of(2010,8,21 ));
        System.out.println(livreRechercheDate);
        List<Document> livreRechercheDateFausse = bibliothequeService.rechercheLivreDate(LocalDate.of(2012,8,21 ));
        System.out.println(livreRechercheDateFausse);

        List<Document> livreRechercheGenre = bibliothequeService.rechercheLivreGenre("roman");
        System.out.println(livreRechercheGenre);
        List<Document> livreRechercheGenreFaux = bibliothequeService.rechercheLivreGenre("rien");
        System.out.println(livreRechercheGenreFaux);

        Emprunt emprunt = empruntService.createEmprunt(user, livreRechercheDate, LocalDateTime.now(), LocalDateTime.now().plusDays(21));
        System.out.println(emprunt.getDocuments().get(0)); //Supposer me donner le livre qui reste 1 exemplaire.

        Emprunt emprunt2 = empruntService.createEmprunt(user, livreRechercheDate, LocalDateTime.now(), LocalDateTime.now().plusDays(21));
        System.out.println(emprunt2.getDocuments().get(0)); //Supposer me donner le livre qui reste 0 exemplaires

        try{
            Emprunt emprunt3 = empruntService.createEmprunt(user, livreRechercheDate, LocalDateTime.now(), LocalDateTime.now().plusDays(21));
            System.out.println(emprunt3.getDocuments().get(0));
        }catch(NullPointerException e){
            System.out.println("Donne bien null");
        }


    }
}
