package br.edu.fjn.estoque.estoque.models;


import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;


@Entity
public class EntradaMaterial{


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long codigo;
	
	@NotNull
	private int qtde;
	
	@NotNull
	private Date dataCompra;
	
	@NotNull
	private String fornecedor;
	
	@NotNull
	private String responsavelCompra;
	
	@NotNull
	private String responsavelVenda;
	
	
	@ManyToOne
	private Produto produto;
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public int getQtde() {
		return qtde;
	}

	public void setQtde(int qtde) {
		this.qtde = qtde;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getResponsavelCompra() {
		return responsavelCompra;
	}

	public void setResponsavelCompra(String responsavelCompra) {
		this.responsavelCompra = responsavelCompra;
	}

	public String getResponsavelVenda() {
		return responsavelVenda;
	}

	public void setResponsavelVenda(String responsavelVenda) {
		this.responsavelVenda = responsavelVenda;
	}

}
