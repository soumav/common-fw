package com.soumav.commonfw.configurations.cassandra;

import java.net.URISyntaxException;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.cassandra.CqlSessionBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Soumav
 *
 */
@Configuration
@Slf4j
@PropertySource("classpath:app.properties")
public class AstraCassandraConfig {

	@Value("${astra.datastax.clientid}")
	private String clientId;

	@Value("${astra.datastax.clientsecret}")
	private String clientSecret;

	@Value("${astra.datastax.configzip.path}")
	private String astraConfigzipPath;

	@Bean
	public CqlSessionBuilderCustomizer sessionBuilderCustomizer() {
		return builder -> {
			try {
				builder.withCloudSecureConnectBundle(
						Paths.get(ClassLoader.getSystemResource(astraConfigzipPath).toURI()))
						.withAuthCredentials(clientId, clientSecret);
			} catch (URISyntaxException e) {
				log.error("Error occured while creating sessionBuilderCustomizer: {}", e.toString());
			}
		};
	}

}