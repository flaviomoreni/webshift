package br.com.fiap.webshift.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



//@Entity
//@Table(name = "TB_LOJASHIFT")
public class LojaModel {

	private long idLoja;
	private String nomeLoja;

	public LojaModel() {
	}

	public LojaModel(long idLoja, String nomeLoja) {
		super();
		this.idLoja = idLoja;
		this.nomeLoja = nomeLoja;
	}

	@Id
	@Column(name = "ID_LOJA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LOJA_SEQ")
	@SequenceGenerator(name = "LOJA_SEQ", initialValue = 1, allocationSize = 1)
	public long getIdLoja() {
		return idLoja;
	}

	public void setIdLoja(long idLoja) {
		this.idLoja = idLoja;
	}

	@Column(name = "NOME_LOJA")
	public String getNomeLoja() {
		return nomeLoja;
	}

	public void setNomeLoja(String nomeLoja) {
		this.nomeLoja = nomeLoja;
	}


}