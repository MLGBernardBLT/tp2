import cal.persistent.BibliothequeDaoH2;
import cal.service.BibliothequeService;

public class mainTP2 {
    public static void main(String[] args) {
        BibliothequeService bibliothequeService = new BibliothequeService(new BibliothequeDaoH2());

        var bibliothequeId = bibliothequeService.createBibliotheque("JavaTown");
        var emprunteurId = bibliothequeService.createEmprunteur("Thomas Laforest", "Bernard");

        bibliothequeService.addEmprunteurToBibliotheque(emprunteurId, bibliothequeId);
    }
}
