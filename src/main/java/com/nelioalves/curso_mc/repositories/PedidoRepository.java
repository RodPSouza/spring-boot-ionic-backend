package com.nelioalves.curso_mc.repositories;

import com.nelioalves.curso_mc.domain.Categoria;
import com.nelioalves.curso_mc.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
