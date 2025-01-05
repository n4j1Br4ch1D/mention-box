package com.anmoon.mentionbox.entity;

import com.anmoon.mentionbox.enumeration.UserRoleEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends BaseEntity implements UserDetails {
    @Column
    String username;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String  lastName;
    private String avatar;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(unique=true)
    private String email;
    @JsonIgnore
//    @Schema(format = "password")
    private String password;
    @Column(name="activated_at")
    private Date activatedAt;
    @Column
    @Enumerated(EnumType.STRING)
    UserRoleEnum role;
    @Column
    Integer points;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<BookmarkEntity> bookmarks = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
