package classroom_project.business.repositorys;

import classroom_project.business.DTOs.DadosEdicaoAula;
import classroom_project.business.entitys.Aula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AulaRepository extends JpaRepository<Aula, Long> {
}
