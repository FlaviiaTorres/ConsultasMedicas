package git.flavia.ConsultasMedicas.serviceImpl;

import java.util.List;
import java.util.Optional;

import git.flavia.ConsultasMedicas.entity.Paciente;

public interface PacienteInterface {
	
	 	List<Paciente> listarPaciente();
	    Optional<Paciente> listarPacienteById(Long id);
	    Paciente cadastrarPaciente(Paciente paciente);
	    Optional<Paciente> atualizarPaciente(Long id, Paciente pacienteDetalhes);
	    boolean apagarPaciente(Long id);

}
