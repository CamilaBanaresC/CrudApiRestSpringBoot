package med.voll.api.RequestRecord;

import jakarta.validation.constraints.NotNull;
import med.voll.api.DatosDireccion;

public record RequestActualizarRegistroMedico(
		@NotNull
		Long id,
		String nombre,
		String documento,
		DatosDireccion direccion) {
	
	
	
	
	
	
}



