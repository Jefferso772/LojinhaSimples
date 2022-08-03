package com.example.test.projetoT.rest;


import com.example.test.projetoT.model.Pedido;
import com.example.test.projetoT.model.StatusPedido;
import com.example.test.projetoT.repository.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/pedidos")
public class PedidoRest {

    @Autowired
    private PedidosRepository pedidosRepository;


    @GetMapping("aguardando")
    public List<Pedido> getPedidoAguardandoOfertas(){

        Sort sort = Sort.by("id").descending();//Orde por ID

        return pedidosRepository.findByStatus(StatusPedido.AGUARDANDO).subList(0,2);
    }
}
