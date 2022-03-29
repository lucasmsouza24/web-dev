package sptech.projetojpa01.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.projetojpa01.entidade.Salgadinho;
import sptech.projetojpa01.repositorio.SalgadinhoRepository;
import sptech.projetojpa01.requisicao.SalgadinhoPrecoApimentadoRequisicao;
import sptech.projetojpa01.resposta.SalgadinhoSimplesResposta;
import java.util.List;
import javax.validation.Valid;
// import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/salgadinhos")
public class SalgadinhoController {

  @Autowired
  private SalgadinhoRepository repository;

  @PostMapping
  public ResponseEntity<Object> postSalgadinho(
      @RequestBody @Valid Salgadinho novoSalgadinho) {
    repository.save(novoSalgadinho);
    return ResponseEntity.status(201).build();
  }

  @GetMapping
  public ResponseEntity<List<Salgadinho>> getSalgadinhos() {
    List<Salgadinho> salgadinhos = repository.findAll();
    if (salgadinhos.isEmpty()) {
      return ResponseEntity.status(204).build();
    }
    return ResponseEntity.status(200).body(salgadinhos);
  }

  @GetMapping("/simples")
  public ResponseEntity<List<SalgadinhoSimplesResposta>> getSimples() {
    List<SalgadinhoSimplesResposta> salgadinhos = repository.listaSimples();
    if (salgadinhos.isEmpty()) {
      return ResponseEntity.status(204).build();
    }
    return ResponseEntity.status(200).body(salgadinhos);
  }

  @DeleteMapping("/{codigo}")
  public ResponseEntity<Object> deleteSalgadinho(
      @PathVariable int codigo) {
    if (repository.existsById(codigo)) {
      repository.deleteById(codigo);
      return ResponseEntity.status(200).build();
    }
    return ResponseEntity.status(404).build();
  }

  @GetMapping("/{codigo}")
  public ResponseEntity<Salgadinho> getPorCodigo(@PathVariable Integer codigo) {
        /*
    O ResponseEntity.of() recebe um Optional e retorna...
    - status 404 e sem corpo se não tiver valor
    - status 200 e com o valor no corpo se tiver valor
             */
    // O findById() tenta recuperar 1 registro do banco
    return ResponseEntity.of(repository.findById(codigo));


//
//    Optional<Salgadinho> salgadinhoOptional = repository.findById(codigo);
//
//    if (salgadinhoOptional.isPresent()) {
//      Salgadinho salgadinho = salgadinhoOptional.get();
//      return ResponseEntity.status(200).body(salgadinho);
//    }
//
//    return ResponseEntity.status(404).build();
  }

  @PutMapping("/{codigo}")
  public ResponseEntity<Object> putSalgadinho(
      @PathVariable Integer codigo,
      @RequestBody Salgadinho salgadinho) {

    if (repository.existsById(codigo)) {
      salgadinho.setCodigo(codigo);
      repository.save(salgadinho);
      return ResponseEntity.status(200).build();
    }

    return ResponseEntity.status(404).build();
  }

  @GetMapping("/contador")
  public ResponseEntity<Long> getMethodName() {
      return ResponseEntity.status(200).body(repository.count());
  }

  @PatchMapping("/{codigo}/preco/{novoPreco}")
  public ResponseEntity<Object> patchSalgadinho(
    @PathVariable int codigo, 
    @PathVariable int novoPreco) {
        if(repository.existsById(codigo)) {
          repository.atualizarPreco(Integer.valueOf(codigo), Double.valueOf(novoPreco));
          return ResponseEntity.status(200).build();
        }

        return ResponseEntity.status(404).build();
  }

  @PatchMapping("/{codigo}/preco-apimentado")
  public ResponseEntity<Object> patchSalgadinhoMelhorado(@PathVariable int codigo, @RequestBody SalgadinhoPrecoApimentadoRequisicao salgadinho) {
    if (repository.existsById(codigo)) {
      repository.atualizarPrecoApimentado(codigo, salgadinho.getPreco(), salgadinho.getApimentado());
      return ResponseEntity.status(200).build();
    }
    return ResponseEntity.status(404).build();
  }
}
