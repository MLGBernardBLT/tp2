package cal.service;

import cal.persistent.BibliothequeDao;
import cal.persistent.BibliothequeDaoH2;

public class BibliothequeService {
    private BibliothequeDao dao;

    public BibliothequeService(BibliothequeDaoH2 dao) {
        this.dao = dao;
    }
}
