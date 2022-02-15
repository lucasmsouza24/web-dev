package school.sptech.projeto02;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paises")
public class OlimpiadasController {

    private List<Pais> paises = new ArrayList<Pais>();
    
    @GetMapping
    public Pais teste() {
        Pais p1 = new Pais("Brasil", 12, 30, 60);
        return p1;
    }

    @GetMapping("/listar")
    public List<Pais> listar() {
        paises.add(new Pais("Brazil", 3, 10, 50));
        paises.add(new Pais("Japao", 31, 10, 8));
        paises.add(new Pais("EUA", 6, 20, 23));

        return paises;
    }

    @GetMapping("/cadastrar/{nome}/{ouro}/{prata}/{bronze}")
    public String cadastrar(
        @PathVariable String nome, 
        @PathVariable Integer ouro, 
        @PathVariable Integer prata,
        @PathVariable Integer bronze
    ) {
        Pais p1 = new Pais(nome, ouro, prata, bronze);
        paises.add(p1);

        return String.format("Pais %s cadastrado!", nome);
    }

    @GetMapping("/buscar/{index}")
    public Pais buscar(@PathVariable Integer index) {
        return paises.get(index);
    }
}
