import cal.model.Bibliotheque;
import cal.model.utilisateur.Emprunteur;
import cal.persistence.BibliothequeDaoH2;
import cal.service.BibliothequeService;

import java.time.LocalDate;

public class MainTP2 {
    public static void main(String[] args) {
        BibliothequeService bibliothequeService = new BibliothequeService(new BibliothequeDaoH2());

        var bibliothequeId = bibliothequeService.createBibliotheque("JavaTown");
        var emprunteurId = bibliothequeService.createEmprunteur("Thomas Laforest", "Bernard");

        bibliothequeService.addEmprunteurToBibliotheque(emprunteurId, bibliothequeId);
        final Emprunteur emprunteur = bibliothequeService.getEmprunteurAvecBibliotheque(emprunteurId);

        System.out.println("\n" +emprunteur + "\n");

        final Bibliotheque bibliotheque = bibliothequeService.getBibliotheque(bibliothequeId);

        System.out.println(bibliotheque);

        var livreId = bibliothequeService.createLivre("Red Eyes Sword", "Tetsuya Tashiro", "Kurokawa", LocalDate.of(2010,8,21), 236, 2);

        System.out.println(livreId);
    }
}
