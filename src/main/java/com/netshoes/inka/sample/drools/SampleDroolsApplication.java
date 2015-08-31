package com.netshoes.inka.sample.drools;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * The main class, which Spring Boot uses to bootstrap the application.
 *
 * @author Rubens Pasternak
 */
@SpringBootApplication
public class SampleDroolsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleDroolsApplication.class, args);
	}

	/**
	 * By defining the {@link KieContainer} as a bean here, we ensure that
	 * Drools will hunt out the kmodule.xml and rules on application startup.
	 * Those can be found in <code>src/main/resources</code>.
	 * 
	 * @return The {@link KieContainer}.
	 */
	@Bean
	public KieContainer kieContainer() {
		return KieServices.Factory.get().getKieClasspathContainer();
	}

}
