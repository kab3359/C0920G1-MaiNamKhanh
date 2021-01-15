package com.example.service;

import com.example.entity.Contract;
import com.example.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    ContractRepository contractRepository;
    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public Contract findById(long id) {
        return contractRepository.findById(id).orElse(null);
    }

    @Override
    public Long createId() {
        long code = 0;
        do {
            code = Math.round(Math.random()*100000);
        }while (code < 10000);
        return code;
    }

    @Override
    public void delete(Contract contract) {
        contractRepository.delete(contract);
    }

    @Override
    public boolean isEmpty(Contract contract) {
        return contractRepository.existsById(contract.getId());
    }

}
