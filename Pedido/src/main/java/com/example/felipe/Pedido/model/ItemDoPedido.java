package com.example.felipe.Pedido.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "itens_do_pedido")

public class ItemDoPedido {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Positive
    private Integer quantidade;

    private String descricao;

    @ManyToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;

    public ItemDoPedido() {
    }

    public ItemDoPedido(Long id, Integer quantidade, String descricao, Pedido pedido) {
        this.id = id;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.pedido = pedido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public String toString() {
        return "ItemDoPedido{" +
                "id=" + id +
                ", quantidade=" + quantidade +
                ", descricao='" + descricao + '\'' +
                ", pedido=" + pedido +
                '}';
    }
}
