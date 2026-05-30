package com.demo.service;

import com.demo.model.Usuario;
import com.demo.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario crearUsuario(Usuario usuario) {
        if (usuario.getEdad() < 0) {
            throw new RuntimeException("Edad inválida");
        }
        return repository.guardar(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return repository.listar();
    }

    public Usuario obtenerPorId(Long id) {
        return repository.buscarPorId(id);
    }
}

