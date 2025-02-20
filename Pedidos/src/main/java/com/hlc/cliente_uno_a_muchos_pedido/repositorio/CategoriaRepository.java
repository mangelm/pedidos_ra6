package com.hlc.cliente_uno_a_muchos_pedido.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hlc.cliente_uno_a_muchos_pedido.entidad.Categoria;

public interface CategoriaRepository  extends JpaRepository<Categoria, Long> {

}
