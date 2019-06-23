package com.ibm.domain;

import java.sql.Date;

public class News {
	private String id;
	private String title;
	private String abstraction;
	private String language;
	private Date publicationDate;
	private String author;
	private String topics;

	public News(String id, String title, String abstraction, String language, Date publicationDate, String author,
			String topics) {
		super();
		this.id = id;
		this.title = title;
		this.abstraction = abstraction;
		this.language = language;
		this.publicationDate = publicationDate;
		this.author = author;
		this.topics = topics;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAbstraction() {
		return abstraction;
	}

	public void setAbstraction(String abstraction) {
		this.abstraction = abstraction;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTopics() {
		return topics;
	}

	public void setTopics(String topics) {
		this.topics = topics;
	}

	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", abstraction=" + abstraction + ", language=" + language
				+ ", publicationDate=" + publicationDate + ", author=" + author + ", topics=" + topics + "]";
	}

}
