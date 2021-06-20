package com.mypack.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mypack.beans.Employee;
@Repository
public class EmployeeDaoImpl extends BaseDao implements EmployeeDao {
	private static Logger log = Logger.getLogger(EmployeeDaoImpl.class);
    
    @Transactional(readOnly=true)
    public List<Employee> findEmployees() {
        @SuppressWarnings("unchecked")
        /**List<Employee> empList = (List<Employee>) getHibernateTemplate().find("from Employee where name in (?, ?)", "Imran", "Vinay");*/
		List<Employee> empList = (List<Employee>) getHibernateTemplate().find("from Employee");
        return empList;
    }
    
    //@Transactional(readOnly=false, propagation=Propagation.REQUIRES_NEW)// This will work independently with outer transaction
    //@Transactional(readOnly=false, propagation=Propagation.NEVER)
    //@Transactional(readOnly=false)
    public void deleteEmployees(List<Employee> empList) {        
        if (!empList.isEmpty()) {
            getHibernateTemplate().deleteAll(empList);
            log.info("Employees deleted");
        }
    }
     
    @Transactional(readOnly=false)
    public void createEmployee(final Employee employee){
        log.info("Create new employee " + employee.getName());
        Employee emp = getHibernateTemplate().execute(new HibernateCallback<Employee>() {

            public Employee doInHibernate(Session session) throws HibernateException {
                session.saveOrUpdate(employee);
                return employee;
            }
        });
        log.info("Employee created " + emp);
    }
    
    @Transactional(readOnly=false)
    public void saveEmployee(Employee emp){
        log.info("Create new employee " + emp);
        getHibernateTemplate().save(emp);
        log.info("Employee created " + emp);        
    }  
    
    @Override
    public void updateEmployee(Employee employee) {
    	getHibernateTemplate().update(employee);
    	
    }
}
