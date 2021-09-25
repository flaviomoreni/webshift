package br.com.fiap.webshift.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="PRODUTO")
public class ProdutoModel {

	@Id
	@Column(name = "ID_PRODUTO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUTO_SEQ")
	@SequenceGenerator(name = "PRODUTO_SEQ", initialValue = 1, allocationSize = 1)
	private int id;

	
	@Column(name = "NOME")
	@NotNull(message = "Nome obrigatório")
	@Size(min = 2, max = 50, message = "NOME deve ser entre 2 e 50 caracteres")
	private String nome;
	
	@Column(name = "SKU")
	@NotNull(message = "Sku obrigatório")
	@Size(min = 2, max = 40, message = "SKU deve ser entre 2 e 50 caracteres")
	private String sku;
	
	@Column(name = "DESCRICAO")
	@NotNull(message = "Descrição obrigatório")
	@Size(min = 10, max = 400, message = "DESCRIÇÃO deve ser entre 10 e 400 caracteres")
	private String descricao;
	
	@Column(name = "PRECO")
	@DecimalMin(value = "0.01", message = "PRECO deve ser acima de 0.01")
	@NumberFormat(style = Style.CURRENCY)
	private float preco;
	
	@Column(name = "CARACTERISTICAS")
	@Size(min = 10, max = 400, message = "CARACTERÍSTICAS deve ser entre 10 e 400 caracteres")
	private String caracteristicas;
	
	@Column(name = "DATA_LANCAMENTO")
	@NotNull(message = "Data obrigatória no formato dia/mês/ano, exemplo: 10/06/2019")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataLancamento;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ID_CATEGORIA", nullable = false)
	private CategoriaModel categoria;
	
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ID_MARCA", nullable = false)
	private MarcaModel marca;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getSku() {
		return sku;
	}


	public void setSku(String sku) {
		this.sku = sku;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public float getPreco() {
		return preco;
	}


	public void setPreco(float preco) {
		this.preco = preco;
	}


	public String getCaracteristicas() {
		return caracteristicas;
	}


	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}


	public Date getDataLancamento() {
		return dataLancamento;
	}


	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}


	public CategoriaModel getCategoria() {
		return categoria;
	}


	public void setCategoria(CategoriaModel categoria) {
		this.categoria = categoria;
	}


	public MarcaModel getMarca() {
		return marca;
	}


	public void setMarca(MarcaModel marca) {
		this.marca = marca;
	}
	
	
	
	
}
