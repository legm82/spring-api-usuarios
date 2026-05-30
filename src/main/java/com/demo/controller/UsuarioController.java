package com.demo.controller;

import com.demo.model.Usuario;
import com.demo.service.UsuarioService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@CrossOrigin(origins = "*") // Permite peticiones desde cualquier origen (útil para pruebas locales)
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    // Inyección por constructor (recomendada)
    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {
        Usuario creado = service.crearUsuario(usuario);
        return ResponseEntity.ok(creado);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        return ResponseEntity.ok(service.listarUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable Long id) {
        Usuario u = service.obtenerPorId(id);
        if (u == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(u);
    }
}

