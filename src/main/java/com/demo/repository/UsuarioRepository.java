package com.demo.repository;

import com.demo.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioRepository {

    private List<Usuario> listaUsuarios = new ArrayList<>();

    public Usuario guardar(Usuario usuario) {
        listaUsuarios.add(usuario);
        return usuario;
    }

    public List<Usuario> listar() {
        return listaUsuarios;
    }

    public Usuario buscarPorId(Long id) {
        return listaUsuarios.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}

