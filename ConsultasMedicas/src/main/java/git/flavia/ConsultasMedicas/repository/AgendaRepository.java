package git.flavia.ConsultasMedicas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import git.flavia.ConsultasMedicas.entity.Agenda;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {

}
