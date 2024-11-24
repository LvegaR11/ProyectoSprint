package unicartagena.web.unidad3.servicio;

import java.util.List;

import unicartagena.web.unidad3.modelo.User;
import unicartagena.web.unidad3.modelo.Visit;

public interface IVisitServicio {

    public List<Visit> listVisitByUserId(User user);

    public void saveVisit(Visit visit);

    public void deleteVisit(Visit visit);

    public Visit searchVisit(Visit visit);

}
