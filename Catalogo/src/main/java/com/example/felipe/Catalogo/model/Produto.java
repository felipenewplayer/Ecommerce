package com.example.felipe.Catalogo.model;

import com.example.felipe.Catalogo.dto.ProdutoDto;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;

    public Produto() {
    }

    public Produto(Long id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public Produto(ProdutoDto dto){
        this.id = dto.id();
        this.price = dto.price();

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Produto produto)) return false;

        return Objects.equals(id, produto.id) && Objects.equals(name, produto.name) && Objects.equals(price, produto.price);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(price);
        return result;
    }

    @Override
    public String toString() {
        return "id = " + id + "name =" + name + "price = " + price;
    }
}
