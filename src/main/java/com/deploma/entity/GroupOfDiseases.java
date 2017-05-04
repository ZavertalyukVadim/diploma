package com.deploma.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "groups_of_diseases")
public class GroupOfDiseases {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "groupsOfDiseases", cascade = CascadeType.ALL)
    private List<Disease> diseases;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Disease> getDiseases() {
        return diseases;
    }

    public void setDiseases(List<Disease> diseases) {
        this.diseases = diseases;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
