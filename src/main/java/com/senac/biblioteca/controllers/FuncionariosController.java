package com.senac.biblioteca.controllers;

import com.senac.biblioteca.entities.Funcionario;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@RestController
@RequestMapping("/funcionarios")
public class FuncionariosController {
    List<Funcionario> lista;

    public FuncionariosController(List<Funcionario> lista) {

        Funcionario func1 = new Funcionario(1, "Roberto", 2000.00);
        Funcionario func2 = new Funcionario(2, "Takakura", 600.00);
        Funcionario func3 = new Funcionario(3, "Momo", 800.00);

        lista.add(func1);
        lista.add(func2);
        lista.add(func3);

        this.lista = lista;
    }


    @GetMapping
    public List<Funcionario> listar() {
        return lista;
    }

    @GetMapping("{idFuncionario}")
    public Funcionario listarFuncionario(@PathVariable Integer idFuncionario) {
        for (Funcionario funcionario : lista) {
            if (Objects.equals(funcionario.getId(), idFuncionario)) {
                return funcionario;
            }
        }
        return null;
    }

    @PostMapping
    public Funcionario criarFuncionario(@RequestBody Funcionario funcionario){
        funcionario.setId(new Random().nextInt(100));
        lista.add(funcionario);
        return funcionario;
    }

    @PutMapping("/{idFuncionario}")
    public Funcionario editarFuncionario(@PathVariable Integer idFuncionario,
                                         @RequestBody Funcionario funcionario){
        for (Funcionario editar: lista){
            if (editar.getId().equals(idFuncionario)){
                editar.setNome(funcionario.getNome());
                editar.setSalario(funcionario.getSalario());
                return editar;
            }
        }
        return null;
    }

    @DeleteMapping("/{idFuncionario}")
    public Funcionario removerFuncionario(@PathVariable Integer idFuncionario){
        for (Funcionario remover: lista){
            if (remover.getId().equals(idFuncionario)){
                lista.remove(remover);
                return remover;
            }
        }
        return null;
    }
}

