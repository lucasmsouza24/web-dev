package school.sptech.projeto02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cidades")
public class Cidades {

    @GetMapping("/listar")
    public String listar() {
        return "todas as cidades";
    }

    @GetMapping("/top-5")
    public String top5() {
        return "As top cidades são A, B e C";
    }

    @GetMapping
    public String home() {
        return "bem vindos à API cidades";
    }
    
}
 