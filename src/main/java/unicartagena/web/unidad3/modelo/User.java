package unicartagena.web.unidad3.modelo;

import lombok.Data;

@Data
public class User {
    //Propiedades
    private String id;
    private String password;
    private String name;
    private String last_name;
    private String role;
    private String email;
    private String phone;
    private String status;
    private String created_at;

}
