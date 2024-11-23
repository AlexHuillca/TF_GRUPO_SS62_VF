package com.example.lookup.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfiguration {
    /*
    http://localhost:8080/swagger-ui/index.html
    */
    private static final String[] AUTH_WHITELIST = {
            // -- swagger ui
            "/v2/api-docs/**",
            "/v3/api-docs/**",
            "/swagger-resources/**",
            "/swagger-ui/**",
            // -- login
            "/api/users/login/**",
            "/api/users/register/**"

    };

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration
                                                        authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }


    @Autowired
    private JwtRequestFilter jwtRequestFilter;


    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
/*
*/

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

        http.csrf().disable();
        http.cors(withDefaults());


        http.authorizeHttpRequests((auth) -> auth
                .requestMatchers(AUTH_WHITELIST).permitAll()
                .requestMatchers(HttpMethod.GET, "/api/users/{id}").hasAnyRole("ADMIN", "CLIENTE")
                .requestMatchers(HttpMethod.POST, "/api/users/**").permitAll()  // Registration is allowed for everyone
                .requestMatchers(HttpMethod.PUT, "/api/users/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/api/users/**").hasRole("ADMIN")

                .requestMatchers(HttpMethod.POST, "/api/preferencia/**").hasRole("CLIENTE")
                .requestMatchers(HttpMethod.PUT, "/api/preferencia/**").hasAnyRole("ADMIN", "CLIENTE")
                .requestMatchers(HttpMethod.GET, "/api/preferencia/{id}").hasAnyRole("ADMIN", "CLIENTE")
                .requestMatchers(HttpMethod.DELETE, "/api/preferencia/**").hasRole("ADMIN")

                .requestMatchers(HttpMethod.POST, "/api/prenda/**").hasAnyRole("ADMIN", "CLIENTE")
                .requestMatchers(HttpMethod.GET, "/api/prendas/**").hasAnyRole("ADMIN", "CLIENTE")
                .requestMatchers(HttpMethod.DELETE, "/api/eliminar/prenda/{id}").hasRole("ADMIN")

                .requestMatchers(HttpMethod.POST, "/api/prendatienda/**").hasRole("CLIENTE")
                .requestMatchers(HttpMethod.GET, "/api/prendastiendas/**").hasAnyRole("ADMIN", "CLIENTE")
                .requestMatchers(HttpMethod.DELETE, "/api/Eliminar/prendatienda/{id}").hasRole("ADMIN")

                .requestMatchers(HttpMethod.POST, "/api/AgregarPreferencia/**").hasAnyRole("ADMIN", "CLIENTE")
                .requestMatchers(HttpMethod.GET, "/api/preferencias/**").hasAnyRole("ADMIN", "CLIENTE")
                .requestMatchers(HttpMethod.DELETE, "/api/eliminar/preferencia/{id}").hasRole("ADMIN")

                .requestMatchers(HttpMethod.POST, "/api/pedido/**").hasRole("CLIENTE")
                .requestMatchers(HttpMethod.GET, "/api/pedidos/**").hasAnyRole("ADMIN", "CLIENTE")
                .requestMatchers(HttpMethod.DELETE, "/api/elimianrpedidios/{id}").hasRole("ADMIN")

                .requestMatchers(HttpMethod.POST, "/api/detallePedido/**").hasRole("CLIENTE")
                .requestMatchers(HttpMethod.GET, "/api/detallePedido/{id}").hasAnyRole("ADMIN", "CLIENTE")
                .requestMatchers(HttpMethod.PUT, "/api/detallePedido/{id}").hasAnyRole("ADMIN", "CLIENTE")
                .requestMatchers(HttpMethod.DELETE, "/api/detallePedido/{id}").hasRole("ADMIN")

                .requestMatchers(HttpMethod.POST, "/api/decuento/**").hasAnyRole("ADMIN", "CLIENTE")
                .requestMatchers(HttpMethod.GET, "/api/descuentos/**").hasAnyRole("ADMIN", "CLIENTE")
                .requestMatchers(HttpMethod.DELETE, "/api/descuento/{id}").hasRole("ADMIN")

                .requestMatchers(HttpMethod.POST, "/api/prendadistribuidora/**").hasRole("CLIENTE")
                .requestMatchers(HttpMethod.GET, "/api/tiendasdistribuidoras/**").hasAnyRole("ADMIN", "CLIENTE")
                .requestMatchers(HttpMethod.DELETE, "/api/tiendaDistribuidora/{id}").hasRole("ADMIN")

                .requestMatchers(HttpMethod.GET, "/api/cometarios/**").hasAnyRole("ADMIN", "CLIENTE")
                .requestMatchers(HttpMethod.POST, "/api/valoracion/**").hasAnyRole("ADMIN", "CLIENTE")
                .requestMatchers(HttpMethod.DELETE, "/eliminar/Valoracion/{id}").hasRole("ADMIN")


                .requestMatchers(HttpMethod.GET, "/api/categorias/**").hasAnyRole("ADMIN", "CLIENTE")
                .requestMatchers(HttpMethod.GET, "/api/marcas/**").hasAnyRole("ADMIN", "CLIENTE")

                .requestMatchers("/**").hasRole("ADMIN")
                .anyRequest().authenticated()
        );


        http.sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));


        return http.build();

    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}


