package classroom_project.business.DTOs;

import classroom_project.business.enums.Andar;
import classroom_project.business.enums.Bloco;
import classroom_project.business.enums.Dia;
import classroom_project.business.enums.Turno;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroAula(
        @NotBlank
        String Id,

        @NotBlank
        String sala,

        @NotNull
        String curso,
        @NotNull
        String horario,

        @NotNull
        String professor,

        @NotNull
        String disciplina,

        @NotNull
        Andar andar,

        @NotNull
        Dia dia,

        @NotNull
        Bloco bloco,

        @NotNull
        Turno turno
) {

}