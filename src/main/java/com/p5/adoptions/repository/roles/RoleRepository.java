package com.p5.adoptions.repository.roles;

import com.p5.adoptions.model.roles.RolesEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>
{
    Optional<Role> findByRole(RolesEnum rolesEnum);


}
