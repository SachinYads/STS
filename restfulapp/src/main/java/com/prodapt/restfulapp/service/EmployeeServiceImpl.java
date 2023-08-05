package com.prodapt.restfulapp.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 

import com.prodapt.restfulapp.entities.Employee;
import com.prodapt.restfulapp.exceptions.EmployeeNotFoundException;
import com.prodapt.restfulapp.repositories.EmployeeRepository;

 

@Service
public class EmployeeServiceImpl implements EmployeeService {
    
    @Autowired
    private EmployeeRepository repository;
    @Override
    public void deleteEmployee(Long id) {
        repository.deleteById(id);

 

    }

 

    @Override
    public Employee replaceEmployee(Employee newEmployee, Long id) {
        
        return repository.findById(id)
                  .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setRole(newEmployee.getRole());
                    return repository.save(employee);
                  })
                  .orElseGet(() -> {
                    newEmployee.setId(id);
                    return repository.save(newEmployee);
                  });
        }

 

    //Single employee
        @Override
        public Employee one(Long id) throws EmployeeNotFoundException {
             return repository.findById(id)
                      .orElseThrow(() -> new EmployeeNotFoundException("Employee with id - "+id+"not found",id));
        }

 

 

        @Override
        public Employee newEmployee(Employee newEmployee) {
            return repository.save(newEmployee);
        }

 

        @Override
        public List<Employee> all() {
            return repository.findAll();
        }
        @Override
		public Employee findByName(String name) throws EmployeeNotFoundException {
			Employee employee = repository.findByName(name);
			if(employee != null ) {
			return repository.findByName(name);
			}else {
				throw new EmployeeNotFoundException(name);
			}
		}

}
 


 