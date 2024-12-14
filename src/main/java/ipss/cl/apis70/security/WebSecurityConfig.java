package ipss.cl.apis70.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

  // Configuración de seguridad HTTP
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(request -> request
        .requestMatchers("api/getAll").permitAll() // Permite acceso sin autenticación
        .requestMatchers("api/create").authenticated()) // Requiere autenticación
        .httpBasic(Customizer.withDefaults()) // Habilita la autenticación básica
        .csrf(csrf -> csrf.disable());
    return http.build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder(); // BCrypt para codificar las contraseñas
  }

  @Bean
  public UserDetailsService inMemoryUserDetails(PasswordEncoder passwordEncoder) {
    User.UserBuilder userBuilder = User.builder();

    // Usuario 1
    UserDetails mario = userBuilder
        .username("mario")
        .password(passwordEncoder.encode("123456"))
        .roles("USER")
        .build();

    // Usuario 2
    UserDetails admin = userBuilder
        .username("admin")
        .password(passwordEncoder.encode("admin123"))
        .roles("ADMIN")
        .build();

    return new InMemoryUserDetailsManager(mario, admin);

  }

}
