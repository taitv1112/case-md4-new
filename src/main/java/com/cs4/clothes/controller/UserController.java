package com.cs4.clothes.controller;

import com.cs4.clothes.dto.request.OrderForm;
import com.cs4.clothes.dto.request.SignUpForm;
import com.cs4.clothes.dto.response.ResponseMessage;
import com.cs4.clothes.model.*;
import com.cs4.clothes.model.querry.IOrders;
import com.cs4.clothes.repository.IOrderDetail;
import com.cs4.clothes.service.ICartDetailService;
import com.cs4.clothes.service.IOrderSPService;
import com.cs4.clothes.service.IProductService;
import com.cs4.clothes.service.impl.RoleServiceImpl;
import com.cs4.clothes.service.impl.UserServiceImpl;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "*")
@RequestMapping("users")
@RestController
public class UserController {
    @Autowired
    ICartDetailService cartDetailService;
    @Autowired
    UserServiceImpl userService;
    @Autowired
    IOrderSPService iOrderSPService;
    @Autowired
    IOrderDetail iOrderDetail;
    @Autowired
    RoleServiceImpl roleService;
    @Autowired
    IProductService productService;

    @GetMapping
    public ResponseEntity<Page<Users>> findAll(@RequestParam(defaultValue = "0") int page){
        return new ResponseEntity<>(userService.findAllUser(PageRequest.of(page,4)),HttpStatus.OK);
    }
    @GetMapping("/user")
    public ResponseEntity<List<Users>> findAll(){
        return new ResponseEntity<>(userService.findAll(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Users> create(@RequestBody Users users) {
        userService.save(users);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @GetMapping("role")
    public ResponseEntity <List<Role>> findAllCate(){
        return new  ResponseEntity<>(roleService.finfAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> findById(@PathVariable long id) {
        return new ResponseEntity<>(userService.findById(id),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable long id){
        userService.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

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
    @PostMapping("/order")
    public  ResponseEntity<?> Orders(@Valid @RequestBody OrderForm orderForm){
        Users users = userService.findByUsername(orderForm.getUsername()).get();
        System.out.println(users.getId());
        OrderSP orderSP = new OrderSP(orderForm.getTotal(),new Date(),new Date(),users);
        orderSP.setStatus("pending");
        iOrderSPService.save(orderSP);
        for (int i = 0; i < orderForm.getCartDetailList().size(); i++) {
            iOrderDetail.save(new OrderDetail(orderForm.getCartDetailList().get(i).getQuantity(),orderSP,orderForm.getCartDetailList().get(i).getProduct()));
            Product product = orderForm.getCartDetailList().get(i).getProduct();
            product.setQuantity_sale(product.getQuantity_sale()+orderForm.getCartDetailList().get(i).getQuantity());
            product.setQuantity(product.getQuantity()-orderForm.getCartDetailList().get(i).getQuantity());
            if (product.getQuantity()==0){
                product.setStatus("0");
            }
            product.setQuantity_max(product.getQuantity());
            productService.save(product);
            cartDetailService.delete(orderForm.getCartDetailList().get(i));
        }
        return new ResponseEntity( HttpStatus.OK);
    }
    @GetMapping("orderList/{userName}")
    public  ResponseEntity<List<OrderSP>> orderList(@Valid @PathVariable  String userName){
        Users users = userService.findByUserName(userName);
        return  new ResponseEntity<>(iOrderSPService.findByUsername(users.getId()), HttpStatus.OK);
    }
    @GetMapping("orderList/orderDetail/{id}")
    public  ResponseEntity<?> orderList(@Valid @PathVariable  Long id){
        List<OrderDetail> orderDetailList = iOrderDetail.findByIdOrderSP(id);
        return  new ResponseEntity<>(orderDetailList, HttpStatus.OK);
    }

}
