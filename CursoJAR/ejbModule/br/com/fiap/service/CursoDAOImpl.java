package br.com.fiap.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.fiap.model.Curso;

@Stateless
public class CursoDAOImpl implements CursoDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Curso> listar() {
		// TODO Auto-generated method stub
		return em.createQuery("from Curso c", Curso.class).getResultList();
	}

	@Override
	public Curso findById(Integer id) {
		// TODO Auto-generated method stub
		return em.find(Curso.class, id);
	}

	@Override
	public Curso salvar(Curso curso) {
		// TODO Auto-generated method stub
		if (curso.getId() != null && curso.getId() != 0) {
			em.merge(curso);
		} else {
			em.persist(curso);
		}
		return curso;
	}

	@Override
	public void deletar(Integer id) {
		Curso curso = this.findById(id);
		em.flush();
		em.remove(curso);
		em.flush();
	}
}
