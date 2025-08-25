package classroom_project.business.entitys;

import classroom_project.business.DTOs.DadosCadastroAula;
import classroom_project.business.DTOs.DadosEdicaoAula;
import classroom_project.business.enums.Andar;
import classroom_project.business.enums.Bloco;
import classroom_project.business.enums.Dia;
import classroom_project.business.enums.Turno;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name= "aulas")
@Entity(name = "Aula" )
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Aula {

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Sala é obrigatória")
    private String sala;

    @NotBlank(message = "Curso é obrigatório")
    private String curso;

    @NotBlank(message = "Horário é obrigatório")
    private String horario;

    @NotBlank(message = "Professor é obrigatório")
    private String professor;

    @NotBlank(message = "Disciplina é obrigatória")
    private String disciplina;

    @NotNull(message = "Andar é obrigatório")
    @Enumerated(EnumType.STRING)
    private Andar andar;

    @NotNull(message = "Dia é obrigatório")
    @Enumerated(EnumType.STRING)
    private Dia dia;

    @NotNull(message = "Bloco é obrigatório")
    @Enumerated(EnumType.STRING)
    private Bloco bloco;

    @NotNull(message = "Turno é obrigatório")
    @Enumerated(EnumType.STRING)
    private Turno turno;

    public Aula(DadosCadastroAula dados) {
        this.sala = dados.sala();
        this.curso = dados.curso();
        this.horario = dados.horario();
        this.professor = dados.professor();
        this.disciplina = dados.disciplina();
        this.horario = dados.horario();
    }

    public void atualizarAula(@Valid DadosEdicaoAula aula) {
        //  Vou editar apenas dia, andar, bloco, sala e horario
        if(aula.dia() != null){
            this.dia = aula.dia();
        }

        if(aula.andar() != null){
            this.andar = aula.andar();
        }

        if(aula.bloco() != null){
            this.bloco = aula.bloco();
        }

        if(aula.sala() != null){
            this.sala = aula.sala();
        }

        if(aula.horario() != null){
            this.horario = aula.horario();
        }

    }
}