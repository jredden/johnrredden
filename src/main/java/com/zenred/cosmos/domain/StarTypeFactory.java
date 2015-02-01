package com.zenred.cosmos.domain;

import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;

import com.zenred.util.GenRandomRolls;

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
	
	static private Logger logger = Logger.getLogger(StarTypeFactory.class);
	
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
		g2fMap.put(new Short("0"), new Double(600.0));
		g2fMap.put(new Short("1"), new Double(584.0));
		g2fMap.put(new Short("2"), new Double(564.0));
		g2fMap.put(new Short("3"), new Double(545.0));
		g2fMap.put(new Short("4"), new Double(531.0));		
		g2fMap.put(new Short("5"), new Double(510.0));		
		g2fMap.put(new Short("6"), new Double(530.0));		
		g2fMap.put(new Short("7"), new Double(538.0));		
		g2fMap.put(new Short("8"), new Double(545.0));		
		g2fMap.put(new Short("9"), new Double(550.0));	
		starLum.put(StarTypeFactory.g2f, g2fMap);
		Map<Short,Double> g2gMap = new HashMap<Short, Double>();
		g2gMap.put(new Short("0"), new Double(560.0));
		g2gMap.put(new Short("1"), new Double(622.0));
		g2gMap.put(new Short("2"), new Double(680.0));
		g2gMap.put(new Short("3"), new Double(690.0));
		g2gMap.put(new Short("4"), new Double(700.0));		
		g2gMap.put(new Short("5"), new Double(740.0));		
		g2gMap.put(new Short("6"), new Double(760.0));		
		g2gMap.put(new Short("7"), new Double(788.0));		
		g2gMap.put(new Short("8"), new Double(820.0));		
		g2gMap.put(new Short("9"), new Double(850.0));	
		starLum.put(StarTypeFactory.g2g, g2gMap);
		Map<Short,Double> g2kMap = new HashMap<Short, Double>();
		g2kMap.put(new Short("0"), new Double(890.0));
		g2kMap.put(new Short("1"), new Double(1.13e3));
		g2kMap.put(new Short("2"), new Double(1.49e3));
		g2kMap.put(new Short("3"), new Double(1.78e3));
		g2kMap.put(new Short("4"), new Double(2.05e3));		
		g2kMap.put(new Short("5"), new Double(2.45e3));		
		g2kMap.put(new Short("6"), new Double(2.9e3));		
		g2kMap.put(new Short("7"), new Double(3.3e3));		
		g2kMap.put(new Short("8"), new Double(3.7e3));		
		g2kMap.put(new Short("9"), new Double(4.1e3));	
		starLum.put(StarTypeFactory.g2k, g2kMap);
		Map<Short,Double> g2mMap = new HashMap<Short, Double>();
		g2mMap.put(new Short("0"), new Double(4.6e3));
		g2mMap.put(new Short("1"), new Double(6.1e3));
		g2mMap.put(new Short("2"), new Double(8.2e3));
		g2mMap.put(new Short("3"), new Double(9.98e3));
		g2mMap.put(new Short("4"), new Double(1.18e4));		
		g2mMap.put(new Short("5"), new Double(1.34e4));		
		g2mMap.put(new Short("6"), new Double(1.52e4));		
		g2mMap.put(new Short("7"), new Double(1.55e4));		
		g2mMap.put(new Short("8"), new Double(1.58e4));		
		g2mMap.put(new Short("9"), new Double(1.63e4));	
		starLum.put(StarTypeFactory.g2m, g2mMap);
		Map<Short,Double> g1oMap = new HashMap<Short, Double>();
		g1oMap.put(new Short("0"), new Double(7.1e5));
		g1oMap.put(new Short("1"), new Double(6.21e5));
		g1oMap.put(new Short("2"), new Double(5.38e5));
		g1oMap.put(new Short("3"), new Double(3.89e5));
		g1oMap.put(new Short("4"), new Double(2.11e5));		
		g1oMap.put(new Short("5"), new Double(1.86e5));		
		g1oMap.put(new Short("6"), new Double(1.69e5));		
		g1oMap.put(new Short("7"), new Double(1.56e5));		
		g1oMap.put(new Short("8"), new Double(1.42e5));		
		g1oMap.put(new Short("9"), new Double(1.28e5));	
		starLum.put(StarTypeFactory.g1o, g1oMap);
		Map<Short,Double> g1bMap = new HashMap<Short, Double>();
		g1bMap.put(new Short("0"), new Double(1.07e5));
		g1bMap.put(new Short("1"), new Double(5.06e4));
		g1bMap.put(new Short("2"), new Double(1.89e4));
		g1bMap.put(new Short("3"), new Double(4.23e4));
		g1bMap.put(new Short("4"), new Double(9.98e3));		
		g1bMap.put(new Short("5"), new Double(6.7e3));		
		g1bMap.put(new Short("6"), new Double(3.26e3));		
		g1bMap.put(new Short("7"), new Double(2.82e3));		
		g1bMap.put(new Short("8"), new Double(2.61e3));		
		g1bMap.put(new Short("9"), new Double(1.09e3));	
		starLum.put(StarTypeFactory.g1b, g1bMap);
		Map<Short,Double> g1aMap = new HashMap<Short, Double>();
		g1aMap.put(new Short("0"), new Double(280.0));
		g1aMap.put(new Short("1"), new Double(245.0));
		g1aMap.put(new Short("2"), new Double(199.0));
		g1aMap.put(new Short("3"), new Double(146.7));
		g1aMap.put(new Short("4"), new Double(110.0));		
		g1aMap.put(new Short("5"), new Double(90.0));		
		g1aMap.put(new Short("6"), new Double(72.0));		
		g1aMap.put(new Short("7"), new Double(68.0));		
		g1aMap.put(new Short("8"), new Double(62.0));		
		g1aMap.put(new Short("9"), new Double(58.0));	
		starLum.put(StarTypeFactory.g1a, g1aMap);
		Map<Short,Double> g1fMap = new HashMap<Short, Double>();
		g1fMap.put(new Short("0"), new Double(53.0));
		g1fMap.put(new Short("1"), new Double(51.0));
		g1fMap.put(new Short("2"), new Double(49.0));
		g1fMap.put(new Short("3"), new Double(47.0));
		g1fMap.put(new Short("4"), new Double(45.0));		
		g1fMap.put(new Short("5"), new Double(43.0));		
		g1fMap.put(new Short("6"), new Double(46.0));		
		g1fMap.put(new Short("7"), new Double(47.5));		
		g1fMap.put(new Short("8"), new Double(49.0));		
		g1fMap.put(new Short("9"), new Double(50.0));	
		starLum.put(StarTypeFactory.g1f, g1fMap);
		Map<Short,Double> g1gMap = new HashMap<Short, Double>();
		g1gMap.put(new Short("0"), new Double(50.2));
		g1gMap.put(new Short("1"), new Double(54.9));
		g1gMap.put(new Short("2"), new Double(60.0));
		g1gMap.put(new Short("3"), new Double(65.0));
		g1gMap.put(new Short("4"), new Double(70.0));		
		g1gMap.put(new Short("5"), new Double(75.0));		
		g1gMap.put(new Short("6"), new Double(79.0));		
		g1gMap.put(new Short("7"), new Double(80.7));		
		g1gMap.put(new Short("8"), new Double(82.0));		
		g1gMap.put(new Short("9"), new Double(90.0));	
		starLum.put(StarTypeFactory.g1g, g1gMap);
		Map<Short,Double> g1kMap = new HashMap<Short, Double>();
		g1kMap.put(new Short("0"), new Double(95.0));
		g1kMap.put(new Short("1"), new Double(146.0));
		g1kMap.put(new Short("2"), new Double(185.0));
		g1kMap.put(new Short("3"), new Double(231.0));
		g1kMap.put(new Short("4"), new Double(275.0));		
		g1kMap.put(new Short("5"), new Double(320.0));		
		g1kMap.put(new Short("6"), new Double(350.0));		
		g1kMap.put(new Short("7"), new Double(381.0));		
		g1kMap.put(new Short("8"), new Double(410.0));		
		g1kMap.put(new Short("9"), new Double(440.0));	
		starLum.put(StarTypeFactory.g1k, g1kMap);
		Map<Short,Double> g1mMap = new HashMap<Short, Double>();
		g1mMap.put(new Short("0"), new Double(470.0));
		g1mMap.put(new Short("1"), new Double(498.0));
		g1mMap.put(new Short("2"), new Double(1.38e3));
		g1mMap.put(new Short("3"), new Double(1.55e3));
		g1mMap.put(new Short("4"), new Double(1.71e3));		
		g1mMap.put(new Short("5"), new Double(2.28e3));		
		g1mMap.put(new Short("6"), new Double(2.37e3));		
		g1mMap.put(new Short("7"), new Double(2.44e3));		
		g1mMap.put(new Short("8"), new Double(2.59e3));		
		g1mMap.put(new Short("9"), new Double(2.69e3));	
		starLum.put(StarTypeFactory.g1m, g1mMap);
		Map<Short,Double> sbgoMap = new HashMap<Short, Double>();
		sbgoMap.put(new Short("0"), new Double(2.5e5));
		sbgoMap.put(new Short("1"), new Double(1.26e5));
		sbgoMap.put(new Short("2"), new Double(1.88e5));
		sbgoMap.put(new Short("3"), new Double(1.72e5));
		sbgoMap.put(new Short("4"), new Double(1.58e5));		
		sbgoMap.put(new Short("5"), new Double(1.46e5));		
		sbgoMap.put(new Short("6"), new Double(1.35e5));		
		sbgoMap.put(new Short("7"), new Double(1.26e5));		
		sbgoMap.put(new Short("8"), new Double(1.12e5));		
		sbgoMap.put(new Short("9"), new Double(1.08e5));	
		starLum.put(StarTypeFactory.sbgo, sbgoMap);
		Map<Short,Double> sbgbMap = new HashMap<Short, Double>();
		sbgbMap.put(new Short("0"), new Double(8.1e4));
		sbgbMap.put(new Short("1"), new Double(4.5e4));
		sbgbMap.put(new Short("2"), new Double(1.2e4));
		sbgbMap.put(new Short("3"), new Double(8.3e3));
		sbgbMap.put(new Short("4"), new Double(5.2e3));		
		sbgbMap.put(new Short("5"), new Double(2.0e3));		
		sbgbMap.put(new Short("6"), new Double(1.12e3));		
		sbgbMap.put(new Short("7"), new Double(984.0));		
		sbgbMap.put(new Short("8"), new Double(705.0));		
		sbgbMap.put(new Short("9"), new Double(289.0));	
		starLum.put(StarTypeFactory.sbgb, sbgbMap);
		Map<Short,Double> sbgaMap = new HashMap<Short, Double>();
		sbgaMap.put(new Short("0"), new Double(156.0));
		sbgaMap.put(new Short("1"), new Double(135.0));
		sbgaMap.put(new Short("2"), new Double(124.0));
		sbgaMap.put(new Short("3"), new Double(103.0));
		sbgaMap.put(new Short("4"), new Double(92.0));		
		sbgaMap.put(new Short("5"), new Double(37.0));		
		sbgaMap.put(new Short("6"), new Double(33.0));		
		sbgaMap.put(new Short("7"), new Double(30.5));		
		sbgaMap.put(new Short("8"), new Double(27.0));		
		sbgaMap.put(new Short("9"), new Double(20.0));	
		starLum.put(StarTypeFactory.sbga, sbgaMap);
		Map<Short,Double> sbgfMap = new HashMap<Short, Double>();
		sbgfMap.put(new Short("0"), new Double(19.0));
		sbgfMap.put(new Short("1"), new Double(18.0));
		sbgfMap.put(new Short("2"), new Double(17.0));
		sbgfMap.put(new Short("3"), new Double(16.0));
		sbgfMap.put(new Short("4"), new Double(15.0));		
		sbgfMap.put(new Short("5"), new Double(12.0));		
		sbgfMap.put(new Short("6"), new Double(11.0));		
		sbgfMap.put(new Short("7"), new Double(10.5));		
		sbgfMap.put(new Short("8"), new Double(9.0));		
		sbgfMap.put(new Short("9"), new Double(7.0));	
		starLum.put(StarTypeFactory.sbgf, sbgfMap);
		Map<Short,Double> sbggMap = new HashMap<Short, Double>();
		sbggMap.put(new Short("0"), new Double(6.5));
		sbggMap.put(new Short("1"), new Double(6.24));
		sbggMap.put(new Short("2"), new Double(5.9));
		sbggMap.put(new Short("3"), new Double(5.6));
		sbggMap.put(new Short("4"), new Double(5.3));		
		sbggMap.put(new Short("5"), new Double(4.9));		
		sbggMap.put(new Short("6"), new Double(4.82));		
		sbggMap.put(new Short("7"), new Double(4.78));		
		sbggMap.put(new Short("8"), new Double(4.73));		
		sbggMap.put(new Short("9"), new Double(4.69));	
		starLum.put(StarTypeFactory.sbgg, sbggMap);
		Map<Short,Double> sbgkMap = new HashMap<Short, Double>();
		sbgkMap.put(new Short("0"), new Double(4.67));
		sbgkMap.put(new Short("1"), new Double(4.61));
		sbgkMap.put(new Short("2"), new Double(4.55));
		sbgkMap.put(new Short("3"), new Double(4.48));
		sbgkMap.put(new Short("4"), new Double(4.41));		
		sbgkMap.put(new Short("5"), new Double(4.40));		
		sbgkMap.put(new Short("6"), new Double(4.39));		
		sbgkMap.put(new Short("7"), new Double(4.37));		
		sbgkMap.put(new Short("8"), new Double(4.35));		
		sbgkMap.put(new Short("9"), new Double(4.33));	
		starLum.put(StarTypeFactory.sbgk, sbgkMap);
		Map<Short,Double> sbgmMap = new HashMap<Short, Double>();
		sbgmMap.put(new Short("0"), new Double(4.32));
		sbgmMap.put(new Short("1"), new Double(4.315));
		sbgmMap.put(new Short("2"), new Double(4.31));
		sbgmMap.put(new Short("3"), new Double(4.309));
		sbgmMap.put(new Short("4"), new Double(4.308));		
		sbgmMap.put(new Short("5"), new Double(4.305));		
		sbgmMap.put(new Short("6"), new Double(4.302));		
		sbgmMap.put(new Short("7"), new Double(4.297));		
		sbgmMap.put(new Short("8"), new Double(4.293));		
		sbgmMap.put(new Short("9"), new Double(4.29));	
		starLum.put(StarTypeFactory.sbgm, sbgmMap);
		Map<Short,Double> oMap = new HashMap<Short, Double>();
		oMap.put(new Short("0"), new Double(1.45e5));
		oMap.put(new Short("1"), new Double(1.41e5));
		oMap.put(new Short("2"), new Double(1.38e5));
		oMap.put(new Short("3"), new Double(1.27e5));
		oMap.put(new Short("4"), new Double(1.23e5));		
		oMap.put(new Short("5"), new Double(1.19e5));		
		oMap.put(new Short("6"), new Double(1.16e5));		
		oMap.put(new Short("7"), new Double(1.12e5));		
		oMap.put(new Short("8"), new Double(1.09e5));		
		oMap.put(new Short("9"), new Double(7.89e4));	
		starLum.put(StarTypeFactory.o, oMap);
		Map<Short,Double> bMap = new HashMap<Short, Double>();
		bMap.put(new Short("0"), new Double(5.6e4));
		bMap.put(new Short("1"), new Double(3.32e4));
		bMap.put(new Short("2"), new Double(1.95e4));
		bMap.put(new Short("3"), new Double(1.23e4));
		bMap.put(new Short("4"), new Double(8.68e3));		
		bMap.put(new Short("5"), new Double(1.410e3));		
		bMap.put(new Short("6"), new Double(729.0));		
		bMap.put(new Short("7"), new Double(673.0));		
		bMap.put(new Short("8"), new Double(495.0));		
		bMap.put(new Short("9"), new Double(281.0));	
		starLum.put(StarTypeFactory.b, bMap);
		Map<Short,Double> aMap = new HashMap<Short, Double>();
		aMap.put(new Short("0"), new Double(90.0));
		aMap.put(new Short("1"), new Double(75.0));
		aMap.put(new Short("2"), new Double(60.0));
		aMap.put(new Short("3"), new Double(45.0));
		aMap.put(new Short("4"), new Double(30.0));		
		aMap.put(new Short("5"), new Double(16.0));		
		aMap.put(new Short("6"), new Double(14.6));		
		aMap.put(new Short("7"), new Double(13.5));		
		aMap.put(new Short("8"), new Double(12.1));		
		aMap.put(new Short("9"), new Double(9.4));	
		starLum.put(StarTypeFactory.a, aMap);
		Map<Short,Double> fMap = new HashMap<Short, Double>();
		fMap.put(new Short("0"), new Double(8.1));
		fMap.put(new Short("1"), new Double(7.65));
		fMap.put(new Short("2"), new Double(5.62));
		fMap.put(new Short("3"), new Double(4.37));
		fMap.put(new Short("4"), new Double(3.18));		
		fMap.put(new Short("5"), new Double(2.76));		
		fMap.put(new Short("6"), new Double(2.32));		
		fMap.put(new Short("7"), new Double(1.84));		
		fMap.put(new Short("8"), new Double(1.55));		
		fMap.put(new Short("9"), new Double(1.52));	
		starLum.put(StarTypeFactory.f, fMap);
		Map<Short,Double> gMap = new HashMap<Short, Double>();
		gMap.put(new Short("0"), new Double(1.2));
		gMap.put(new Short("1"), new Double(1.1));
		gMap.put(new Short("2"), new Double(1.0));
		gMap.put(new Short("3"), new Double(.945));
		gMap.put(new Short("4"), new Double(.814));		
		gMap.put(new Short("5"), new Double(.712));		
		gMap.put(new Short("6"), new Double(.610));		
		gMap.put(new Short("7"), new Double(.558));		
		gMap.put(new Short("8"), new Double(.501));		
		gMap.put(new Short("9"), new Double(.408));	
		starLum.put(StarTypeFactory.g, gMap);
		Map<Short,Double> kMap = new HashMap<Short, Double>();
		kMap.put(new Short("0"), new Double(.363));
		kMap.put(new Short("1"), new Double(.333));
		kMap.put(new Short("2"), new Double(.282));
		kMap.put(new Short("3"), new Double(.257));
		kMap.put(new Short("4"), new Double(.216));		
		kMap.put(new Short("5"), new Double(.184));		
		kMap.put(new Short("6"), new Double(.162));		
		kMap.put(new Short("7"), new Double(.147));		
		kMap.put(new Short("8"), new Double(.123));		
		kMap.put(new Short("9"), new Double(.105));	
		starLum.put(StarTypeFactory.k, kMap);
		Map<Short,Double> mMap = new HashMap<Short, Double>();
		mMap.put(new Short("0"), new Double(.0912));
		mMap.put(new Short("1"), new Double(.0734));
		mMap.put(new Short("2"), new Double(.0595));
		mMap.put(new Short("3"), new Double(.0466));
		mMap.put(new Short("4"), new Double(.0317));		
		mMap.put(new Short("5"), new Double(.0276));		
		mMap.put(new Short("6"), new Double(.0152));		
		mMap.put(new Short("7"), new Double(.0134));		
		mMap.put(new Short("8"), new Double(.0111));		
		mMap.put(new Short("9"), new Double(.0096));	
		starLum.put(StarTypeFactory.m, mMap);
		Map<Short,Double> sdoMap = new HashMap<Short, Double>();
		sdoMap.put(new Short("0"), new Double(11.0));
		sdoMap.put(new Short("1"), new Double(10.5));
		sdoMap.put(new Short("2"), new Double(10.0));
		sdoMap.put(new Short("3"), new Double(9.5));
		sdoMap.put(new Short("4"), new Double(9.0));		
		sdoMap.put(new Short("5"), new Double(8.5));		
		sdoMap.put(new Short("6"), new Double(8.0));		
		sdoMap.put(new Short("7"), new Double(7.5));		
		sdoMap.put(new Short("8"), new Double(7.0));		
		sdoMap.put(new Short("9"), new Double(6.5));	
		starLum.put(StarTypeFactory.sdo, sdoMap);
		Map<Short,Double> sdbMap = new HashMap<Short, Double>();
		sdbMap.put(new Short("0"), new Double(6.0));
		sdbMap.put(new Short("1"), new Double(5.6));
		sdbMap.put(new Short("2"), new Double(5.2));
		sdbMap.put(new Short("3"), new Double(4.8));
		sdbMap.put(new Short("4"), new Double(4.4));		
		sdbMap.put(new Short("5"), new Double(4.0));		
		sdbMap.put(new Short("6"), new Double(4.6));		
		sdbMap.put(new Short("7"), new Double(4.2));		
		sdbMap.put(new Short("8"), new Double(3.2));		
		sdbMap.put(new Short("9"), new Double(3.4));	
		starLum.put(StarTypeFactory.sdb, sdbMap);
		Map<Short,Double> sdaMap = new HashMap<Short, Double>();
		sdaMap.put(new Short("0"), new Double(3.0));
		sdaMap.put(new Short("1"), new Double(2.8));
		sdaMap.put(new Short("2"), new Double(2.6));
		sdaMap.put(new Short("3"), new Double(2.4));
		sdaMap.put(new Short("4"), new Double(2.2));		
		sdaMap.put(new Short("5"), new Double(2.0));		
		sdaMap.put(new Short("6"), new Double(1.8));		
		sdaMap.put(new Short("7"), new Double(1.6));		
		sdaMap.put(new Short("8"), new Double(1.4));		
		sdaMap.put(new Short("9"), new Double(1.2));	
		starLum.put(StarTypeFactory.sda, sdaMap);
		Map<Short,Double> sdfMap = new HashMap<Short, Double>();
		sdfMap.put(new Short("0"), new Double(1.0));
		sdfMap.put(new Short("1"), new Double(.96));
		sdfMap.put(new Short("2"), new Double(.92));
		sdfMap.put(new Short("3"), new Double(.88));
		sdfMap.put(new Short("4"), new Double(.84));		
		sdfMap.put(new Short("5"), new Double(.80));		
		sdfMap.put(new Short("6"), new Double(.76));		
		sdfMap.put(new Short("7"), new Double(.72));		
		sdfMap.put(new Short("8"), new Double(.68));		
		sdfMap.put(new Short("9"), new Double(.64));	
		starLum.put(StarTypeFactory.sdf, sdfMap);
		Map<Short,Double> sdgMap = new HashMap<Short, Double>();
		sdgMap.put(new Short("0"), new Double(.6));
		sdgMap.put(new Short("1"), new Double(.5856));
		sdgMap.put(new Short("2"), new Double(.5712));
		sdgMap.put(new Short("3"), new Double(.5568));
		sdgMap.put(new Short("4"), new Double(.5424));		
		sdgMap.put(new Short("5"), new Double(.528));		
		sdgMap.put(new Short("6"), new Double(.5084));		
		sdgMap.put(new Short("7"), new Double(.4888));		
		sdgMap.put(new Short("8"), new Double(.4692));		
		sdgMap.put(new Short("9"), new Double(.4496));	
		starLum.put(StarTypeFactory.sdg, sdgMap);
		Map<Short,Double> sdkMap = new HashMap<Short, Double>();
		sdkMap.put(new Short("0"), new Double(.43));
		sdkMap.put(new Short("1"), new Double(.41));
		sdkMap.put(new Short("2"), new Double(.39));
		sdkMap.put(new Short("3"), new Double(.37));
		sdkMap.put(new Short("4"), new Double(.35));		
		sdkMap.put(new Short("5"), new Double(.33));		
		sdkMap.put(new Short("6"), new Double(.2948));		
		sdkMap.put(new Short("7"), new Double(.2596));		
		sdkMap.put(new Short("8"), new Double(.2244));		
		sdkMap.put(new Short("9"), new Double(.1892));	
		starLum.put(StarTypeFactory.sdk, sdkMap);
		Map<Short,Double> sdmMap = new HashMap<Short, Double>();
		sdmMap.put(new Short("0"), new Double(.154));
		sdmMap.put(new Short("1"), new Double(.144));
		sdmMap.put(new Short("2"), new Double(.134));
		sdmMap.put(new Short("3"), new Double(.124));
		sdmMap.put(new Short("4"), new Double(.114));		
		sdmMap.put(new Short("5"), new Double(.104));		
		sdmMap.put(new Short("6"), new Double(.0948));		
		sdmMap.put(new Short("7"), new Double(.0856));		
		sdmMap.put(new Short("8"), new Double(.0764));		
		sdmMap.put(new Short("9"), new Double(.0672));	
		starLum.put(StarTypeFactory.sdm, sdmMap);
		Map<Short,Double> dwoMap = new HashMap<Short, Double>();
		dwoMap.put(new Short("0"), new Double(.392));
		dwoMap.put(new Short("1"), new Double(.3574));
		dwoMap.put(new Short("2"), new Double(.3228));
		dwoMap.put(new Short("3"), new Double(.2882));
		dwoMap.put(new Short("4"), new Double(.2536));		
		dwoMap.put(new Short("5"), new Double(.219));		
		dwoMap.put(new Short("6"), new Double(.1844));		
		dwoMap.put(new Short("7"), new Double(.1498));		
		dwoMap.put(new Short("8"), new Double(.1152));		
		dwoMap.put(new Short("9"), new Double(.0806));	
		starLum.put(StarTypeFactory.dwo, dwoMap);
		Map<Short,Double> dbMap = new HashMap<Short, Double>();
		dbMap.put(new Short("0"), new Double(.046));
		dbMap.put(new Short("1"), new Double(.0419));
		dbMap.put(new Short("2"), new Double(.0378));
		dbMap.put(new Short("3"), new Double(.0337));
		dbMap.put(new Short("4"), new Double(.0296));		
		dbMap.put(new Short("5"), new Double(.0255));		
		dbMap.put(new Short("6"), new Double(.0214));		
		dbMap.put(new Short("7"), new Double(.0173));		
		dbMap.put(new Short("8"), new Double(.0132));		
		dbMap.put(new Short("9"), new Double(.0091));	
		starLum.put(StarTypeFactory.db, dbMap);
		Map<Short,Double> daMap = new HashMap<Short, Double>();
		daMap.put(new Short("0"), new Double(5.0e-3));
		daMap.put(new Short("1"), new Double(4.53e-3));
		daMap.put(new Short("2"), new Double(4.06e-3));
		daMap.put(new Short("3"), new Double(3.59e-3));
		daMap.put(new Short("4"), new Double(3.12e-3));		
		daMap.put(new Short("5"), new Double(2.65e-3));		
		daMap.put(new Short("6"), new Double(2.18e-3));		
		daMap.put(new Short("7"), new Double(1.71e-3));		
		daMap.put(new Short("8"), new Double(1.24e-3));		
		daMap.put(new Short("9"), new Double(7.7e-4));	
		starLum.put(StarTypeFactory.da, daMap);
		Map<Short,Double> dfMap = new HashMap<Short, Double>();
		dfMap.put(new Short("0"), new Double(3.0e-4));
		dfMap.put(new Short("1"), new Double(2.76e-4));
		dfMap.put(new Short("2"), new Double(2.52e-4));
		dfMap.put(new Short("3"), new Double(2.28e-4));
		dfMap.put(new Short("4"), new Double(2.04e-4));		
		dfMap.put(new Short("5"), new Double(1.8e-4));		
		dfMap.put(new Short("6"), new Double(1.56e-4));		
		dfMap.put(new Short("7"), new Double(1.32e-4));		
		dfMap.put(new Short("8"), new Double(1.08e-4));		
		dfMap.put(new Short("9"), new Double(8.4e-5));	
		starLum.put(StarTypeFactory.df, dfMap);
		Map<Short,Double> dgMap = new HashMap<Short, Double>();
		dgMap.put(new Short("0"), new Double(6.0e-5));
		dgMap.put(new Short("1"), new Double(5.8e-5));
		dgMap.put(new Short("2"), new Double(5.6e-5));
		dgMap.put(new Short("3"), new Double(5.4e-5));
		dgMap.put(new Short("4"), new Double(5.2e-5));		
		dgMap.put(new Short("5"), new Double(5.0e-5));		
		dgMap.put(new Short("6"), new Double(4.8e-5));		
		dgMap.put(new Short("7"), new Double(4.6e-5));		
		dgMap.put(new Short("8"), new Double(4.4e-5));		
		dgMap.put(new Short("9"), new Double(4.2e-5));	
		starLum.put(StarTypeFactory.dg, dgMap);
		Map<Short,Double> dkMap = new HashMap<Short, Double>();
		dkMap.put(new Short("0"), new Double(4.0e-5));
		dkMap.put(new Short("1"), new Double(3.95e-5));
		dkMap.put(new Short("2"), new Double(3.9e-5));
		dkMap.put(new Short("3"), new Double(3.85e-5));
		dkMap.put(new Short("4"), new Double(3.8e-5));		
		dkMap.put(new Short("5"), new Double(3.75e-5));		
		dkMap.put(new Short("6"), new Double(3.7e-5));		
		dkMap.put(new Short("7"), new Double(3.65e-5));		
		dkMap.put(new Short("8"), new Double(3.6e-5));		
		dkMap.put(new Short("9"), new Double(3.55e-5));	
		starLum.put(StarTypeFactory.dk, dkMap);
		Map<Short,Double> dmMap = new HashMap<Short, Double>();
		dmMap.put(new Short("0"), new Double(3.0e-5));
		dmMap.put(new Short("1"), new Double(2.95e-5));
		dmMap.put(new Short("2"), new Double(2.9e-5));
		dmMap.put(new Short("3"), new Double(2.85e-5));
		dmMap.put(new Short("4"), new Double(2.8e-5));		
		dmMap.put(new Short("5"), new Double(2.75e-5));		
		dmMap.put(new Short("6"), new Double(2.7e-5));		
		dmMap.put(new Short("7"), new Double(2.65e-5));		
		dmMap.put(new Short("8"), new Double(2.6e-5));		
		dmMap.put(new Short("9"), new Double(2.55e-5));	
		starLum.put(StarTypeFactory.dm, dmMap);
		Map<Short,Double> pmdMap = new HashMap<Short, Double>();
		pmdMap.put(new Short("0"), new Double(2.30-5));
		pmdMap.put(new Short("1"), new Double(2.29e-5));
		pmdMap.put(new Short("2"), new Double(2.27e-5));
		pmdMap.put(new Short("3"), new Double(2.25e-5));
		pmdMap.put(new Short("4"), new Double(2.24e-5));		
		pmdMap.put(new Short("5"), new Double(2.23e-5));		
		pmdMap.put(new Short("6"), new Double(2.22e-5));		
		pmdMap.put(new Short("7"), new Double(2.21e-5));		
		pmdMap.put(new Short("8"), new Double(2.205e-5));		
		pmdMap.put(new Short("9"), new Double(2.20e-5));
		starLum.put(StarTypeFactory.pmd, pmdMap);
		Map<Short,Double> bsMap = new HashMap<Short, Double>();
		bsMap.put(new Short("0"), new Double(2.00-5));
		bsMap.put(new Short("1"), new Double(1.95e-5));
		bsMap.put(new Short("2"), new Double(1.90e-5));
		bsMap.put(new Short("3"), new Double(1.85e-5));
		bsMap.put(new Short("4"), new Double(1.80e-5));		
		bsMap.put(new Short("5"), new Double(1.70e-5));		
		bsMap.put(new Short("6"), new Double(1.50e-5));		
		bsMap.put(new Short("7"), new Double(1.30e-5));		
		bsMap.put(new Short("8"), new Double(1.15e-5));		
		bsMap.put(new Short("9"), new Double(1.05e-5));
		starLum.put(StarTypeFactory.bs, bsMap);
		Map<Short,Double> dbsMap = new HashMap<Short, Double>();
		dbsMap.put(new Short("0"), new Double(1.00-5));
		dbsMap.put(new Short("1"), new Double(0.95e-5));
		dbsMap.put(new Short("2"), new Double(0.90e-5));
		dbsMap.put(new Short("3"), new Double(0.85e-5));
		dbsMap.put(new Short("4"), new Double(0.80e-5));		
		dbsMap.put(new Short("5"), new Double(0.70e-5));		
		dbsMap.put(new Short("6"), new Double(0.50e-5));		
		dbsMap.put(new Short("7"), new Double(0.30e-5));		
		dbsMap.put(new Short("8"), new Double(0.15e-5));		
		dbsMap.put(new Short("9"), new Double(0.05e-5));
		starLum.put(StarTypeFactory.dbs, dbsMap);
	}

	private static Map<StarTypeFactory,Map<Short, Double>> starMass = new HashMap<StarTypeFactory, Map<Short,Double>>();
	static{
		Map<Short,Double> sg2oMap = new HashMap<Short, Double>();
		sg2oMap.put(new Short("0"), new Double(160.0));
		sg2oMap.put(new Short("1"), new Double(140.0));
		sg2oMap.put(new Short("2"), new Double(80.0));
		sg2oMap.put(new Short("3"), new Double(47.0));
		sg2oMap.put(new Short("4"), new Double(12.0));		
		sg2oMap.put(new Short("5"), new Double(18.0));		
		sg2oMap.put(new Short("6"), new Double(23.0));		
		sg2oMap.put(new Short("7"), new Double(26.0));		
		sg2oMap.put(new Short("8"), new Double(28.0));		
		sg2oMap.put(new Short("9"), new Double(30.0));	
		starMass.put(StarTypeFactory.sg2o, sg2oMap);
		
		Map<Short,Double> sg2bMap = new HashMap<Short, Double>();
		sg2bMap.put(new Short("0"), new Double(155.0));
		sg2bMap.put(new Short("1"), new Double(135.0));
		sg2bMap.put(new Short("2"), new Double(75.0));
		sg2bMap.put(new Short("3"), new Double(45.0));
		sg2bMap.put(new Short("4"), new Double(11.0));		
		sg2bMap.put(new Short("5"), new Double(17.0));		
		sg2bMap.put(new Short("6"), new Double(21.0));		
		sg2bMap.put(new Short("7"), new Double(23.0));		
		sg2bMap.put(new Short("8"), new Double(26.0));		
		sg2bMap.put(new Short("9"), new Double(28.0));	
		starMass.put(StarTypeFactory.sg2b, sg2bMap);
		
		Map<Short,Double> sg2aMap = new HashMap<Short, Double>();
		sg2aMap.put(new Short("0"), new Double(30.0));
		sg2aMap.put(new Short("1"), new Double(29.0));
		sg2aMap.put(new Short("2"), new Double(28.0));
		sg2aMap.put(new Short("3"), new Double(27.0));
		sg2aMap.put(new Short("4"), new Double(26.0));		
		sg2aMap.put(new Short("5"), new Double(25.0));		
		sg2aMap.put(new Short("6"), new Double(26.0));		
		sg2aMap.put(new Short("7"), new Double(27.0));		
		sg2aMap.put(new Short("8"), new Double(29.0));		
		sg2aMap.put(new Short("9"), new Double(30.0));	
		starMass.put(StarTypeFactory.sg2a, sg2aMap);
		
		Map<Short,Double> sg2fMap = new HashMap<Short, Double>();
		sg2fMap.put(new Short("0"), new Double(28.0));
		sg2fMap.put(new Short("1"), new Double(27.0));
		sg2fMap.put(new Short("2"), new Double(25.0));
		sg2fMap.put(new Short("3"), new Double(23.0));
		sg2fMap.put(new Short("4"), new Double(21.0));		
		sg2fMap.put(new Short("5"), new Double(21.5));		
		sg2fMap.put(new Short("6"), new Double(23.0));		
		sg2fMap.put(new Short("7"), new Double(24.0));		
		sg2fMap.put(new Short("8"), new Double(25.0));		
		sg2fMap.put(new Short("9"), new Double(26.0));	
		starMass.put(StarTypeFactory.sg2f, sg2fMap);
		
		Map<Short,Double> sg2gMap = new HashMap<Short, Double>();
		sg2gMap.put(new Short("0"), new Double(24.0));
		sg2gMap.put(new Short("1"), new Double(20.0));
		sg2gMap.put(new Short("2"), new Double(18.0));
		sg2gMap.put(new Short("3"), new Double(17.5));
		sg2gMap.put(new Short("4"), new Double(17.0));		
		sg2gMap.put(new Short("5"), new Double(16.0));		
		sg2gMap.put(new Short("6"), new Double(17.0));		
		sg2gMap.put(new Short("7"), new Double(21.0));		
		sg2gMap.put(new Short("8"), new Double(23.0));		
		sg2gMap.put(new Short("9"), new Double(26.0));	
		starMass.put(StarTypeFactory.sg2g, sg2gMap);
		
		Map<Short,Double> sg2kMap = new HashMap<Short, Double>();
		sg2kMap.put(new Short("0"), new Double(27.0));
		sg2kMap.put(new Short("1"), new Double(25.0));
		sg2kMap.put(new Short("2"), new Double(23.0));
		sg2kMap.put(new Short("3"), new Double(21.0));
		sg2kMap.put(new Short("4"), new Double(20.0));		
		sg2kMap.put(new Short("5"), new Double(21.5));		
		sg2kMap.put(new Short("6"), new Double(23.0));		
		sg2kMap.put(new Short("7"), new Double(25.0));		
		sg2kMap.put(new Short("8"), new Double(27.0));		
		sg2kMap.put(new Short("9"), new Double(29.0));	
		starMass.put(StarTypeFactory.sg2k, sg2kMap);
		
		Map<Short,Double> sg2mMap = new HashMap<Short, Double>();
		sg2mMap.put(new Short("0"), new Double(31.0));
		sg2mMap.put(new Short("1"), new Double(27.0));
		sg2mMap.put(new Short("2"), new Double(26.0));
		sg2mMap.put(new Short("3"), new Double(25.0));
		sg2mMap.put(new Short("4"), new Double(24.5));		
		sg2mMap.put(new Short("5"), new Double(24.0));		
		sg2mMap.put(new Short("6"), new Double(25.0));		
		sg2mMap.put(new Short("7"), new Double(26.0));		
		sg2mMap.put(new Short("8"), new Double(27.0));		
		sg2mMap.put(new Short("9"), new Double(30.0));	
		starMass.put(StarTypeFactory.sg2m, sg2mMap);
		
		Map<Short,Double> sg1oMap = new HashMap<Short, Double>();
		sg1oMap.put(new Short("0"), new Double(50.0));
		sg1oMap.put(new Short("1"), new Double(45.0));
		sg1oMap.put(new Short("2"), new Double(40.0));
		sg1oMap.put(new Short("3"), new Double(35.0));
		sg1oMap.put(new Short("4"), new Double(30.0));		
		sg1oMap.put(new Short("5"), new Double(27.0));		
		sg1oMap.put(new Short("6"), new Double(26.0));		
		sg1oMap.put(new Short("7"), new Double(25.0));		
		sg1oMap.put(new Short("8"), new Double(21.0));		
		sg1oMap.put(new Short("9"), new Double(20.0));	
		starMass.put(StarTypeFactory.sg1o, sg1oMap);
		
		Map<Short,Double> sg1bMap = new HashMap<Short, Double>();
		sg1bMap.put(new Short("0"), new Double(45.0));
		sg1bMap.put(new Short("1"), new Double(40.0));
		sg1bMap.put(new Short("2"), new Double(35.0));
		sg1bMap.put(new Short("3"), new Double(30.0));
		sg1bMap.put(new Short("4"), new Double(28.0));		
		sg1bMap.put(new Short("5"), new Double(24.0));		
		sg1bMap.put(new Short("6"), new Double(23.0));		
		sg1bMap.put(new Short("7"), new Double(20.0));		
		sg1bMap.put(new Short("8"), new Double(19.0));		
		sg1bMap.put(new Short("9"), new Double(18.0));	
		starMass.put(StarTypeFactory.sg1b, sg1bMap);
		
		Map<Short,Double> sg1aMap = new HashMap<Short, Double>();
		sg1aMap.put(new Short("0"), new Double(30.0));
		sg1aMap.put(new Short("1"), new Double(27.0));
		sg1aMap.put(new Short("2"), new Double(25.0));
		sg1aMap.put(new Short("3"), new Double(22.0));
		sg1aMap.put(new Short("4"), new Double(20.0));		
		sg1aMap.put(new Short("5"), new Double(19.0));		
		sg1aMap.put(new Short("6"), new Double(18.0));		
		sg1aMap.put(new Short("7"), new Double(17.5));		
		sg1aMap.put(new Short("8"), new Double(17.1));		
		sg1aMap.put(new Short("9"), new Double(16.0));	
		starMass.put(StarTypeFactory.sg1a, sg1aMap);
		
		Map<Short,Double> sg1fMap = new HashMap<Short, Double>();
		sg1fMap.put(new Short("0"), new Double(20.0));
		sg1fMap.put(new Short("1"), new Double(19.0));
		sg1fMap.put(new Short("2"), new Double(17.0));
		sg1fMap.put(new Short("3"), new Double(16.5));
		sg1fMap.put(new Short("4"), new Double(16.0));		
		sg1fMap.put(new Short("5"), new Double(15.5));		
		sg1fMap.put(new Short("6"), new Double(15.0));		
		sg1fMap.put(new Short("7"), new Double(14.6));		
		sg1fMap.put(new Short("8"), new Double(14.1));		
		sg1fMap.put(new Short("9"), new Double(14.0));	
		starMass.put(StarTypeFactory.sg1f, sg1fMap);
		
		Map<Short,Double> sg1gMap = new HashMap<Short, Double>();
		sg1gMap.put(new Short("0"), new Double(12.0));
		sg1gMap.put(new Short("1"), new Double(11.0));
		sg1gMap.put(new Short("2"), new Double(10.9));
		sg1gMap.put(new Short("3"), new Double(10.7));
		sg1gMap.put(new Short("4"), new Double(10.3));		
		sg1gMap.put(new Short("5"), new Double(10.0));		
		sg1gMap.put(new Short("6"), new Double(10.7));		
		sg1gMap.put(new Short("7"), new Double(10.9));		
		sg1gMap.put(new Short("8"), new Double(11.0));		
		sg1gMap.put(new Short("9"), new Double(11.5));	
		starMass.put(StarTypeFactory.sg1g, sg1gMap);
		
		Map<Short,Double> sg1kMap = new HashMap<Short, Double>();
		sg1kMap.put(new Short("0"), new Double(14.0));
		sg1kMap.put(new Short("1"), new Double(1.23e4));
		sg1kMap.put(new Short("2"), new Double(1.46e4));
		sg1kMap.put(new Short("3"), new Double(1.65e4));
		sg1kMap.put(new Short("4"), new Double(1.81e4));		
		sg1kMap.put(new Short("5"), new Double(2.09e4));		
		sg1kMap.put(new Short("6"), new Double(2.32e4));		
		sg1kMap.put(new Short("7"), new Double(2.87e4));		
		sg1kMap.put(new Short("8"), new Double(3.16e4));		
		sg1kMap.put(new Short("9"), new Double(16.0));	
		starMass.put(StarTypeFactory.sg1k, sg1kMap);
		
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
		starMass.put(StarTypeFactory.sg1m, sg1mMap);
	}
