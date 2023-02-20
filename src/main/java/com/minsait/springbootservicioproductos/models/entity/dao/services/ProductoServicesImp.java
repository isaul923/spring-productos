package com.minsait.springbootservicioproductos.models.entity.dao.services;

import com.minsait.springbootservicioproductos.models.entity.Producto;
import com.minsait.springbootservicioproductos.models.entity.dao.ProductoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class ProductoServicesImp implements IProductoServices {
    @Autowired
    ProductoDao productoDao;

    @Override
    @Transactional(readOnly=true)
    public List<Producto> findAll() {
        return (List<Producto>) productoDao.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public Producto findById(Long id) {
        return  productoDao.findById(id).orElseThrow();
    }

    @Override
    @Transactional
    public Producto save(Producto save) {
        return productoDao.save(save);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
    productoDao.deleteById(id);
    }
}
