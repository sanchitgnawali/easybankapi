package easy.bank.easybankapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class ProjectSecurityConfig {

  @Bean
  SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests()
        .requestMatchers("/myCards", "myAccount", "myBalance", "myLoans")
        .authenticated()
        .requestMatchers("/notices", "contact")
        .permitAll()
        .and()
        .formLogin()
        .and()
        .httpBasic();

    return http.build();
  }

  //    @Bean
  //    public InMemoryUserDetailsManager userDetailsManager() {
  //      UserDetails admin = User.withDefaultPasswordEncoder()
  //              .username("admin")
  //              .password("admin")
  //              .authorities("admin")
  //              .build();
  //
  //      UserDetails user = User.withDefaultPasswordEncoder()
  //              .username("user")
  //              .password("user")
  //              .authorities("read")
  //              .build();
  //
  //      return new InMemoryUserDetailsManager(admin, user);
  //    }

  @Bean
  public UserDetailsService userDetailsService(DataSource dataSource) {
    return new JdbcUserDetailsManager(dataSource);
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return NoOpPasswordEncoder.getInstance();
  }
}
