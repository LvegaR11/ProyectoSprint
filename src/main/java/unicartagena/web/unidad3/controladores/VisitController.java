package unicartagena.web.unidad3.controladores;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;
import unicartagena.web.unidad3.modelo.User;
import unicartagena.web.unidad3.modelo.Visit;
import unicartagena.web.unidad3.servicio.IUserServicio;
import unicartagena.web.unidad3.servicio.IVisitServicio;

@Controller
@Slf4j
public class VisitController {

    @Autowired
    private IVisitServicio visitServicio;
    @Autowired
    private IUserServicio userService;

    @GetMapping("/visitas/{id}")
    public String listarVisitas(User user, Model modelo) {
        log.info("En el controlador de visitas");
        List<Visit> lista = (List<Visit>) visitServicio.listVisitByUserId(user);
        modelo.addAttribute("visitas", lista);
        return "visitas/listaVisitas";
    }

    @GetMapping("/visitas/agregar/{id}")
    public String addVisit(User user, Visit visit) {
        log.info("Mostrando el controlador MVC");
        visit.setId(1);
        visit.setUser(user);
        return "visitas/modificar";

    }

    @GetMapping("/visitas/editar/{id}")
    public String editVisit(Visit visit, Model modelo) {
        log.info("Mostrando el controlador MVC");
        Visit visitSearch = visitServicio.searchVisit(visit);
        modelo.addAttribute("visit", visitSearch);
        return "visitas/modificar";
    }

    @GetMapping("/visitas/eliminar/{id}")
    public String deleteVisit(Visit visit) {
        log.info("Invocando el metodo deleteVisit");
        visitServicio.deleteVisit(visit);
        final String userId = visit.getUser().getId();
        return "redirect:/visitas/" + userId;
    }

    @GetMapping("/visitas/guardar/")
    public String saveVisit(@Valid Visit visit, Errors errors) {
        if (errors.hasErrors()) {
            return "visitas/modificar";

        }
        User user = userService.searchUser(visit.getUser());
        visit.setUser(user);
        visitServicio.saveVisit(visit);

        return "redirect:/visitas/" + user.getId();
    }

}
