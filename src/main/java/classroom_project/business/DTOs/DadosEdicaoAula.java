package classroom_project.business.DTOs;

import classroom_project.business.enums.Andar;
import classroom_project.business.enums.Bloco;
import classroom_project.business.enums.Dia;
import classroom_project.business.enums.Turno;
import jakarta.validation.constraints.NotBlank;

public record DadosEdicaoAula(
        @NotBlank
        String Id,
        String sala,
        String curso,
        String horario,
        String professor,
        String disciplina,
        Andar andar,
        Dia dia,
        Bloco bloco,
        Turno turno
) {

}