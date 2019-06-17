package sap.crun.performance.api.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"SAP_CRUN_PERFORMANCE_TESTTAB\"")
public class SnglRecOut {

	@Id
	@Column(name = "\"ID\"")
	private String redId;

	@Column(name = "\"TITLE\"")
	private String recTitle;


	@Column(name = "\"STOCK\"")
	private int recStock;

	public String getRecTitle() {
		return recTitle;
	}

	public void getBookTitle(String recTitle) {
		this.recTitle = recTitle;
	}

}


//
//package sap.crun.performance.api.model;
//
//public class Book {
//
//	private String bookId;
//
//	private String bookTitle;
//
//
//	private int bookStock;
//
//	public String getBookTitle() {
//		return bookTitle;
//	}
//
//	public void getBookTitle(String bookTitle) {
//		this.bookTitle = bookTitle;
//	}
//
//}