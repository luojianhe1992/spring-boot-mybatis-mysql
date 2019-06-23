package com.ibm.web;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.domain.Employee;
import com.ibm.service.RecommendationService;

@RestController
@RequestMapping(value = "/recommendation")
public class RecommendationController {

	@Autowired
	private RecommendationService recommendationService;

	@RequestMapping(value = "/recommendByPublicationDate", method = RequestMethod.GET)
	public List<Employee> findNewsByPublicationDate(
			@RequestParam(value = "publication_date", required = true) String publicationDateStr) {
		Date publicationDate = Date.valueOf(publicationDateStr);
		return recommendationService.recommendNewsToEmployeeListByPublicationDate(publicationDate);
	}
}
