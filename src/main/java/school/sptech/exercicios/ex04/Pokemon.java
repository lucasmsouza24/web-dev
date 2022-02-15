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
