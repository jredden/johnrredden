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
		Map<Short,Double> sg2aMap = new HashMap<Short, Double>();
		Map<Short,Double> sg2fMap = new HashMap<Short, Double>();
		Map<Short,Double> sg2gMap = new HashMap<Short, Double>();
		Map<Short,Double> sg2kMap = new HashMap<Short, Double>();
		Map<Short,Double> sg2mMap = new HashMap<Short, Double>();
		Map<Short,Double> sg1oMap = new HashMap<Short, Double>();
		Map<Short,Double> sg1bMap = new HashMap<Short, Double>();
		Map<Short,Double> sg1aMap = new HashMap<Short, Double>();
		Map<Short,Double> sg1fMap = new HashMap<Short, Double>();
		Map<Short,Double> sg1gMap = new HashMap<Short, Double>();
		Map<Short,Double> sg1kMap = new HashMap<Short, Double>();
		Map<Short,Double> sg1mMap = new HashMap<Short, Double>();
		Map<Short,Double> g2oMap = new HashMap<Short, Double>();
		Map<Short,Double> g2bMap = new HashMap<Short, Double>();
		Map<Short,Double> g2aMap = new HashMap<Short, Double>();
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
