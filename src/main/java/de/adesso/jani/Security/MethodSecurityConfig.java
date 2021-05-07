package de.adesso.jani.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class MethodSecurityConfig {
}
