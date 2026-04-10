package com.fiap.eficienciaenergetica.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Desabilita CSRF para simplificar testes; considere habilitar em produção
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/**").permitAll() // Permite tudo em /api/public
                        .requestMatchers(HttpMethod.GET, "/**").permitAll() // Permite apenas GET em /api/itens
                        .requestMatchers(HttpMethod.POST, "/**").hasAuthority("USER") // Permite POST em /api/itens para USER
                        .anyRequest().hasAuthority("ADM") // Requer ADM para qualquer outra requisição
                )
                .httpBasic(Customizer.withDefaults()); // Usa autenticação básica HTTP
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        JdbcUserDetailsManager manager = new JdbcUserDetailsManager();
        manager.setDataSource(dataSource);
        manager.setUsersByUsernameQuery("SELECT username, password, enabled FROM usuarios WHERE username = ?");
        manager.setAuthoritiesByUsernameQuery("SELECT username, role FROM usuarios WHERE username = ?");
        return manager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
