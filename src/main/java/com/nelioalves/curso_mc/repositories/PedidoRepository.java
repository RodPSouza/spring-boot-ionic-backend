package com.nelioalves.curso_mc.repositories;

import com.nelioalves.curso_mc.domain.Cliente;
import com.nelioalves.curso_mc.domain.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;
import java.awt.print.Pageable;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    /*
    @Transactional(readOnly=true)
    Page<Pedido> findByCliente(Cliente cliente, Pageable pageRequest);
    */
}
