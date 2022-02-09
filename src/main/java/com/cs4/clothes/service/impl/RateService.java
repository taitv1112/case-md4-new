package com.cs4.clothes.service.impl;

import com.cs4.clothes.model.Rate;
import com.cs4.clothes.repository.IRateRepo;
import com.cs4.clothes.service.IRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RateService implements IRateService {
    @Autowired
    IRateRepo iRateRepo;
    @Override
    public List<Rate> findAll() {
        return iRateRepo.findAll();
    }
}
