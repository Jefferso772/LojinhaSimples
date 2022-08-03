package com.example.test.projetoT.repository;

import com.example.test.projetoT.model.Pedido;
import com.example.test.projetoT.model.StatusPedido;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidosRepository extends JpaRepository<Pedido, Long> {

    @Cacheable("status")//Usando cacha, para diminuir o fluxo do banco
    List<Pedido> findByStatus(StatusPedido status);

    @Query("select p from Pedido p join p.user u where u.username = :username")
    List<Pedido> findAllByUsuario(@Param("username")String username);

    @Query("select p from Pedido p join p.user u where u.username = :username and p.status = :status")
    List<Pedido> findByStatusEUsuario(@Param("status")StatusPedido status, @Param("username")String username);
}