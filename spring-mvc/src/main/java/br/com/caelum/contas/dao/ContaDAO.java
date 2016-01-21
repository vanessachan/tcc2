package br.com.caelum.contas.dao;

import br.com.caelum.contas.ConnectionFactory;
import br.com.caelum.contas.modelo.Conta;
import br.com.caelum.contas.modelo.TipoDaConta;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Repository
public class ContaDAO {

    @PersistenceContext
    private EntityManager em;

    @Transactional
	public void adiciona(Conta conta) {
		em.persist(conta);
	}

    @Transactional
	public void remove(Conta conta) {
        em.remove(conta);
	}

    @Transactional
	public void altera(Conta conta) {
		em.merge(conta);
	}

	public List<Conta> lista() {
		return em.createQuery("select c from Conta c").getResultList();
	}

	public Conta buscaPorId(Long id) {
        return em.find(Conta.class, id);
	}

    @Transactional
	public void paga(Long id) {

		em.createQuery("update Conta c set c.paga = true, c.dataPagamento = :data where c.id = :id")
                .setParameter("data", new Date()).setParameter("id", id).executeUpdate();

	}
}
