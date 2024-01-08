package Com.Elif.repository;

import Com.Elif.entity.Brans;

public class BransRepository extends RepositoryManager<Brans,Long> {
    public BransRepository() {
        super(new Brans());
    }
}
