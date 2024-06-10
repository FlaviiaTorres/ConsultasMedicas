package git.flavia.ConsultasMedicas.serviceImpl;

import java.util.List;
import java.util.Optional;

import git.flavia.ConsultasMedicas.entity.Medico;

public interface MedicoInterface {
	
	 	List<Medico> listarMedicos();
	    Optional<Medico> listarMedicoById(Long id);
	    Medico cadastroMedico(Medico medico);
	    Optional<Medico> atualizarMedico(Long id, Medico medicoDetalhes);
	    boolean apagarMedico(Long id);

}
