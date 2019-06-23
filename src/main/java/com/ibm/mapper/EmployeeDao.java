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

	@Insert("insert into employee(id, name, location, role, department, interests) values (#{id}, #{name}, #{location}, #{role}, #{department}, #{interests})")
	void addEmployee(Employee employee);

	@Update("update employee set name=#{name}, location=#{location}, role=#{role}, department=#{department} interests=#{interests} where id=#{id}")
	void updateEmployee(Employee employee);

	@Delete("delete from employee where id=#{id}")
	void deleteEmployeeById(String id);

	@Delete("delete from employee where name=#{name}")
	void deleteEmployeeByName(String name);

	@Select("SELECT id, name, location, role, department, interests FROM employee where id=#{id}")
	Employee findEmployeeById(String id);

	@Select("SELECT id, name, location, role, department, interests FROM employee where name=#{name}")
	List<Employee> findEmployeeByName(String name);

	@Select("SELECT id, name, location, role, department, interests FROM employee where interests like CONCAT('%',CONCAT(#{interest}, '%'))")
	List<Employee> findEmployeeByInterest(String interest);

	@Select("SELECT id, name, location, role, department, interests FROM employee")
	List<Employee> findAllEmployee();
}
