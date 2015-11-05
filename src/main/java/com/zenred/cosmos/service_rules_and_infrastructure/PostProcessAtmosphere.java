package com.zenred.cosmos.service_rules_and_infrastructure;

import java.util.List;
import java.util.Properties;

import org.kie.api.KieServices;
import org.kie.api.event.rule.DebugAgendaEventListener;
import org.kie.api.event.rule.DebugRuleRuntimeEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.zenred.cosmos.domain.Atmosphere;
import com.zenred.cosmos.domain.Planetoid;


public class PostProcessAtmosphere {
	
	
	public static String NATIVE = "NATIVE";
	public static String JAVA_COMPILER_PROPERTY = "drools.dialect.java.compiler";
	
	
	public static void processByRules(List<Atmosphere> atmospheres, Planetoid planetoid){
		Properties properties = System.getProperties();
		properties.setProperty(JAVA_COMPILER_PROPERTY, NATIVE);
        KieContainer kc = KieServices.Factory.get().getKieClasspathContainer();
        KieSession ksession = kc.newKieSession("PostProcessAtmosphere");
        ksession.addEventListener( new DebugAgendaEventListener() );
        ksession.addEventListener( new DebugRuleRuntimeEventListener() );
        ksession.insert(planetoid);
        ksession.insert(new RadiusRangeConst());
        ksession.insert(new TemperatureRangeConst());
               ksession.fireAllRules();
 
        for(Atmosphere atmosphere : atmospheres){
        	ksession.insert(atmosphere);
        }
        ksession.fireAllRules();
        
        ksession.dispose(); // Stateful rule session must always be disposed when finished

	}

}
