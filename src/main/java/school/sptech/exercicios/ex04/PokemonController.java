package school.sptech.exercicios.ex04;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {
    
    @GetMapping("/cadastrar/{nome}/{tipo}/{forca}/{capturado}")
    public String cadastrar() {
        return "";
    }

    @GetMapping("/remover/{indice}")
    public String remover() {
        return "";
    }

    @GetMapping("/buscar/{indice}")
    public String buscar() {
        return "";
    }

    @GetMapping("/atualizar/{indice}/{nome}/{tipo}/{forca}/{capturado}")
    public String atualizar() {
        return "";
    } 

    @GetMapping("/listar")
    public String listar() {
        return "";
    }
}
