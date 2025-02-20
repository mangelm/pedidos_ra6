package com.hlc.cliente_uno_a_muchos_pedido.entidad;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

public class ProductoTest {
	
	 private Producto producto;
	 private Validator validator;
	 
	 @BeforeEach
	 void setUp() {
		 producto = new Producto();
		 producto.setId(1L);
		 producto.setNombre("Patatas");
		 producto.setDescripcion("Producto de prueba");
		 producto.setPeso(23.0);
		 producto.setStock(15);
	    }
	 
	 @Test
	 @DisplayName("Debe crear un producto con valores válidos")
	 void crearProducto_DeberiaTenerValoresValidos() {
	        assertThat(producto.getId()).isEqualTo(1L);
	        assertThat(producto.getNombre()).isEqualTo("Patatas");
	        assertThat(producto.getDescripcion()).isEqualTo("Producto de prueba");
	        assertThat(producto.getPeso()).isEqualTo(23.0);
	        assertThat(producto.getStock()).isEqualTo(15);
	  }
	 
	 @Test
	 @DisplayName("No debe permitir un nombre vacío")
	 void nombreVacio_DeberiaSerInvalido() {
		 producto.setNombre("");
		 var violaciones = validator.validate(producto);
		 assertThat(violaciones).extracting(ConstraintViolation::getMessage)
                               	.contains("El nombre del producto no puede estar vacío");
	 }
	 
	 @Test
	 @DisplayName("No debe permitir una descripción mayor a 255 caracteres")
		void descripcionLarga_DeberiaSerInvalida() {
		    String descripcionLarga = "A".repeat(256);
		    producto.setDescripcion(descripcionLarga);
		    assertThat(producto.getDescripcion().length()).isGreaterThan(255);
		}
}
