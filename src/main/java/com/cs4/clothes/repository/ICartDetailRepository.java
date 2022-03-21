package com.cs4.clothes.repository;

import com.cs4.clothes.model.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICartDetailRepository extends JpaRepository<CartDetail, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM case4xxx.cart_detail where cart_detail.cart_id=:id")
    List<CartDetail> findCartDetailsByCart_Id(@Param("id") Long id);
}
