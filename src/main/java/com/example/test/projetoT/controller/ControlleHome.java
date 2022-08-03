package com.example.test.projetoT.controller;


import com.example.test.projetoT.model.Pedido;
import com.example.test.projetoT.model.StatusPedido;
import com.example.test.projetoT.repository.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/home")
public class ControlleHome {
    @Autowired
    private PedidosRepository repository;

    @GetMapping
    public String home(Model model, Principal principal) {

        Sort.by("dataDaEntrega").descending();

        List<Pedido> pedidos = repository.findByStatus(StatusPedido.AGUARDANDO).subList(0,2);
        model.addAttribute("pedidos", pedidos);
        return "home";
    }
}
