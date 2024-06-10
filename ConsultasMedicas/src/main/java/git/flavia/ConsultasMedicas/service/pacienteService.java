package git.flavia.ConsultasMedicas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import git.flavia.ConsultasMedicas.entity.Paciente;
import git.flavia.ConsultasMedicas.repository.PacienteRepository;
import git.flavia.ConsultasMedicas.serviceImpl.PacienteInterface;

@Service
public class pacienteService implements PacienteInterface {
	
	@Autowired
	private PacienteRepository pacienteRepository;

	@Override
	public List<Paciente> listarPaciente() {
		return pacienteRepository.findAll();
	}

	@Override
	public Optional<Paciente> listarPacienteById(Long id) {
		return pacienteRepository.findById(id);
	}

	@Override
	public Paciente cadastrarPaciente(Paciente paciente) {
		return pacienteRepository.save(paciente);
	}

	@Override
	public Optional<Paciente> atualizarPaciente(Long id, Paciente pacienteDetalhes) {
		return pacienteRepository.findById(id)
                .map(paciente -> {
                    paciente.setNome(pacienteDetalhes.getNome());
                    paciente.setTelefone(pacienteDetalhes.getTelefone());
                    return pacienteRepository.save(paciente);
                });
    }
	

	@Override
	public boolean apagarPaciente(Long id) {
		return pacienteRepository.findById(id)
                .map(paciente -> {
                    pacienteRepository.delete(paciente);
                    return true;
                })
                .orElse(false);
    }
	}


