package com.example.test.projetoT.dto;

import com.example.test.projetoT.model.Pedido;
import com.example.test.projetoT.model.StatusPedido;
import com.sun.istack.NotNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

//os nomes dos atributos que sao mapeados para os inputs
public class RequisicaoNovoPedido {

    @NotBlank(message="Campo não pode ser deixado em branco")
    private String nomeProduto;
    @NotBlank(message="Campo não pode ser deixado em branco")
    private String urlProduto;
    @NotBlank(message="Campo não pode ser deixado em branco")
    private String urlImagem;
    private String descricao;



    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getUrlProduto() {
        return urlProduto;
    }

    public void setUrlProduto(String urlProduto) {
        this.urlProduto = urlProduto;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Pedido toPedido() {
        //Aqui esta passando os valores dos atributos da class para o pedido
        Pedido pedido = new Pedido();
        pedido.setNomeProduto(nomeProduto);
        pedido.setDescricao(descricao);
        pedido.setUrlImagem(urlImagem);
        pedido.setUrlProduto(urlProduto);
        pedido.setStatus(StatusPedido.AGUARDANDO);
        return pedido;
    }
}
