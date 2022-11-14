package com.sringproject.springbackendapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "members")
public class Members {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long crewId;
    @Column(name= "name")
    private String name;
    @Column(name= "image")
    private String image;

    public Members() {

    }

    public Members(String name, String image) {
        super();
        this.name = name;
        this.image = image;
    }

    public long getCrewId() {
        return crewId;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public void setCrewId(long crewId) {
        this.crewId = crewId;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

}
