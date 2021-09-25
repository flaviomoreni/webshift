package br.com.fiap.webshift.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "MARCA")
public class MarcaModel {

	@Id
	@Column(name = "ID_MARCA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MARCA_SEQ")
	@SequenceGenerator(name = "MARCA_SEQ", initialValue = 1, allocationSize = 1)
	private int idMarca;
	
	
	@Column(name = "NOME_MARCA", length = 50, nullable = false)
	@NotNull(message = "Nome obrigatório")
	@Size(min = 2, max = 50, message = "NOME deve ser entre 2 e 50 caracteres")
	private String nomeMarca;

	
	@OneToMany(mappedBy = "marca", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private List<ProdutoModel> produtos;
	
	
	public MarcaModel() {
	}

	public MarcaModel(int idMarca, String nomeMarca) {
		super();
		this.idMarca = idMarca;
		this.nomeMarca = nomeMarca;
	}

	
	public int getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(int idMarca) {
		this.idMarca = idMarca;
	}

	
	public String getNomeMarca() {
		return nomeMarca;
	}

	public void setNomeMarca(String nomeMarca) {
		this.nomeMarca = nomeMarca;
	}
	
	
	public List<ProdutoModel> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoModel> produtos) {
		this.produtos = produtos;
	}
	
	
	@Override
	public String toString() {
		return "MarcaModel [idMarca=" + idMarca + ", nomeMarca=" + nomeMarca + "]";
	}

	

}
