package com.zenred.cosmos.service_rules_and_infrastructure;

import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;


import com.zenred.cosmos.domain.Atmosphere;
import com.zenred.cosmos.domain.Planetoid;


public class PostProcessAtmosphere {
	
	public static void processByRules(List<Atmosphere> atmospheres, Planetoid planetoid){
        KieContainer kc = KieServices.Factory.get().getKieClasspathContainer();
        KieSession ksession = kc.newKieSession("PostProcessAtmosphere");
        ksession.insert(planetoid);
        for(Atmosphere atmosphere : atmospheres){
        	ksession.insert(atmosphere);
        }
        ksession.fireAllRules();
        ksession.dispose(); // Stateful rule session must always be disposed when finished

	}

}
