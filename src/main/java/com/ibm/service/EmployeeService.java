package com.ibm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.domain.Employee;
import com.ibm.mapper.EmployeeDao;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	public boolean addEmployee(Employee employee) {
		boolean flag = false;
		try {
			employeeDao.addEmployee(employee);
			flag = true;
		} catch (Exception e) {
			System.out.println("新增失败!");
			e.printStackTrace();
		}
		return flag;
	}

	public boolean updateEmployee(Employee employee) {
		boolean flag = false;
		try {
			employeeDao.updateEmployee(employee);
			flag = true;
		} catch (Exception e) {
			System.out.println("修改失败!");
			e.printStackTrace();
		}
		return flag;
	}

	public boolean deleteEmployeeById(String id) {
		boolean flag = false;
		try {
			employeeDao.deleteEmployeeById(id);
			flag = true;
		} catch (Exception e) {
			System.out.println("删除失败!");
			e.printStackTrace();
		}
		return flag;
	}

	public boolean deleteEmployeeByName(String name) {
		boolean flag = false;
		try {
			employeeDao.deleteEmployeeByName(name);
			flag = true;
		} catch (Exception e) {
			System.out.println("删除失败!");
			e.printStackTrace();
		}
		return flag;
	}

	public Employee findEmployeeById(String id) {
		return employeeDao.findEmployeeById(id);
	}

	public Employee findEmployeeByName(String name) {
		return employeeDao.findEmployeeByName(name);
	}

	public List<Employee> findAllEmployee() {
		return employeeDao.findAllEmployee();
	}

}
