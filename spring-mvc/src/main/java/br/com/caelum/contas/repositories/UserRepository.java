package br.com.caelum.contas.repositories;

import br.com.caelum.contas.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by vanessa on 21/01/16.
 */
public interface UserRepository extends JpaRepository<Usuario,String>{
    //List<Usuario> findByName(String nome);
}
