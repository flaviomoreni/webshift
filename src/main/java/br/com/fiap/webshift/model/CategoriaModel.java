package br.com.fiap.webshift.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="CATEGORIA")
public class CategoriaModel {

	
	@Id
	@Column(name = "ID_CATEGORIA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATEGORIA_SEQ")
	@SequenceGenerator(name = "CATEGORIA_SEQ", initialValue = 1, allocationSize = 1)
	private int idCategoria;

	@Column(name = "NOME_CATEGORIA", length = 50, nullable = false)
	@NotNull(message = "Nome obrigatório")
	@Size(min = 2, max = 50, message = "NOME deve ser entre 2 e 50 caracteres")
	private String nomeCategoria;
	
	public CategoriaModel() {
		super();
	}
	
	public CategoriaModel(int idCategoria, String nomeCategoria) {
		super();
		this.idCategoria = idCategoria;
		this.nomeCategoria = nomeCategoria;
	}

	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getNomeCategoria() {
		return nomeCategoria;
	}
	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	@Override
	public String toString() {
		return "CategoriaModel [idCategoria=" + idCategoria + ", nomeCategoria=" + nomeCategoria + "]";
	}
	
}
