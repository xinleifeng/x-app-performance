package sap.crun.performance.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SAP_CRUN_PERFORMANCE_BOOKS")
public class Book implements Serializable {

	@Id
	//@Column(name = "\"ID\"")
	@Column(name = "ID")
	private int bookId;

	//@Column(name = "\"TITLE\"")
	@Column(name = "TITLE")
	private String bookTitle;


	//@Column(name = "\"STOCK\"")
	@Column(name = "STOCK")
	private int bookStock;

	public String getBookTitle() {
		return bookTitle;
	}

	public void getBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

}
