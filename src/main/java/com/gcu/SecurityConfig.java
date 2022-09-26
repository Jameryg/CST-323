package com.gcu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.gcu.business.UserBusinessService;

/*
 * @Configuration annotation indicates that a class declares on of more @Bean methods and may be processed by the Spring 
 * Container to generate bean definitions and service requests for those beans at runtime. (In this file - our
 * web security)
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
	/**
	 * Declare a class scope method variable named service.
	 * Of type of the UserBusinessService that is Autowired.
	 */
	@Autowired
	UserBusinessService service; 
	
	/**
	 * Declare a class scope method variables named passwordEncoder of 
	 * type PasswordEncoder that is Autowired.
	 */
	@Autowired
	PasswordEncoder passwordEncoder;
	
	/** 
	 * Return an instance of BCryptPasswordEncoder, using beans
	 */
	@Bean(name="passwordEncoder")
	public static BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	/*
	 * Allows for 
	 */
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.csrf().disable()
	        .httpBasic()
				.and()
				.authorizeRequests()
				.antMatchers("/service/**").authenticated()
				.and()
			/*
			 * Will permit all of the given URI's (Uniform Resource Identifier) with all of the 
			 * other URI's and will then check for authentication, thus there is added security.
			 */
	        .authorizeRequests()
	        	.antMatchers("/register/**", "/images/**", "/service/**")
	        	.permitAll()
	        	.anyRequest().authenticated()
	       		.and()
	       	/*
	       	 * POST to this form (The /login/ form) and then pass in the given parameters, both
	       	 * the "username" and "password", allowing for them to go through the verification process.
	       	 * When the login was successful then it will default to the given url.
	       	 */
        	.formLogin()
        		.loginPage("/login/")
        		.usernameParameter("username")
        		.passwordParameter("password")
        		.permitAll()
        		.defaultSuccessUrl("/login/personalProductPage", true)
        		.and()
        	/*
        	 * The logout handler, will mess with the logout and the logout buttons to allow for 
        	 * it to go back to the login page.
        	 */
        	.logout()
        		.logoutUrl("/logout")
        		.invalidateHttpSession(true)
        		.clearAuthentication(true)
        		.permitAll()
        		.logoutSuccessUrl("/");
    }
    
    /*
     * AuthenticationManagerBuilder - Allows providing a parent 
     * AuthenticationManagerBuilder that will be tried if this AuthenticationManager was unable to authenticate 
     * the provided Authentication. 
     */
    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception
    {
    	auth
    	.userDetailsService(service)
    	.passwordEncoder(passwordEncoder);
    }
}
