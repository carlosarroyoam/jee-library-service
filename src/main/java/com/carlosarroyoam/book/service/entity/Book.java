package com.carlosarroyoam.book.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "books")
@NamedQuery(name = Book.FIND_ALL, query = "SELECT b FROM Book b")
@Data
public class Book {

	public static final String FIND_ALL = "Book.findAll";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "isbn", unique = true)
	private String isbn;

	@Column(name = "title", nullable = false)
	private String title;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "author_id", referencedColumnName = "id", nullable = false)
	private Author author;

}