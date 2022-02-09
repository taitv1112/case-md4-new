package com.cs4.clothes.service.impl;

import com.cs4.clothes.model.Img;
import com.cs4.clothes.repository.IImgRepository;
import com.cs4.clothes.service.IImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImgServiceImpl implements IImgService {
    @Autowired
    IImgRepository imgRepository;
    @Override
    public List<Img> findAll() {
        return imgRepository.findAll();
    }
}
