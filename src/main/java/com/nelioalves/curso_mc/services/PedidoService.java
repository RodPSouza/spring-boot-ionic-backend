package com.nelioalves.curso_mc.services;

import com.nelioalves.curso_mc.domain.Pedido;
import com.nelioalves.curso_mc.repositories.PedidoRepository;
import com.nelioalves.curso_mc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido find(Integer id) throws ObjectNotFoundException {
		Pedido obj = repo.findOne(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto nao encontrado. Id " + id + ", Tipo " + Pedido.class.getName());
		}
		return obj;
	}

}
