package com.cs4.clothes.repository;

import com.cs4.clothes.model.Rate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRateRepo extends JpaRepository<Rate,Long> {
}
