package cal.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Bibliotheque {
    private String nom;
    private List<Document> documents = new ArrayList<>();

    public Bibliotheque(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }
}
