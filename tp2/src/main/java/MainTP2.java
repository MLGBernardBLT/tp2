import cal.model.Bibliotheque;
import cal.model.utilisateur.Emprunteur;
import cal.model.utilisateur.Utilisateur;
import cal.persistence.BibliothequeDaoH2;
import cal.service.BibliothequeService;

public class MainTP2 {
    public static void main(String[] args) {
        BibliothequeService bibliothequeService = new BibliothequeService(new BibliothequeDaoH2());

        var bibliothequeId = bibliothequeService.createBibliotheque("JavaTown");
        var emprunteurId = bibliothequeService.createEmprunteur("Thomas Laforest", "Bernard");

        bibliothequeService.addEmprunteurToBibliotheque(emprunteurId, bibliothequeId);
        final Emprunteur emprunteur = bibliothequeService.getEmprunteurAvecBibliotheque(emprunteurId);

        System.out.println(emprunteur);
    }
}
