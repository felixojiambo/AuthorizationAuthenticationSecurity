package com.zep.ldls.user.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
public class AdminInvitation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    private String email;

    @Getter
    private String invitationCode;

    private LocalDateTime createdDate;

    private boolean accepted;

    public void setEmail(String email) {
    }

    public void setInvitationCode(String invitationCode) {
    }

    public void setCreatedDate(LocalDateTime now) {
    }

    public void setAccepted(boolean b) {
    }

    public boolean isAccepted() {
        return  true;
    }

    // Constructors, getters, and setters
}
