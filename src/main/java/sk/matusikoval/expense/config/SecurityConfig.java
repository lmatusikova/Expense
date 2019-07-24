package sk.matusikoval.expense.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().disable().csrf().disable().authorizeRequests().anyRequest().permitAll(); 
		
		//http.authorizeRequests().
		//antMatchers("/role", "/role/*").permitAll()
		///.antMatchers(HttpMethod.POST, "/role/*", "/role", "/role/", "role", "/role/**", "role/*", "/role*").permitAll()
		//.anyRequest().authenticated();
	}
}
