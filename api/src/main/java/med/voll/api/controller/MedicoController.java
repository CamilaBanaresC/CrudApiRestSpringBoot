package med.voll.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.RequestRecord.RequestActualizarRegistroMedico;
import med.voll.api.RequestRecord.RequestRegistroMedico;
import med.voll.api.medico.DatosListadoMedicoDTO;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
@RestController
@RequestMapping("/medicos")

public class MedicoController {
    Gson gson = new Gson();

	@Autowired
	private MedicoRepository medicoRepository;
	
	@PostMapping
	public void registrarMedico( @RequestBody @Valid RequestRegistroMedico jsonRegistroMedico) {
		System.out.println("***(Comienza el registro de medico)***");
		medicoRepository.save(new Medico(jsonRegistroMedico)); //Guardando el registro en la base de datos
	}
	
	@GetMapping
	public Page<DatosListadoMedicoDTO>  listadoDeMedicos(Pageable paginacion){
		//return medicoRepository.findAll(paginacion).map(DatosListadoMedicoDTO::new) ; 
		return medicoRepository.findByActivoTrue(paginacion).map(DatosListadoMedicoDTO::new) ; 

	} 
	
	
	@PutMapping
	@Transactional //funciona para que se realice un comit en la bbdd
	public void actualizarMedico(@RequestBody @Valid RequestActualizarRegistroMedico requestActualizarRegistroMedico) {
		Medico medico = medicoRepository.getReferenceById(requestActualizarRegistroMedico.id());
		medico.actualizarDatos(requestActualizarRegistroMedico);
	}
	
	@DeleteMapping("/{id}") //Valor enviado desde el path en insomnia o postman
	@Transactional
	public void eliminarMecido(@PathVariable  Long id) {
	Medico medico = medicoRepository.getReferenceById(id);
	medico.desactivarMedico();
	}
	
//	@DeleteMapping("/{id}") //Valor enviado desde el path en insomnia o postman
//	@Transactional
//	public void eliminarMecido(@PathVariable  Long id) {
//	Medico medico = medicoRepository.getReferenceById(id);
//	medicoRepository.delete(medico);
//	}
	
}
