package classroom_project.business.entitys;

import classroom_project.business.DTOs.DadosCadastroAula;
import classroom_project.business.DTOs.DadosEdicaoAula;
import classroom_project.business.enums.Andar;
import classroom_project.business.enums.Bloco;
import classroom_project.business.enums.Dia;
import classroom_project.business.enums.Turno;
import jakarta.persistence.*;
import jakarta.validation.Valid;
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
    private String sala;
    private String curso;
    private String horario;
    private String professor;
    private String disciplina;
    @Enumerated(EnumType.STRING)
    private Andar andar;
    @Enumerated(EnumType.STRING)
    private Dia dia;
    @Enumerated(EnumType.STRING)
    private Bloco bloco;
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