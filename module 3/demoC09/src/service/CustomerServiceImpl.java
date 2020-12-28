package service;

import model.Customer;
import repository.CustomerRepository;
import service.impl.CustomerService;

import java.sql.SQLException;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository = new CustomerRepository();

    @Override
    public List<Customer> getAll() {
        return customerRepository.selectAllCustomer();
    }

    @Override
    public void addCus(Customer customer) {
        try {
            customerRepository.insertUser(customer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCus(int id) {
        try {
            customerRepository.deleteCus(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Customer getCusById(int id) {
        return customerRepository.selectCus(id);
    }

    @Override
    public List<Customer> getCusByName(String name) {
        return customerRepository.searchCustomer(name);
    }
}
