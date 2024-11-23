package unicartagena.web.unidad3.dao;

import org.springframework.data.repository.CrudRepository;
import unicartagena.web.unidad3.modelo.User;

public interface IUserCrud extends CrudRepository<User, String> {
      
}
