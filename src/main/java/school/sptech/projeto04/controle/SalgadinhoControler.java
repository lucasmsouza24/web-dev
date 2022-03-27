package school.sptech.projeto04.controle;

import java.util.List;
import org.springframework.http.ResponseEntity;
import school.sptech.projeto04.repositorio.SalgadinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.sptech.projeto04.entidade.Salgadinho;

@RestController
@RequestMapping("/salgadinhos")
public class SalgadinhoControler {
    
    @Autowired
    private SalgadinhoRepository repository;
    
    @PostMapping
    public ResponseEntity<Salgadinho> postSalgadinho(@RequestBody Salgadinho novoSalgadinho) {
        repository.save(novoSalgadinho);
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity<Object> getSalgadinhos() {
        List<Salgadinho> salgadinhos = repository.findAll();

        if(salgadinhos.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(salgadinhos);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Salgadinho> deleteSalgadinhos(@PathVariable Integer codigo) {
        if(repository.existsById(codigo)) {
            repository.deleteById(codigo);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Salgadinho> getSalgadinhos(@PathVariable Integer codigo) {
        return ResponseEntity.of(repository.findById(codigo));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Salgadinho> putSalgadinhos(@PathVariable Integer codigo, @RequestBody Salgadinho salg) {
        if (repository.existsById(codigo)) {
            salg.setCodigo(codigo);
            repository.save(salg);
            return ResponseEntity.status(200).build();
        }

        return ResponseEntity.status(404).build();
    }
}
