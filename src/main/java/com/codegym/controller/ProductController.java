package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping
    public ResponseEntity<Iterable<Product>> findAllProduct() {
        List<Product> products = (List<Product>) productService.findAll();
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Iterable<Product>> findAllByNameContainingProduct(@PathVariable String name) {
        Iterable<Product> products = productService.findAllByNameContaining(name);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/sortByPrice")
    public ResponseEntity<Iterable<Product>> findAllByOrderByPrice() {
        Iterable<Product> products = productService.findAllByOrderByPrice();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @GetMapping("/getTop4")
    public ResponseEntity<Iterable<Product>> getTop4() {
        Iterable<Product> products = productService.getTop4();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
