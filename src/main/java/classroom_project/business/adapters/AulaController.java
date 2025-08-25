package classroom_project.business.adapters;

import classroom_project.business.DTOs.DadosCadastroAula;
import classroom_project.business.entitys.Aula;
import classroom_project.business.services.AulaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("aulas")
@RequiredArgsConstructor
public class AulaController {

    @Autowired
    private AulaService aulaService;

    @PostMapping
    @Transactional
    public ResponseEntity<?> salvarAula(@Valid @RequestBody Aula aula){
        return aulaService.salvarAula(aula);
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity<?> excluirAula(@Valid @RequestParam Long id){
        return aulaService.excluirAula(id);
    }

    @GetMapping
    public List<Aula> listarAulas(){
        return aulaService.listarAulas();
    }
}
