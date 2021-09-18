package br.com.fiap.webshift.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.fiap.webshift.model.UsuarioModel;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {

	
	public UsuarioModel findByEmailAndSenha(String email, String senha);
	
	public List<UsuarioModel> findByIdade(int idade);

	@Query(value="SELECT count(ID_USUARIO) as total FROM USUARIO WHERE idade = :age", 
			nativeQuery = true)
	public long getTotalByIdade(@Param("age") int idade);
	
	@Query(value="SELECT DISTINCT COUNT(ID_USUARIO) as TOTAL FROM USUARIO WHERE idade > 0", 
			nativeQuery = true)
 	public long getTotalUsers();
	
}
