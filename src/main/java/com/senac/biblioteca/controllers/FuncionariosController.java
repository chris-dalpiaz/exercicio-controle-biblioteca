package com.senac.biblioteca.controllers;

import com.senac.biblioteca.entities.Funcionario;
import com.senac.biblioteca.entities.Livro;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/funcionarios")
public class FuncionariosController {
    List<Funcionario> lista = new ArrayList<>();

    @GetMapping
    public List<Funcionario> listar() {
        List<Funcionario> lista = Arrays.asList(
                new Funcionario(1, "Roberto", 2000.00),
                new Funcionario(2, "Takakura", 600.00),
                new Funcionario(3, "Momo", 800.00)
        );
        this.lista = lista;
        return lista;
    }

    @GetMapping("{idFuncionario}")
    public Funcionario listarFuncionario(@PathVariable Integer idFuncionario){
        for (Funcionario funcionario : lista){
            if (Objects.equals(funcionario.getId(), idFuncionario)){
                return funcionario;
            }
        }
        return null;
    }
}
