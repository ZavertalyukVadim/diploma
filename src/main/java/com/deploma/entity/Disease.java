package com.deploma.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "diseases_symptoms", joinColumns = {
            @JoinColumn(name = "diseases_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "symptoms_id",
                    nullable = false)})
    private Set<Symptom> symptoms =  new HashSet<>();

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

    public Set<Symptom> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(Set<Symptom> symptoms) {
        this.symptoms = symptoms;
    }

    @Override
    public String toString() {
        return "Disease{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", groupsOfDiseases=" + groupsOfDiseases +
                ", symptoms=" + symptoms +
                '}';
    }

}
