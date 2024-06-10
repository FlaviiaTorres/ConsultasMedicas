package git.flavia.ConsultasMedicas.serviceImpl;

import java.util.List;
import java.util.Optional;

import git.flavia.ConsultasMedicas.entity.Agenda;

public interface AgendaInterface {
	
	 	List<Agenda> listarAgendamentos();
	    Optional<Agenda> listarAgendamentosById(Long id);
	    Agenda criarAgendamento(Agenda agenda);
	    Optional<Agenda> atualizarAgendamento(Long id, Agenda detalhesAgendamento);
	    boolean deletarAgendamento(Long id);

}
