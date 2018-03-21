package model;

import javax.persistence.*;

@Entity
@Table(name = "issue")
public class Issue {

    @Id
    @GeneratedValue
    private int issue_id;

    @Column(name = "book_id")
    private int book_id;

    @Column(name = "publisher_id")
    private int publisher_id;

    @Column(name = "issue_no")
    private int issue_no;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "author",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id")}
    )

    public Issue(int book_id, int publisher_id, int issue_no) {
        this.book_id = book_id;
        this.publisher_id = publisher_id;
        this.issue_no = issue_no;
    }

    public int getIssue_id() {
        return issue_id;
    }

    public void setIssue_id(int issue_id) {
        this.issue_id = issue_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(int publisher_id) {
        this.publisher_id = publisher_id;
    }

    public int getIssue_no() {
        return issue_no;
    }

    public void setIssue_no(int issue_no) {
        this.issue_no = issue_no;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "issue_id=" + issue_id +
                ", book_id=" + book_id +
                ", publisher_id=" + publisher_id +
                ", issue_no=" + issue_no +
                '}';
    }
}
