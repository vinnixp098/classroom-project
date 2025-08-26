package classroom_project.business.adapters;

import classroom_project.business.DTOs.DadosCadastroAula;
import classroom_project.business.DTOs.DadosEdicaoAula;
import classroom_project.business.entitys.Aula;
import classroom_project.business.enums.Dia;
import classroom_project.business.enums.Turno;
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

    @GetMapping("/reservados")
    public List<Aula> listarAulas(){
        return aulaService.listarAulasReservados();
    }

    @PutMapping
    public ResponseEntity<?> editarAula(@Valid @RequestBody DadosEdicaoAula aula){
        return aulaService.editarAula(aula);
    }

    @GetMapping
    public List<Aula> listarAulas(
            @RequestParam(required = false)Dia dia,
            @RequestParam(required = false)Turno turno
    ){
        return aulaService.listarAulas(dia, turno);
    }

}
