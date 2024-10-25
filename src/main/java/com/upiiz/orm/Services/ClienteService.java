package com.upiiz.orm.Services;

import com.upiiz.orm.Models.ClienteEntity;
import com.upiiz.orm.Repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ClienteService {

    //Inyectar una dependencia de ClienteRepository
    @Autowired
    private ClienteRepository clienteRepository;

    //Listar todos los clientes
    public List<ClienteEntity> getAllClientes(){
        return clienteRepository.findAll();
    }

    //Guardar un cliente
    public ClienteEntity saveCliente(ClienteEntity cliente){
        return clienteRepository.save(cliente);
    }

    //Buscar un cliente por id
    public ClienteEntity getClienteById(Long id){
        return clienteRepository.findById(id).orElse(null);
    }

    //Actualizar un cliente por id
    public ClienteEntity updateCliente(Long id, ClienteEntity clienteActualizado) {
        return clienteRepository.findById(id)
                .map(clienteExistente -> {
                    clienteExistente.setNombre(clienteActualizado.getNombre());
                    clienteExistente.setEmail(clienteActualizado.getEmail());
                    clienteExistente.setEdad(clienteActualizado.getEdad());
                    clienteExistente.setApellido(clienteActualizado.getApellido());
                    clienteExistente.setDireccion(clienteActualizado.getDireccion());
                    clienteExistente.setTelefono(clienteActualizado.getTelefono());
                    clienteExistente.setRfc(clienteActualizado.getRfc());
                    return clienteRepository.save(clienteExistente);
                })
                .orElseThrow(() -> new NoSuchElementException("No se encontró el cliente con el id " + id));
    }

    // Borrar un cliente por id
    public void deleteClienteById(Long id){
        clienteRepository.findById(id).ifPresentOrElse(
            cliente -> clienteRepository.delete(cliente),
            () -> { throw new RuntimeException("Cliente con ID " + id + " no encontrado"); }
    );}
}
