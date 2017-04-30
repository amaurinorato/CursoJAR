package br.com.fiap.service;

import java.util.List;

import javax.ejb.Local;

import br.com.fiap.model.Curso;

@Local
public interface CursoDAO {

	List<Curso> listar();
	Curso findById(Integer id);
	Curso salvar(Curso curso);
	void deletar(Integer id);
	
}
