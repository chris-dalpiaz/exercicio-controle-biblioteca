package com.senac.biblioteca.controllers;

import com.senac.biblioteca.entities.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Random;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
    List<Usuario> lista;

    public UsuariosController(List<Usuario> lista) {
        Usuario usuario1 = new Usuario(1, "Roberta", 98);
        Usuario usuario2 = new Usuario(2, "Osvaldo", 32);
        Usuario usuario3 = new Usuario(3, "Maria", 12);

        lista.add(usuario1);
        lista.add(usuario2);
        lista.add(usuario3);

        this.lista = lista;
    }

    @GetMapping
    public List<Usuario> listar() {
        return lista;
    }

    @GetMapping("{idUsuario}")
    public Usuario buscarUsuario(@PathVariable Integer idUsuario) {
        for (Usuario usuario : lista) {
            if (Objects.equals(usuario.getId(), idUsuario)) {
                return usuario;
            }
        }
        return null;
    }

    @PostMapping
    public Usuario criarUsuario(@RequestBody Usuario usuario){
        usuario.setId(new Random().nextInt(100));
        lista.add(usuario);
        return usuario;
    }

    @PutMapping("/{idUsuario}")
    public Usuario editarUsuario(@PathVariable Integer idUsuario,
                                 @RequestBody Usuario usuario){
        for (Usuario editar: lista){
            if (editar.getId().equals(idUsuario)){
                editar.setIdade(usuario.getIdade());
                editar.setNome(usuario.getNome());
            return editar;
            }
        }
        return null;
    }

    @DeleteMapping("/{idUsuario}")
    public Usuario deletarUsuario(@PathVariable Integer idUsuario){
        for (Usuario deletar: lista){
            if (deletar.getId().equals(idUsuario)){
                lista.remove(deletar);
                return deletar;
            }
        }
        return null;
    }

}
