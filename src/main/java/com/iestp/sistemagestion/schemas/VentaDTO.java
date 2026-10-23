package com.iestp.sistemagestion.schemas;
import com.iestp.sistemagestion.modelo.Venta;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class VentaDTO {
    // aca van  los atributos o propiedades de la entidad venta
	  private Long id;
	  private String clienteNombre;
	  private String productoNombre;
      private Integer cantidad;
	  private BigDecimal total;
      private LocalDateTime fecha;
      
     //crear emtodo que tranforma los atributos a dto
      
      public static VentaDTO fromEntity(Venta venta) {
    	  VentaDTO dto= new VentaDTO();
    	  
    	  dto.id=venta.getId();
    	  dto.clienteNombre=venta.getCliente().getNombre();
    	  dto.productoNombre=venta.getProducto().getNombre();
    	  dto.cantidad=venta.getCantidad();
    	  dto.total=venta.getTotal();
    	  dto.fecha=venta.getFecha();
    	  return dto;  
      }
      
      public long getId() {return id;}
      public String getclienteNombre() {return clienteNombre; }
      public String getProductoNombre() { return productoNombre; }
      public Integer getCantidad() { return cantidad; }
      public BigDecimal getTotal() { return total; }
      public LocalDateTime getFecha() { return fecha; }
       
      
} //fin de la clase VentaDTO
