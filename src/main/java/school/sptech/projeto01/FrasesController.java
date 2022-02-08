package school.sptech.projeto01;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FrasesController {

    private int value = 0;
    
    @GetMapping("/cumprimentar")
    public String cumprimentar() {
        return "Olha eu na REST API!";
    }

    // chamada /boa-noite que retorna "Boa noite, numero X"
    // Onde X é um número aleatório
    @GetMapping("boa-noite")
    public String boaNoite() {
        Integer randomInteger = ThreadLocalRandom.current().nextInt(0, 10);
        return "Boa noite, número: " + randomInteger;
    }

    @GetMapping("/{numero1}/{numero2}")
    public String somar(@PathVariable int numero1, @PathVariable int numero2) {
        int soma = numero1 + numero2;
        return String.format("%d + %d = %d", numero1, numero2, soma);
    }

    // Crie uma chamada "saudacao" que recebe um nome e retorna 
    // "Bem-vindo X" onde x é o nome informado

    @GetMapping("saudacao/{name}")
    public String saudacao(@PathVariable String name) {
        return String.format("Bem-vindo %s", name);
    }

    @GetMapping("saudacao")
    public String saudacao() {
        return String.format("Bem-Vindo Anônimo");
    }

    @GetMapping("/contar")
    public int contar() {
        return ++value;
    }

    // /registrar-vitoria
    // /registrar-derrota
    // /registrar-empate

    // gera uma partida

    // /pontuacao
    //      vitoria = 3 pontos
    //      empate  = 1 ponto
    //      derrota = 3 pontos

    private int partidas = 0;
    private int pontos = 0;

    private String pontuacao() {
        return String.format("Vitórias: %d\nDerrotas: %d\nEmpates: %d");
    }

    @GetMapping("registrar-vitoria")
    public String registrarVitoria() {
        return pontuacao();
    }
}
