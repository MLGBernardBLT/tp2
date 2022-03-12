import cal.persistent.BibliothequeDaoH2;
import cal.service.BibliothequeService;

public class mainTP2 {
    public static void main(String[] args) {
        BibliothequeService bibliothequeService = new BibliothequeService(new BibliothequeDaoH2());


    }
}
