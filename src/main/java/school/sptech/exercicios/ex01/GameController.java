package school.sptech.exercicios.ex01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {
    
    private int vitorias = 0;
    private int empates = 0; 
    private int derrotas = 0;
    
    private int partidas() {
        return vitorias + empates + derrotas;
    }

    private int pontuacao() {
        return vitorias * 3 + empates;
    }

    private int pontuacaoPotencial() {
        return this.partidas() * 3;
    }

    private int aproveitamento() {
        return (pontuacao() * 100) / pontuacaoPotencial();
    }

    // endpoints

    @GetMapping("/")
    public String index() {
        StringBuilder sb = new StringBuilder();

        sb.append("Partidas jogadas: %d<br>");
        sb.append("Pontuação: %d<br><br>");

        sb.append("Vitorias: %d<br>");
        sb.append("Empates: %d<br>");
        sb.append("Derrotas: %d<br>");

        String str = String.valueOf(sb);

        return String.format(str, this.partidas(), this.pontuacao(), this.vitorias, this.empates, this.derrotas);
    }
    
    @GetMapping("/registrar-vitoria")
    public String registrarVitoria() {
        this.vitorias++;
        return String.format("Vitórias: %d", this.vitorias);
    }

    @GetMapping("/registrar-empate")
    public String registrarEmpates() {
        this.empates++;
        return String.format("Empates: %d", this.empates);
    }

    @GetMapping("/registrar-derrota")
    public String registrarDerrotas() {
        this.derrotas++;
        return String.format("Derrotas: %d", this.derrotas);
    }  

    @GetMapping("/pontuacao")
    public String getPontuacao() {
        if(this.partidas() > 0) {
            return String.format("Ola, você tem %d pontos e %d partidas - Aproveitamento %s%%", this.pontuacao(), this.partidas(), this.aproveitamento());
        } else {
            return "Cadastre pelo menos uma vitória, empate ou derrota";
        }
    }
}
