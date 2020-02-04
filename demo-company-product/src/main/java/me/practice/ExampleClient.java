package me.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import me.practice.entity.Address;
import me.practice.entity.Employee;
import me.practice.entity.Phone;
import me.practice.entity.Phone.PhoneType;
import me.practice.repository.EmployeeRepository;

@Component
public class ExampleClient implements CommandLineRunner{

	@Autowired
	private EmployeeRepository employeeRepository;

	
    @Override
    @Transactional
    public void run(String... args) throws Exception {
		
    	Address address = new Address("Emek Hahula", "Modiin");
		List<Phone> phones = new ArrayList<Phone>();
		phones.add(new Phone(PhoneType.Home,"112233"));
		phones.add(new Phone(PhoneType.Work,"911"));
		Employee e1 = new Employee("DIMA", address, phones);
		
		employeeRepository.save(e1);

		findAllEmployees();

	}

	private void findAllEmployees() {
		System.out.println(" -- getting all Employees --");
		Iterable<Employee> iterable = employeeRepository.findAll();
		List<Employee> allEmployees = StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
		allEmployees.forEach(System.out::println);
	}
}
