package com.iestp.sistemagestion;
import com.iestp.sistemagestion.dao.ClienteRepository;
import com.iestp.sistemagestion.modelo.Cliente;
import com.iestp.sistemagestion.modelo.Producto;
import com.iestp.sistemagestion.modelo.Venta;
import com.iestp.sistemagestion.servicio.ClienteService;
import com.iestp.sistemagestion.servicio.ProductoService;
import com.iestp.sistemagestion.servicio.VentaService;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


//@Component
public class DatosDePruebaRunner implements CommandLineRunner{

	 private final ClienteService clienteService;
	 private final ProductoService productoService;
	 private final VentaService ventaService;

	    public DatosDePruebaRunner(
	    		ClienteService clienteService,
                ProductoService productoService,
                VentaService ventaService) {
	        
	    	 this.clienteService = clienteService;
	         this.productoService = productoService;
	         this.ventaService = ventaService;
	    }
	    

	    @Override
	    public void run(String... args) {
	    	
	    	Cliente cliente = clienteService.crear(
	                new Cliente("Comercial Guerra-solis SAC", "19568521478", "guevara@gmail.com", "899111222"));
	        System.out.println("Cliente creado con id: " + cliente.getId());
	    	
	        Producto producto = productoService.crear(new Producto("Teclado Gamer asus", new BigDecimal("150.00")));
	        System.out.println("Producto creado con id: " + producto.getId());
	        
	        
	        Venta venta = ventaService.registrarVenta(cliente.getId(), producto.getId(), 3);
	        System.out.println("Venta registrada con id: " + venta.getId() + " - total: " + venta.getTotal());
	        
	    }
}








