package git.flavia.ConsultasMedicas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import git.flavia.ConsultasMedicas.entity.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{

}
