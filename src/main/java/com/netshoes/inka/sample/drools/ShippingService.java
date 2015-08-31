package com.netshoes.inka.sample.drools;

import java.util.Collection;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netshoes.inka.sample.drools.facts.CategoryList;
import com.netshoes.inka.sample.drools.facts.DynamicShipping;
import com.netshoes.inka.sample.drools.facts.Order;
import com.netshoes.inka.sample.drools.facts.SkuList;

@Service
public class ShippingService {

	private final KieContainer kieContainer;

	@Autowired
	public ShippingService(KieContainer kieContainer) {
		this.kieContainer = kieContainer;
	}

	public DynamicShipping calculate(Order order) {

		KieSession kieSession = kieContainer.newKieSession("SampleKieSession");

		SkuList skuList = new SkuList();
		skuList.addSkuCode("000-000-0000");
		skuList.addSkuCode("333-000-0000");
		kieSession.insert(skuList);

		CategoryList categoryList = new CategoryList();
		categoryList.addCategoryCode("CAT_TRES");
		categoryList.addCategoryCode("CAT_QUATRO");
		kieSession.insert(categoryList);

		kieSession.insert(order);

		DynamicShipping dynamicShipping = new DynamicShipping();
		kieSession.insert(dynamicShipping);
		// kieSession.setGlobal("result", dynamicShipping);

		// Agenda agenda = kieSession.getAgenda();
		// agenda.getAgendaGroup("elegibilidade").setFocus();
		// agenda.getAgendaGroup("desconto").setFocus();
		// agenda.getAgendaGroup("acrescimo").setFocus();

		kieSession.fireAllRules();

		printFactsMessage(kieSession);

		kieSession.dispose();

		return dynamicShipping;
	}

	/**
	 * Print out details of all facts in working memory. Handy for debugging.
	 */
	private void printFactsMessage(KieSession kieSession) {
		Collection<FactHandle> allHandles = kieSession.getFactHandles();

		String msg = "\nAll facts:\n";
		for (FactHandle handle : allHandles) {
			msg += "    " + kieSession.getObject(handle) + "\n";
		}
		System.out.println(msg);
	}

}
