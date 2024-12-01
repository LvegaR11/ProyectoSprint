package unicartagena.web.unidad3.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import unicartagena.web.unidad3.modelo.Visit;

public interface IVisitCrud extends CrudRepository<Visit, Integer> {

    @Query("SELECT v FROM Visit v WHERE v.user.id = ?1")
    public Iterable<Visit> findAllByUserId(@Param("id") String id);
}
