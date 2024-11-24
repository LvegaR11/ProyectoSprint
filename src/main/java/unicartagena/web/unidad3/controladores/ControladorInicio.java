package unicartagena.web.unidad3.controladores;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;
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

    @GetMapping("/addUser")
    public String addUser(User user) {
        return "modificar";

    }

    @PostMapping("/saveUser")
    public String saveUser(@Valid User user, Errors errores) {
        if(errores.hasErrors()) {
            return "modificar";
        }
        userServicio.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/editUser/{id}")
    public String edirUser(User user, Model modelo) {
         log.info("Mostrando el controlador MVC");
        user = userServicio.searchUser(user);
        modelo.addAttribute("user", user);
        return "modificar";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(User user) {
        userServicio.deleteUser(user);
        return "redirect:/";
    }
}