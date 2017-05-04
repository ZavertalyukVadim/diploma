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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "groups_of_diseases_users", joinColumns = {
            @JoinColumn(name = "groups_of_diseases_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "user_id",
                    nullable = false)})
    private List<User> users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

}
