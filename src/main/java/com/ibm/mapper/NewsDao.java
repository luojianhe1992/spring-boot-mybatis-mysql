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

	@Insert("insert into news(id, title, abstraction, language, publication_date, author, topics) values (#{id}, #{title}, #{abstraction}, #{language}, #{publication_date}, #{author}, #{topics})")
	void addNews(News news);

	@Update("update news set id=#{id}, title=#{title}, abstraction=#{abstraction}, language=#{language}, publication_date=#{publication_date}, author=#{author}, topics=#{topics} where id=#{id}")
	void updateNews(News news);

	@Delete("delete from news where id=#{id}")
	void deleteNewsByTitle(String title);

	@Delete("delete from news where publication_date=#{publicationDate}")
	void deleteNewsByPublicationDate(Date publicationDate);

	@Select("SELECT id, title, abstraction, language, publication_date, author, topics FROM news where id=#{id}")
	News findNewsById(String id);

	@Select("SELECT id, title, abstraction, language, publication_date, author, topics FROM news where title=#{title}")
	List<News> findNewsByTitle(String title);

	@Select("SELECT id, title, abstraction, language, publication_date, author, topics FROM news where publication_date=#{publicationDate}")
	List<News> findNewsByPublicationDate(Date publicationDate);

	@Select("SELECT id, title, abstraction, language, publication_date, author, topics FROM news")
	List<News> findAllNews();
}
