package med.voll.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import jakarta.validation.Valid;
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
	public List<DatosListadoMedicoDTO>  listadoDeMedicos(){
		return medicoRepository.findAll().stream().map(DatosListadoMedicoDTO::new).toList() ; //Retorno los datos desde la BBDD   List<DatosListadoMedicoDTO>
	} 
}
