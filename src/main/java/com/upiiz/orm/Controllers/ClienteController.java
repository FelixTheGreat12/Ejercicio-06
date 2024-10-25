package com.upiiz.orm.Controllers;

import com.upiiz.orm.Models.ClienteEntity;
import com.upiiz.orm.Services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // Anotación para definir que es un controlador REST
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Listar todos los clientes
    @GetMapping
    public ResponseEntity<List<ClienteEntity>> getAllClientes() {
        return ResponseEntity.ok(clienteService.getAllClientes());
    }

    // Guardar un cliente
    @PostMapping
    public ResponseEntity<ClienteEntity> saveCliente(@RequestBody ClienteEntity cliente) {
        return ResponseEntity.created(null).body(clienteService.saveCliente(cliente));
    }

    // Buscar un cliente por id
    @GetMapping("/{id}")
    public ResponseEntity<ClienteEntity> getClienteById(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.getClienteById(id));
    }

    //Actualizar cliente por id
    @PutMapping("/{id}")
    public ResponseEntity<ClienteEntity> updateCliente(@PathVariable Long id, @RequestBody ClienteEntity cliente) {
        ClienteEntity clienteActualizado = clienteService.updateCliente(id, cliente);
        return ResponseEntity.ok(clienteActualizado);
    }

    //Borrar cliente por id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id){
        clienteService.deleteClienteById(id);
        return ResponseEntity.noContent().build();
    }
}
