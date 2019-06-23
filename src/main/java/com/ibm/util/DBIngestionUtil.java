package com.ibm.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import com.ibm.domain.Employee;
import com.ibm.domain.News;
import com.ibm.util.generator.EmployeeGenerator;
import com.ibm.util.generator.NewsGenerator;

import java.sql.*;

public class DBIngestionUtil {

	public static void ingestEmployeeList(List<Employee> employeeList) {
		Connection connection = null;
		Statement stmt = null;
		try {
			System.out.println("Connecting to a selected database...");
			Properties properties = new Properties();
			properties.load(new FileInputStream(new File("src/main/resources/application.properties")));
			Class.forName(properties.getProperty("spring.datasource.driver-class-name"));
			String url = properties.getProperty("spring.datasource.url");
			String user = properties.getProperty("spring.datasource.username");
			String password = properties.getProperty("spring.datasource.password");
			connection = DriverManager.getConnection(url, user, password);
			System.out.println(connection + ", Connected database successfully...");

			System.out.println("Inserting records into the table...");
			stmt = connection.createStatement();

			for (Employee employee : employeeList) {
				String sql = "INSERT INTO employee " + "VALUES ('" + employee.getId() + "', '" + employee.getName()
						+ "', '" + employee.getLocation() + "', '" + employee.getRole() + "', '"
						+ employee.getDepartment() + "', '" + employee.getInterests() + "')";
				System.out.println("sql = " + sql);
				stmt.executeUpdate(sql);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					connection.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		System.out.println("Goodbye!");
	}

	public static void ingestNewsList(List<News> newsList) {
		Connection connection = null;
		Statement stmt = null;
		try {
			System.out.println("Connecting to a selected database...");
			Properties properties = new Properties();
			properties.load(new FileInputStream(new File("src/main/resources/application.properties")));
			Class.forName(properties.getProperty("spring.datasource.driver-class-name"));
			String url = properties.getProperty("spring.datasource.url");
			String user = properties.getProperty("spring.datasource.username");
			String password = properties.getProperty("spring.datasource.password");
			connection = DriverManager.getConnection(url, user, password);
			System.out.println(connection + ", Connected database successfully...");

			System.out.println("Inserting records into the table...");
			stmt = connection.createStatement();

			for (News news : newsList) {
				String sql = "INSERT INTO news " + "VALUES ('" + news.getId() + "', '" + news.getTitle() + "', '"
						+ news.getAbstraction() + "', '" + news.getLanguage() + "', '" + news.getPublicationDate()
						+ "', '" + news.getAuthor() + "', '" + news.getTopics() + "')";
				System.out.println("sql = " + sql);
				stmt.executeUpdate(sql);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					connection.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		System.out.println("Goodbye!");
	}

	public static void main(String[] args) {
		 List<Employee> employeeList = EmployeeGenerator.generateEmployeeList(50);
		 DBIngestionUtil.ingestEmployeeList(employeeList);

//		List<News> newsList = NewsGenerator.generateNewsList(50);
//		DBIngestionUtil.ingestNewsList(newsList);
	}

}
