package git.flavia.ConsultasMedicas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import git.flavia.ConsultasMedicas.entity.Medico;
import git.flavia.ConsultasMedicas.repository.MedicoRepository;
import git.flavia.ConsultasMedicas.serviceImpl.MedicoInterface;

@Service
public class medicoService implements MedicoInterface {
	
	@Autowired
	private MedicoRepository medicoRepository;

	@Override
	public List<Medico> listarMedicos() {
		return medicoRepository.findAll();
	}

	@Override
	public Optional<Medico> listarMedicoById(Long id) {
		return medicoRepository.findById(id);
	}

	@Override
	public Medico cadastroMedico(Medico medico) {
		return medicoRepository.save(medico);
	}

	@Override
	public Optional<Medico> atualizarMedico(Long id, Medico medicoDetalhes) {
		 return medicoRepository.findById(id)
	                .map(medico -> {
	                    medico.setNome(medicoDetalhes.getNome());
	                    medico.setEspecialidade(medicoDetalhes.getEspecialidade());
	                    return medicoRepository.save(medico);
	                });
	    }

	@Override
	public boolean apagarMedico(Long id) {
		return medicoRepository.findById(id)
                .map(medico -> {
                    medicoRepository.delete(medico);
                    return true;
                })
                .orElse(false);
    }
	}


