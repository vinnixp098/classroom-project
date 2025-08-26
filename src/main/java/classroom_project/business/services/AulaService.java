package classroom_project.business.services;

import classroom_project.business.DTOs.DadosEdicaoAula;
import classroom_project.business.entitys.Aula;
import classroom_project.business.enums.Dia;
import classroom_project.business.enums.Turno;
import classroom_project.business.repositorys.AulaRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AulaService {
    private final AulaRepository repository;
    private Dia dia;
    private Object horario;
    private Turno turno;
    private String sala;

    public AulaService(AulaRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<?> salvarAula (Aula aula){
        return repository
                .findByHorarioAndAndarAndBloco(aula.getHorario(), aula.getAndar(), aula.getBloco())
                .map(lesson -> ResponseEntity.badRequest().body("A sala já foi reservada!"))
                .orElseGet(() -> {
                    repository.save(aula);
                    return ResponseEntity.ok().body("Sala reservada com sucesso!");
                });
    }

    public ResponseEntity<?> excluirAula(@Valid Long id) {
        return repository
                .findById(id)
                .map(lesson -> {
                        repository.deleteById(id);
                        return ResponseEntity.ok().body("Sala excluída com sucesso!");
                })
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    public List<Aula> listarAulasReservados() {
        return repository.findAll();
    }

    public List<Aula> listarAulas(Dia dia, Turno turno) {
        if(dia != null && turno != null){
            return repository.findByDiaAndTurno(dia, turno);
        } else if(dia != null){
            return repository.findByDia(dia);
        } else if(turno != null){
            return repository.findByTurno(turno);
        } else{
            return repository.findAll();
        }
    }

    public ResponseEntity<?> editarAula(@Valid DadosEdicaoAula aula) {
        var aulaEditadaOptional = repository.findById(Long.valueOf(aula.Id()));

        if (aulaEditadaOptional.isPresent()) {
            Aula aulaEditada = aulaEditadaOptional.get();

            if (aula.dia() != null) aulaEditada.setDia(aula.dia());
            if (aula.horario() != null) aulaEditada.setHorario(aula.horario());
            if (aula.turno() != null) aulaEditada.setTurno(aula.turno());
            if (aula.sala() != null) aulaEditada.setSala(aula.sala());

            repository.save(aulaEditada);

            return ResponseEntity.ok().body("Dados editados com sucesso!");
        } else {
            return ResponseEntity.badRequest().body("Não foi possível editar a reserva!");
        }
    }

}
