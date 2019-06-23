package com.ibm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ibm.domain.Employee;

@Mapper
public interface EmployeeDao {
	
	@Insert("insert into employee(id, name, location, role, department) values (#{id}, #{name}, #{location}, #{role}, #{department})")
	void addEmployee(Employee employee);

	@Update("update employee set name=#{name}, location=#{location}, role=#{role}, department=#{department} where id=#{id}")
	void updateEmployee(Employee employee);

	@Delete("delete from employee where id=#{id}")
	void deleteEmployeeById(String id);

	@Delete("delete from employee where name=#{name}")
	void deleteEmployeeByName(String name);

	@Select("SELECT id, name, location, role, department FROM employee where id=#{id}")
	Employee findEmployeeById(String id);

	@Select("SELECT id, name, location, role, department FROM employee where name=#{name}")
	Employee findEmployeeByName(String name);

	@Select("SELECT id, name, location, role, department FROM employee")
	List<Employee> findAllEmployee();
}
