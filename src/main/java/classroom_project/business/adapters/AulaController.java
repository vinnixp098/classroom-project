package classroom_project.business.adapters;

import classroom_project.business.DTOs.DadosCadastroAula;
import classroom_project.business.repositorys.AulaRepository;
import classroom_project.business.services.AulaService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("aulas")

public class AulaController {

    @Autowired
    private AulaRepository repository;

    @GetMapping
    public ResponseEntity<?> salavrAula(@RequestBody DadosCadastroAula aula){
        return repository.save(aula)
    }
}
