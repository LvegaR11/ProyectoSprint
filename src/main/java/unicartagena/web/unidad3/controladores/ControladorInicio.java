package unicartagena.web.unidad3.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import unicartagena.web.unidad3.dao.IUserCrud;
import java.util.List;
import unicartagena.web.unidad3.modelo.User;

@Controller
@Slf4j 
public class ControladorInicio {
    
    @Autowired
    IUserCrud crudUser;
    @GetMapping("/")
    public String inicio(Model modelo) {

        List<User> lista = (List<User>) crudUser.findAll();
        modelo.addAttribute("users", lista);
        log.info("Mostrando el controlador MVC");
        return "index";
    }

}
