package com.paymentchain.product.controller;

import com.paymentchain.product.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.paymentchain.product.repository.ProductRepository;
import java.util.Optional;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    private List<Product> findAll(){
        return productRepository.findAll();
    }
    
     @GetMapping("/{id}")
    public Product get(@PathVariable long id) {
        return productRepository.findById(id).get();
    }

    @PostMapping
    private Product save(@RequestBody Product container){
        return productRepository.save(container);
    }
    
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        Optional<Product> findById = productRepository.findById(id);
        if(findById.isPresent()){
            productRepository.delete(findById.get());
        }
        
        return ResponseEntity.ok().build();
    }
}
