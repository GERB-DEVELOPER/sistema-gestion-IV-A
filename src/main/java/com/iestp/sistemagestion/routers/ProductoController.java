package com.iestp.sistemagestion.routers;

import org.springframework.web.bind.annotation.*;
import com.iestp.sistemagestion.servicio.ProductoService;
import com.iestp.sistemagestion.modelo.Producto;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
	private final ProductoService productoService;
	
	public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }
	
	//listar todos los prpoductos
	@GetMapping
    public List<Producto> listar() {
        return productoService.listar();
    }
	
	//listar por id
	@GetMapping("/{id}")
    public Producto obtenerPorId(@PathVariable Long id) {
        return productoService.obtenerPorId(id);
    }

	//crear productos
	 @PostMapping
	    public ResponseEntity<Producto> crear(@RequestBody Producto producto) {
	        Producto creado = productoService.crear(producto);
	        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
	    }

	//modificar producto
	 @PutMapping("/{id}")
	    public Producto actualizar(@PathVariable Long id, @RequestBody Producto datos) {
	        return productoService.actualizar(id, datos);
	    }

	 //eliminar productos
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
	        productoService.eliminar(id);
	        return ResponseEntity.noContent().build();
	    }
//excepciones
	    @ExceptionHandler(RuntimeException.class)
	    public ResponseEntity<String> manejarError(RuntimeException ex) {
	        return ResponseEntity.badRequest().body(ex.getMessage());
	    }
	
	
	
	
}//fin de la clase
