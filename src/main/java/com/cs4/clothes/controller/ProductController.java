package com.cs4.clothes.controller;

import com.cs4.clothes.model.Category;
import com.cs4.clothes.model.Product;
import com.cs4.clothes.model.Rate;
import com.cs4.clothes.service.ICategoryService;
import com.cs4.clothes.service.IRateService;
import com.cs4.clothes.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin("*")
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    ICategoryService iCategoryService;
    @Autowired
    IRateService iRateService;


    @GetMapping
    public ResponseEntity<Page<Product>> findAll(@RequestParam(defaultValue = "0") int page){
        return new ResponseEntity<>(productService.findAllProduct(PageRequest.of(page,4)),HttpStatus.OK);
    }
 @GetMapping("category")
 public ResponseEntity<List<Category>> findAllCategory(){
        return new ResponseEntity<>(iCategoryService.findAll(),HttpStatus.OK);
 }
    @GetMapping("rate")
    public ResponseEntity<List<Rate>> findAllRate(){
        return new ResponseEntity<>(iRateService.findAll(),HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        productService.save(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable long id) {
        return new ResponseEntity<>(productService.findByID(id),HttpStatus.OK);
    }
    @GetMapping("/delete/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable long id) {
        return new ResponseEntity<>(productService.findByID(id),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable long id){
        productService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<Product> edit(@PathVariable long id ,@RequestBody Product product) {
        product.setId(id);
        productService.save(product);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }
    @GetMapping("/find/{name}")
    public  ResponseEntity<Set<Product>> findById(@PathVariable String name){
        return new ResponseEntity<>( productService.findByName(name) , HttpStatus.OK);
    }



}
