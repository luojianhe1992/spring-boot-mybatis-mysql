package com.ibm.web;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.domain.News;
import com.ibm.service.NewsService;

@RestController
@RequestMapping(value = "/news")
public class NewsController {

	@Autowired
	private NewsService newsService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public boolean addNews(@RequestBody News news) {
		return newsService.addNews(news);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public boolean updateNews(@RequestBody News news) {
		return newsService.updateNews(news);
	}

	@RequestMapping(value = "/deleteByTitle", method = RequestMethod.DELETE)
	public boolean deleteNewsByTitle(@RequestParam(value = "title", required = true) String title) {
		return newsService.deleteNewsByTitle(title);
	}

	@RequestMapping(value = "/deleteByPublicationDate", method = RequestMethod.DELETE)
	public boolean deleteNewsByPublicationDate(
			@RequestParam(value = "publication_date", required = true) String publicationDateStr) {
		Date publicationDate = Date.valueOf(publicationDateStr);
		return newsService.deleteNewsByPublicationDate(publicationDate);
	}

	@RequestMapping(value = "/findById", method = RequestMethod.GET)
	public News findNewsById(@RequestParam(value = "id", required = true) String id) {
		return newsService.findNewsById(id);
	}

	@RequestMapping(value = "/findByTitle", method = RequestMethod.GET)
	public List<News> findNewsByTitle(@RequestParam(value = "title", required = true) String title) {
		return newsService.findNewsByTitle(title);
	}

	@RequestMapping(value = "/findByPublicationDate", method = RequestMethod.GET)
	public List<News> findNewsByPublicationDate(
			@RequestParam(value = "publication_date", required = true) String publicationDateStr) {
		Date publicationDate = Date.valueOf(publicationDateStr);
		return newsService.findNewsByPublicationDate(publicationDate);
	}

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public List<News> findAllNews() {
		return newsService.findAllNews();
	}
}
