package com.deploma.entity;

import javax.persistence.*;

@Entity
@Table(name = "groups_of_diseases")
public class GroupOfDiseases {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
}
