package me.practice.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import me.practice.entity.Employee;
import me.practice.entity.Phone;
import me.practice.entity.Phone.PhoneType;

public class EmployeeSpecs {

	  public static Specification<Employee> getEmployeesByNameSpec(String name) {
	      return new Specification<Employee>() {

			private static final long serialVersionUID = 1L;

			@Override
	          public Predicate toPredicate(Root<Employee> root,
	                                       CriteriaQuery<?> query,
	                                       CriteriaBuilder criteriaBuilder) {
	              Predicate equalPredicate = criteriaBuilder.equal(root.get("name"), name);
	              return equalPredicate;
	          }
	      };
	  }

	  public static Specification<Employee> getEmployeesByPhoneTypeSpec(PhoneType phoneType) {
	      return new Specification<Employee>() {

			private static final long serialVersionUID = 1L;

			@Override
	          public Predicate toPredicate(Root<Employee> root,
	                                       CriteriaQuery<?> query,
	                                       CriteriaBuilder criteriaBuilder) {
	              ListJoin<Employee, Phone> phoneJoin = root.joinList("phones");
	              Predicate equalPredicate = criteriaBuilder.equal(phoneJoin.get("type"), phoneType);
	              return equalPredicate;
	          }
	      };
	  }
}
