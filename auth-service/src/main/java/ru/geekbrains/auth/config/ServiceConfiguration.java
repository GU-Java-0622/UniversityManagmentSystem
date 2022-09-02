package ru.geekbrains.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.geekbrains.commons.security.RoleChecker;

@Configuration
public class ServiceConfiguration {

    @Bean
    public RoleChecker getRoleChecker(){
        return new RoleChecker();
    }
}
