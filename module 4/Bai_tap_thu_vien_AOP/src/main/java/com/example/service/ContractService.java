package com.example.service;

import com.example.entity.Contract;

public interface ContractService {
    void save(Contract contract);
    Contract findById(long id);
    Long createId();
    void delete(Contract contract);
    boolean isEmpty(Contract contract);
}
