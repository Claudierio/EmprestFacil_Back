package br.edu.ufape.web.agiota.negocio.basica;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false) // O agiota é obrigatório
    @JoinColumn(name = "agiota_id")
    @JsonManagedReference
    private Agiota agiota;

    @ManyToOne(optional = false) // O usuário é obrigatório
    @JoinColumn(name = "usuario_id")
    @JsonManagedReference
    private Usuario usuario;

    private double valor;
    private double taxaJuros;
    private String dataVencimento;
    private int parcelas;

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Agiota getAgiota() {
        return agiota;
    }

    public void setAgiota(Agiota agiota) {
        this.agiota = agiota;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(double taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }
}