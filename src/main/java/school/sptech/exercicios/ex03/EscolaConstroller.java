package school.sptech.exercicios.ex03;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EscolaConstroller {
    
    // attributes
    String nome;
    Double nota1;
    Double nota2;

    public Double media() {
        return (nota1 + nota2) / 2;
    }

    // endpoints 
    @GetMapping("/cadastrar-estudante/{nome}")
    public String cadastrarEstudante(@PathVariable String nome) {
        this.nome = nome;
        return String.format("studante %s cadastrado(a) com sucesso", nome);
    }

    @GetMapping("/cadastrar-notas/{nota1}/{nota2}")
    public String cadastrarNotas(@PathVariable Double nota1,@PathVariable Double nota2) {
        this.nota1 = nota1;
        this.nota2 = nota2;

        return "Notas cadastradas com sucesso";
    }

    @GetMapping("/resultado")
    public String resultado() {
        if (nome == null || nota1 == null || nota2 == null) {
            return "Cadastre o nome e as notas antes";
        } else if(media() >= 6) {
            return String.format("Estudante aprovado com a média %.1f", media());
        } else {
            return String.format("Com a média %.1f infelizmente não há aprovação", media());
        }
    }
}
