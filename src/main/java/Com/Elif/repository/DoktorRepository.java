package Com.Elif.repository;

import Com.Elif.entity.Doktor;

import java.util.List;

public class DoktorRepository extends RepositoryManager<Doktor,Long> {
    public DoktorRepository() {
        super(new Doktor());
    }

}
