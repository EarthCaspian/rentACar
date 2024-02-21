package com.tobeto.rentACar.core.configurations;


import com.tobeto.rentACar.core.filters.JwtAuthFilter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@AllArgsConstructor
public class SecurityConfiguration {

    private final PasswordEncoder passwordEncoder;
    private final JwtAuthFilter jwtAuthFilter;
    private final UserDetailsService userDetailsService;

    private static final String[] WHITE_LIST_URLS = {
            "/swagger-ui/**",
            "/v2/api-docs",
            "/v3/api-docs",
            "/v3/api-docs/**",
            "/api/users/**",
            "/api/auth/**",
            "/api/roles/**",
            "/api/brands/**",
            "/api/contact/**"

    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(x -> x
                        .requestMatchers(WHITE_LIST_URLS).permitAll()

                        //Get Methods
                        .requestMatchers(HttpMethod.GET, "/api/cars/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/rentals/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/models/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/colors/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/invoices/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/customers/**").permitAll()

                        //Post Methods
                        .requestMatchers(HttpMethod.POST, "/api/cars/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/rentals/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/models/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/rentals/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/customers/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/invoices/**").permitAll()

                        //Put/Update Methods
                        .requestMatchers(HttpMethod.PUT, "/api/cars/**").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/api/rentals/**").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/api/models/**").permitAll()

                        //Delete Methods
                        .requestMatchers(HttpMethod.DELETE, "/api/cars/**").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/api/rentals/**").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/api/models/**").permitAll()


                        .anyRequest().authenticated())
                .httpBasic(AbstractHttpConfigurer::disable)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        authenticationProvider.setUserDetailsService(userDetailsService);
        return authenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public GrantedAuthorityDefaults grantedAuthorityDefaults() {
        return new GrantedAuthorityDefaults("");
    }
}
