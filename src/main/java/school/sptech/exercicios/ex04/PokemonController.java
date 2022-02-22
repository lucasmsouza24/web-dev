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
    public Message test() {
        Pokemon p1 = new Pokemon("Pikachu", "Electricity", 600d, false);
        Pokemon p2 = new Pokemon("Bulbassaur", "Grass", 4030d, true);
        Pokemon p3 = new Pokemon("Squartle", "Water", 960d, true);

        pkms.add(p1);
        pkms.add(p2);
        pkms.add(p3);

        return new Message("Pokemons criados");
    }
    
    @GetMapping("/cadastrar/{nome}/{tipo}/{forca}/{capturado}")
    public Message cadastrar(@PathVariable String nome, @PathVariable String tipo, @PathVariable Double forca, @PathVariable Boolean capturado) {
        Pokemon p1 = new Pokemon(nome, tipo, forca, capturado);
        pkms.add(p1);
        return new Message(String.format("Pokemon %s adicionado!", p1.getNome()));
    }

    @GetMapping("/remover/{indice}")
    public Message remover(@PathVariable int indice) {
        String nome = pkms.get(indice).getNome();
        pkms.remove(indice);
        return new Message(String.format("Pokemon %s removido", nome));
    }

    @GetMapping("/buscar/{indice}")
    public Pokemon buscar(@PathVariable Integer indice) {
        return pkms.get(indice);
    }

    @GetMapping("/atualizar/{indice}/{nome}/{tipo}/{forca}/{capturado}")
    public Message atualizar(@PathVariable Integer indice, @PathVariable String nome, @PathVariable String tipo, @PathVariable Double forca, @PathVariable Boolean capturado) {

        pkms.get(indice).setNome(nome);
        pkms.get(indice).setTipo(tipo);
        pkms.get(indice).setForca(forca);
        pkms.get(indice).setCapturado(capturado);

        return new Message("Pokemon atualizado");
    } 

    @GetMapping("/listar")
    public List<Pokemon> listar() {
        return pkms;
    }

    @GetMapping("/{tipo}/contagem")
    public Integer contagem(@PathVariable String tipo) {
        int amount = 0;

        for (Pokemon p : pkms) {
            if (p.getTipo().equals(tipo)) {
                amount++;
            }
        }

        return amount;
    }

    @GetMapping("/capturados")
    public List<Pokemon> capturados(){
        List<Pokemon> capturados = new ArrayList<Pokemon>();

        for (Pokemon p : pkms) {
            if (p.getCapturado()) {
                capturados.add(p);
            }
        }

        return capturados;
    }

    @GetMapping("/fortes")
    public List<Pokemon> fortes(){
        List<Pokemon> fortes = new ArrayList<Pokemon>();

        for (Pokemon p : pkms) {
            if (p.getForca() > 3000) {
                fortes.add(p);
            }
        }

        return fortes;
    }

    @GetMapping("/fracos")
    public List<Pokemon> fracos(){
        List<Pokemon> fracos = new ArrayList<Pokemon>();

        for (Pokemon p : pkms) {
            if (p.getForca() <= 3000) {
                fracos.add(p);
            }
        }

        return fracos;
    }
}
