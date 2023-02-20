package com.minsait.springbootservicioproductos.controller;


import com.minsait.springbootservicioproductos.models.entity.Producto;
import com.minsait.springbootservicioproductos.models.entity.dao.services.IProductoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "productos")
public class ProductoController {

    @Autowired
    private Environment environment;
    @Autowired
    private IProductoServices iProductoServices;

    @Value("${server.port}")
    private String portM;

    @GetMapping(value = "/listar")
    public List<Producto> listar() {

        return iProductoServices.findAll().stream().map(producto -> {
            producto.setPort(environment.getProperty("local.server.port"));
            return producto;
        }).collect(Collectors.toList());
    }

    @GetMapping("/listar/{id}")
    public Producto detale(@PathVariable Long id) {
        Producto producto = iProductoServices.findById(id);
        producto.setPort(environment.getProperty("local.server.port"));
        return producto;
    }

    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto crear(@RequestBody Producto producto) {
        return iProductoServices.save(producto);
    }

    @PutMapping("/editar/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto editar(@RequestBody Producto producto, @PathVariable Long id) {
        Producto productoDb = iProductoServices.findById(id);
        productoDb.setNombre(producto.getNombre());
        productoDb.setPrecio(producto.getPrecio());
        return iProductoServices.save(productoDb);
    }


    @DeleteMapping("/eliminar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void elimar(@PathVariable Long id){
        iProductoServices.deleteById(id);
    }
}