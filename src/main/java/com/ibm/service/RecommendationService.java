package com.ibm.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.domain.Employee;
import com.ibm.domain.News;

@Service
public class RecommendationService {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private NewsService newsService;

	public List<Employee> recommendNewsToEmployeeListByPublicationDate(Date publicationDate) {
		List<News> newsList = newsService.findNewsByPublicationDate(publicationDate);
		System.out.println("newsList = " + newsList);
		Set<Employee> employeeSet = new HashSet<Employee>();
		for (News news : newsList) {
			String topics = news.getTopics();
			if (topics.equals("")) {
				return new ArrayList<Employee>();
			}
			String[] topicsArray = topics.split(",");
			for (String topic : topicsArray) {
				employeeSet.addAll(employeeService.findEmployeeByInterest(topic));
			}
		}
		return new ArrayList<Employee>(employeeSet);
	}

}
