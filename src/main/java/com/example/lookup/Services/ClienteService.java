package com.example.lookup.Services;

import com.example.lookup.entities.Cliente;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public interface ClienteService {
    Cliente save(Cliente c);
    List<Cliente> list();
    String delete(Long id);
}
