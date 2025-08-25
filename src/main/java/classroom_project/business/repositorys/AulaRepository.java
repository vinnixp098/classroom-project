package classroom_project.business.repositorys;

import classroom_project.business.DTOs.DadosEdicaoAula;
import classroom_project.business.entitys.Aula;
import classroom_project.business.enums.Andar;
import classroom_project.business.enums.Bloco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface AulaRepository extends JpaRepository<Aula, Long> {

    Optional<Object> findByHorarioAndAndarAndBloco(@NotBlank(message = "Horário é obrigatório") String horario, @NotNull(message = "Andar é obrigatório") Andar andar, @NotNull(message = "Bloco é obrigatório") Bloco bloco);

    ResponseEntity<?> deleteAllById(@Valid Long id);
}
