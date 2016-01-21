package br.com.caelum.contas.dao;

import br.com.caelum.contas.modelo.Usuario;
import br.com.caelum.contas.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by vanessa on 21/01/16.
 */
@Service
public class UserDAO {
    @PersistenceContext
    private EntityManager em;

    public List<Usuario> findByName(String name){
        return em.createQuery("select u from Usuario u where u.login = :login").setParameter("login", name).getResultList();
    }
}
