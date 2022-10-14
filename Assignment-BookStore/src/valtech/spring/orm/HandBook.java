package valtech.spring.orm;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("handbook")
public class HandBook extends Book {

	private String isbn;
	private float price;
	private int publishedYear;
	private String editions;
	public HandBook() {}
	public HandBook(String name,Date whenPublished,String isbn, float price, int publishedYear, String editions) {
		super(name,whenPublished);
		this.isbn = isbn;
		this.price = price;
		this.publishedYear = publishedYear;
		this.editions = editions;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getPublishedYear() {
		return publishedYear;
	}
	public void setPublishedYear(int publishedYear) {
		this.publishedYear = publishedYear;
	}
	public String getEditions() {
		return editions;
	}
	public void setEditions(String editions) {
		this.editions = editions;
	}
	@Override
	public String toString() {
		return "HandBook [isbn=" + isbn + ", price=" + price + ", publishedYear=" + publishedYear + ", editions="
				+ editions + "]";
	}
}
