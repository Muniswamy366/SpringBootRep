package com.arya.myapp.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.arya.myapp.exceptions.EmployeeNotFoundException;
import com.arya.myapp.model.Employee;

@Repository("employeeDao")
public class EmployeeDaoImpl extends AbstractDao implements EmployeeDao{
	
	private static final Logger logger = Logger.getLogger(EmployeeDaoImpl.class);
	
	public void saveEmployee(Employee employee) {
		persist(employee);
		getSession().flush();
	}

	@SuppressWarnings("unchecked")
	public List<Employee> findAllEmployees() {
		Criteria criteria = getSession().createCriteria(Employee.class);
		return (List<Employee>) criteria.list();
	}

	public void deleteEmployeeById(int id) throws EmployeeNotFoundException{
		Query query = getSession().createSQLQuery("delete from Employee where id = :id");
		query.setInteger("id", id);
		int result = query.executeUpdate();
		if(result < 1)
			throw new EmployeeNotFoundException("Employee Not Found with id = "+id);
	}

	public Employee findById(int id){
		Criteria criteria = getSession().createCriteria(Employee.class);
		criteria.add(Restrictions.eq("id",id));
		return (Employee) criteria.uniqueResult();
	}
	
	public void updateEmployee(Employee employee){
		getSession().update(employee);
	}
	
}
