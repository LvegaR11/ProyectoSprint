package unicartagena.web.unidad3.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import unicartagena.web.unidad3.modelo.Visit;

public interface IVisitCrud extends CrudRepository<Visit, Integer> {

    @Query("select v from Visit v where v.user.id = :userId")
    public Iterable<Visit> findAllByUserId(@Param("userId") String Id);
}
