package git.flavia.ConsultasMedicas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import git.flavia.ConsultasMedicas.entity.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

}
