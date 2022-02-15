package school.sptech.projeto02;

public class Pais {

    // attributo
    private String nome;
    private Integer medalhasOuro;
    private Integer medalhasPrata;
    private Integer medalhasBronze;

    // constructor

    public Pais() {
    }
    public Pais(String nome, Integer medalhasOuro, Integer medalhasPrata, Integer medalhasBronze) {
        this.nome = nome;
        this.medalhasOuro = medalhasOuro;
        this.medalhasPrata = medalhasPrata;
        this.medalhasBronze = medalhasBronze;
    }

    // methods
    public int getTotalMedalhas() {
        return this.medalhasOuro + this.medalhasPrata + this.medalhasBronze;
    }

    public Boolean isVencedor() {
        return true;
    }

    // getters and setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Integer getMedalhasOuro() {
        return medalhasOuro;
    }
    public void setMedalhasOuro(Integer medalhasOuro) {
        this.medalhasOuro = medalhasOuro;
    }
    public Integer getMedalhasPrata() {
        return medalhasPrata;
    }
    public void setMedalhasPrata(Integer medalhasPrata) {
        this.medalhasPrata = medalhasPrata;
    }
    public Integer getMedalhasBronze() {
        return medalhasBronze;
    }
    public void setMedalhasBronze(Integer medalhasBronze) {
        this.medalhasBronze = medalhasBronze;
    }
}
