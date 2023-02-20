package com.minsait.springbootservicioproductos.models.entity.dao.services;

import com.minsait.springbootservicioproductos.models.entity.Producto;

import java.util.List;

public interface IProductoServices {

    public List<Producto> findAll();
    public Producto findById(Long id);

    public Producto save(Producto save);

    public void deleteById(Long id);

}
