package com.p5.adoptions.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)

public class RoleHierachyConfiguration extends GlobalMethodSecurityConfiguration
{
    @Bean
    public RoleHierarchy roleHieerarchy()
    {
        RoleHierarchyImpl roleHierarchy=new RoleHierarchyImpl();
        String hierarchy="ROLE_ADMIN> ROLE_MOD \n ROLE_MOD>ROLE_USER";



        roleHierarchy.setHierarchy(hierarchy);
        return roleHierarchy;

    }

    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler()
    {
        DefaultMethodSecurityExpressionHandler expressionHandler=new DefaultMethodSecurityExpressionHandler();
        expressionHandler.setRoleHierarchy(roleHieerarchy());
        return expressionHandler;

    }
}
