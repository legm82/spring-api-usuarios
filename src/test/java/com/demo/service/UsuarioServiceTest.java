package com.demo.service;

import com.demo.model.Usuario;
import com.demo.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UsuarioServiceTest {

    @Test
    void crearUsuario_validaEdadYGuarda() {
        UsuarioRepository repo = mock(UsuarioRepository.class);
        UsuarioService service = new UsuarioService(repo);

        Usuario u = new Usuario(1L, "X", 20);
        when(repo.guardar(u)).thenReturn(u);

        Usuario res = service.crearUsuario(u);

        verify(repo).guardar(u);
        assertEquals(20, res.getEdad());
    }

    @Test
    void crearUsuario_edadNegativa_lanzaException() {
        UsuarioRepository repo = mock(UsuarioRepository.class);
        UsuarioService service = new UsuarioService(repo);

        Usuario u = new Usuario(2L, "Y", -5);
        assertThrows(RuntimeException.class, () -> service.crearUsuario(u));
        verify(repo, never()).guardar(any());
    }

    @Test
    void listarUsuarios_delegaEnRepository() {
        UsuarioRepository repo = mock(UsuarioRepository.class);
        UsuarioService service = new UsuarioService(repo);

        List<Usuario> datos = Arrays.asList(new Usuario(1L, "A", 10), new Usuario(2L, "B", 20));
        when(repo.listar()).thenReturn(datos);

        List<Usuario> res = service.listarUsuarios();
        assertEquals(2, res.size());
        assertEquals("A", res.get(0).getNombre());
        verify(repo).listar();
    }
}

