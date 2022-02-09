package com.cs4.clothes.repository;

import com.cs4.clothes.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepo extends JpaRepository<Category,Long> {

}
