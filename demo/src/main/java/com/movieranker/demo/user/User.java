package com.movieranker.demo.user;

import com.movieranker.demo.user.utils.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movie_users")
public class User implements UserDetails {

    @Id
    @GeneratedValue
    private Long id;

    private String nickname;
    private String password;

    @Email
    private String email;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    private LocalDate dateOfBirth;


    public User(String nickname, String password, String email, UserRole userRole, LocalDate dateOfBirth) {
        this.nickname = nickname;
        this.password = password;
        this.email = email;
        this.userRole = userRole;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRole.name());

        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return nickname;
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
