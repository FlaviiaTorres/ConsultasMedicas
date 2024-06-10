package git.flavia.ConsultasMedicas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import git.flavia.ConsultasMedicas.entity.Agenda;
import git.flavia.ConsultasMedicas.repository.AgendaRepository;
import git.flavia.ConsultasMedicas.serviceImpl.AgendaInterface;

@Service
public class agendaService implements AgendaInterface{
	
	@Autowired
	private AgendaRepository agendaRepository;

	@Override
	public List<Agenda> listarAgendamentos() {
		return agendaRepository.findAll();
	}

	@Override
	public Optional<Agenda> listarAgendamentosById(Long id) {
		return agendaRepository.findById(id);
	}

	@Override
	public Agenda criarAgendamento(Agenda agenda) {
		return agendaRepository.save(agenda);
	}

	@Override
	public Optional<Agenda> atualizarAgendamento(Long id, Agenda detalhesAgendamento) {
		return agendaRepository.findById(id)
		.map(agenda -> {
			agenda.setMedico(detalhesAgendamento.getMedico());
			agenda.setPaciente(detalhesAgendamento.getPaciente());
			agenda.setDataConsulta(detalhesAgendamento.getDataConsulta());
			return agendaRepository.save(agenda);
		});
	}

	@Override
	public boolean deletarAgendamento(Long id) {
		return agendaRepository.findById(id)
				.map(agenda -> {
					agendaRepository.delete(agenda);
					return true;
				})
				.orElse(false);
	}

}
