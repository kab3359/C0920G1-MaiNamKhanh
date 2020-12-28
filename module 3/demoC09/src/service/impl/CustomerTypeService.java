package service.impl;

import model.CustomerType;

import java.util.List;

public interface CustomerTypeService {

    public List<CustomerType> getAll();

    public CustomerType getCusTypeById(int id);
}
