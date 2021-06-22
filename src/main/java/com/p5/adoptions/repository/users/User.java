package com.p5.adoptions.repository.users;

import com.p5.adoptions.repository.roles.Role;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "users")

public class User
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;
    @Column(nullable = false,unique = true)
    private String email;
    private String password;

    @ManyToMany(cascade =CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> userRoles= new HashSet<>();

    public Set<Role> getUserRoles() {
        return userRoles;
    }

    public User setUserRoles(Set<Role> userRoles) {
        this.userRoles = userRoles;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public User setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }
}
