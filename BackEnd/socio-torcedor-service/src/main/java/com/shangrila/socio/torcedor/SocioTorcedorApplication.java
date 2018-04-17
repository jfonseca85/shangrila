package com.shangrila.socio.torcedor;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
//for jsr310 java 8 java.time.*
@EntityScan( basePackageClasses = {SocioTorcedorApplication.class, Jsr310JpaConverters.class})
@EnableFeignClients("com.shangrila.socio.torcedor")
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
public class SocioTorcedorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocioTorcedorApplication.class, args);
	}
	
	@Bean
	public LocaleResolver localeResolver() {
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}
}
