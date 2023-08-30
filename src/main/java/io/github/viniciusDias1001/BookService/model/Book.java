package io.github.viniciusDias1001.BookService.model;



import jakarta.persistence.*;


import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


@Entity(name = "book")
@Table
public class Book implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "author", nullable = false, length = 180)
    private String author;

    @Column(name = "LAUNCH_DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date launchDate;

    @Column(name = "PRICE", nullable = false)
    private Double price;

    @Column(name = "TITLE", nullable = false,length = 250)
    private String title;

    @Transient
    private String currency;

    @Transient
    private String environment;

    public Book() {
    }

    public Book(Long id, String author,String title ,Date launchDate, Double prince , String currency, String environment) {
        this.id = id;
        this.author = author;
        this.launchDate = launchDate;
        this.price = prince;
        this.title = title;
        this.currency = currency;
        this.environment = environment;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(Date launchDate) {
        this.launchDate = launchDate;
    }

    public Double getPrince() {
        return price;
    }

    public void setPrince(Double prince) {
        this.price = prince;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) && Objects.equals(author, book.author) && Objects.equals(launchDate, book.launchDate) && Objects.equals(price, book.price) && Objects.equals(title, book.title) && Objects.equals(currency, book.currency) && Objects.equals(environment, book.environment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, launchDate, price, title, currency, environment);
    }
}
