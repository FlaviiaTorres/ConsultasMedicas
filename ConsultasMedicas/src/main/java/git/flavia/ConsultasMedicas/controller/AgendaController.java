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

import git.flavia.ConsultasMedicas.entity.Agenda;
import git.flavia.ConsultasMedicas.service.agendaService;

@RestController
@RequestMapping("/agenda")
public class AgendaController {

	@Autowired
    private agendaService agendaService;

    @GetMapping
    public List<Agenda> getAllAgendamentos() {
        return agendaService.listarAgendamentos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agenda> getAgendamentosById(@PathVariable Long id) {
        return agendaService.listarAgendamentosById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Agenda criarAgendamento(@RequestBody Agenda agenda) {
        return agendaService.criarAgendamento(agenda);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agenda> atualizarAgendamento(@PathVariable Long id, @RequestBody Agenda agendaDetalhes) {
        return agendaService.atualizarAgendamento(id, agendaDetalhes)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
        return agendaService.deletarAgendamento(id)
                ? ResponseEntity.ok().build()
                : ResponseEntity.notFound().build();
    }
}
