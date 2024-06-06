package med.voll.api.RequestRecord;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.DatosDireccion;
import med.voll.api.medico.Especialidad;

public record RequestRegistroMedico(
		@NotBlank String nombre, 
		@NotBlank  @Email String email, 
		@NotBlank String telefono,
		@NotBlank @Pattern(regexp = "\\d{4,6}") String documento,
		@NotNull @Valid Especialidad especialidad, 
		@NotNull @Valid DatosDireccion direccion) {

}
