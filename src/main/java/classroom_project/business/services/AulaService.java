package classroom_project.business.services;

import classroom_project.business.DTOs.DadosCadastroAula;
import classroom_project.business.DTOs.DadosEdicaoAula;
import classroom_project.business.entitys.Aula;
import classroom_project.business.repositorys.AulaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AulaService {
    private final AulaRepository repository;

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

    public List<Aula> listarAulas() {
        return repository.findAll();
    }
}
