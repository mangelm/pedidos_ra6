package com.hlc.cliente_uno_a_muchos_pedido.entidad;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "categorias")
public class Categoria {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "nombre", nullable = false)
	@NotNull      
	@NotBlank(message = "El nombre de usuario no puede estar vacío")      
	@Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres") 
    private String nombre;
	
	@Column(name = "descripcion", nullable = false)
    private String descripcion;
	
	// Relación inversa: una categoría puede tener muchos productos      
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true)      
	private List<Producto> productos; 
	
	public Categoria() {
		
	}
	
	public Long getId() {
	       return id;
	}

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
    
    
}