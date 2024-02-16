package com.zep.ldls.user.model;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "token_blacklist")
public class TokenBlacklist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String token;

    public void setToken(String token) {

    }
}
