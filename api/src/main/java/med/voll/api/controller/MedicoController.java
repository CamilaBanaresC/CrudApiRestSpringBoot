package med.voll.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import med.voll.api.RequestRecord.RequestRegistroMedico;

@RestController
@RequestMapping("/medicos")

public class MedicoController {

	
	@PostMapping
	public void registrarMedico( @RequestBody RequestRegistroMedico json) {
		System.out.println("***(Comienza el registro de medico)***");
		System.out.println("***(RequestRegistroMedico)***"+ json);

	}
}
