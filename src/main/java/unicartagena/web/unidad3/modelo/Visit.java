package unicartagena.web.unidad3.modelo;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * @author Luis Vega
 */
@Entity
@Table(name = "visit")
@Data
public class Visit implements Serializable {
    // Propiedades
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false, length = 10)
    private int id;
    @NotEmpty
    private String location;
    @NotEmpty
    private float duration;
    @NotEmpty
    private int number_of_persons;
    @NotEmpty
    private String visit_date;
    // FK
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
