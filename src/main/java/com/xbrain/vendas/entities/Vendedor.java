package com.xbrain.vendas.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Vendedor {
    
    @Id
    private Long vendedorId;
    private String nome;

    public Vendedor() {}

    public Vendedor(Long vendedorId, String nome) {
        this.vendedorId = vendedorId;
        this.nome = nome;
    }

    

    public Long getVendedorId() {
        return this.vendedorId;
    }

    public void setVendedorId(Long vendedorId) {
        this.vendedorId = vendedorId;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
    @Override
    public boolean equals(Object o) 
    {
        if (o == this)
            return true;
        if (!(o instanceof Vendedor)) {
            return false;
        }
        Vendedor vendedor = (Vendedor) o;
        return vendedorId.equals(vendedor.vendedorId);
    }

   
    @Override
    public int hashCode() {
        return vendedorId.hashCode();
    }

    
}
