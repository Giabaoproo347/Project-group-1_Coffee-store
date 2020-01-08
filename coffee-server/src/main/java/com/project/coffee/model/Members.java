package com.project.coffee.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "members")
public class Members {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long memberId;
    private String email;
    private String password;
    private String memberName;
    private Date memberDOB;
    private boolean gender;
    private String memberPhone;
    private String memberAddress;
    private boolean memberStatus;

    public Members() {
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public Date getMemberDOB() {
        return memberDOB;
    }

    public void setMemberDOB(Date memberDOB) {
        this.memberDOB = memberDOB;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public String getMemberAddress() {
        return memberAddress;
    }

    public void setMemberAddress(String memberAddress) {
        this.memberAddress = memberAddress;
    }

    public boolean isMemberStatus() {
        return memberStatus;
    }

    public void setMemberStatus(boolean memberStatus) {
        this.memberStatus = memberStatus;
    }
}
