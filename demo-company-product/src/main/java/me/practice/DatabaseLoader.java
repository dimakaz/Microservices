package me.practice;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import me.practice.entity.Company;
import me.practice.entity.Customer;
import me.practice.entity.Product;
import me.practice.repository.CompanyRepository;
import me.practice.repository.CustomerRepository;
import me.practice.repository.ProductRepository;

@Component
public class DatabaseLoader implements CommandLineRunner {
    
    private final CompanyRepository companyRepository;
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;
    
    @Autowired
    public DatabaseLoader(CompanyRepository companyRepository, ProductRepository productRepository, CustomerRepository customerRepository) {
        this.companyRepository = companyRepository;
        this.productRepository = productRepository;
        this.customerRepository = customerRepository; 
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Company apple = new Company("Apple", "San Francisco, USA", "123-456-7890");
        Company samsung = new Company("Samsung", "Seoul, South Korea", "123-456-1111");
        Company sony = new Company("Sony", "Tokyo, Japan", "123-456-0987");
        
        this.companyRepository.save(apple);
        this.companyRepository.save(samsung);
        this.companyRepository.save(sony);
        
        Product iPhone = new Product("iPhone", "p0001", "USA", apple);
        Product iPad = new Product("iPad", "p0002", "USA", apple);
        Product mac = new Product("MacBook", "p0003", "USA", apple);
        Product galaxyNote = new Product("Galaxy Note", "p0004", "South Korea", samsung);
        Product galaxyS = new Product("Galaxy S", "p0005", "South Korea", samsung);
        
        this.productRepository.save(iPhone);
        this.productRepository.save(iPad);
        this.productRepository.save(mac);
        this.productRepository.save(galaxyNote);
        this.productRepository.save(galaxyS);
        
        Customer customerJohn = new Customer();
        customerJohn.setFirstName("John");
        customerJohn.setLastName("Doe");
        customerJohn.setEmail("john@doe.com");
        customerJohn.setAge(22);
        customerRepository.save(customerJohn);
 
        Customer customerTom = new Customer();
        customerTom.setFirstName("Tom");
        customerTom.setLastName("Doe");
        customerTom.setEmail("tom@doe.com");
        customerTom.setAge(26);
        customerRepository.save(customerTom);
        
        System.out.println("\nData is created successfully...\n");
    }
    
}
