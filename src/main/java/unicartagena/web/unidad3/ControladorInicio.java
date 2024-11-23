package unicartagena.web.unidad3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Value;

@Controller
@Slf4j 
public class ControladorInicio {
    @Value("${index.mensaje}")
    String datos;
    @GetMapping("/")
    public String inicio(Model modelo) {
        String mesaje = "Saludos desde Sprint MVC";
        modelo.addAttribute("mesaje", mesaje);
        modelo.addAttribute("datos", datos);
        log.info("Mostrando el controlador MVC");
        return "index";
    }

}
