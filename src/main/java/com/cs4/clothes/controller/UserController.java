package com.cs4.clothes.controller;

import com.cs4.clothes.dto.response.ResponseMessage;
import com.cs4.clothes.model.Category;
import com.cs4.clothes.model.Product;
import com.cs4.clothes.model.Rate;
import com.cs4.clothes.model.Users;
import com.cs4.clothes.service.ICategoryService;
import com.cs4.clothes.service.IRateService;
import com.cs4.clothes.service.impl.ProductService;
import com.cs4.clothes.service.impl.UserServiceImpl;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@CrossOrigin(origins = "*")
@RequestMapping("user")
@RestController
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        Optional<Users> users = userService.findById(id);
        if(!users.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userService.deleteById(users.get().getId());
        return new ResponseEntity<>(new ResponseMessage("Delete Success!"), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<Page<Users>> findAll(@RequestParam(defaultValue = "0") int page){
        return new ResponseEntity<>(userService.findAllUser(PageRequest.of(page,4)),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Users> create(@RequestBody Users users) {
        userService.save(users);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> findById(@PathVariable long id) {
        return new ResponseEntity<>(userService.findByID(id),HttpStatus.OK);
    }
    @GetMapping("/delete/{id}")
    public ResponseEntity<Users> deleteProduct(@PathVariable long id) {
        return new ResponseEntity<>(userService.findByID(id),HttpStatus.OK);
    }
//    @DeleteMapping("/{id}")
//    public ResponseEntity delete(@PathVariable long id){
//        userService.deleteById(id);
//        return new ResponseEntity(HttpStatus.OK);
//    }

    @PutMapping ("/{id}")
    public ResponseEntity<Users> edit(@PathVariable long id ,@RequestBody Users users) {
        users.setId(id);
        userService.save(users);
        return new ResponseEntity<>(users,HttpStatus.OK);
    }
    @GetMapping("/find/{name}")
    public  ResponseEntity<Set<Users>> findById(@PathVariable String name){
        return new ResponseEntity(userService.findByUsername(name) , HttpStatus.OK);
    }

}
