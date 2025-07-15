package com.senac.biblioteca.controllers;

import com.senac.biblioteca.entities.Usuario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
    List<Usuario> lista = new ArrayList<>();

    @GetMapping
    public List<Usuario> listar(){
        List<Usuario> lista = Arrays.asList(
                new Usuario(1, "Roberta", 98),
                new Usuario(2, "Osvaldo", 32),
                new Usuario(3, "Maria", 12)
        );

        this.lista = lista;

        return lista;
    }

    @GetMapping("{idUsuario}")
    public Usuario buscarUsuario(@PathVariable Integer idUsuario){
        for (Usuario usuario : lista){
            if (Objects.equals(usuario.getId(), idUsuario)){
                return usuario;
            }
        }
        return null;
    }
}
