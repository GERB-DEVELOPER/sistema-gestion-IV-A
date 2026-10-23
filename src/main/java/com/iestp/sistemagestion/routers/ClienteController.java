package com.iestp.sistemagestion.routers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.iestp.sistemagestion.modelo.Cliente;
import com.iestp.sistemagestion.schemas.ClienteDTO;
import com.iestp.sistemagestion.servicio.ClienteService;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
	 private final ClienteService clienteService;
	 
	 public ClienteController(ClienteService clienteService) {
	        this.clienteService = clienteService;
	 }
	 
	 //listar todo
	 @GetMapping
	    public List<ClienteDTO> listar() {
	        return clienteService.listar()
	        		.stream()
	                .map(ClienteDTO::fromEntity)
	                .collect(Collectors.toList());
	}
	 
	 //listar cliente especifico
	 @GetMapping("/{id}")
	    public ClienteDTO obtenerPorId(@PathVariable Long id) {
	        return ClienteDTO.fromEntity(clienteService.obtenerPorId(id));
	 }
	 
	 //crear cliente
	 @PostMapping
	    public ResponseEntity<Cliente> crear(@RequestBody Cliente cliente) {
	        Cliente creado = clienteService.crear(cliente);
	        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
	    }
	 
	//modificar cliente
	 @PutMapping("/{id}")
	    public Cliente actualizar(@PathVariable Long id, @RequestBody Cliente datos) {
	        return clienteService.actualizar(id, datos);
	    }
	 //eliminar
	 
	 @DeleteMapping("/{id}")
	    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
	        clienteService.eliminar(id);
	        return ResponseEntity.noContent().build();
	    }
	 
	 
	 
} //fin de clase
