package com.p5.adoptions.security;


import com.p5.adoptions.repository.users.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserPrincipal implements UserDetails
{

    private final User principal;

    public UserPrincipal(User principal)
    {
        this.principal = principal;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return principal.getUserRoles().stream()
                .filter(Objects::nonNull)
                .filter(el-> el.getRole()!= null)
                .filter(el -> !el.getRole().name().isEmpty())
                .map(el -> new SimpleGrantedAuthority(el.getRole().name()))
                .collect(Collectors.toSet());
    }

    @Override
    public String getPassword() {
        return principal.getPassword();
    }

    @Override
    public String getUsername() {
        return principal.getEmail();
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
