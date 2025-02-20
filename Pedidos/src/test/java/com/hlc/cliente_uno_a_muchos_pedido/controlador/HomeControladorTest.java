package com.hlc.cliente_uno_a_muchos_pedido.controlador;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.hlc.cliente_uno_a_muchos_pedido.servicio.ProductoServicio;

class HomeControladorTest {

    private MockMvc mockMvc;
    
    @Mock
    private ProductoServicio productoServicio;
    
    @InjectMocks
    private HomeControlador homeControlador; 
    
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);  // Inicializa los mocks

        // Evita NullPointerException devolviendo una lista vacía
        when(productoServicio.obtenerTodasLasCategorias()).thenReturn(Collections.emptyList());

        mockMvc = MockMvcBuilders.standaloneSetup(homeControlador).build();
    }

    @Test
    @DisplayName("Debe devolver la vista 'public/home' con el título correcto en el modelo")
    void mostrarHome_DeberiaRetornarVistaHome() throws Exception {
        mockMvc.perform(get("/home"))
               .andExpect(status().isOk()) // Verifica que la respuesta es 200 OK
               .andExpect(view().name("public/home")) // Verifica la vista retornada
               .andExpect(model().attributeExists("titulo")) // Verifica que el modelo contiene el atributo 'titulo'
               .andExpect(model().attribute("titulo", "Página de Inicio")); // Verifica que 'titulo' tiene el valor correcto
    }
}
