package school.sptech.exercicios.ex04;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {

    private List<Pokemon> pkms = new ArrayList<Pokemon>();

    // test endpoint
    @GetMapping("/test")
    public String test() {
        Pokemon p1 = new Pokemon("Pikachu", "Electricity", 600d, false);
        Pokemon p2 = new Pokemon("Bulbassaur", "Grass", 830d, true);
        Pokemon p3 = new Pokemon("Squartle", "Water", 960d, true);

        pkms.add(p1);
        pkms.add(p2);
        pkms.add(p3);

        return "Pokemons criados";
    }
    
    @GetMapping("/cadastrar/{nome}/{tipo}/{forca}/{capturado}")
    public String cadastrar(@PathVariable String nome, @PathVariable String tipo, @PathVariable Double forca, @PathVariable Boolean capturado) {
        Pokemon p1 = new Pokemon(nome, tipo, forca, capturado);
        pkms.add(p1);
        return String.format("Pokemon %s adicionado!", p1.getNome());
    }

    @GetMapping("/remover/{indice}")
    public String remover(@PathVariable Integer indice) {
        pkms.remove((int) indice);
        return "Pokemon removido";
    }

    @GetMapping("/buscar/{indice}")
    public Pokemon buscar(@PathVariable Integer indice) {
        return pkms.get(indice);
    }

    @GetMapping("/atualizar/{indice}/{nome}/{tipo}/{forca}/{capturado}")
    public String atualizar(@PathVariable Integer indice, @PathVariable String nome, @PathVariable String tipo, @PathVariable Double forca, @PathVariable Boolean capturado) {

        pkms.get(indice).setNome(nome);
        pkms.get(indice).setTipo(tipo);
        pkms.get(indice).setForca(forca);
        pkms.get(indice).setCapturado(capturado);

        return "Pokemon atualizado";
    } 

    @GetMapping("/listar")
    public List<Pokemon> listar() {

        return pkms;
    }

    // @GetMapping("/{tipo}/contagem");
    // public String 
}
