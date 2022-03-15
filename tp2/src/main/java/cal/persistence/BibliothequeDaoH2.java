package cal.persistence;

import cal.model.Bibliotheque;
import cal.model.document.Document;
import cal.model.document.Livre;
import cal.model.utilisateur.Emprunteur;
import cal.model.utilisateur.Utilisateur;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.time.LocalDate;

public class BibliothequeDaoH2 implements BibliothequeDao {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp2.exe");



    @Override
    public <T> void save(T t) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(t);

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public <T> void merge(T t) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.merge(t);

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Bibliotheque createBibliotheque(String nom) {
        final Bibliotheque bibliotheque = new Bibliotheque(nom);
        save(bibliotheque);
        return bibliotheque;
    }

    @Override
    public long createEmprunteur(String nom, String prenom) {
        final Utilisateur utilisateur = new Emprunteur(nom, prenom);
        save(utilisateur);
        return utilisateur.getId();
    }

    @Override
    public long createLivre(String titre, String auteur, String editeur, LocalDate anneePublication, int nbrePage, int exemplaires) {
        final Document livre = new Livre(titre, auteur, editeur, anneePublication, nbrePage, exemplaires);
//        if(livreDejaCree(livre)){
//
//        }else{
//            save(livre);
//        }
        save(livre);
        return livre.getId();
    }

    @Override
    public void addEmprunteurToBibliotheque(Emprunteur emprunteur, Bibliotheque bibliotheque) {
        merge(emprunteur);
        merge(bibliotheque);
    }

//    private boolean livreDejaCree(Livre livre) {
//        final EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//        return em.find(Livre.class, livre.getId()) != null;
//    }

    @Override
    public Bibliotheque getBibliotheque(long bibliothequeId) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final Bibliotheque bibliotheque = em.find(Bibliotheque.class, bibliothequeId);

        em.getTransaction().commit();
        em.close();
        return bibliotheque;
    }

    @Override
    public Bibliotheque getBibliothequeAvecUtilisateur(long id) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final TypedQuery<Bibliotheque> query = em.createQuery(
                "SELECT b from Bibliotheque b LEFT JOIN FETCH b.utilisateurs bu WHERE b.id = :bibliothequeId"
                , Bibliotheque.class);
        query.setParameter("bibliothequeId", id);
        final Bibliotheque bibliotheque = query.getSingleResult();

        em.getTransaction().commit();
        em.close();
        return bibliotheque;
    }


}
