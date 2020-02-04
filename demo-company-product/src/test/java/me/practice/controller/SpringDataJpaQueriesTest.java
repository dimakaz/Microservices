package me.practice.controller;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import me.practice.entity.Employee;
import me.practice.entity.EmployeeNameCityProjection;
import me.practice.repository.EmployeeRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringDataJpaQueriesTest {


//    @Autowired
//    EmployeeRepository repository;
//    
//    @Test
//    @Transactional
//    public void stream() {
//        try (final Stream<Employee> all = repository.findAllStream()) {
//            assertThat(all.count(), is(4L));
//        }
//    }
//    
//    @Test
//    public void async() {
//        CompletableFuture<Employee> employeeFuture = repository.findByName("Hemingway");
//        
//        assertThat(employeeFuture.join().getName(), is("Hemingway"));
//    }
//    
//    @Test
//    public void namedQuery() {
//        List<Employee> employees = repository.employeesByIssueDescription("stay sharp!");
//        
//        assertThat(employees, hasSize(1));
//        assertThat(employees.get(0).getName(), is("Tumilowicz"));
//    }
//    
//    @Test
//    public void nativeQuery() {
//        List<Employee> employeesFromKrakow = repository.findByCity("Krakow");
//
//        assertThat(employeesFromKrakow, hasSize(2));
//        assertThat(employeesFromKrakow.get(0).getName(), is("Mrozek"));
//        assertThat(employeesFromKrakow.get(1).getName(), is("Lem"));
//    }
//    
//    @Test
//    public void SpEL_namedParams() {
//        List<Employee> byNames = repository.findByNames("a", "b");
//        
//        assertThat(byNames, is(empty()));
//    }
//    
//    @Test
//    @Transactional
//    public void update() {
//        int i = repository.updateNameForEmployeesFromCity("Tumilowicz updated", "Warsaw");
//        
//        assertThat(i, is(1));
//        assertThat(repository.findById(1).get().getName(), is("Tumilowicz updated"));
//    }
//    
//    @Test
//    @Transactional
//    public void delete() {
//        repository.deleteByAddress_Street("Plac Zbawiciela");
//        
//        assertThat(repository.findAll(), hasSize(3));
//    }
//
//    @Test
//    @Transactional
//    public void deleteBulk() {
//        repository.deleteInBulkByStreet("907 Whitehead St");
//        
//        assertThat(repository.findAll(), hasSize(3));
//    }
//    
//    @Test
//    public void projection() {
//        List<EmployeeNameCityProjection> all = repository.findAll_NameCityProjection();
//        
//        assertThat(all, hasSize(4));
//    }
}
