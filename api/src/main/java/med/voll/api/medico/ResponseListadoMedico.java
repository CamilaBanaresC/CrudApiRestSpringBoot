package med.voll.api.medico;

import jakarta.validation.constraints.NotNull;

public record ResponseListadoMedico(@NotNull Long id, String nombre, String especialidas, String documento, String email) {
	
  
    public ResponseListadoMedico(Medico medico) {
        this(medico.getId(),medico.getNombre(), medico.getEspecialidad().toString(), medico.getDocumento(), medico.getEmail());
    }


}