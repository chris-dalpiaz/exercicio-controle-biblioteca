package com.senac.biblioteca.controllers;

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
@RequestMapping("/livros")
public class LivrosController {

    List<Livro> lista = new ArrayList<>();

    @GetMapping
    public List<Livro> listar(){
        List<Livro> lista = Arrays.asList(
                new Livro(1, "A volta dos que não foram",
                        "Takana Kama", 20.00),
                new Livro(2, "Assim falou Zaratrusta",
                        "Nietzsche", 25.00),
                new Livro(3, "Roube como um artista",
                        "Austin Kleon", 30.00)
        );

        this.lista = lista;
        return lista;
    }

    @GetMapping("/{idLivro}")
    public Livro buscarLivro(@PathVariable Integer idLivro){
        for (Livro livro : lista){
            if (Objects.equals(livro.getId(), idLivro)){
                return livro;
            }
        }
        return null;
    }

}
