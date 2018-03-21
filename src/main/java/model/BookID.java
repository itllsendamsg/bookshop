package model;

import javax.persistence.*;


@Entity
@Table(name = "book_id")
public class BookID {

    @Id
    @GeneratedValue
    private int author_id;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "author",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id")}
    )

    public BookID() {
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }


    @Override
    public String toString() {
        return "BookID{" +
                "author_id=" + author_id +
                '}';
    }
}
