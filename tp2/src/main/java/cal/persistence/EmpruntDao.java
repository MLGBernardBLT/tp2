package cal.persistence;

import cal.model.Emprunt;
import cal.model.document.Document;
import cal.model.utilisateur.Utilisateur;

import java.time.LocalDateTime;
import java.util.List;

public interface EmpruntDao {

    <T> void save(T t);
    <T> void merge(T t);

    Emprunt createEmprunt(Utilisateur user, List<Document> documents, LocalDateTime dateEmprunt, LocalDateTime dateRetourMax);
}
