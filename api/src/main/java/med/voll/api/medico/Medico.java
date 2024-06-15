package med.voll.api.medico;


import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.RequestRecord.RequestActualizarRegistroMedico;
import med.voll.api.RequestRecord.RequestRegistroMedico;
import med.voll.api.direccion.direccion.Direccion;

@Entity
@Table(name = "medicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 1, max = 255, message = "La longitud del nombre debe estar entre 1 y 255 caracteres")
    private String nombre;

    @NotBlank(message = "El teléfono no puede estar vacío")
    @Size(min = 10, max = 20, message = "La longitud del teléfono debe estar entre 10 y 20 caracteres")
    private String telefono;

    @Email(message = "Email debe ser válido")
    @NotBlank(message = "El email no puede estar vacío")
    private String email;

    @NotBlank(message = "El documento no puede estar vacío")
    private String documento;

    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;

    @Embedded
    private Direccion direccion;

    public Medico(RequestRegistroMedico jsonRegistroMedico) {
        this.nombre = jsonRegistroMedico.nombre();
        this.telefono = jsonRegistroMedico.telefono();
        this.email = jsonRegistroMedico.email();
        this.documento = jsonRegistroMedico.documento();
        this.especialidad = jsonRegistroMedico.especialidad();
        this.direccion = new Direccion(jsonRegistroMedico.direccion());
    }

	public void actualizarDatos(RequestActualizarRegistroMedico requestActualizarRegistroMedico) {
       if( requestActualizarRegistroMedico.nombre() != null) {
   		this.nombre = requestActualizarRegistroMedico.nombre();

       }
       if(requestActualizarRegistroMedico.documento() != null) {
           this.documento = requestActualizarRegistroMedico.documento();

       }
       if(requestActualizarRegistroMedico.direccion() != null) {
        this.direccion = direccion.actualizarDato(requestActualizarRegistroMedico.direccion());

	}

 }
}