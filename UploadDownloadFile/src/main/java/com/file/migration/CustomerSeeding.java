package com.file.migration;

import com.file.entity.Address;
import com.file.entity.Customer;
import com.file.repository.CustomerRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Component
public class CustomerSeeding {

    private CustomerRepository customerRepository;

    public CustomerSeeding(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    private List<Customer> customers = Arrays.asList(
            new Customer("Viet", "Hoang", "vh@gmail.com", new Address("Japan", "some state", "Tokyo","Kyoto")),
                    new Customer("Dai", "Huy", "fsd@gmail.com", new Address("Vietnam", "some state", "Tokyo","Kyoto")),
                            new Customer("Nhu", "Jaika", "fds@gmail.com", new Address("USA", "some state", "Tokyo","Kyoto")),
                                    new Customer("Thuy", "Jacobs", "gd@gmail.com", new Address("India", "some state", "Tokyo","Kyoto")),
                                            new Customer("Hai", "Damn", "fd@gmail.com", new Address("Cuba", "some state", "Tokyo","Kyoto"))
    );

    @PostConstruct
    public void saveCustomer() {
        customerRepository.saveAll(customers);
    }
}
