package cal.service;

import cal.model.Emprunt;
import cal.model.document.Document;
import cal.model.utilisateur.Utilisateur;
import cal.persistence.EmpruntDao;
import cal.persistence.EmpruntDaoH2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class EmpruntService {
    private EmpruntDao dao;
    public EmpruntService(EmpruntDaoH2 dao) {
        this.dao = dao;
    }

    public Emprunt createEmprunt(Utilisateur user, List<Document> documents, LocalDateTime dateEmprunt, LocalDateTime dateRetourMax) {
        return dao.createEmprunt(user, documents,dateEmprunt, dateRetourMax);
    }
}
