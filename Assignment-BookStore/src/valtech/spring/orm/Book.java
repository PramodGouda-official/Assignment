package valtech.spring.orm;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Book_Type")
@DiscriminatorValue("books")
@Table(name="Book")
public class Book {

		@Id
		@GeneratedValue(strategy=GenerationType.SEQUENCE)
		private int id;
		private String name;
		@Temporal(TemporalType.DATE)
		private Date whenPublished;
		@ManyToOne(targetEntity=Publisher.class,cascade={CascadeType.MERGE, CascadeType.PERSIST},fetch=FetchType.EAGER)
		@JoinColumn(name="publisher_id",referencedColumnName="id")
		private Publisher publisher;
		@ManyToMany(targetEntity=Author.class,cascade={CascadeType.MERGE, CascadeType.PERSIST})
		@JoinTable(name="book_author", joinColumns=@JoinColumn(name="book_id",referencedColumnName="id"),
		inverseJoinColumns=@JoinColumn(name="author_id",referencedColumnName="id"))
		private Set<Author> authors;

		public Book() {}

		public Book(String name, Date whenPublished) {
			super();
			this.name = name;
			this.whenPublished = whenPublished;
		}

		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Date getWhenPublished() {
			return whenPublished;
		}
		public void setWhenPublished(Date whenPublished) {
			this.whenPublished = whenPublished;
		}

		public Set<Author> getAuthors() {
			return authors;
		}

		public void setAuthors(Set<Author> authors) {
			this.authors = authors;
		}

		public Publisher getPublisher() {
			return publisher;
		}

		public void setPublisher(Publisher publisher) {
			this.publisher = publisher;
		}
		
		public void addAuthor(Author a){

			if(getAuthors()==null){
				authors=new HashSet<Author>();

			}
			authors.add(a);

			if(a.getBooks()==null){
				a.setBooks(new HashSet<Book>());
			}
			a.getBooks().add(this);
		}

		@Override
		public String toString() {
			return "Book [id=" + id + ", name=" + name + ", whenPublished=" + whenPublished + "]";
		}

}
