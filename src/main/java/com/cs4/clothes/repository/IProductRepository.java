package com.cs4.clothes.repository;

import com.cs4.clothes.model.Product;
import com.cs4.clothes.model.querry.ICartDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface IProductRepository extends JpaRepository<Product , Long> {

     List<Product> findProductsByCategory_Id(Long id);
     List<Product> findProductsByNameContaining(String name);
     List<Product> findProductsByCategory_Name(String category_name);
     @Query(value = "select p from Product p where p.category.id = :id and p.status = '1'")
     List<Product> findProductsByCategory_IdAndStatus(Long id);

     @Query(value = "select u from Product u where u.name like concat('%',:name, '%') and u.status ='1'")
     List<Product> findAllByName(String name);


     @Query(nativeQuery = true, value = "SELECT product.id,product.description,product.img,product.name,product.price,product.quantity_max,product.quantity_min,product.quantity_sale,product.status,product.view,product.category_id,cart_detail.quantity FROM product  join cart_detail on product.id = cart_detail.product_id  join cart on cart_detail.cart_id = cart.id  where cart.id = :id;")
     List<Product> findByCart(@Param("id") Long id);
}
