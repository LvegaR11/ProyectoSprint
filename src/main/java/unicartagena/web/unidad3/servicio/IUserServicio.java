package unicartagena.web.unidad3.servicio;

import java.util.List;

import unicartagena.web.unidad3.modelo.User;


public interface IUserServicio {

    public List<User> listarUsers();

    public void saveUser(User user);

    public void deleteUser(User user);

    public User searchUser(User user);

}
