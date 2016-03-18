package com.autodealer.model.entity.personal;

import com.autodealer.model.entity.autodealer.AutoDealer;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by user on 15.03.2016.
 */
@Entity
public class Personal {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private PersonalPost personalPost;

    @Column(nullable = false)
    private String sex;

    @Column(nullable = false)
    private LocalDate receiptDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    private List<AutoDealer> autoDealerList;

    public Personal() {
    }

    public Personal(PersonalPost personalPost, LocalDate receiptDate, String sex, User user, List<AutoDealer> autoDealerList) {
        this.personalPost = personalPost;
        this.receiptDate = receiptDate;
        this.sex = sex;
        this.user = user;
        this.autoDealerList = autoDealerList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PersonalPost getPersonalPost() {
        return personalPost;
    }

    public void setPersonalPost(PersonalPost personalPost) {
        this.personalPost = personalPost;
    }

    public LocalDate getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(LocalDate receiptDate) {
        this.receiptDate = receiptDate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<AutoDealer> getAutoDealerList() {
        return autoDealerList;
    }

    public void setAutoDealerList(List<AutoDealer> autoDealerList) {
        this.autoDealerList = autoDealerList;
    }
}
