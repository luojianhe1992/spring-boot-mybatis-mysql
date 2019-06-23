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
		System.out.println("开始新增...");
		return newsService.addNews(news);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public boolean updateNews(@RequestBody News news) {
		System.out.println("开始更新...");
		return newsService.updateNews(news);
	}

	@RequestMapping(value = "/deleteByTitle", method = RequestMethod.DELETE)
	public boolean deleteNewsByTitle(@RequestParam(value = "title", required = true) String title) {
		System.out.println("开始删除...");
		return newsService.deleteNewsByTitle(title);
	}

	@RequestMapping(value = "/deleteByPublicationDate", method = RequestMethod.DELETE)
	public boolean deleteNewsByPublicationDate(@RequestParam(value = "publication_date", required = true) String publicationDateStr) {
		System.out.println("开始删除...");
		Date publicationDate = Date.valueOf(publicationDateStr);
		return newsService.deleteNewsByPublicationDate(publicationDate);
	}

	@RequestMapping(value = "/findByTitle", method = RequestMethod.GET)
	public News findNewsByTitle(@RequestParam(value = "title", required = true) String title) {
		System.out.println("开始查询...");
		return newsService.findNewsByTitle(title);
	}

	@RequestMapping(value = "/findByPublicationDate", method = RequestMethod.GET)
	public News findNewsByPublicationDate(@RequestParam(value = "publication_date", required = true) String publicationDateStr) {
		System.out.println("开始查询...");
		Date publicationDate = Date.valueOf(publicationDateStr);
		return newsService.findNewsByPublicationDate(publicationDate);
	}

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public List<News> findAllNews() {
		System.out.println("开始查询所有数据...");
		return newsService.findAllNews();
	}
}
