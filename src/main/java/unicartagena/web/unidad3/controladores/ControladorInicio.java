package unicartagena.web.unidad3.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import unicartagena.web.unidad3.modelo.User;
import unicartagena.web.unidad3.servicio.IUserServicio;

@Controller
@Slf4j 
public class ControladorInicio {
    
    @Autowired 
    IUserServicio userServicio;
    @GetMapping("/")
    public String inicio(Model modelo) {

        List<User> lista = (List<User>) userServicio.listarUsers();
        modelo.addAttribute("users", lista);
        log.info("Mostrando el controlador MVC");
        return "index";
    }

}
