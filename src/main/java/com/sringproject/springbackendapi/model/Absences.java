package com.sringproject.springbackendapi.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name= "absences")
public class Absences {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "admitterNote")
    private String admitterNote;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "crewId", nullable = false)
    private Members member;

    @Column(name = "endDate")
    private Date endDate;

    @Column(name = "startDate")
    private Date startDate;

    @Column(name = "memberNote")
    private String memberNote;

    @Column(name = "type")
    private String type;

    @Column(name = "rejectedAt")
    private String rejectedAt;

    @Column(name = "confirmedAt")
    private String confirmedAt;

    public Absences() {

    }

    public Absences(String admitterNote, Date endDate, Date startDate, String memberNote, String type, String rejectedAt, String confirmedAt, Members member) {
        super();
        this.admitterNote = admitterNote;
        this.endDate = endDate;
        this.startDate = startDate;
        this.memberNote = memberNote;
        this.type = type;
        this.rejectedAt = rejectedAt;
        this.confirmedAt = confirmedAt;
        this.member = member;
    }

    public long getId() {
        return id;
    }

    public String getAdmitterNote() {
        return admitterNote;
    }

    public String getConfirmedAt() {
        return confirmedAt;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getMemberNote() {
        return memberNote;
    }

    public String getRejectedAt() {
        return rejectedAt;
    }

    public Date getStartDate() {
        return startDate;
    }

    public String getType() {
        return type;
    }

    public Members getMember() {
        return member;
    }

    public void setAdmitterNote(String admitterNote) {
        this.admitterNote = admitterNote;
    }

    public void setConfirmedAt(String confirmedAt) {
        this.confirmedAt = confirmedAt;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setMemberNote(String memberNote) {
        this.memberNote = memberNote;
    }

    public void setRejectedAt(String rejectedAt) {
        this.rejectedAt = rejectedAt;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMember(Members member) {
        this.member = member;
    }
}
