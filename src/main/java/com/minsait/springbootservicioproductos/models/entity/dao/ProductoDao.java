package com.minsait.springbootservicioproductos.models.entity.dao;

import com.minsait.springbootservicioproductos.models.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoDao extends CrudRepository<Producto,Long> {
}
