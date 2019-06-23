package com.ibm.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.domain.Employee;
import com.ibm.service.EmployeeService;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public boolean addEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public boolean updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}

	@RequestMapping(value = "/deleteById", method = RequestMethod.DELETE)
	public boolean deleteEmployeeById(@RequestParam(value = "id", required = true) String id) {
		return employeeService.deleteEmployeeById(id);
	}

	@RequestMapping(value = "/deleteByName", method = RequestMethod.DELETE)
	public boolean deleteEmployeeByName(@RequestParam(value = "name", required = true) String name) {
		return employeeService.deleteEmployeeByName(name);
	}

	@RequestMapping(value = "/findById", method = RequestMethod.GET)
	public Employee findEmployeeById(@RequestParam(value = "id", required = true) String id) {
		return employeeService.findEmployeeById(id);
	}

	@RequestMapping(value = "/findByName", method = RequestMethod.GET)
	public List<Employee> findEmployeeByName(@RequestParam(value = "name", required = true) String name) {
		return employeeService.findEmployeeByName(name);
	}

	/**
	 * find by interest
	 * 
	 * @param interest
	 * @return
	 */
	@RequestMapping(value = "/findByInterest", method = RequestMethod.GET)
	public List<Employee> findEmployeeByInterest(@RequestParam(value = "interest", required = true) String interest) {
		return employeeService.findEmployeeByInterest(interest);
	}

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public List<Employee> findAllEmployee() {
		System.out.println("开始查询所有数据...");
		return employeeService.findAllEmployee();
	}
}
