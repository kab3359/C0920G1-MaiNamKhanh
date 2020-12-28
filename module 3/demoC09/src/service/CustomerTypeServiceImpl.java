package service;

import model.CustomerType;
import repository.CustomerTypeRepository;

import java.util.List;

public class CustomerTypeServiceImpl implements service.impl.CustomerTypeService {

    private CustomerTypeRepository customerTypeRepository = new CustomerTypeRepository();

    @Override
    public List<CustomerType> getAll() {
        return customerTypeRepository.selectAllCustomerType();
    }

    @Override
    public CustomerType getCusTypeById(int id) {
        return customerTypeRepository.selectTypeNote(id);
    }
}
