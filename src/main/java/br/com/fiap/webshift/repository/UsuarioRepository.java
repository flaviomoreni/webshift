package br.com.fiap.webshift.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.fiap.webshift.model.UsuarioModel;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {

	public UsuarioModel findByEmailAndSenha(String email, String senha);
	
	
	@Query(value="SELECT count(ID_USUARIO) as total FROM USUARIO "
			+ " WHERE idade = :idade", nativeQuery = true)
	public long getTotalByIdade(@Param("idade") int idade);
	
}
