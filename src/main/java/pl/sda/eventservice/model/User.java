package pl.sda.eventservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_user;
    private String nickname;
    private String email;
    private String password;
    private LocalDateTime registration_date = LocalDateTime.now();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",                                 // nazwa tabelki
            joinColumns = @JoinColumn(name = "user_id"),        // klucz uzytkownika
            inverseJoinColumns = @JoinColumn(name = "role_id")  // klucz roli
    )private Set<Role> roles = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Event> events = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comment> comments = new ArrayList<>();

    public User(String nickname, String email, String password) {
        this.nickname = nickname;
        this.email = email;
        this.password = password;
    }

    public void addEvent() {

    }

    public void addComment() {

    }

    public void addRole(Role role){
        this.roles.add(role);
    }
}

