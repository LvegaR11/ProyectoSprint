package unicartagena.web.unidad3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;

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
        User u1 = new User();
        u1.setId("1");
        u1.setPassword("123456");
        u1.setName("Juan");
        u1.setLast_name("Perez");
        u1.setRole("Administrador");
        u1.setEmail("juanperez@gmail.com");
        u1.setPhone("123456789");
        u1.setStatus("Activo");
        u1.setCreated_at("2022-01-01");
        modelo.addAttribute("user", u1);
        User u2 = new User();
        u2.setId("2");
        u2.setPassword("0000");
        u2.setName("Pedro");
        u2.setLast_name("Perez");
        u2.setRole("Usuario");
        u2.setEmail("pedro@gmail.com");
        u2.setPhone("123456789");
        u2.setStatus("Activo");
        u2.setCreated_at("2022-01-01");
        
        User u3 = new User();
        u3.setId("3");
        u3.setPassword("1111");
        u3.setName("Luis");
        u3.setLast_name("Vega");
        u3.setRole("Estudiante");
        u3.setEmail("luis@gmail.com");
        u3.setPhone("3007056108");
        u3.setStatus("Activo");
        u3.setCreated_at("2024-11-22");
        
        List<User> lista = Arrays.asList( u2, u3);
        modelo.addAttribute("users", lista);
        log.info("Mostrando el controlador MVC");
        return "index";
    }

}
