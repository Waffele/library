package chmielecki.a.library.domain;

import javax.persistence.*;

@Entity
public class Pending {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Book book;

    @OneToOne
    private User user;

    public Pending(Book book, User user) {
        this.book = book;
        this.user = user;
    }

    public Pending() {
    }

    @Override
    public String toString() {
        return "Pending{" +
                "id=" + id +
                ", book=" + book +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pending pending = (Pending) o;

        if (id != null ? !id.equals(pending.id) : pending.id != null) return false;
        if (book != null ? !book.equals(pending.book) : pending.book != null) return false;
        return user != null ? user.equals(pending.user) : pending.user == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (book != null ? book.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
