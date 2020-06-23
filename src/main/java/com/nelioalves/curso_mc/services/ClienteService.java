package com.nelioalves.curso_mc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.curso_mc.domain.Cliente;
import com.nelioalves.curso_mc.repositories.ClienteRepository;
import com.nelioalves.curso_mc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer id) throws ObjectNotFoundException {
		Cliente obj = repo.findOne(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto nao encontrado. Id " + id + ", Tipo " + Cliente.class.getName());
		}
		return obj;
	}

}
