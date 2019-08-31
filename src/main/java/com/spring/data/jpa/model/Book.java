package com.spring.data.jpa.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;

import org.springframework.data.jpa.repository.Query;

@Entity
@Table(name="BOOK")
/*@NamedQueries({
	@NamedQuery(name="Book.queryJpql1",query="select b from Book b"),
	@NamedQuery(name="Book.queryJpqlOrdinalParam", query="select b from Book b where b.price = ?1"),
	@NamedQuery(name="Book.queryJpqlNamedParam",query="select b from Book b where b.title = :title")

})*/
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long bookId;
	
	private String title;
	
	private Date publishDate;
	
	private int pageCount;
	
	private BigDecimal price;
	
	
	@Version
	private long version;
	

	@ManyToOne
	@JoinColumn(name="AUTHOR_ID")
	private Author author;
	
	public Book() {

	}
	
	public Book(String title) {
		super();
		this.title = title;
	}



	public Book(String title, Date publishDate, int pageCount, BigDecimal price) {
		this.title = title;
		this.publishDate = publishDate;
		this.pageCount = pageCount;
		this.price = price;
	}


	public Long getBookId() {
		return bookId;
	}



	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public Date getPublishDate() {
		return publishDate;
	}



	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}



	public int getPageCount() {
		return pageCount;
	}



	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}



	public BigDecimal getPrice() {
		return price;
	}



	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}
	
	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", publishDate=" + publishDate + ", pageCount="
				+ pageCount + ", price=" + price + ", version=" + version + ", author=" + author + "]";
	}	
	

}
