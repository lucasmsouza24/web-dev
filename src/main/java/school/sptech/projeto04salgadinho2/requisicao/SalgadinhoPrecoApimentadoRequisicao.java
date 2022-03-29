package sptech.projetojpa01.requisicao;

public class SalgadinhoPrecoApimentadoRequisicao {

    private Double preco;
    private Boolean apimentado;

    public SalgadinhoPrecoApimentadoRequisicao(Double preco, Boolean apimentado) {
        this.preco = preco;
        this.apimentado = apimentado;
    }

    public Double getPreco() {
        return preco;
    }
    public Boolean getApimentado() {
        return apimentado;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public void setApimentado(Boolean apimentado) {
        this.apimentado = apimentado;
    }
    
}
