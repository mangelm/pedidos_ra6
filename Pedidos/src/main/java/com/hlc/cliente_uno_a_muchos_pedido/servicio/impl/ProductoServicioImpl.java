package com.hlc.cliente_uno_a_muchos_pedido.servicio.impl;

import com.hlc.cliente_uno_a_muchos_pedido.entidad.Categoria;
import com.hlc.cliente_uno_a_muchos_pedido.entidad.Producto;
import com.hlc.cliente_uno_a_muchos_pedido.repositorio.CategoriaRepository;
import com.hlc.cliente_uno_a_muchos_pedido.repositorio.ProductoRepository;
import com.hlc.cliente_uno_a_muchos_pedido.servicio.ProductoServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicioImpl implements ProductoServicio {

    @Autowired
    private ProductoRepository productoRepository;
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto obtenerProductoPorId(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Producto> obtenerTodosLosProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto actualizarProducto(Long id, Producto productoActualizado) {
        return productoRepository.findById(id).map(producto -> {
            producto.setNombre(productoActualizado.getNombre());
            producto.setDescripcion(productoActualizado.getDescripcion());
            producto.setPeso(productoActualizado.getPeso());
            producto.setStock(productoActualizado.getStock());
            return productoRepository.save(producto);
        }).orElse(null);
    }

    @Override
    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }

	@Override
	public List<Producto> buscarPorCategoria(Categoria categoria) {
		return productoRepository.findByCategoria(categoria); 
	}

	@Override
	public List<Producto> buscarPorNombreCategoria(String nombre_categoria) {
		Optional<Categoria> categoria =   categoriaRepository.findByNombreIgnoreCase(nombre_categoria);   
		List<Producto> productos = productoRepository.findByCategoria(categoria.get());   
		return productos; 
	}

	@Override
	public List<Categoria> obtenerTodasLasCategorias() {
		return categoriaRepository.findAll();
	}
}
