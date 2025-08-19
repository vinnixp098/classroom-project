package classroom_project.business.services;

import classroom_project.business.DTOs.DadosCadastroAula;
import classroom_project.business.DTOs.DadosEdicaoAula;
import classroom_project.business.entitys.Aula;
import classroom_project.business.repositorys.AulaRepository;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class AulaService {
    private final AulaRepository repository;

    Aula objetoAula = new Aula();

    public AulaService(AulaRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<?> salvarAula (DadosCadastroAula aula){
        repository.save(new DadosCadastroAula(aula));
        return ResponseEntity.ok().build();
    }

    public List<Aula> listarAulas(){
        return new ArrayList<>(repository.findAll());
    }

    public void atualizarAula(DadosEdicaoAula aula){
        objetoAula.atualizarAula(aula);
    }

    public void excluirAula(Long id){
        repository.deleteById(id);
    }
}
