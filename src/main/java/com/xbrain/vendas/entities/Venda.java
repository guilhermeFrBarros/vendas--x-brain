package com.xbrain.vendas.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity                                 // => configura a class java para ser equivalente a uma tabela do banco relacional
@Table(name = "tb_vendas")
public class Venda {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataDaVenda;
    private Double valorDaVenda;

    @ManyToOne
    @JoinColumn(name = "vendedor_id")
    private Vendedor vendedorId;
    private String nomeVendedor; 
    
 

    public Venda() {}


    public Venda(Long id, LocalDate dataDaVenda, Double valorDaVenda,
            Vendedor vendedorId, String nomeVendedor) {
        this.id = id;
        this.dataDaVenda = dataDaVenda;
        this.valorDaVenda = valorDaVenda;
        this.vendedorId = vendedorId;
        this.nomeVendedor = nomeVendedor;
    }
    

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataDaVenda() {
        return this.dataDaVenda;
    }

    public void setDataDaVenda(LocalDate dataDaVenda) {
        this.dataDaVenda = dataDaVenda;
    }

    public Double getValorDaVenda() {
        return this.valorDaVenda;
    }

    public void setValorDaVenda(Double valorDaVenda) {
        this.valorDaVenda = valorDaVenda;
    }

    public Vendedor getVendedorId() {
        return this.vendedorId;
    }

    public void setVendedorId(Vendedor vendedorId) {
        this.vendedorId = vendedorId;
    }

    public String getNomeVendedor() {
        return this.nomeVendedor;
    }

    public void setNomeVendedor(String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
    }
    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());  // se id for null e não existir o ((id == null) ? 0 : id.hashCode()) ocorreria um null point ecepion
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        // so muda daqui para baixo
        Venda other = (Venda) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
