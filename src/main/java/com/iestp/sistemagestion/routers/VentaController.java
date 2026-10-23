package com.iestp.sistemagestion.routers;

import org.springframework.web.bind.annotation.*;
import com.iestp.sistemagestion.servicio.VentaService;
import java.util.List;
import org.springframework.http.HttpStatus;
import com.iestp.sistemagestion.modelo.Venta;
import org.springframework.http.ResponseEntity;



import com.iestp.sistemagestion.schemas.VentaDTO;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {
	 private final VentaService ventaService;
	 
	 public VentaController(VentaService ventaService) {
	        this.ventaService = ventaService;
	 }

	 @PostMapping  //crea una venta
	 public ResponseEntity<VentaDTO> registrar(
			 @RequestParam Long clienteId,
			 @RequestParam Long productoId,
			 @RequestParam Integer cantidad
			 ){
		 Venta creada = ventaService.registrarVenta(clienteId, productoId, cantidad);
		 return ResponseEntity.status(HttpStatus.CREATED).body(VentaDTO.fromEntity(creada));
		  
	 }
     //listar todos las ventas se reallizar la proxima clases
	 @GetMapping
	 public List<VentaDTO> listarTodas() {
		 return ventaService.listarTodas()
				 .stream()
	             .map(VentaDTO::fromEntity)
	             .collect(Collectors.toList());
	 }
	 
	 
	 
	 @GetMapping("/cliente/{clienteId}") //lista un cliente buscado por ID
	 public List<VentaDTO> listarPorCliente(@PathVariable Long clienteId) {
	        return ventaService.listarPorCliente(clienteId)
	        		.stream()
	        		.map(VentaDTO::fromEntity)
	        		.collect(Collectors.toList());
	    }
	 
	 
	    //exepcion
	    @ExceptionHandler(RuntimeException.class)
	    public ResponseEntity<String> manejarError(RuntimeException ex) {
	        return ResponseEntity.badRequest().body(ex.getMessage());
	    }
	 
	    
	  
	    
	    
	    
	    
} //fin de ventacontrolador

