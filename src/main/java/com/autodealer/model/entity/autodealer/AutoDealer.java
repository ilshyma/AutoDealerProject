package com.autodealer.model.entity.autodealer;

import com.autodealer.model.entity.personal.Personal;

import javax.persistence.*;
import java.util.List;

/**
 * Created by user on 15.03.2016.
 */
@Entity
public class AutoDealer {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private AutoDealerInfo autoDealerInfo;


    @ManyToMany(mappedBy = "autoDealerList")
    private List<Personal> personalList;

    public AutoDealer() {
    }

    public AutoDealer(AutoDealerInfo autoDealerInfo) {
        this.autoDealerInfo = autoDealerInfo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AutoDealerInfo getAutoDealerInfo() {
        return autoDealerInfo;
    }

    public void setAutoDealerInfo(AutoDealerInfo autoDealerInfo) {
        this.autoDealerInfo = autoDealerInfo;
    }

    public List<Personal> getPersonalList() {
        return personalList;
    }

    public void setPersonalList(List<Personal> personalList) {
        this.personalList = personalList;
    }
}
