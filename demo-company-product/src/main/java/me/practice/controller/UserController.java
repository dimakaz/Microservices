package me.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import me.practice.entity.Customer;
import me.practice.repository.CustomerRepository;

@Controller
public class UserController {
 
    @Autowired
    private CustomerRepository repo;
 
    @RequestMapping(method = RequestMethod.GET, value = "/users")
    @ResponseBody
    public List<Customer> search(@RequestParam(value = "search") String search) {
//    	CustomerSpecificationsBuilder builder = new CustomerSpecificationsBuilder();
//        Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
//        Matcher matcher = pattern.matcher(search + ",");
//        while (matcher.find()) {
//            builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
//        }
//         
//        Specification<Customer> spec = builder.build();
//        return repo.findAll(spec);
    	return null;
    }
}

