package unicartagena.web.unidad3.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import unicartagena.web.unidad3.dao.IVisitCrud;
import unicartagena.web.unidad3.modelo.User;
import unicartagena.web.unidad3.modelo.Visit;

@Service
public class VisitServicioImp implements IVisitServicio {

    @Autowired
    IVisitCrud crudVisit;

    @Transactional(readOnly = true)
    @Override
    public List<Visit> listVisitByUserId(User user) {
        return (List<Visit>) crudVisit.findAllByUserId(user.getId());
    }

    @Transactional
    @Override
    public void saveVisit(Visit visit) {
        crudVisit.save(visit);
    }

    @Transactional
    @Override
    public void deleteVisit(Visit visit) {
        crudVisit.delete(visit);
    }

    @Transactional(readOnly = true)
    @Override
    public Visit searchVisit(Visit visit) {
        return crudVisit.findById(visit.getId()).orElse(null);
    }

}
