package com.hlc.cliente_uno_a_muchos_pedido.servicio;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.hlc.cliente_uno_a_muchos_pedido.entidad.Cliente;
import com.hlc.cliente_uno_a_muchos_pedido.repositorio.ClienteRepository;
import com.hlc.cliente_uno_a_muchos_pedido.servicio.impl.ClienteServicioImpl;

public class ClienteServicioTest {
	 @Mock   
	 private ClienteRepository clienteRepository;   
	 @InjectMocks   
	 private ClienteServicioImpl clienteServicio;     
	 
	 private Cliente c1;   
	 private Cliente c2;     
	 /**       
	  * * 🔹 Configuración inicial: Creamos dos productos simulados antes de cada prueba.       
	  **/      
	 
	 @BeforeEach      void setUp() {          
		 MockitoAnnotations.openMocks(this);          
		 c1 = new Cliente();          
		 c1.setId(1L);          
		 c1.setNombre("Manuel");          
		 c1.setTelefono("123456789");          
		 c1.setDireccion("Avenida de Roma");                   
		 //c1.setPedidos(null);          
		 c2 = new Cliente();
		 c2.setId(1L); 
		 c2.setNombre("Juan"); 
		 c2.setTelefono("987654321"); 
		 c2.setDireccion("Calle de Madrid");
	 }
	 
	 /** 
	  * * 🛠 Test 1: Guardar un cliente 
	  * * ✅ Verifica que el servicio guarda un cliente correctamente en el 
	  * * repositorio
	  * */ 
	 
	 @Test
	 @DisplayName(" 💾 Debe guardar un cliente correctamente")
	 void guardarProducto_DeberiaRetornarProductoGuardado() { 
		 when(clienteRepository.save(c1)).thenReturn(c1); 
		 Cliente resultado = clienteServicio.guardarCliente(c1); 
		 assertThat(resultado).isNotNull(); 
		 assertThat(resultado.getNombre()).isEqualTo("Manuel"); 
		// 📌 Verifica que el metodo fue llamado 1 vez 
		 verify(clienteRepository, times(1)).save(c1);  
	 } 
}
