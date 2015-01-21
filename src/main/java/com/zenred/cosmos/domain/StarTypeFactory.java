package com.zenred.cosmos.domain;

import java.util.HashMap;
import java.util.Map;

public enum StarTypeFactory {
	sg2o("sg2o"){
		
	},
	sg2b("sg2b"){
		
	},
	sg2a("sg2a"){
	},
	sg2f("sg2f"){
	},
	sg2g("sg2g"){
	},
	sg2k("sg2k"){
	},
	sg2m("sg2m"){
	},
	sg1o("sg1o"){
	},
	sg1b("sg1b"){
	},
	sg1a("sg1a"){
	},
	sg1f("sg1f"){
	},
	sg1g("sg1g"){
	},
	sg1k("sg1k"){
	},
	sg1m("sg1m"){
	},
	g2o("g2o"){
	},
	g2b("g2b"){
	},
	g2a("g2a"){
	},
	g2f("g2f"){
	},
	g2g("g2g"){
	},
	g2k("g2k"){
	},
	g2m("g2m"){
	},
	g1o("g1o"){
	},
	g1b("g1b"){
	},
	g1a("g1a"){
	},
	g1f("g1f"){
	},
	g1g("g1g"){
	},
	g1k("g1k"){
	},
	g1m("g1m"){
	},
	sbgo("sbgo"){
	},
	sbgb("sbgb"){
	},
	sbga("sbga"){
	},
	sbgf("sbgf"){
	},
	sbgg("sbgg"){
	},
	sbgk("sbgk"){
	},
	sbgm("sbgm"){
	},
	o("o"){
	},
	b("b"){
	},
	a("a"){
	},
	f("f"){
	},
	g("g"){
	},
	k("k"){
	},
	m("m"){
	},
	sdo("sdo"){
	},
	sdb("sdb"){
	},
	sda("sda"){
	},
	sdf("sdf"){
	},
	sdg("sdg"){
	},
	sdk("sdk"){
	},
	sdm("sdm"){
	},
	dwo("do"){
	},
	db("db"){
	},
	da("da"){
	},
	df("df"){
	},
	dg("dg"){
	},
	dk("dk"){
	},
	dm("dm"){
	},
	pmd("pmd"){
	},
	bs("bs"){
	},
	dbs("dbs"){
	}
	;
	private String type;
	private StarTypeFactory (String type){
		this.type = type;
	}
	private static Map<StarTypeFactory,Map<Short, Double>> starLum = new HashMap<StarTypeFactory, Map<Short,Double>>();
	static{
		Map<Short,Double> sg2oMap = new HashMap<Short, Double>();
		sg2oMap.put(new Short("0"), new Double(1.69e8));
		sg2oMap.put(new Short("1"), new Double(1.21e8));
		sg2oMap.put(new Short("2"), new Double(1.81e7));
		sg2oMap.put(new Short("3"), new Double(1.89e6));
		sg2oMap.put(new Short("4"), new Double(1.32e6));		
		sg2oMap.put(new Short("5"), new Double(1.17e6));		
		sg2oMap.put(new Short("6"), new Double(1.07e6));		
		sg2oMap.put(new Short("7"), new Double(9.96e5));		
		sg2oMap.put(new Short("8"), new Double(8.8e5));		
		sg2oMap.put(new Short("9"), new Double(6.98e5));	
		starLum.put(StarTypeFactory.sg2o, sg2oMap);
		Map<Short,Double> sg2bMap = new HashMap<Short, Double>();
		sg2bMap.put(new Short("0"), new Double(5.6e5));
		sg2bMap.put(new Short("1"), new Double(4.78e5));
		sg2bMap.put(new Short("2"), new Double(4.24e5));
		sg2bMap.put(new Short("3"), new Double(3.78e5));
		sg2bMap.put(new Short("4"), new Double(2.89e5));		
		sg2bMap.put(new Short("5"), new Double(2.41e5));		
		sg2bMap.put(new Short("6"), new Double(2.01e5));		
		sg2bMap.put(new Short("7"), new Double(1.82e5));		
		sg2bMap.put(new Short("8"), new Double(1.63e5));		
		sg2bMap.put(new Short("9"), new Double(1.44e5));	
		starLum.put(StarTypeFactory.sg2b, sg2bMap);
		Map<Short,Double> sg2aMap = new HashMap<Short, Double>();
		sg2aMap.put(new Short("0"), new Double(1.07e5));
		sg2aMap.put(new Short("1"), new Double(9.56e4));
		sg2aMap.put(new Short("2"), new Double(9.04e4));
		sg2aMap.put(new Short("3"), new Double(8.75e4));
		sg2aMap.put(new Short("4"), new Double(8.56e4));		
		sg2aMap.put(new Short("5"), new Double(8.11e4));		
		sg2aMap.put(new Short("6"), new Double(7.64e4));		
		sg2aMap.put(new Short("7"), new Double(7.32e4));		
		sg2aMap.put(new Short("8"), new Double(7.18e4));		
		sg2aMap.put(new Short("9"), new Double(6.6e4));	
		starLum.put(StarTypeFactory.sg2a, sg2aMap);
		Map<Short,Double> sg2fMap = new HashMap<Short, Double>();
		sg2fMap.put(new Short("0"), new Double(6.1e4));
		sg2fMap.put(new Short("1"), new Double(5.87e4));
		sg2fMap.put(new Short("2"), new Double(5.7e4));
		sg2fMap.put(new Short("3"), new Double(5.5e4));
		sg2fMap.put(new Short("4"), new Double(5.3e4));		
		sg2fMap.put(new Short("5"), new Double(5.47e4));		
		sg2fMap.put(new Short("6"), new Double(5.62e4));		
		sg2fMap.put(new Short("7"), new Double(5.89e4));		
		sg2fMap.put(new Short("8"), new Double(6.26e4));		
		sg2fMap.put(new Short("9"), new Double(6.41e4));	
		starLum.put(StarTypeFactory.sg2f, sg2fMap);
		Map<Short,Double> sg2gMap = new HashMap<Short, Double>();
		sg2gMap.put(new Short("0"), new Double(6.7e4));
		sg2gMap.put(new Short("1"), new Double(7.1e4));
		sg2gMap.put(new Short("2"), new Double(7.5e4));
		sg2gMap.put(new Short("3"), new Double(7.9e4));
		sg2gMap.put(new Short("4"), new Double(8.4e4));		
		sg2gMap.put(new Short("5"), new Double(8.8e4));		
		sg2gMap.put(new Short("6"), new Double(9.1e4));		
		sg2gMap.put(new Short("7"), new Double(9.24e4));		
		sg2gMap.put(new Short("8"), new Double(9.38e4));		
		sg2gMap.put(new Short("9"), new Double(9.54e4));	
		starLum.put(StarTypeFactory.sg2g, sg2gMap);
		Map<Short,Double> sg2kMap = new HashMap<Short, Double>();
		sg2kMap.put(new Short("0"), new Double(9.7e4));
		sg2kMap.put(new Short("1"), new Double(9.9e4));
		sg2kMap.put(new Short("2"), new Double(1.01e5));
		sg2kMap.put(new Short("3"), new Double(1.03e5));
		sg2kMap.put(new Short("4"), new Double(1.05e5));		
		sg2kMap.put(new Short("5"), new Double(1.07e5));		
		sg2kMap.put(new Short("6"), new Double(1.09e5));		
		sg2kMap.put(new Short("7"), new Double(1.11e5));		
		sg2kMap.put(new Short("8"), new Double(1.13e5));		
		sg2kMap.put(new Short("9"), new Double(1.15e5));	
		starLum.put(StarTypeFactory.sg2k, sg2kMap);
		Map<Short,Double> sg2mMap = new HashMap<Short, Double>();
		sg2mMap.put(new Short("0"), new Double(1.17e5));
		sg2mMap.put(new Short("1"), new Double(1.19e5));
		sg2mMap.put(new Short("2"), new Double(1.21e5));
		sg2mMap.put(new Short("3"), new Double(1.24e5));
		sg2mMap.put(new Short("4"), new Double(1.27e5));		
		sg2mMap.put(new Short("5"), new Double(1.30e5));		
		sg2mMap.put(new Short("6"), new Double(1.33e5));		
		sg2mMap.put(new Short("7"), new Double(1.35e5));		
		sg2mMap.put(new Short("8"), new Double(1.37e5));		
		sg2mMap.put(new Short("9"), new Double(1.41e5));	
		starLum.put(StarTypeFactory.sg2m, sg2mMap);
		Map<Short,Double> sg1oMap = new HashMap<Short, Double>();
		sg1oMap.put(new Short("0"), new Double(1.81e6));
		sg1oMap.put(new Short("1"), new Double(1.42e6));
		sg1oMap.put(new Short("2"), new Double(1.03e6));
		sg1oMap.put(new Short("3"), new Double(9.8e5));
		sg1oMap.put(new Short("4"), new Double(9.1e5));		
		sg1oMap.put(new Short("5"), new Double(8.6e5));		
		sg1oMap.put(new Short("6"), new Double(7.9e5));		
		sg1oMap.put(new Short("7"), new Double(6.7e5));		
		sg1oMap.put(new Short("8"), new Double(5.3e5));		
		sg1oMap.put(new Short("9"), new Double(3.8e5));	
		starLum.put(StarTypeFactory.sg1o, sg1oMap);
		Map<Short,Double> sg1bMap = new HashMap<Short, Double>();
		sg1bMap.put(new Short("0"), new Double(2.7e5));
		sg1bMap.put(new Short("1"), new Double(2.34e5));
		sg1bMap.put(new Short("2"), new Double(1.81e5));
		sg1bMap.put(new Short("3"), new Double(1.22e5));
		sg1bMap.put(new Short("4"), new Double(9.13e4));		
		sg1bMap.put(new Short("5"), new Double(7.26e5));		
		sg1bMap.put(new Short("6"), new Double(4.03e4));		
		sg1bMap.put(new Short("7"), new Double(3.28e4));		
		sg1bMap.put(new Short("8"), new Double(2.76e4));		
		sg1bMap.put(new Short("9"), new Double(2.13e4));	
		starLum.put(StarTypeFactory.sg1b, sg1bMap);
		Map<Short,Double> sg1aMap = new HashMap<Short, Double>();
		sg1aMap.put(new Short("0"), new Double(1.5e4));
		sg1aMap.put(new Short("1"), new Double(1.45e4));
		sg1aMap.put(new Short("2"), new Double(1.4e4));
		sg1aMap.put(new Short("3"), new Double(1.3e4));
		sg1aMap.put(new Short("4"), new Double(1.2e4));		
		sg1aMap.put(new Short("5"), new Double(1.17e4));		
		sg1aMap.put(new Short("6"), new Double(1.14e4));		
		sg1aMap.put(new Short("7"), new Double(1.09e4));		
		sg1aMap.put(new Short("8"), new Double(9.8e3));		
		sg1aMap.put(new Short("9"), new Double(8.1e3));	
		starLum.put(StarTypeFactory.sg1a, sg1aMap);
		Map<Short,Double> sg1fMap = new HashMap<Short, Double>();
		sg1fMap.put(new Short("0"), new Double(7.4e3));
		sg1fMap.put(new Short("1"), new Double(6.8e3));
		sg1fMap.put(new Short("2"), new Double(6.4e3));
		sg1fMap.put(new Short("3"), new Double(5.9e3));
		sg1fMap.put(new Short("4"), new Double(5.5e3));		
		sg1fMap.put(new Short("5"), new Double(5.4e3));		
		sg1fMap.put(new Short("6"), new Double(5.3e3));		
		sg1fMap.put(new Short("7"), new Double(5.4e3));		
		sg1fMap.put(new Short("8"), new Double(5.5e3));		
		sg1fMap.put(new Short("9"), new Double(5.8e3));	
		starLum.put(StarTypeFactory.sg1f, sg1fMap);
		Map<Short,Double> sg1gMap = new HashMap<Short, Double>();
		sg1gMap.put(new Short("0"), new Double(6.1e3));
		sg1gMap.put(new Short("1"), new Double(6.5e3));
		sg1gMap.put(new Short("2"), new Double(6.9e3));
		sg1gMap.put(new Short("3"), new Double(7.4e3));
		sg1gMap.put(new Short("4"), new Double(7.7e3));		
		sg1gMap.put(new Short("5"), new Double(8.1e3));		
		sg1gMap.put(new Short("6"), new Double(9.1e3));		
		sg1gMap.put(new Short("7"), new Double(9.8e3));		
		sg1gMap.put(new Short("8"), new Double(1.01e4));		
		sg1gMap.put(new Short("9"), new Double(1.12e4));	
		starLum.put(StarTypeFactory.sg1g, sg1gMap);
		Map<Short,Double> sg1kMap = new HashMap<Short, Double>();
		sg1kMap.put(new Short("0"), new Double(1.17e4));
		sg1kMap.put(new Short("1"), new Double(1.23e4));
		sg1kMap.put(new Short("2"), new Double(1.46e4));
		sg1kMap.put(new Short("3"), new Double(1.65e4));
		sg1kMap.put(new Short("4"), new Double(1.81e4));		
		sg1kMap.put(new Short("5"), new Double(2.09e4));		
		sg1kMap.put(new Short("6"), new Double(2.32e4));		
		sg1kMap.put(new Short("7"), new Double(2.87e4));		
		sg1kMap.put(new Short("8"), new Double(3.16e4));		
		sg1kMap.put(new Short("9"), new Double(3.89e4));	
		starLum.put(StarTypeFactory.sg1k, sg1kMap);
		Map<Short,Double> sg1mMap = new HashMap<Short, Double>();
		sg1mMap.put(new Short("0"), new Double(4.6e4));
		sg1mMap.put(new Short("1"), new Double(5.39e4));
		sg1mMap.put(new Short("2"), new Double(6.01e4));
		sg1mMap.put(new Short("3"), new Double(6.95e4));
		sg1mMap.put(new Short("4"), new Double(7.82e4));		
		sg1mMap.put(new Short("5"), new Double(8.45e4));		
		sg1mMap.put(new Short("6"), new Double(9.01e4));		
		sg1mMap.put(new Short("7"), new Double(9.87e4));		
		sg1mMap.put(new Short("8"), new Double(1.08e5));		
		sg1mMap.put(new Short("9"), new Double(1.17e5));	
		starLum.put(StarTypeFactory.sg1m, sg1mMap);
		Map<Short,Double> g2oMap = new HashMap<Short, Double>();
		g2oMap.put(new Short("0"), new Double(9.9e5));
		g2oMap.put(new Short("1"), new Double(8.4e5));
		g2oMap.put(new Short("2"), new Double(7.8e5));
		g2oMap.put(new Short("3"), new Double(6.9e5));
		g2oMap.put(new Short("4"), new Double(5.1e5));		
		g2oMap.put(new Short("5"), new Double(4.7e5));		
		g2oMap.put(new Short("6"), new Double(3.8e5));		
		g2oMap.put(new Short("7"), new Double(3.3e5));		
		g2oMap.put(new Short("8"), new Double(2.9e5));		
		g2oMap.put(new Short("9"), new Double(2.1e5));	
		starLum.put(StarTypeFactory.g2o, g2oMap);
		Map<Short,Double> g2bMap = new HashMap<Short, Double>();
		g2bMap.put(new Short("0"), new Double(1.7e5));
		g2bMap.put(new Short("1"), new Double(1.43e5));
		g2bMap.put(new Short("2"), new Double(1.09e5));
		g2bMap.put(new Short("3"), new Double(8.34e4));
		g2bMap.put(new Short("4"), new Double(4.88e4));		
		g2bMap.put(new Short("5"), new Double(2.76e4));		
		g2bMap.put(new Short("6"), new Double(1.53e4));		
		g2bMap.put(new Short("7"), new Double(9.78e3));		
		g2bMap.put(new Short("8"), new Double(8.76e3));		
		g2bMap.put(new Short("9"), new Double(5.48e3));	
		starLum.put(StarTypeFactory.g2b, g2bMap);
		Map<Short,Double> g2aMap = new HashMap<Short, Double>();
		g2aMap.put(new Short("0"), new Double(2.2e3));
		g2aMap.put(new Short("1"), new Double(1.92e3));
		g2aMap.put(new Short("2"), new Double(1.66e3));
		g2aMap.put(new Short("3"), new Double(1.44e3));
		g2aMap.put(new Short("4"), new Double(1.12e3));		
		g2aMap.put(new Short("5"), new Double(988.0));		
		g2aMap.put(new Short("6"), new Double(750.0));		
		g2aMap.put(new Short("7"), new Double(701.0));		
		g2aMap.put(new Short("8"), new Double(650.0));		
		g2aMap.put(new Short("9"), new Double(625.0));	
		starLum.put(StarTypeFactory.g2a, g2aMap);
		Map<Short,Double> g2fMap = new HashMap<Short, Double>();
		Map<Short,Double> g2gMap = new HashMap<Short, Double>();
		Map<Short,Double> g2kMap = new HashMap<Short, Double>();
		Map<Short,Double> g2mMap = new HashMap<Short, Double>();
		Map<Short,Double> g1oMap = new HashMap<Short, Double>();
		Map<Short,Double> g1bMap = new HashMap<Short, Double>();
		Map<Short,Double> g1aMap = new HashMap<Short, Double>();
		Map<Short,Double> g1fMap = new HashMap<Short, Double>();
		Map<Short,Double> g1gMap = new HashMap<Short, Double>();
		Map<Short,Double> g1kMap = new HashMap<Short, Double>();
		Map<Short,Double> g1mMap = new HashMap<Short, Double>();
		Map<Short,Double> sbgoMap = new HashMap<Short, Double>();
		Map<Short,Double> sbgbMap = new HashMap<Short, Double>();
		Map<Short,Double> sbgaMap = new HashMap<Short, Double>();
		Map<Short,Double> sbgfMap = new HashMap<Short, Double>();
		Map<Short,Double> sbggMap = new HashMap<Short, Double>();
		Map<Short,Double> sbgkMap = new HashMap<Short, Double>();
		Map<Short,Double> sbgmMap = new HashMap<Short, Double>();
		Map<Short,Double> oMap = new HashMap<Short, Double>();
		Map<Short,Double> bMap = new HashMap<Short, Double>();
		Map<Short,Double> aMap = new HashMap<Short, Double>();
		Map<Short,Double> fMap = new HashMap<Short, Double>();
		Map<Short,Double> gMap = new HashMap<Short, Double>();
		Map<Short,Double> kMap = new HashMap<Short, Double>();
		Map<Short,Double> mMap = new HashMap<Short, Double>();
		Map<Short,Double> sdoMap = new HashMap<Short, Double>();
		Map<Short,Double> sdbMap = new HashMap<Short, Double>();
		Map<Short,Double> sdaMap = new HashMap<Short, Double>();
		Map<Short,Double> sdfMap = new HashMap<Short, Double>();
		Map<Short,Double> sdgMap = new HashMap<Short, Double>();
		Map<Short,Double> sdkMap = new HashMap<Short, Double>();
		Map<Short,Double> sdmMap = new HashMap<Short, Double>();
		Map<Short,Double> dwoMap = new HashMap<Short, Double>();
		Map<Short,Double> dbMap = new HashMap<Short, Double>();
		Map<Short,Double> daMap = new HashMap<Short, Double>();
		Map<Short,Double> dfMap = new HashMap<Short, Double>();
		Map<Short,Double> dgMap = new HashMap<Short, Double>();
		Map<Short,Double> dkMap = new HashMap<Short, Double>();
		Map<Short,Double> pmdMap = new HashMap<Short, Double>();
		Map<Short,Double> bsMap = new HashMap<Short, Double>();
		Map<Short,Double> dbsMap = new HashMap<Short, Double>();
	}

}
