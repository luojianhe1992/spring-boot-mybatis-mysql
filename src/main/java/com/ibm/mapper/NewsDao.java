package com.ibm.mapper;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ibm.domain.News;

@Mapper
public interface NewsDao {

	@Insert("insert into news(title, abstraction, language, publication_date, author) values (#{title}, #{abstraction}, #{language}, #{publication_date}, #{author})")
	void addNews(News news);

	@Update("update news set title=#{title}, abstraction=#{abstraction}, language=#{language}, publication_date=#{publication_date}, author=#{author} where title=#{title}")
	void updateNews(News news);

	@Delete("delete from news where title=#{title}")
	void deleteNewsByTitle(String title);

	@Delete("delete from news where publication_date=#{publicationDate}")
	void deleteNewsByPublicationDate(Date publicationDate);

	@Select("SELECT title, abstraction, language, publication_date, author FROM news where title=#{title}")
	News findNewsByTitle(String title);

	@Select("SELECT title, abstraction, language, publication_date, author FROM news where publication_date=#{publicationDate}")
	News findNewsByPublicationDate(Date publicationDate);

	@Select("SELECT title, abstraction, language, publication_date, author FROM news")
	List<News> findAllNews();
}
