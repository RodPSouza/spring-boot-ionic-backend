package com.nelioalves.curso_mc.services;

import com.nelioalves.curso_mc.services.exceptions.DataIntegrityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.nelioalves.curso_mc.domain.Categoria;
import com.nelioalves.curso_mc.repositories.CategoriaRepository;
import com.nelioalves.curso_mc.services.exceptions.ObjectNotFoundException;

import java.util.List;


@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) throws ObjectNotFoundException {
		Categoria obj = repo.findOne(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto nao encontrado. Id " + id + ", Tipo " + Categoria.class.getName());
		}
		return obj;
	}

	public Categoria insert(Categoria obj){
		obj.setId(null);
		return repo.save(obj);
	}

	public Categoria update(Categoria obj){
		find(obj.getId());
		return repo.save(obj);
	}

	public void delete(Integer id){
		find(id);
		try {
			repo.delete(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel  excluir  uma categoria  que possui produtos!");
		}
	}

	public List<Categoria> findAll() {
		return repo.findAll();
	}

}
