package com.ibm.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.domain.News;
import com.ibm.mapper.NewsDao;

@Service
public class NewsService {

	@Autowired
	private NewsDao newsDao;

	public boolean addNews(News news) {
		boolean flag = false;
		try {
			newsDao.addNews(news);
			flag = true;
		} catch (Exception e) {
			System.out.println("新增失败!");
			e.printStackTrace();
		}
		return flag;
	}

	public boolean updateNews(News news) {
		boolean flag = false;
		try {
			newsDao.updateNews(news);
			flag = true;
		} catch (Exception e) {
			System.out.println("修改失败!");
			e.printStackTrace();
		}
		return flag;
	}

	public boolean deleteNewsByTitle(String title) {
		boolean flag = false;
		try {
			newsDao.deleteNewsByTitle(title);
			flag = true;
		} catch (Exception e) {
			System.out.println("删除失败!");
			e.printStackTrace();
		}
		return flag;
	}

	public boolean deleteNewsByPublicationDate(Date publicationDate) {
		boolean flag = false;
		try {
			newsDao.deleteNewsByPublicationDate(publicationDate);
			flag = true;
		} catch (Exception e) {
			System.out.println("删除失败!");
			e.printStackTrace();
		}
		return flag;
	}

	public News findNewsById(String id) {
		return newsDao.findNewsById(id);
	}

	public List<News> findNewsByTitle(String title) {
		return newsDao.findNewsByTitle(title);
	}

	public List<News> findNewsByPublicationDate(Date publicationDate) {
		return newsDao.findNewsByPublicationDate(publicationDate);
	}

	public List<News> findAllNews() {
		return newsDao.findAllNews();
	}

}
