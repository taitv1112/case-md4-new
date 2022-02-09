package com.cs4.clothes.repository;

import com.cs4.clothes.model.Img;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IImgRepository extends JpaRepository<Img , Long> {
}
