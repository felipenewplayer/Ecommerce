package com.example.felipe.Pedido.model;

import com.example.felipe.Pedido.dto.ItemPedidoDto;
import com.example.felipe.Pedido.dto.PedidoDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String clientName;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy ="pedido")
    private List<ItemDoPedido> itens = new ArrayList<>();

    public Pedido(Long id, String clientName, Status status, List<ItemDoPedido> itens) {
        this.id = id;
        this.clientName = clientName;
        this.status = status;
        this.itens = itens;
    }

    public Pedido(PedidoDto dto) {
        this.id = dto.id();
        this.clientName = dto.clientName();
        this.status = dto.status();
        this.itens = (dto.itens() != null) ? dto.itens().stream()
                .map(itemDto -> new ItemDoPedido(itemDto.id(), itemDto.quantidade(), itemDto.descricao(), this))
                .toList() : new ArrayList<>();
    }

    public Pedido() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<ItemPedidoDto> getItens() {
        return (itens != null) ? itens.stream()
                .map(item -> new ItemPedidoDto(item.getId(), item.getQuantidade(), item.getDescricao()))
                .toList() : new ArrayList<>();
    }

    public void setItens(List<ItemDoPedido> itensDto) {
        this.itens = (itensDto != null) ? itensDto.stream()
                .map(itemDto -> new ItemDoPedido(itemDto.getId(), itemDto.getQuantidade(), itemDto.getDescricao(), this))
                .toList() : new ArrayList<>();
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Pedido pedido)) return false;

        return Objects.equals(id, pedido.id) && Objects.equals(clientName, pedido.clientName) && status == pedido.status && Objects.equals(itens, pedido.itens);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(clientName);
        result = 31 * result + Objects.hashCode(status);
        result = 31 * result + Objects.hashCode(itens);
        return result;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", clientName='" + clientName + '\'' +
                ", status=" + status +
                ", itens=" + itens +
                '}';
    }
}
