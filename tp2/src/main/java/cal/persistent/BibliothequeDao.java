package cal.persistent;

public interface BibliothequeDao {
    <T> void save(T t);
    long createBibliotheque(String nom);
    long createEmprunteur(String nom, String prenom);
}
