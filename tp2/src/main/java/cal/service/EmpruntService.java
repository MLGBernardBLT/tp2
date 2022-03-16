package cal.service;

import cal.model.Emprunt;
import cal.model.document.Document;
import cal.model.utilisateur.Emprunteur;
import cal.model.utilisateur.Utilisateur;
import cal.persistence.EmpruntDao;
import cal.persistence.EmpruntDaoH2;
import cal.persistence.UserDao;

import java.time.LocalDateTime;
import java.util.List;

public class EmpruntService {
    private EmpruntDao daoEmprunt;
    private UserDao daoUtilisateur;

    public EmpruntService(EmpruntDaoH2 empruntDao, UserDao daoUtilisateur) {
        this.daoEmprunt = empruntDao;
        this.daoUtilisateur = daoUtilisateur;
    }

    public Emprunt createEmprunt(Utilisateur user, List<Document> documents, LocalDateTime dateEmprunt, LocalDateTime dateRetourMax) {
        return daoEmprunt.createEmprunt(user, documents,dateEmprunt, dateRetourMax);
    }
}
