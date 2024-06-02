package med.voll.api.RequestRecord;

import med.voll.api.Direccion;
import med.voll.api.medico.Especialidad;

public record RequestRegistroMedico(String nombre,String email, String documento, Especialidad especialidad, Direccion direccion) {

}
