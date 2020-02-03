package me.practice.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.data.jpa.domain.Specification;

import me.practice.entity.Customer;
import me.practice.repository.CustomerRepository;
import me.practice.search.SearchCriteria;
import me.practice.specification.CustomerSpecification;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Transactional
public class JPASpecificationsTest {
 
	@Mock
	private final CustomerRepository customerRepository=null;
 
    private Customer customerJohn;
    private Customer customerTom;
 
    @Before
    public void init() {

    }
    
	@Test
    public void givenLast_whenGettingListOfCustomers_thenCorrect() {
    	CustomerSpecification spec = new CustomerSpecification(new SearchCriteria("lastName", ":", "doe"));
    	List<Customer> results = customerRepository.findAll(spec);

    	assert(results.contains(customerJohn));
    	assert(results.contains(customerTom));
    	//assertThat(userTom, isIn(results));
    }
	
	@Test
	public void givenFirstAndLastName_whenGettingListOfUsers_thenCorrect() {
		CustomerSpecification spec1 = new CustomerSpecification(new SearchCriteria("firstName", ":", "john"));
		CustomerSpecification spec2 = new CustomerSpecification(new SearchCriteria("lastName", ":", "doe"));
	     
	    List<Customer> results = customerRepository.findAll(Specification.where(spec1).and(spec2));
	 
	    //assertThat(customerJohn, isIn(results));
	    //assertThat(customerTom, not(isIn(results)));
	}
	
	@Test
	public void givenLastAndAge_whenGettingListOfUsers_thenCorrect() {
		CustomerSpecification spec1 = new CustomerSpecification(new SearchCriteria("age", ">", "25"));
		CustomerSpecification spec2 = new CustomerSpecification(new SearchCriteria("lastName", ":", "doe"));
	 
	    List<Customer> results = customerRepository.findAll(Specification.where(spec1).and(spec2));
	 
	    //assertThat(userTom, isIn(results));
	    //assertThat(userJohn, not(isIn(results)));
	}
	
	@Test
	public void givenPartialFirst_whenGettingListOfUsers_thenCorrect() {
		CustomerSpecification spec = new CustomerSpecification(new SearchCriteria("firstName", ":", "jo"));
	     
	    List<Customer> results = customerRepository.findAll(spec);
	 
	    //assertThat(userJohn, isIn(results));
	    //assertThat(userTom, not(isIn(results)));
	}
}