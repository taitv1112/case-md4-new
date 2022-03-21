package com.cs4.clothes.controller;

import com.cs4.clothes.dto.request.CartForm;
import com.cs4.clothes.dto.request.SignInForm;
import com.cs4.clothes.dto.request.SignUpForm;
import com.cs4.clothes.dto.response.JwtResponse;
import com.cs4.clothes.dto.response.ResponseMessage;
import com.cs4.clothes.model.*;
import com.cs4.clothes.repository.ICategoryRepository;
import com.cs4.clothes.security.jwt.JwtProvider;
import com.cs4.clothes.security.userpincal.UserPrinciple;
import com.cs4.clothes.service.ICartDetailService;
import com.cs4.clothes.service.ICartService;
import com.cs4.clothes.service.IProductService;
import com.cs4.clothes.service.email.RegistrationService;
import com.cs4.clothes.service.impl.ProductServiceImpl;
import com.cs4.clothes.service.impl.RoleServiceImpl;
import com.cs4.clothes.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "*")
@RestController
public class AuthController {
    @Autowired
    ICartDetailService cartDetailService;
    @Autowired
    ICategoryRepository iCategoryRepository;
    @Autowired
    ICartService iCartService;
    @Autowired
    UserServiceImpl userService;
    @Autowired
    RoleServiceImpl roleService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtProvider jwtProvider;
    @Autowired
    private RegistrationService registrationService;
    @GetMapping("/login")
    public String login(){
        return "redirect:/http://localhost:63342/package.json/Source%20Code%20(1)/public/login.html";
    }
    @PostMapping("/signup")
    public ResponseEntity<?> register(@Valid @RequestBody SignUpForm signUpForm){
        if(userService.existsByUsername(signUpForm.getUsername())){
            return new ResponseEntity<>(new ResponseMessage("no_user"), HttpStatus.OK);
        }
        if(userService.existsByEmail(signUpForm.getEmail())){
            return new ResponseEntity<>(new ResponseMessage("no_email"), HttpStatus.OK);
        }
        if(signUpForm.getAvatar() == null || signUpForm.getAvatar().trim().isEmpty()){
            signUpForm.setAvatar("https://firebasestorage.googleapis.com/v0/b/chinhbeo-18d3b.appspot.com/o/avatar.png?alt=media&token=3511cf81-8df2-4483-82a8-17becfd03211");
        }
        Users users = new Users(signUpForm.getName(), signUpForm.getUsername(), signUpForm.getEmail(),
                signUpForm.getAvatar(), passwordEncoder.encode(signUpForm.getPassword()),signUpForm.getPhone());
        Set<String> strRoles = signUpForm.getRoles();
        Set<Role> roles = new HashSet<>();
        strRoles.forEach(role ->{
            switch (role){
                case "admin":
                    Role adminRole = roleService.findByName(RoleName.ADMIN).orElseThrow( ()-> new RuntimeException("Role not found"));
                    roles.add(adminRole);
                    break;
                case "pm":
                    Role pmRole = roleService.findByName(RoleName.PM).orElseThrow( ()-> new RuntimeException("Role not found"));
                    roles.add(pmRole);
                    break;
                default:
                    Role userRole = roleService.findByName(RoleName.USER).orElseThrow( ()-> new RuntimeException("Role not found"));
                    roles.add(userRole);
            }
        });
        Cart cart = new Cart();
        iCartService.save(cart);
        users.setCart(cart);
        users.setRoles(roles);
        registrationService.register(users);
        return new ResponseEntity<>(new ResponseMessage("yes"), HttpStatus.OK);

    }
    @GetMapping("/register/confirm")
    public String confirm(@RequestParam String token){
        registrationService.confirmToken(token);
        return "Registration Success";
    }
    @GetMapping("/signin")
    public String viewlogin(){
        return "redirect:/admin";
    }
    @PostMapping("/signin")
    public ResponseEntity<?> login(@Valid @RequestBody SignInForm signInForm){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInForm.getUsername(), signInForm.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.createToken(authentication);
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        System.out.println("user name ====" + userPrinciple.getUsername());
        List<CartDetail> cartDetailList = cartDetailService.findCartDetailsByCart_Id(userPrinciple.getCart().getId());
        return ResponseEntity.ok(new JwtResponse(token, userPrinciple.getName(), userPrinciple.getAvatar(),userPrinciple.getAuthorities(),cartDetailList,userPrinciple.getUsername(),userPrinciple.getCart())); }
    @GetMapping("/signout")
    public ResponseEntity<?> logout(@Valid @RequestBody CartForm cartForm){
        for (int i = 0; i < cartForm.getCartDetailList().size(); i++) {
            cartDetailService.save(cartForm.getCartDetailList().get(i));
        }
        return new ResponseEntity<>(new ResponseMessage("yes"), HttpStatus.OK);
    }
}
