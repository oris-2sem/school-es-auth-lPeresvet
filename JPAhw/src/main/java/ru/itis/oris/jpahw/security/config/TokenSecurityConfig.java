package ru.itis.oris.jpahw.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import ru.itis.oris.jpahw.entities.users.roles.Role;
import ru.itis.oris.jpahw.security.details.UserDetailsServiceImpl;
import ru.itis.oris.jpahw.security.filters.JwtAuthenticationFilter;
import ru.itis.oris.jpahw.security.filters.JwtAuthorizationFilter;

@EnableWebSecurity
@RequiredArgsConstructor
public class TokenSecurityConfig {
    private final PasswordEncoder passwordEncoder;

    private final UserDetailsServiceImpl userDetailsServiceImpl;

    private final AuthenticationProvider provider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security,
                                                   JwtAuthorizationFilter jwtAuthorizationFilter,
                                                   JwtAuthenticationFilter jwtAuthenticationFilter) throws Exception{
        security.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        security.csrf().disable();

        String teacherAuthority = "TEACHER";
        security.authorizeRequests()
                .antMatchers("/students/**").hasAuthority(teacherAuthority)
                .antMatchers("/parents/**").hasAuthority(teacherAuthority)
                .antMatchers("/teachers/**").hasAuthority(teacherAuthority)
                .antMatchers(HttpMethod.GET, "/classes/**").authenticated()
                .antMatchers(HttpMethod.GET, "/tasks/**").authenticated()
                .antMatchers(HttpMethod.GET, "/timetable/**").authenticated()
                .antMatchers(HttpMethod.GET, "/lessons/**").authenticated()
                .antMatchers("/classes/**").hasAuthority(teacherAuthority)
                .antMatchers("/tasks/**").hasAuthority(teacherAuthority)
                .antMatchers("/timetable/**").hasAuthority(teacherAuthority)
                .antMatchers("/lessons/**").hasAuthority(teacherAuthority);

        security.addFilter(jwtAuthenticationFilter);
        security.addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);

        return security.build();
    }

    @Autowired
    public void bindUserDetailsServiceAndPasswordEncoder(AuthenticationManagerBuilder builder) throws Exception{
        builder.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder);
        builder.authenticationProvider(provider);
    }


}
