package com.cs4.clothes.repository;

import com.cs4.clothes.model.Img;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IImgRepo extends JpaRepository<Img,Long> {
}
