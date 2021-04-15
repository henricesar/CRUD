package br.com.eletronlab.Crud.controller;

import br.com.eletronlab.Crud.model.Client;
import br.com.eletronlab.Crud.repository.ClientRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    public ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    @GetMapping
    public List<Client> listClients() {
        System.out.println("*** LISTANDO TODOS OS CLIENTES ***");
        return clientRepository.findAll();
    }

    @GetMapping("/{id}")
    public Client listClientById(@PathVariable("id") Long id){
        System.out.println("*** LISTANDO CLIENTE POR ID ***");
        return clientRepository.findById(id).get();
    }

    @PostMapping
    public void addClient(@RequestBody Client client){
        clientRepository.save(client);
    }

    @PostMapping
    public void deleteAll(){
        clientRepository.deleteAll();
    }
}
