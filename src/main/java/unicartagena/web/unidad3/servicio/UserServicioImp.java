package unicartagena.web.unidad3.servicio;

import java.util.List;
import unicartagena.web.unidad3.dao.IUserCrud;
import unicartagena.web.unidad3.modelo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServicioImp implements IUserServicio {

    @Autowired
    IUserCrud crudUser;

    @Transactional(readOnly = true)
    @Override
    public List<User> listarUsers() {
        return (List<User>) crudUser.findAll();
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        crudUser.save(user);
    }

    @Transactional
    @Override
    public void deleteUser(User user) {
        crudUser.delete(user);
    }

    @Transactional(readOnly = true)
    @Override
    public User searchUser(User user) {
        return crudUser.findById(user.getId()).orElse(user);
    }

}