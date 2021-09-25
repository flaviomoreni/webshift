package br.com.fiap.webshift.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.webshift.model.MarcaModel;

@Repository
public interface MarcaRepository  extends JpaRepository<MarcaModel, Integer> {

}
