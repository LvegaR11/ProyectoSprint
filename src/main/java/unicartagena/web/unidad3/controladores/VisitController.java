package unicartagena.web.unidad3.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;
import unicartagena.web.unidad3.modelo.User;
import unicartagena.web.unidad3.modelo.Visit;
import unicartagena.web.unidad3.servicio.IVisitServicio;

@Controller
@Slf4j
public class VisitController {

    @Autowired
    IVisitServicio visitServicio;

    @GetMapping("/visitas")
    public String listarVisitas(User user, Model modelo) {
        List<Visit> lista = (List<Visit>) visitServicio.listVisitByUserId(user);
        modelo.addAttribute("visits", lista);
        log.info("Mostrando el controlador MVC");
        return "index";
    }

    @GetMapping("/addVisit")
    public String addVisit(Visit visit) {
        return "modificar";

    }

    @GetMapping("/editVisit/{id}")
    public String editVisit(Visit visit, Model modelo) {
        log.info("Mostrando el controlador MVC");
        visit = visitServicio.searchVisit(visit);
        modelo.addAttribute("visit", visit);
        return "modificar";
    }

    @GetMapping("/deleteVisit/{id}")
    public String deleteVisit(Visit visit) {
        visitServicio.deleteVisit(visit);
        return "redirect:/";
    }

    @GetMapping("/saveVisit")
    public String saveVisit(@Autowired IVisitServicio visitServicio, Visit visit, Errors errores) {
        if (errores.hasErrors()) {
            return "modificar";
        }
        visitServicio.saveVisit(visit);
        return "redirect:/";
    }

}
