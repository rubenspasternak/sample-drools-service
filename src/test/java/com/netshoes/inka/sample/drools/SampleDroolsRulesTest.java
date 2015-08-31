package com.netshoes.inka.sample.drools;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class SampleDroolsRulesTest {

	private KieServices kieServices;
	private KieContainer kieContainer;
	private KieSession kieSession;

	@Before
	public void initialize() {
		if (kieSession != null) {
			kieSession.dispose();
		}
		this.kieServices = KieServices.Factory.get();
		this.kieContainer = kieServices.getKieClasspathContainer();
		this.kieSession = kieContainer.newKieSession("SampleKieSession");
	}

	/**
	 * If this passes, then the {@link KieSession} was initialized and injected
	 * into the Spring components.
	 */
	@Test
	public void shouldConfigureDroolsComponents() {
		assertNotNull(kieSession);
	}

}
