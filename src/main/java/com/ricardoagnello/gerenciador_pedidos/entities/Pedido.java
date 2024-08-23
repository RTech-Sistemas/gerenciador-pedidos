package com.ricardoagnello.gerenciador_pedidos.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.ricardoagnello.gerenciador_pedidos.utils.CalculoUtil;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Pedido implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pedidoId;

    @NotEmpty(message = "Nome obrigatório")
    private String nomeCliente;

    @CreationTimestamp
    private LocalDate data;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemPedido> itens = new ArrayList<>();

    @SuppressWarnings("unused")
    private Double valorTotalPedido;

    public Pedido(String nomeCliente, LocalDate data, List<ItemPedido> itens, Double valorTotalPedido) {
        this.nomeCliente = nomeCliente;
        this.data = data;
        this.itens = itens;
    }

    public Double getValorTotalPedido() {
        return CalculoUtil.calcularValorTotalPedido(this.itens);
    }

}
