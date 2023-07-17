package com.example.demo;

import static org.springframework.security.config.Customizer.withDefaults;
import java.util.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig {
	@Bean
	public SecurityFilterChain web(HttpSecurity http) throws Exception
	{	http.authorizeHttpRequests((authz)->authz
		.requestMatchers("/Distributor/AddDistributor").hasRole("ADMIN")
		.requestMatchers("/Distributor/fetchAllDistributors").hasRole("ADMIN")
		.requestMatchers("/Distributor/updateDistributorDetails").hasRole("ADMIN")
		.requestMatchers("Supplier/AddSupplier").hasRole("ADMIN")
		.requestMatchers("Supplier/fetchAllSuppliers").hasRole("ADMIN")
		.requestMatchers("Supplier/updateSupplierDetails").hasRole("ADMIN")
		.requestMatchers("Supplier/AddWarehouse").hasRole("ADMIN")
		.requestMatchers("Supplier/FetchWarehouse").hasRole("ADMIN")
		).httpBasic(withDefaults());
		return http.build();	
	}

	@Bean
	public UserDetailsServiceImpl user()
	{	return new UserDetailsServiceImpl(); 
	}
	@Bean
	public DaoAuthenticationProvider authenticationProvider()
	{	DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(user());
		return auth;
	}
//	@Bean
//	public InMemoryUserDetailsManager userDetailsService()
//	{	UserDetails usede1 = org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder().username("Omar").password("123")
//		.roles("USER").build();
//	UserDetails usede2 = org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder().username("Bayezid").password("123")
//			.roles("USER").build();
//	UserDetails usede3 = org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder().username("Zulqarnain").password("123")
//			.roles("ADMIN").build();
//	List<UserDetails> UserDetailsList = new ArrayList();
//	UserDetailsList.add(usede1);
//	UserDetailsList.add(usede2);
//	UserDetailsList.add(usede3);
//	InMemoryUserDetailsManager inmem =  new InMemoryUserDetailsManager(UserDetailsList);
//	return inmem;
//	}
}
