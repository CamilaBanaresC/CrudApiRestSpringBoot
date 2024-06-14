package med.voll.api.medico;

public record DatosListadoMedicoDTO(String nombre, String especialidas, String documento, String email) {
	
  
    public DatosListadoMedicoDTO(Medico medico) {
        this(medico.getNombre(), medico.getEspecialidad().toString(), medico.getDocumento(), medico.getEmail());
    }


}