/**
 * 
 * @param starCode
 * @param starTypeFactory
 * @param starFactory
 * @param sequence
 * @return luminosity
 */

	public static Double genLuminsoity(short starCode,
			StarTypeFactory starTypeFactory, StarFactory starFactory,
			Sequence sequence) {
		Double lumen = starTypeFactory.starLum.get(starTypeFactory)
				.get(starCode).doubleValue();

		// edge conditions
		if (starCode == 0 && sequence.sfup == null) {

			Double mod = StarTypeFactory.starLum.get(starTypeFactory).get(
					starCode);
			mod = delta(lumen, mod)
					* (GenRandomRolls.Instance().getD49() / 100.0);
			lumen += mod;
		} else if (starCode == 9 && sequence.sfdown == null) {
			Double mod = StarTypeFactory.starLum.get(starTypeFactory).get(
					starCode);
			mod = delta(lumen, mod)
					* (GenRandomRolls.Instance().getD49() / 100.0);

			lumen = starTypeFactory.starLum.get(starTypeFactory).get(starCode)
					.doubleValue();
			mod = StarTypeFactory.starLum.get(starTypeFactory).get(starCode);
			mod = mod * GenRandomRolls.Instance().getD49();
			lumen += mod;
		} else {
			// random plus or minus lumenosity
			int flipACoin = GenRandomRolls.Instance().get_D2();
			if (flipACoin == 1) {
				lumen = starTypeFactory.starLum.get(starTypeFactory)
						.get(starCode).doubleValue();
				short starCode2 = nextPlusCode(starCode);
				Double mod = null;
				if (starCode == 0) {
					mod = StarTypeFactory.starLum.get(sequence.sfup).get(
							starCode2);
					mod = delta(lumen, mod)
							* (GenRandomRolls.Instance().getD49() / 100.0);

					logger.info("SFUP1:"+sequence.sfup);
				} else {
					mod = starTypeFactory.starLum.get(starTypeFactory)
							.get(starCode2).doubleValue();
					mod = delta(lumen, mod)

					* (GenRandomRolls.Instance().getD49() / 100.0);
				}
				logger.info("MOD1:"+mod);
				lumen += mod;
			} else {
				short starCode2 = nextMinusCode(starCode);
				Double mod = null;
				if (starCode == 9) {
					mod = StarTypeFactory.starLum.get(sequence.sfdown).get(
							starCode2);
					mod = delta(lumen, mod)
							* (GenRandomRolls.Instance().getD49() / 100.0);

					logger.info("SFDOWN2:"+sequence.sfdown);
				}  else {
					mod = starTypeFactory.starLum.get(starTypeFactory)
							.get(starCode2).doubleValue();
					mod = delta(lumen, mod)
							* (GenRandomRolls.Instance().getD49() / 100.0);
				}
				logger.info("MOD2:"+mod);
				lumen -= mod;
			}
		}
		return lumen;
	}

	private static short nextPlusCode(short starCode) {
		short starCode2 = (short) (starCode - 1);
		if (starCode2 == -1) {
			starCode2 = 0;
		}
		logger.info("NEXT_MINUS_CODE:"+starCode2);
		return starCode2;
	}

	private static short nextMinusCode(short starCode) {
		short starCode2 = (short) (starCode + 1);
		if (starCode2 == 10) {
			starCode2 = 9;
		}
		logger.info("NEXT_PLUS_CODE:"+starCode2);
		return starCode2;
	}
	private static Double delta(Double luman, Double mod){
		Double answer = null;
		if (mod < luman){
			answer = luman - mod;
		}
		else{
			answer = mod - luman;
		}
		logger.info("DELTA.luman:"+answer);
		return answer;
	}

}
