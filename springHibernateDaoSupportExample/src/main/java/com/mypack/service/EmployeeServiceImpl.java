package com.mypack.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mypack.beans.EmpDetails;
import com.mypack.beans.Employee;
import com.mypack.dao.EmployeeDao;

//@Service("employeeServiceImpl") // to provide custom name to this bean
@Service
public class EmployeeServiceImpl implements EmployeeService {
	private static Logger log = Logger.getLogger(EmployeeServiceImpl.class);
	@Autowired
	EmployeeDao employeeDao;

	@Override
	public List<Employee> findEmployees() {
		return employeeDao.findEmployees();
	}

	@Override
	public void deleteEmployees(List<Employee> empList) {
		employeeDao.deleteEmployees(empList);
		
	}

	@Override
	public void createEmployee(Employee employee) {
		employeeDao.createEmployee(employee);
		
	}

	@Override
	public void saveEmployee(Employee employee) {
		employeeDao.saveEmployee(employee);
		
	}
	
	@Override
	public void updateEmployee(Employee employee) {
		employeeDao.updateEmployee(employee);
		
	}
	
	
	@Transactional(propagation=Propagation.REQUIRED, isolation = Isolation.READ_UNCOMMITTED)
    public void execute() {
    	try {
    		List<Employee> empList = findEmployees();
    		for(Employee emp : empList) {
    			log.info(emp);
    		}
    		//deleteEmployees(empList);
    		Employee emp = empList.get(0);
    		log.info("Emp: " + emp);
    		emp.setName("XXX");
    		updateEmployee(emp);
    		
    		EmpDetails empDetails = new EmpDetails();
    		empDetails.setCity("New Delhi");
    		empDetails.setPincode("110033");
    		Employee employee = new Employee();
    		employee.setName("Imran Khan");
    		employee.setContact("9090");
    		employee.setEmpDetails(empDetails);
    		
    		//createEmployee(employee);
            
    		EmpDetails empDetails2 = new EmpDetails();
    		empDetails2.setCity("UP");
    		empDetails2.setPincode("202002");
    		Employee employee2 = new Employee();
    		employee2.setName("Vinay Kumr");
    		employee2.setContact("9090");
    		employee2.setEmpDetails(empDetails2);
    		
    		//saveEmployee(employee2);
            log.info("List of employees: " + findEmployees());
    	} catch(DataAccessException e) {
    		log.error(e);
    	}
    }

	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
}
