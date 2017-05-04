package com.deploma.entity;

import javax.persistence.*;

@Entity
@Table(name = "diseases")
public class Disease {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "groupsOfDiseases_id")
    private GroupOfDiseases groupsOfDiseases;

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

    public GroupOfDiseases getGroupsOfDiseases() {
        return groupsOfDiseases;
    }

    public void setGroupsOfDiseases(GroupOfDiseases groupsOfDiseases) {
        this.groupsOfDiseases = groupsOfDiseases;
    }
}
