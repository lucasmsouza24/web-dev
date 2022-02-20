package school.sptech.exercicios.ex04;

public class Pokemon {
    
    // attributes
    private String nome; 
    private String tipo; 
    private Double forca; 
    private Boolean capturado;

    // constructor
    public Pokemon() {
    } 
    public Pokemon(String nome, String tipo, Double forca, Boolean capturado) {
        this.nome = nome;
        this.tipo = tipo;
        this.forca = forca;
        this.capturado = capturado;
    }

    // methods
    public String toString() {
        StringBuilder sb = new StringBuilder("<br> Pokemon");

        sb.append(String.format("<br> &nbsp nome: %s", this.nome));
        sb.append(String.format("<br> &nbsp tipo: %s", this.tipo));
        sb.append(String.format("<br> &nbsp forca: %.2f", this.forca));
        sb.append(String.format("<br> &nbsp capturado: %b<br>", this.capturado));

        return String.valueOf(sb);
    }

    // getters and setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public Double getForca() {
        return forca;
    }
    public void setForca(Double forca) {
        this.forca = forca;
    }
    public Boolean getCapturado() {
        return capturado;
    }
    public void setCapturado(Boolean capturado) {
        this.capturado = capturado;
    }
}
