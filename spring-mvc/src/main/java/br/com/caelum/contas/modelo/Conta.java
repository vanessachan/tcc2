package br.com.caelum.contas.modelo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Calendar;

@Entity
public class Conta {

    @Id
    @GeneratedValue
	private Long id;
	@NotNull(message="")
	@Size(min = 3, message="{conta.descricao.size}")
	private String descricao;

	private boolean paga;
	
	private double valor;

	private Calendar dataPagamento;
	
	private TipoDaConta tipo;

	private String UF;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isPaga() {
		return paga;
	}

	public void setPaga(boolean paga) {
		this.paga = paga;
	}

	public Calendar getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Calendar dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public TipoDaConta getTipo() {
		return tipo;
	}

	public void setTipo(TipoDaConta tipo) {
		this.tipo = tipo;
	}

	public double getValor() {
		return valor;
	}	
	
	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getUF() {
		return UF;
	}

	public void setUF(String UF) {
		this.UF = UF;
	}
}
