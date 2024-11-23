package unicartagena.web.unidad3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Value;
import unicartagena.web.unidad3.modelo.User;

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
        User user = new User();
        user.setId("1");
        user.setPassword("123456");
        user.setName("Juan");
        user.setLast_name("Perez");
        user.setRole("Administrador");
        user.setEmail("juanperez@gmail.com");
        user.setPhone("123456789");
        user.setStatus("Activo");
        user.setCreated_at("2022-01-01");
        modelo.addAttribute("user", user);
        log.info("Mostrando el controlador MVC");
        return "index";
    }

}
