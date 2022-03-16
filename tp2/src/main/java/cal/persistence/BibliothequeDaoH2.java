package cal.persistence;

import cal.model.Bibliotheque;
import cal.model.document.Document;
import cal.model.document.Livre;

import javax.persistence.*;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

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
    public Document createLivre(String titre, String auteur, String editeur, LocalDate anneePublication, int nbrePage) {
        final Document livre = new Livre(titre, auteur, editeur, anneePublication, nbrePage);
        save(livre);
        return livre;
    }

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
    public Document getLivre(long livreId) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final Livre livre = em.find(Livre.class, livreId);

        em.getTransaction().commit();
        em.close();
        return livre;
    }

    @Override
    public void addLivreToBibliotheque(Livre livre, Bibliotheque bibliotheque) {
        if(livreExist(livre)){
            livre.ajoutExemplaire();
        }
        merge(livre);
        merge(bibliotheque);
    }

    private boolean livreExist(Livre livre) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final TypedQuery<Document> query = em.createQuery(
                "select d from Document d left join fetch d.bibliotheque db where d.id = :livreId"
                , Document.class);
        query.setParameter("livreId", livre.getId());
        try{
            query.getSingleResult();
            em.getTransaction().commit();
            em.close();
            return true;
        }catch (NoResultException e){
            em.getTransaction().commit();
            em.close();
            return false;
        }
    }

    @Override
    public List<Document> rechercheLivreTitre(String recherche) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final TypedQuery<Document> query = em.createQuery(
                "select d from Document d left join fetch d.bibliotheque db where d.titre LIKE :livreTitre"
                   , Document.class);
        query.setParameter("livreTitre", "%" +recherche + "%");
        try{
            return query.getResultList();
        }catch(NoResultException e){
            return null;
        }
    }

    @Override
    public List<Document> rechercheLivreAuteur(String auteur) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final TypedQuery<Document> query = em.createQuery(
                "select d from Document d left join fetch d.bibliotheque db where d.auteur LIKE :auteurLivre"
                   , Document.class);
        query.setParameter("auteurLivre", auteur);
        try{
            return query.getResultList();
        }catch(NoResultException e){
            return null;
        }
    }

    @Override
    public List<Document> rechercheLivreDate(LocalDate date) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final TypedQuery<Document> query = em.createQuery(
                "select d from Document d left join fetch d.bibliotheque db where d.anneePublication = :datePublication"
                   , Document.class);
        query.setParameter("datePublication", date);
        try {
            return query.getResultList();
        }catch(NoResultException e){
            return null;
        }
    }



}
