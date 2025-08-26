package classroom_project.business.repositorys;

import classroom_project.business.entitys.Aula;
import classroom_project.business.enums.Andar;
import classroom_project.business.enums.Bloco;
import classroom_project.business.enums.Dia;
import classroom_project.business.enums.Turno;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AulaRepository extends JpaRepository<Aula, Long> {

    Optional<Object> findByHorarioAndAndarAndBloco(@NotBlank(message = "Horário é obrigatório") String horario, @NotNull(message = "Andar é obrigatório") Andar andar, @NotNull(message = "Bloco é obrigatório") Bloco bloco);

    List<Aula> findByDiaAndTurno(Dia dia, Turno turno);

    List<Aula> findByDia(Dia dia);

    List<Aula> findByTurno(Turno turno);
}
