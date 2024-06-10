package git.flavia.ConsultasMedicas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import git.flavia.ConsultasMedicas.entity.Medico;
import git.flavia.ConsultasMedicas.service.medicoService;

@RestController
@RequestMapping("/medico")
public class MedicoController {
	
	 @Autowired
	    private medicoService medicoService;

	    @GetMapping
	    public List<Medico> getAllMedicos() {
	        return medicoService.listarMedicos();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Medico> getMedicoById(@PathVariable Long id) {
	        return medicoService.listarMedicoById(id)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }

	    @PostMapping
	    public Medico cadastrarMedico(@RequestBody Medico medico) {
	        return medicoService.cadastroMedico(medico);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Medico> atualizarMedico(@PathVariable Long id, @RequestBody Medico medicoDetalhes) {
	        return medicoService.atualizarMedico(id, medicoDetalhes)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
	        return medicoService.apagarMedico(id)
	                ? ResponseEntity.ok().build()
	                : ResponseEntity.notFound().build();
	    }
	}


