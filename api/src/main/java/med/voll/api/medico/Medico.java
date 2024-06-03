package med.voll.api.medico;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.RequestRecord.RequestRegistroMedico;
import med.voll.api.direccion.direccion.Direccion;
@Table(name = "medicos")
@Entity (name ="medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of ="id")
public class Medico {

@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
private Long id;
private String nombres;
private String email;
private String documento;
@Enumerated(EnumType.STRING)
private Especialidad especialidad;
@Embedded
private Direccion direccion;

public Medico(RequestRegistroMedico jsonRegistroMedico) {
	this.nombres =jsonRegistroMedico.nombre();
	this.email =jsonRegistroMedico.email();
	this.documento =jsonRegistroMedico.documento();
	this.especialidad =jsonRegistroMedico.especialidad();
	this.direccion = new Direccion(jsonRegistroMedico.direccion());
}
public Medico() {}





}
