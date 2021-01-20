package com.codegym.service;

import com.codegym.model.Smartphone;
import org.springframework.stereotype.Service;

public interface SmartphoneService {
    Iterable<Smartphone> findAll();
    Smartphone findById(Integer id);
    Smartphone save(Smartphone phone);
    Smartphone remove(Integer id);
}
