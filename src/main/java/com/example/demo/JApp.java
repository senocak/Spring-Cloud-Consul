package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigurationProperties
@EnableScheduling
public class JApp {
	private final UserProp userProp;

	public JApp(UserProp userProp) {
		this.userProp = userProp;
	}

	public static void main(String[] args) {
		SpringApplication.run(JApp.class, args);
	}

    @Scheduled(fixedRate = 3_000)
	public void getUserProp() {
		System.out.println(userProp.toString());
	}
}

@RefreshScope
@Configuration
@ConfigurationProperties(prefix = "api")
class UserProp {
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserProp{" +
				"username='" + username + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}