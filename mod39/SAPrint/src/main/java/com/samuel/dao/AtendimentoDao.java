package com.samuel.dao;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.samuel.dao.generics.GenericDao;
import com.samuel.exception.DaoException;
import com.samuel.model.Atendimento;
import com.samuel.model.Cliente;
import com.samuel.model.Servico;

public class AtendimentoDao extends GenericDao<Atendimento, Integer> implements IAtendimentoDao{

    public AtendimentoDao(Class<Atendimento> persistenteClass) {
        super(Atendimento.class);
    }

    @Override
    public void finalizarAtendimento(Atendimento atendimento) throws DaoException {
        super.alterar(atendimento);
    }

    @Override
    public void cancelarAtendimento(Atendimento atendimento) throws DaoException {
        super.alterar(atendimento);
        
    }

    @Override
    public Atendimento consultarComCollection(Integer id) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Atendimento> query = builder.createQuery(Atendimento.class);
        Root<Atendimento> root = query.from(Atendimento.class);
		root.fetch("cliente");
		root.fetch("servicos");
		query.select(root).where(builder.equal(root.get("id"), id));
		TypedQuery<Atendimento> tpQuery = entityManager.createQuery(query);
		Atendimento atendimento = tpQuery.getSingleResult(); 
		return atendimento;
    }

    @Override
    public Atendimento cadastrar(Atendimento atendimento) throws DaoException {
        try {
            atendimento.getServicos().forEach(s -> {
                Servico serv = entityManager.merge(s.getServico());
                s.setServico(serv);                
            });
            Cliente cliente = entityManager.merge(atendimento.getCliente());
            atendimento.setCliente(cliente);
            entityManager.persist(atendimento);
            return atendimento;
        } catch (Exception e) {
            throw new DaoException("Erro salvando atendimento", e);
        }
    }

    @Override
    public void excluir(Atendimento entity) throws DaoException {
        throw new UnsupportedOperationException("Operação não permitida.");
    }
    
}
