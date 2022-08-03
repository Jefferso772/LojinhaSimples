package com.example.test.projetoT.controller;

import com.example.test.projetoT.dto.RequisicaoNovoPedido;
import com.example.test.projetoT.model.Pedido;
import com.example.test.projetoT.model.User;
import com.example.test.projetoT.repository.PedidosRepository;
import com.example.test.projetoT.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("pedido")
public class PedidoController {

    @Autowired
    private PedidosRepository pedidoRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("formulario")
    public String formulario(RequisicaoNovoPedido requisicao) {
        return "pedido/formulario";
    }

    @PostMapping("novo")
    public String novo(@Valid RequisicaoNovoPedido requisicao, BindingResult result) {
        if (result.hasErrors()) {
            return "pedido/formulario";
        }

//        Descubir o usuario q está logado
//        GetContex para seguranca. getAuthentica dados do usuario
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username);

        Pedido pedido = requisicao.toPedido();
        pedido.setUser(user);
        pedidoRepository.save(pedido);
        return "redirect:/home";

    }}