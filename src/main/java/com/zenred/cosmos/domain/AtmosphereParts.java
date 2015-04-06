package com.zenred.cosmos.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum AtmosphereParts {

	Methane("methane", "ch[4]", 90.6, 109.0), SulfuricAcid("sulfuric_acid",
			"h[1]so[4]", 283.15, 613.15), CarbonDioxide("carbon_dioxide",
			"co[1]", 194.5, 216.5), Nitrogen("nitrogen", "n[1]", 64.0, 78.0), Ammonia(
			"ammonia", "nh[3]", 195.3, 239.6), NitrogenDioxide(
			"nitrogen_dioxide", "no[1]", 261.8, 294.2), Oxygen("oxygen",
			"o[1]", 54.6, 90.0), Water("water", "h[2]o", 273.0, 373.0), Neon(
			"neon", "ne[1]", 24.6, 27.1), HydrogenSulfide("hydrogen_sulfide",
			"h[1]s", 187.5, 212.3), SulferDioxide("sulfer_dioxide", "so[1]",
			200.8, 263.0), Chlorine("chlorine", "cl[1]", 171.9, 238.4), Argon(
			"argon", "ar[1]", 83.8, 87.4), Helium("helium", "he[1]", 1.0, 1.15), Hydrogen(
			"hydrogen", "h[1]", 14.01, 33.0), HydrocloricAcid(
			"hydrocloric_acid", "h[1]cl[1]", 247.0, 523.15), CarbonMonoxide(
			"carbon_monoxide", "co[1]", 67.9, 83.0), Sodium("sodium", "na[1]",
			370.87, 1156.0), Potassium("potassium", "k[1]", 336.53, 1032.0), Sulfur(
			"sulfer", "s[1]", 388.36, 717.8), Carbon("carbon", "c[1]", 3900.0,
			5000.0), Ozone("ozone", "o[3]", 81.0, 161.0), Silicon("silicon",
			"si[1]", 1673.15, 3073.15), Ethane("ethane", "c[2]h[6]", 90.4,
			184.6), Acetylene("acetylene", "c[2]h[2]", 189.0, 192.0), Dicetylene(
			"dicetylene", "c[4]h[2]", 263.0, 283.0), Methlacetylene(
			"methacetylene", "ch[3]c=ch", 170.0, 250.0), Cyanoacetylene(
			"cyanoacetylene", "c[3]h[1]n[1]", 278.0, 316.0), HydrogenCyanide(
			"hydrogen_cyanide", "h[1]c[1]n[1]", 260.0, 269.0);

	private AtmosphereParts(final String text, final String symbol,
			final Double solid, final Double gas) {
		this.text = text;
		this.symbol = symbol;
		this.solid = solid;
		this.gas = gas;
	}

	private final String text;
	private final String symbol;
	private final Double solid;
	private final Double gas;

	public String getText() {
		return text;
	}

	public String getSymbol() {
		return symbol;
	}

	public Double getSolid() {
		return solid;
	}

	public Double getGas() {
		return gas;
	}
	
	private static Map<StarFactory, List<StarToChemicalProfile>> starToAtmosphere = new HashMap<StarFactory, List<StarToChemicalProfile>>();
	static{
		starToAtmosphere.put(StarFactory.BLUE_SG_II, new ArrayList<StarToChemicalProfile>());

		// BLUE_SG_II
		StarToChemicalProfile starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Argon);
		starToChemicalProfile.setUltraVioletReducingScale(50.0);
		starToChemicalProfile.setWeightDuringAnalysis(3.0); // high rates more
		starToAtmosphere.get(StarFactory.BLUE_SG_II).add(starToChemicalProfile);
		
		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Carbon);
		starToChemicalProfile.setUltraVioletReducingScale(47.0);
		starToChemicalProfile.setWeightDuringAnalysis(13.0);
		starToAtmosphere.get(StarFactory.BLUE_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Helium);
		starToChemicalProfile.setUltraVioletReducingScale(4.0);
		starToChemicalProfile.setWeightDuringAnalysis(66.0);
		starToAtmosphere.get(StarFactory.BLUE_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Hydrogen);
		starToChemicalProfile.setUltraVioletReducingScale(1.0);
		starToChemicalProfile.setWeightDuringAnalysis(98.0);
		starToAtmosphere.get(StarFactory.BLUE_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Neon);
		starToChemicalProfile.setUltraVioletReducingScale(52.0);
		starToChemicalProfile.setWeightDuringAnalysis(2.0);
		starToAtmosphere.get(StarFactory.BLUE_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Nitrogen);
		starToChemicalProfile.setUltraVioletReducingScale(6.0);
		starToChemicalProfile.setWeightDuringAnalysis(86.0);
		starToAtmosphere.get(StarFactory.BLUE_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Oxygen);
		starToChemicalProfile.setUltraVioletReducingScale(20.0);
		starToChemicalProfile.setWeightDuringAnalysis(12.0);
		starToAtmosphere.get(StarFactory.BLUE_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Silicon);
		starToChemicalProfile.setUltraVioletReducingScale(34.0);
		starToChemicalProfile.setWeightDuringAnalysis(12.0);
		starToAtmosphere.get(StarFactory.BLUE_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Water);
		starToChemicalProfile.setUltraVioletReducingScale(33.0);
		starToChemicalProfile.setWeightDuringAnalysis(1.0);
		starToAtmosphere.get(StarFactory.BLUE_SG_II).add(starToChemicalProfile);

		starToAtmosphere.put(StarFactory.LTBL_SG_II, new ArrayList<StarToChemicalProfile>());
		// LTBL_SG_II

		// uv and reducing: 01 is extreme UV and 99 is extreme reducing

		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Argon);
		starToChemicalProfile.setUltraVioletReducingScale(64.0);
		starToChemicalProfile.setWeightDuringAnalysis(4.0); // high rates more
		starToAtmosphere.get(StarFactory.LTBL_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Carbon);
		starToChemicalProfile.setUltraVioletReducingScale(45.0);
		starToChemicalProfile.setWeightDuringAnalysis(15.0);
		starToAtmosphere.get(StarFactory.LTBL_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Helium);
		starToChemicalProfile.setUltraVioletReducingScale(5.0);
		starToChemicalProfile.setWeightDuringAnalysis(64.0);
		starToAtmosphere.get(StarFactory.LTBL_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Hydrogen);
		starToChemicalProfile.setUltraVioletReducingScale(2.0);
		starToChemicalProfile.setWeightDuringAnalysis(96.0);
		starToAtmosphere.get(StarFactory.LTBL_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Neon);
		starToChemicalProfile.setUltraVioletReducingScale(50.0);
		starToChemicalProfile.setWeightDuringAnalysis(4.0);
		starToAtmosphere.get(StarFactory.LTBL_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Nitrogen);
		starToChemicalProfile.setUltraVioletReducingScale(8.0);
		starToChemicalProfile.setWeightDuringAnalysis(88.0);
		starToAtmosphere.get(StarFactory.LTBL_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Oxygen);
		starToChemicalProfile.setUltraVioletReducingScale(22.0);
		starToChemicalProfile.setWeightDuringAnalysis(14.0);
		starToAtmosphere.get(StarFactory.LTBL_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Silicon);
		starToChemicalProfile.setUltraVioletReducingScale(36.0);
		starToChemicalProfile.setWeightDuringAnalysis(11.0);
		starToAtmosphere.get(StarFactory.LTBL_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Water);
		starToChemicalProfile.setUltraVioletReducingScale(33.0);
		starToChemicalProfile.setWeightDuringAnalysis(2.0);
		starToAtmosphere.get(StarFactory.LTBL_SG_II).add(starToChemicalProfile);

		starToAtmosphere.put(StarFactory.WHIT_SG_II, new ArrayList<StarToChemicalProfile>());
		// WHIT_SG_II

		// uv and reducing: 01 is extreme UV and 99 is extreme reducing
		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Argon);
		starToChemicalProfile.setUltraVioletReducingScale(62.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0); // high rates more
															// probable
		starToAtmosphere.get(StarFactory.WHIT_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Carbon);
		starToChemicalProfile.setUltraVioletReducingScale(49.0);
		starToChemicalProfile.setWeightDuringAnalysis(13.0);
		starToAtmosphere.get(StarFactory.WHIT_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Helium);
		starToChemicalProfile.setUltraVioletReducingScale(7.0);
		starToChemicalProfile.setWeightDuringAnalysis(68.0);
		starToAtmosphere.get(StarFactory.WHIT_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Hydrogen);
		starToChemicalProfile.setUltraVioletReducingScale(4.0);
		starToChemicalProfile.setWeightDuringAnalysis(99.0);
		starToAtmosphere.get(StarFactory.WHIT_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Neon);
		starToChemicalProfile.setUltraVioletReducingScale(54.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.WHIT_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Nitrogen);
		starToChemicalProfile.setUltraVioletReducingScale(10.0);
		starToChemicalProfile.setWeightDuringAnalysis(84.0);
		starToAtmosphere.get(StarFactory.WHIT_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Oxygen);
		starToChemicalProfile.setUltraVioletReducingScale(24.0);
		starToChemicalProfile.setWeightDuringAnalysis(16.0);
		starToAtmosphere.get(StarFactory.WHIT_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Silicon);
		starToChemicalProfile.setUltraVioletReducingScale(38.0);
		starToChemicalProfile.setWeightDuringAnalysis(10.0);
		starToAtmosphere.get(StarFactory.WHIT_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Water);
		starToChemicalProfile.setUltraVioletReducingScale(34.0);
		starToChemicalProfile.setWeightDuringAnalysis(4.0);
		starToAtmosphere.get(StarFactory.WHIT_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.CarbonDioxide);
		starToChemicalProfile.setUltraVioletReducingScale(2.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.WHIT_SG_II).add(starToChemicalProfile);

		starToAtmosphere.put(StarFactory.PYEL_SG_II, new ArrayList<StarToChemicalProfile>());
		// PYEL_SG_II

		// uv and reducing: 01 is extreme UV and 99 is extreme reducing
		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Argon);
		starToChemicalProfile.setUltraVioletReducingScale(60.0);
		starToChemicalProfile.setWeightDuringAnalysis(6.0); // high rates more
															// likely
		starToAtmosphere.get(StarFactory.PYEL_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Carbon);
		starToChemicalProfile.setUltraVioletReducingScale(40.0);
		starToChemicalProfile.setWeightDuringAnalysis(11.0);
		starToAtmosphere.get(StarFactory.PYEL_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Helium);
		starToChemicalProfile.setUltraVioletReducingScale(10.0);
		starToChemicalProfile.setWeightDuringAnalysis(69.0);
		starToAtmosphere.get(StarFactory.PYEL_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Hydrogen);
		starToChemicalProfile.setUltraVioletReducingScale(10.0);
		starToChemicalProfile.setWeightDuringAnalysis(96.0);
		starToAtmosphere.get(StarFactory.PYEL_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Neon);
		starToChemicalProfile.setUltraVioletReducingScale(50.0);
		starToChemicalProfile.setWeightDuringAnalysis(6.0);
		starToAtmosphere.get(StarFactory.PYEL_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Nitrogen);
		starToChemicalProfile.setUltraVioletReducingScale(15.0);
		starToChemicalProfile.setWeightDuringAnalysis(88.0);
		starToAtmosphere.get(StarFactory.PYEL_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Oxygen);
		starToChemicalProfile.setUltraVioletReducingScale(32.0);
		starToChemicalProfile.setWeightDuringAnalysis(30.0);
		starToAtmosphere.get(StarFactory.PYEL_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Silicon);
		starToChemicalProfile.setUltraVioletReducingScale(40.0);
		starToChemicalProfile.setWeightDuringAnalysis(6.0);
		starToAtmosphere.get(StarFactory.PYEL_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Water);
		starToChemicalProfile.setUltraVioletReducingScale(40.0);
		starToChemicalProfile.setWeightDuringAnalysis(10.0);
		starToAtmosphere.get(StarFactory.PYEL_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Potassium);
		starToChemicalProfile.setUltraVioletReducingScale(2.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.PYEL_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sodium);
		starToChemicalProfile.setUltraVioletReducingScale(2.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.PYEL_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sulfur);
		starToChemicalProfile.setUltraVioletReducingScale(2.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.PYEL_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.SulfuricAcid);
		starToChemicalProfile.setUltraVioletReducingScale(2.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.PYEL_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.CarbonDioxide);
		starToChemicalProfile.setUltraVioletReducingScale(2.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.PYEL_SG_II).add(starToChemicalProfile);

		starToAtmosphere.put(StarFactory.YELO_SG_II, new ArrayList<StarToChemicalProfile>());
		// YELO_SG_II

		// uv and reducing: 01 is extreme UV and 99 is extreme reducing
		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Argon);
		starToChemicalProfile.setUltraVioletReducingScale(60.0);
		starToChemicalProfile.setWeightDuringAnalysis(6.0); // high rates more
															// likely
		starToAtmosphere.get(StarFactory.YELO_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Carbon);
		starToChemicalProfile.setUltraVioletReducingScale(40.0);
		starToChemicalProfile.setWeightDuringAnalysis(11.0);
		starToAtmosphere.get(StarFactory.YELO_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Helium);
		starToChemicalProfile.setUltraVioletReducingScale(10.0);
		starToChemicalProfile.setWeightDuringAnalysis(69.0);
		starToAtmosphere.get(StarFactory.YELO_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Hydrogen);
		starToChemicalProfile.setUltraVioletReducingScale(10.0);
		starToChemicalProfile.setWeightDuringAnalysis(96.0);
		starToAtmosphere.get(StarFactory.YELO_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Neon);
		starToChemicalProfile.setUltraVioletReducingScale(50.0);
		starToChemicalProfile.setWeightDuringAnalysis(6.0);
		starToAtmosphere.get(StarFactory.YELO_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Nitrogen);
		starToChemicalProfile.setUltraVioletReducingScale(15.0);
		starToChemicalProfile.setWeightDuringAnalysis(88.0);
		starToAtmosphere.get(StarFactory.YELO_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Oxygen);
		starToChemicalProfile.setUltraVioletReducingScale(32.0);
		starToChemicalProfile.setWeightDuringAnalysis(30.0);
		starToAtmosphere.get(StarFactory.YELO_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Silicon);
		starToChemicalProfile.setUltraVioletReducingScale(40.0);
		starToChemicalProfile.setWeightDuringAnalysis(6.0);
		starToAtmosphere.get(StarFactory.YELO_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Water);
		starToChemicalProfile.setUltraVioletReducingScale(40.0);
		starToChemicalProfile.setWeightDuringAnalysis(10.0);
		starToAtmosphere.get(StarFactory.YELO_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Potassium);
		starToChemicalProfile.setUltraVioletReducingScale(2.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.YELO_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sodium);
		starToChemicalProfile.setUltraVioletReducingScale(2.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.YELO_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sulfur);
		starToChemicalProfile.setUltraVioletReducingScale(2.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.YELO_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.SulfuricAcid);
		starToChemicalProfile.setUltraVioletReducingScale(2.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.YELO_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.CarbonDioxide);
		starToChemicalProfile.setUltraVioletReducingScale(2.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.YELO_SG_II).add(starToChemicalProfile);

		starToAtmosphere.put(StarFactory.ORNG_SG_II, new ArrayList<StarToChemicalProfile>());
		// ORNG_SG_II

		// uv and reducing: 01 is extreme UV and 99 is extreme reducing
		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Argon);
		starToChemicalProfile.setUltraVioletReducingScale(66.0);
		starToAtmosphere.get(StarFactory.ORNG_SG_II).add(starToChemicalProfile);
		
		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Carbon);
		starToChemicalProfile.setUltraVioletReducingScale(47.0);
		starToChemicalProfile.setWeightDuringAnalysis(13.0);
		starToAtmosphere.get(StarFactory.ORNG_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Helium);
		starToChemicalProfile.setUltraVioletReducingScale(4.0);
		starToChemicalProfile.setWeightDuringAnalysis(66.0);
		starToAtmosphere.get(StarFactory.ORNG_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Hydrogen);
		starToChemicalProfile.setUltraVioletReducingScale(1.0);
		starToChemicalProfile.setWeightDuringAnalysis(98.0);
		starToAtmosphere.get(StarFactory.ORNG_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Neon);
		starToChemicalProfile.setUltraVioletReducingScale(52.0);
		starToChemicalProfile.setWeightDuringAnalysis(2.0);
		starToAtmosphere.get(StarFactory.ORNG_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Nitrogen);
		starToChemicalProfile.setUltraVioletReducingScale(6.0);
		starToChemicalProfile.setWeightDuringAnalysis(86.0);
		starToAtmosphere.get(StarFactory.ORNG_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Oxygen);
		starToChemicalProfile.setUltraVioletReducingScale(20.0);
		starToChemicalProfile.setWeightDuringAnalysis(12.0);
		starToAtmosphere.get(StarFactory.ORNG_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Silicon);
		starToChemicalProfile.setUltraVioletReducingScale(34.0);
		starToChemicalProfile.setWeightDuringAnalysis(12.0);
		starToAtmosphere.get(StarFactory.ORNG_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Water);
		starToChemicalProfile.setUltraVioletReducingScale(33.0);
		starToChemicalProfile.setWeightDuringAnalysis(1.0);
		starToAtmosphere.get(StarFactory.ORNG_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Potassium);
		starToChemicalProfile.setUltraVioletReducingScale(2.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.ORNG_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sodium);
		starToChemicalProfile.setUltraVioletReducingScale(2.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.ORNG_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sulfur);
		starToChemicalProfile.setUltraVioletReducingScale(2.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.ORNG_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.SulfuricAcid);
		starToChemicalProfile.setUltraVioletReducingScale(2.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.ORNG_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.CarbonDioxide);
		starToChemicalProfile.setUltraVioletReducingScale(2.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.ORNG_SG_II).add(starToChemicalProfile);


		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Carbon);
		starToChemicalProfile.setUltraVioletReducingScale(47.0);
		starToChemicalProfile.setWeightDuringAnalysis(13.0);
		starToAtmosphere.get(StarFactory.ORNG_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Helium);
		starToChemicalProfile.setUltraVioletReducingScale(4.0);
		starToChemicalProfile.setWeightDuringAnalysis(66.0);
		starToAtmosphere.get(StarFactory.ORNG_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Hydrogen);
		starToChemicalProfile.setUltraVioletReducingScale(1.0);
		starToChemicalProfile.setWeightDuringAnalysis(98.0);
		starToAtmosphere.get(StarFactory.ORNG_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Neon);
		starToChemicalProfile.setUltraVioletReducingScale(52.0);
		starToChemicalProfile.setWeightDuringAnalysis(2.0);
		starToAtmosphere.get(StarFactory.ORNG_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Nitrogen);
		starToChemicalProfile.setUltraVioletReducingScale(6.0);
		starToChemicalProfile.setWeightDuringAnalysis(86.0);
		starToAtmosphere.get(StarFactory.ORNG_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Oxygen);
		starToChemicalProfile.setUltraVioletReducingScale(20.0);
		starToChemicalProfile.setWeightDuringAnalysis(12.0);
		starToAtmosphere.get(StarFactory.ORNG_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Silicon);
		starToChemicalProfile.setUltraVioletReducingScale(34.0);
		starToChemicalProfile.setWeightDuringAnalysis(12.0);
		starToAtmosphere.get(StarFactory.ORNG_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Water);
		starToChemicalProfile.setUltraVioletReducingScale(33.0);
		starToChemicalProfile.setWeightDuringAnalysis(1.0);
		starToAtmosphere.get(StarFactory.ORNG_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Potassium);
		starToChemicalProfile.setUltraVioletReducingScale(2.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.ORNG_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sodium);
		starToChemicalProfile.setUltraVioletReducingScale(2.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.ORNG_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sulfur);
		starToChemicalProfile.setUltraVioletReducingScale(2.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.ORNG_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.SulfuricAcid);
		starToChemicalProfile.setUltraVioletReducingScale(2.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.ORNG_SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.CarbonDioxide);
		starToChemicalProfile.setUltraVioletReducingScale(2.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.ORNG_SG_II).add(starToChemicalProfile);

		starToAtmosphere.put(StarFactory.RED__SG_II, new ArrayList<StarToChemicalProfile>());
		// RED__SG_II

		// uv and reducing: 01 is extreme UV and 99 is extreme reducing
		
		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Argon);
		starToChemicalProfile.setUltraVioletReducingScale(66.0);
		starToChemicalProfile.setWeightDuringAnalysis(3.0); // high means
															// increased
															// probability
		starToAtmosphere.get(StarFactory.RED__SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Carbon);
		starToChemicalProfile.setUltraVioletReducingScale(47.0);
		starToChemicalProfile.setWeightDuringAnalysis(1.0);
		starToAtmosphere.get(StarFactory.RED__SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Helium);
		starToChemicalProfile.setUltraVioletReducingScale(4.0);
		starToChemicalProfile.setWeightDuringAnalysis(66.0);
		starToAtmosphere.get(StarFactory.RED__SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Hydrogen);
		starToChemicalProfile.setUltraVioletReducingScale(1.0);
		starToChemicalProfile.setWeightDuringAnalysis(98.0);
		starToAtmosphere.get(StarFactory.RED__SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Neon);
		starToChemicalProfile.setUltraVioletReducingScale(52.0);
		starToChemicalProfile.setWeightDuringAnalysis(2.0);
		starToAtmosphere.get(StarFactory.RED__SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Nitrogen);
		starToChemicalProfile.setUltraVioletReducingScale(6.0);
		starToChemicalProfile.setWeightDuringAnalysis(86.0);
		starToAtmosphere.get(StarFactory.RED__SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Oxygen);
		starToChemicalProfile.setUltraVioletReducingScale(20.0);
		starToChemicalProfile.setWeightDuringAnalysis(12.0);
		starToAtmosphere.get(StarFactory.RED__SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Silicon);
		starToChemicalProfile.setUltraVioletReducingScale(34.0);
		starToChemicalProfile.setWeightDuringAnalysis(1.0);
		starToAtmosphere.get(StarFactory.RED__SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Water);
		starToChemicalProfile.setUltraVioletReducingScale(33.0);
		starToChemicalProfile.setWeightDuringAnalysis(15.0);
		starToAtmosphere.get(StarFactory.RED__SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Potassium);
		starToChemicalProfile.setUltraVioletReducingScale(22.0);
		starToChemicalProfile.setWeightDuringAnalysis(15.0);
		starToAtmosphere.get(StarFactory.RED__SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sodium);
		starToChemicalProfile.setUltraVioletReducingScale(22.0);
		starToChemicalProfile.setWeightDuringAnalysis(15.0);
		starToAtmosphere.get(StarFactory.RED__SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sulfur);
		starToChemicalProfile.setUltraVioletReducingScale(22.0);
		starToChemicalProfile.setWeightDuringAnalysis(15.0);
		starToAtmosphere.get(StarFactory.RED__SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.SulfuricAcid);
		starToChemicalProfile.setUltraVioletReducingScale(22.0);
		starToChemicalProfile.setWeightDuringAnalysis(15.0);
		starToAtmosphere.get(StarFactory.RED__SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.CarbonDioxide);
		starToChemicalProfile.setUltraVioletReducingScale(2.0);
		starToChemicalProfile.setWeightDuringAnalysis(15.0);
		starToAtmosphere.get(StarFactory.RED__SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Methane);
		starToChemicalProfile.setUltraVioletReducingScale(22.0);
		starToChemicalProfile.setWeightDuringAnalysis(10.0);
		starToAtmosphere.get(StarFactory.RED__SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Ethane);
		starToChemicalProfile.setUltraVioletReducingScale(28.0);
		starToChemicalProfile.setWeightDuringAnalysis(8.0);
		starToAtmosphere.get(StarFactory.RED__SG_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile
				.setAtmosphereParts(AtmosphereParts.HydrogenSulfide);
		starToChemicalProfile.setUltraVioletReducingScale(35.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.RED__SG_II).add(starToChemicalProfile);
		
		starToAtmosphere.put(StarFactory.BLUE_SG_I, new ArrayList<StarToChemicalProfile>());
		// uv and reducing: 01 is extreme UV and 99 is extreme reducing

		// BLUE_SG_I
		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Argon);
		starToChemicalProfile.setUltraVioletReducingScale(68.0);
		starToChemicalProfile.setWeightDuringAnalysis(4.0); // high means
															// greater
															// probability
		starToAtmosphere.get(StarFactory.BLUE_SG_I).add(starToChemicalProfile);

		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Carbon);
		starToChemicalProfile.setUltraVioletReducingScale(45.0);
		starToChemicalProfile.setWeightDuringAnalysis(11.0);
		starToAtmosphere.get(StarFactory.BLUE_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Helium);
		starToChemicalProfile.setUltraVioletReducingScale(6.0);
		starToChemicalProfile.setWeightDuringAnalysis(68.0);
		starToAtmosphere.get(StarFactory.BLUE_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Hydrogen);
		starToChemicalProfile.setUltraVioletReducingScale(2.0);
		starToChemicalProfile.setWeightDuringAnalysis(97.0);
		starToAtmosphere.get(StarFactory.BLUE_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Neon);
		starToChemicalProfile.setUltraVioletReducingScale(52.0);
		starToChemicalProfile.setWeightDuringAnalysis(2.0);
		starToAtmosphere.get(StarFactory.BLUE_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Nitrogen);
		starToChemicalProfile.setUltraVioletReducingScale(6.0);
		starToChemicalProfile.setWeightDuringAnalysis(86.0);
		starToAtmosphere.get(StarFactory.BLUE_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Oxygen);
		starToChemicalProfile.setUltraVioletReducingScale(20.0);
		starToChemicalProfile.setWeightDuringAnalysis(13.0);
		starToAtmosphere.get(StarFactory.BLUE_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Silicon);
		starToChemicalProfile.setUltraVioletReducingScale(34.0);
		starToChemicalProfile.setWeightDuringAnalysis(13.0);
		starToAtmosphere.get(StarFactory.BLUE_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Water);
		starToChemicalProfile.setUltraVioletReducingScale(33.0);
		starToChemicalProfile.setWeightDuringAnalysis(3.0);
		starToAtmosphere.get(StarFactory.BLUE_SG_I).add(starToChemicalProfile);

		starToAtmosphere.put(StarFactory.LTBL_SG_I, new ArrayList<StarToChemicalProfile>());
		// LTBL_SG_1

		// uv and reducing: 01 is extreme UV and 99 is extreme reducing
		
		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Argon);
		starToChemicalProfile.setUltraVioletReducingScale(62.0);
		starToChemicalProfile.setWeightDuringAnalysis(4.0); // high rates more
		starToAtmosphere.get(StarFactory.LTBL_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Carbon);
		starToChemicalProfile.setUltraVioletReducingScale(43.0);
		starToChemicalProfile.setWeightDuringAnalysis(15.0);
		starToAtmosphere.get(StarFactory.LTBL_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Helium);
		starToChemicalProfile.setUltraVioletReducingScale(6.0);
		starToChemicalProfile.setWeightDuringAnalysis(64.0);
		starToAtmosphere.get(StarFactory.LTBL_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Hydrogen);
		starToChemicalProfile.setUltraVioletReducingScale(2.0);
		starToChemicalProfile.setWeightDuringAnalysis(96.0);
		starToAtmosphere.get(StarFactory.LTBL_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Neon);
		starToChemicalProfile.setUltraVioletReducingScale(51.0);
		starToChemicalProfile.setWeightDuringAnalysis(4.0);
		starToAtmosphere.get(StarFactory.LTBL_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Nitrogen);
		starToChemicalProfile.setUltraVioletReducingScale(8.0);
		starToChemicalProfile.setWeightDuringAnalysis(88.0);
		starToAtmosphere.get(StarFactory.LTBL_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Oxygen);
		starToChemicalProfile.setUltraVioletReducingScale(22.0);
		starToChemicalProfile.setWeightDuringAnalysis(14.0);
		starToAtmosphere.get(StarFactory.LTBL_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Silicon);
		starToChemicalProfile.setUltraVioletReducingScale(36.0);
		starToChemicalProfile.setWeightDuringAnalysis(11.0);
		starToAtmosphere.get(StarFactory.LTBL_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Water);
		starToChemicalProfile.setUltraVioletReducingScale(33.0);
		starToChemicalProfile.setWeightDuringAnalysis(2.0);
		starToAtmosphere.get(StarFactory.LTBL_SG_I).add(starToChemicalProfile);

		starToAtmosphere.put(StarFactory.WHIT_SG_I, new ArrayList<StarToChemicalProfile>());
		// WHIT_SG_I

		// uv and reducing: 01 is extreme UV and 99 is extreme reducing
		
		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Argon);
		starToChemicalProfile.setUltraVioletReducingScale(60.0);
		starToChemicalProfile.setWeightDuringAnalysis(7.0); // high rates more
															// probable
		starToAtmosphere.get(StarFactory.WHIT_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Carbon);
		starToChemicalProfile.setUltraVioletReducingScale(51.0);
		starToChemicalProfile.setWeightDuringAnalysis(15.0);
		starToAtmosphere.get(StarFactory.WHIT_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Helium);
		starToChemicalProfile.setUltraVioletReducingScale(7.0);
		starToChemicalProfile.setWeightDuringAnalysis(70.0);
		starToAtmosphere.get(StarFactory.WHIT_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Hydrogen);
		starToChemicalProfile.setUltraVioletReducingScale(4.0);
		starToChemicalProfile.setWeightDuringAnalysis(99.0);
		starToAtmosphere.get(StarFactory.WHIT_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Neon);
		starToChemicalProfile.setUltraVioletReducingScale(52.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.WHIT_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Nitrogen);
		starToChemicalProfile.setUltraVioletReducingScale(10.0);
		starToChemicalProfile.setWeightDuringAnalysis(84.0);
		starToAtmosphere.get(StarFactory.WHIT_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Oxygen);
		starToChemicalProfile.setUltraVioletReducingScale(22.0);
		starToChemicalProfile.setWeightDuringAnalysis(18.0);
		starToAtmosphere.get(StarFactory.WHIT_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Silicon);
		starToChemicalProfile.setUltraVioletReducingScale(38.0);
		starToChemicalProfile.setWeightDuringAnalysis(10.0);
		starToAtmosphere.get(StarFactory.WHIT_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Water);
		starToChemicalProfile.setUltraVioletReducingScale(34.0);
		starToChemicalProfile.setWeightDuringAnalysis(4.0);
		starToAtmosphere.get(StarFactory.WHIT_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.CarbonDioxide);
		starToChemicalProfile.setUltraVioletReducingScale(2.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.WHIT_SG_I).add(starToChemicalProfile);

		starToAtmosphere.put(StarFactory.PYEL_SG_I, new ArrayList<StarToChemicalProfile>());
		// PYEL_SG_I

		// uv and reducing: 01 is extreme UV and 99 is extreme reducing
		
		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Argon);
		starToChemicalProfile.setUltraVioletReducingScale(58.0);
		starToChemicalProfile.setWeightDuringAnalysis(8.0); // high rates more
															// likely
		starToAtmosphere.get(StarFactory.PYEL_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Carbon);
		starToChemicalProfile.setUltraVioletReducingScale(38.0);
		starToChemicalProfile.setWeightDuringAnalysis(11.0);
		starToAtmosphere.get(StarFactory.PYEL_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Helium);
		starToChemicalProfile.setUltraVioletReducingScale(10.0);
		starToChemicalProfile.setWeightDuringAnalysis(72.0);
		starToAtmosphere.get(StarFactory.PYEL_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Hydrogen);
		starToChemicalProfile.setUltraVioletReducingScale(10.0);
		starToChemicalProfile.setWeightDuringAnalysis(96.0);
		starToAtmosphere.get(StarFactory.PYEL_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Neon);
		starToChemicalProfile.setUltraVioletReducingScale(48.0);
		starToChemicalProfile.setWeightDuringAnalysis(6.0);
		starToAtmosphere.get(StarFactory.PYEL_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Nitrogen);
		starToChemicalProfile.setUltraVioletReducingScale(19.0);
		starToChemicalProfile.setWeightDuringAnalysis(90.0);
		starToAtmosphere.get(StarFactory.PYEL_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Oxygen);
		starToChemicalProfile.setUltraVioletReducingScale(30.0);
		starToChemicalProfile.setWeightDuringAnalysis(32.0);
		starToAtmosphere.get(StarFactory.PYEL_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Silicon);
		starToChemicalProfile.setUltraVioletReducingScale(40.0);
		starToChemicalProfile.setWeightDuringAnalysis(6.0);
		starToAtmosphere.get(StarFactory.PYEL_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Water);
		starToChemicalProfile.setUltraVioletReducingScale(40.0);
		starToChemicalProfile.setWeightDuringAnalysis(10.0);
		starToAtmosphere.get(StarFactory.PYEL_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Potassium);
		starToChemicalProfile.setUltraVioletReducingScale(2.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.PYEL_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sodium);
		starToChemicalProfile.setUltraVioletReducingScale(2.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.PYEL_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sulfur);
		starToChemicalProfile.setUltraVioletReducingScale(2.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.PYEL_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.SulfuricAcid);
		starToChemicalProfile.setUltraVioletReducingScale(2.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.PYEL_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.CarbonDioxide);
		starToChemicalProfile.setUltraVioletReducingScale(2.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.PYEL_SG_I).add(starToChemicalProfile);
		
		starToAtmosphere.put(StarFactory.YELO_SG_I, new ArrayList<StarToChemicalProfile>());
		// YELO_SG_I

		// uv and reducing: 01 is extreme UV and 99 is extreme reducing
		
		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Argon);
		starToChemicalProfile.setUltraVioletReducingScale(58.0);
		starToChemicalProfile.setWeightDuringAnalysis(8.0); // high rates more
															// likely
		starToAtmosphere.get(StarFactory.YELO_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Carbon);
		starToChemicalProfile.setUltraVioletReducingScale(38.0);
		starToChemicalProfile.setWeightDuringAnalysis(11.0);
		starToAtmosphere.get(StarFactory.YELO_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Helium);
		starToChemicalProfile.setUltraVioletReducingScale(10.0);
		starToChemicalProfile.setWeightDuringAnalysis(72.0);
		starToAtmosphere.get(StarFactory.YELO_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Hydrogen);
		starToChemicalProfile.setUltraVioletReducingScale(10.0);
		starToChemicalProfile.setWeightDuringAnalysis(96.0);
		starToAtmosphere.get(StarFactory.YELO_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Neon);
		starToChemicalProfile.setUltraVioletReducingScale(48.0);
		starToChemicalProfile.setWeightDuringAnalysis(6.0);
		starToAtmosphere.get(StarFactory.YELO_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Nitrogen);
		starToChemicalProfile.setUltraVioletReducingScale(19.0);
		starToChemicalProfile.setWeightDuringAnalysis(90.0);
		starToAtmosphere.get(StarFactory.YELO_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Oxygen);
		starToChemicalProfile.setUltraVioletReducingScale(30.0);
		starToChemicalProfile.setWeightDuringAnalysis(32.0);
		starToAtmosphere.get(StarFactory.YELO_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Silicon);
		starToChemicalProfile.setUltraVioletReducingScale(40.0);
		starToChemicalProfile.setWeightDuringAnalysis(6.0);
		starToAtmosphere.get(StarFactory.YELO_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Water);
		starToChemicalProfile.setUltraVioletReducingScale(40.0);
		starToChemicalProfile.setWeightDuringAnalysis(10.0);
		starToAtmosphere.get(StarFactory.YELO_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Potassium);
		starToChemicalProfile.setUltraVioletReducingScale(2.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.YELO_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sodium);
		starToChemicalProfile.setUltraVioletReducingScale(2.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.YELO_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sulfur);
		starToChemicalProfile.setUltraVioletReducingScale(2.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.YELO_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.SulfuricAcid);
		starToChemicalProfile.setUltraVioletReducingScale(2.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.YELO_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.CarbonDioxide);
		starToChemicalProfile.setUltraVioletReducingScale(2.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.YELO_SG_I).add(starToChemicalProfile);
		
		starToAtmosphere.put(StarFactory.ORNG_SG_I, new ArrayList<StarToChemicalProfile>());

		// ORNG_SG_I

		// uv and reducing: 01 is extreme UV and 99 is extreme reducing
		
		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Argon);
		starToChemicalProfile.setUltraVioletReducingScale(60.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0); // high rates more
															// higher
															// probability
		starToAtmosphere.get(StarFactory.ORNG_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Carbon);
		starToChemicalProfile.setUltraVioletReducingScale(47.0);
		starToChemicalProfile.setWeightDuringAnalysis(15.0);
		starToAtmosphere.get(StarFactory.ORNG_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Helium);
		starToChemicalProfile.setUltraVioletReducingScale(4.0);
		starToChemicalProfile.setWeightDuringAnalysis(68.0);
		starToAtmosphere.get(StarFactory.ORNG_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Hydrogen);
		starToChemicalProfile.setUltraVioletReducingScale(1.0);
		starToChemicalProfile.setWeightDuringAnalysis(98.0);
		starToAtmosphere.get(StarFactory.ORNG_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Neon);
		starToChemicalProfile.setUltraVioletReducingScale(52.0);
		starToChemicalProfile.setWeightDuringAnalysis(2.0);
		starToAtmosphere.get(StarFactory.ORNG_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Nitrogen);
		starToChemicalProfile.setUltraVioletReducingScale(6.0);
		starToChemicalProfile.setWeightDuringAnalysis(88.0);
		starToAtmosphere.get(StarFactory.ORNG_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Oxygen);
		starToChemicalProfile.setUltraVioletReducingScale(18.0);
		starToChemicalProfile.setWeightDuringAnalysis(15.0);
		starToAtmosphere.get(StarFactory.ORNG_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Silicon);
		starToChemicalProfile.setUltraVioletReducingScale(30.0);
		starToChemicalProfile.setWeightDuringAnalysis(10.0);
		starToAtmosphere.get(StarFactory.ORNG_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Water);
		starToChemicalProfile.setUltraVioletReducingScale(30.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.ORNG_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Potassium);
		starToChemicalProfile.setUltraVioletReducingScale(2.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.ORNG_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sodium);
		starToChemicalProfile.setUltraVioletReducingScale(2.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.ORNG_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sulfur);
		starToChemicalProfile.setUltraVioletReducingScale(2.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.ORNG_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.SulfuricAcid);
		starToChemicalProfile.setUltraVioletReducingScale(2.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.ORNG_SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.CarbonDioxide);
		starToChemicalProfile.setUltraVioletReducingScale(2.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.ORNG_SG_I).add(starToChemicalProfile);
		
		starToAtmosphere.put(StarFactory.RED__SG_I, new ArrayList<StarToChemicalProfile>());
		// RED__SG_I

		// uv and reducing: 01 is extreme UV and 99 is extreme reducing
		
		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Argon);
		starToChemicalProfile.setUltraVioletReducingScale(58.0);
		starToChemicalProfile.setWeightDuringAnalysis(6.0); // high means
															// increased
															// probability
		starToAtmosphere.get(StarFactory.RED__SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Carbon);
		starToChemicalProfile.setUltraVioletReducingScale(40.0);
		starToChemicalProfile.setWeightDuringAnalysis(3.0);
		starToAtmosphere.get(StarFactory.RED__SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Helium);
		starToChemicalProfile.setUltraVioletReducingScale(4.0);
		starToChemicalProfile.setWeightDuringAnalysis(68.0);
		starToAtmosphere.get(StarFactory.RED__SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Hydrogen);
		starToChemicalProfile.setUltraVioletReducingScale(1.0);
		starToChemicalProfile.setWeightDuringAnalysis(99.0);
		starToAtmosphere.get(StarFactory.RED__SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Neon);
		starToChemicalProfile.setUltraVioletReducingScale(52.0);
		starToChemicalProfile.setWeightDuringAnalysis(2.0);
		starToAtmosphere.get(StarFactory.RED__SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Nitrogen);
		starToChemicalProfile.setUltraVioletReducingScale(6.0);
		starToChemicalProfile.setWeightDuringAnalysis(88.0);
		starToAtmosphere.get(StarFactory.RED__SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Oxygen);
		starToChemicalProfile.setUltraVioletReducingScale(18.0);
		starToChemicalProfile.setWeightDuringAnalysis(15.0);
		starToAtmosphere.get(StarFactory.RED__SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Silicon);
		starToChemicalProfile.setUltraVioletReducingScale(34.0);
		starToChemicalProfile.setWeightDuringAnalysis(1.0);
		starToAtmosphere.get(StarFactory.RED__SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Water);
		starToChemicalProfile.setUltraVioletReducingScale(30.0);
		starToChemicalProfile.setWeightDuringAnalysis(18.0);
		starToAtmosphere.get(StarFactory.RED__SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Potassium);
		starToChemicalProfile.setUltraVioletReducingScale(20.0);
		starToChemicalProfile.setWeightDuringAnalysis(12.0);
		starToAtmosphere.get(StarFactory.RED__SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sodium);
		starToChemicalProfile.setUltraVioletReducingScale(20.0);
		starToChemicalProfile.setWeightDuringAnalysis(15.0);
		starToAtmosphere.get(StarFactory.RED__SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sulfur);
		starToChemicalProfile.setUltraVioletReducingScale(20.0);
		starToChemicalProfile.setWeightDuringAnalysis(15.0);
		starToAtmosphere.get(StarFactory.RED__SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.SulfuricAcid);
		starToChemicalProfile.setUltraVioletReducingScale(20.0);
		starToChemicalProfile.setWeightDuringAnalysis(15.0);
		starToAtmosphere.get(StarFactory.RED__SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.CarbonDioxide);
		starToChemicalProfile.setUltraVioletReducingScale(2.0);
		starToChemicalProfile.setWeightDuringAnalysis(17.0);
		starToAtmosphere.get(StarFactory.RED__SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Methane);
		starToChemicalProfile.setUltraVioletReducingScale(20.0);
		starToChemicalProfile.setWeightDuringAnalysis(15.0);
		starToAtmosphere.get(StarFactory.RED__SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Ethane);
		starToChemicalProfile.setUltraVioletReducingScale(26.0);
		starToChemicalProfile.setWeightDuringAnalysis(8.0);
		starToAtmosphere.get(StarFactory.RED__SG_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile
				.setAtmosphereParts(AtmosphereParts.HydrogenSulfide);
		starToChemicalProfile.setUltraVioletReducingScale(38.0);
		starToChemicalProfile.setWeightDuringAnalysis(7.0);
		starToAtmosphere.get(StarFactory.RED__SG_I).add(starToChemicalProfile);

		starToAtmosphere.put(StarFactory.BLUE_GI_II, new ArrayList<StarToChemicalProfile>());
		// uv and reducing: 01 is extreme UV and 99 is extreme reducing

		// BLUE_GI_II
		
		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Argon);
		starToChemicalProfile.setUltraVioletReducingScale(70.0);
		starToChemicalProfile.setWeightDuringAnalysis(6.0); // high means
															// greater
															// probability
		starToAtmosphere.get(StarFactory.BLUE_GI_II).add(starToChemicalProfile);

		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Carbon);
		starToChemicalProfile.setUltraVioletReducingScale(43.0);
		starToChemicalProfile.setWeightDuringAnalysis(10.0);
		starToAtmosphere.get(StarFactory.BLUE_GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Helium);
		starToChemicalProfile.setUltraVioletReducingScale(8.0);
		starToChemicalProfile.setWeightDuringAnalysis(70.0);
		starToAtmosphere.get(StarFactory.BLUE_GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Hydrogen);
		starToChemicalProfile.setUltraVioletReducingScale(4.0);
		starToChemicalProfile.setWeightDuringAnalysis(96.0);
		starToAtmosphere.get(StarFactory.BLUE_GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Neon);
		starToChemicalProfile.setUltraVioletReducingScale(52.0);
		starToChemicalProfile.setWeightDuringAnalysis(2.0);
		starToAtmosphere.get(StarFactory.BLUE_GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Nitrogen);
		starToChemicalProfile.setUltraVioletReducingScale(8.0);
		starToChemicalProfile.setWeightDuringAnalysis(88.0);
		starToAtmosphere.get(StarFactory.BLUE_GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Oxygen);
		starToChemicalProfile.setUltraVioletReducingScale(21.0);
		starToChemicalProfile.setWeightDuringAnalysis(14.0);
		starToAtmosphere.get(StarFactory.BLUE_GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Silicon);
		starToChemicalProfile.setUltraVioletReducingScale(34.0);
		starToChemicalProfile.setWeightDuringAnalysis(13.0);
		starToAtmosphere.get(StarFactory.BLUE_GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Water);
		starToChemicalProfile.setUltraVioletReducingScale(33.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.BLUE_GI_II).add(starToChemicalProfile);
		
		starToAtmosphere.put(StarFactory.BLUE_GI_I, new ArrayList<StarToChemicalProfile>());
		// uv and reducing: 01 is extreme UV and 99 is extreme reducing

		// BLUE_GI_I
		
		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Argon);
		starToChemicalProfile.setUltraVioletReducingScale(70.0);
		starToChemicalProfile.setWeightDuringAnalysis(6.0); // high means
															// greater
															// probability
		starToAtmosphere.get(StarFactory.BLUE_GI_I).add(starToChemicalProfile);

		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Carbon);
		starToChemicalProfile.setUltraVioletReducingScale(43.0);
		starToChemicalProfile.setWeightDuringAnalysis(10.0);
		starToAtmosphere.get(StarFactory.BLUE_GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Helium);
		starToChemicalProfile.setUltraVioletReducingScale(8.0);
		starToChemicalProfile.setWeightDuringAnalysis(70.0);
		starToAtmosphere.get(StarFactory.BLUE_GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Hydrogen);
		starToChemicalProfile.setUltraVioletReducingScale(4.0);
		starToChemicalProfile.setWeightDuringAnalysis(96.0);
		starToAtmosphere.get(StarFactory.BLUE_GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Neon);
		starToChemicalProfile.setUltraVioletReducingScale(52.0);
		starToChemicalProfile.setWeightDuringAnalysis(2.0);
		starToAtmosphere.get(StarFactory.BLUE_GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Nitrogen);
		starToChemicalProfile.setUltraVioletReducingScale(8.0);
		starToChemicalProfile.setWeightDuringAnalysis(88.0);
		starToAtmosphere.get(StarFactory.BLUE_GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Oxygen);
		starToChemicalProfile.setUltraVioletReducingScale(21.0);
		starToChemicalProfile.setWeightDuringAnalysis(14.0);
		starToAtmosphere.get(StarFactory.BLUE_GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Silicon);
		starToChemicalProfile.setUltraVioletReducingScale(34.0);
		starToChemicalProfile.setWeightDuringAnalysis(13.0);
		starToAtmosphere.get(StarFactory.BLUE_GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Water);
		starToChemicalProfile.setUltraVioletReducingScale(33.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.BLUE_GI_I).add(starToChemicalProfile);
		
		starToAtmosphere.put(StarFactory.LTBL_GI_II, new ArrayList<StarToChemicalProfile>());
		// LTBL_GI_II

		// uv and reducing: 01 is extreme UV and 99 is extreme reducing

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Argon);
		starToChemicalProfile.setUltraVioletReducingScale(58.0);
		starToChemicalProfile.setWeightDuringAnalysis(4.0); // high rates more
		starToAtmosphere.get(StarFactory.LTBL_GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Carbon);
		starToChemicalProfile.setUltraVioletReducingScale(43.0);
		starToChemicalProfile.setWeightDuringAnalysis(16.0);
		starToAtmosphere.get(StarFactory.LTBL_GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Helium);
		starToChemicalProfile.setUltraVioletReducingScale(6.0);
		starToChemicalProfile.setWeightDuringAnalysis(66.0);
		starToAtmosphere.get(StarFactory.LTBL_GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Hydrogen);
		starToChemicalProfile.setUltraVioletReducingScale(2.0);
		starToChemicalProfile.setWeightDuringAnalysis(96.0);
		starToAtmosphere.get(StarFactory.LTBL_GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Neon);
		starToChemicalProfile.setUltraVioletReducingScale(50.0);
		starToChemicalProfile.setWeightDuringAnalysis(4.0);
		starToAtmosphere.get(StarFactory.LTBL_GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Nitrogen);
		starToChemicalProfile.setUltraVioletReducingScale(8.0);
		starToChemicalProfile.setWeightDuringAnalysis(90.0);
		starToAtmosphere.get(StarFactory.LTBL_GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Oxygen);
		starToChemicalProfile.setUltraVioletReducingScale(22.0);
		starToChemicalProfile.setWeightDuringAnalysis(16.0);
		starToAtmosphere.get(StarFactory.LTBL_GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Silicon);
		starToChemicalProfile.setUltraVioletReducingScale(36.0);
		starToChemicalProfile.setWeightDuringAnalysis(11.0);
		starToAtmosphere.get(StarFactory.LTBL_GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Water);
		starToChemicalProfile.setUltraVioletReducingScale(33.0);
		starToChemicalProfile.setWeightDuringAnalysis(4.0);
		starToAtmosphere.get(StarFactory.LTBL_GI_II).add(starToChemicalProfile);
		
		starToAtmosphere.put(StarFactory.LTBL_GI_I, new ArrayList<StarToChemicalProfile>());
		// LTBL_GI_I

		// uv and reducing: 01 is extreme UV and 99 is extreme reducing

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Argon);
		starToChemicalProfile.setUltraVioletReducingScale(58.0);
		starToChemicalProfile.setWeightDuringAnalysis(4.0); // high rates more
		starToAtmosphere.get(StarFactory.LTBL_GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Carbon);
		starToChemicalProfile.setUltraVioletReducingScale(43.0);
		starToChemicalProfile.setWeightDuringAnalysis(16.0);
		starToAtmosphere.get(StarFactory.LTBL_GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Helium);
		starToChemicalProfile.setUltraVioletReducingScale(6.0);
		starToChemicalProfile.setWeightDuringAnalysis(66.0);
		starToAtmosphere.get(StarFactory.LTBL_GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Hydrogen);
		starToChemicalProfile.setUltraVioletReducingScale(2.0);
		starToChemicalProfile.setWeightDuringAnalysis(96.0);
		starToAtmosphere.get(StarFactory.LTBL_GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Neon);
		starToChemicalProfile.setUltraVioletReducingScale(50.0);
		starToChemicalProfile.setWeightDuringAnalysis(4.0);
		starToAtmosphere.get(StarFactory.LTBL_GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Nitrogen);
		starToChemicalProfile.setUltraVioletReducingScale(8.0);
		starToChemicalProfile.setWeightDuringAnalysis(90.0);
		starToAtmosphere.get(StarFactory.LTBL_GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Oxygen);
		starToChemicalProfile.setUltraVioletReducingScale(22.0);
		starToChemicalProfile.setWeightDuringAnalysis(16.0);
		starToAtmosphere.get(StarFactory.LTBL_GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Silicon);
		starToChemicalProfile.setUltraVioletReducingScale(36.0);
		starToChemicalProfile.setWeightDuringAnalysis(11.0);
		starToAtmosphere.get(StarFactory.LTBL_GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Water);
		starToChemicalProfile.setUltraVioletReducingScale(33.0);
		starToChemicalProfile.setWeightDuringAnalysis(4.0);
		starToAtmosphere.get(StarFactory.LTBL_GI_I).add(starToChemicalProfile);

		starToAtmosphere.put(StarFactory.WHIT_GI_II, new ArrayList<StarToChemicalProfile>());
		// WHIT_GI_II

		// uv and reducing: 01 is extreme UV and 99 is extreme reducing

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Argon);
		starToChemicalProfile.setUltraVioletReducingScale(56.0);
		starToChemicalProfile.setWeightDuringAnalysis(7.0); // high rates more
															// probable
		starToAtmosphere.get(StarFactory.WHIT_GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Carbon);
		starToChemicalProfile.setUltraVioletReducingScale(48.0);
		starToChemicalProfile.setWeightDuringAnalysis(18.0);
		starToAtmosphere.get(StarFactory.WHIT_GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Helium);
		starToChemicalProfile.setUltraVioletReducingScale(8.0);
		starToChemicalProfile.setWeightDuringAnalysis(72.0);
		starToAtmosphere.get(StarFactory.WHIT_GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Hydrogen);
		starToChemicalProfile.setUltraVioletReducingScale(4.0);
		starToChemicalProfile.setWeightDuringAnalysis(99.0);
		starToAtmosphere.get(StarFactory.WHIT_GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Neon);
		starToChemicalProfile.setUltraVioletReducingScale(52.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.WHIT_GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Nitrogen);
		starToChemicalProfile.setUltraVioletReducingScale(10.0);
		starToChemicalProfile.setWeightDuringAnalysis(86.0);
		starToAtmosphere.get(StarFactory.WHIT_GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Oxygen);
		starToChemicalProfile.setUltraVioletReducingScale(22.0);
		starToChemicalProfile.setWeightDuringAnalysis(20.0);
		starToAtmosphere.get(StarFactory.WHIT_GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Silicon);
		starToChemicalProfile.setUltraVioletReducingScale(30.0);
		starToChemicalProfile.setWeightDuringAnalysis(10.0);
		starToAtmosphere.get(StarFactory.WHIT_GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Water);
		starToChemicalProfile.setUltraVioletReducingScale(34.0);
		starToChemicalProfile.setWeightDuringAnalysis(6.0);
		starToAtmosphere.get(StarFactory.WHIT_GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.CarbonDioxide);
		starToChemicalProfile.setUltraVioletReducingScale(4.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.WHIT_GI_II).add(starToChemicalProfile);

		starToAtmosphere.put(StarFactory.WHIT_GI_I, new ArrayList<StarToChemicalProfile>());
		// WHIT_GI_I

		// uv and reducing: 01 is extreme UV and 99 is extreme reducing

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Argon);
		starToChemicalProfile.setUltraVioletReducingScale(56.0);
		starToChemicalProfile.setWeightDuringAnalysis(7.0); // high rates more
															// probable
		starToAtmosphere.get(StarFactory.WHIT_GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Carbon);
		starToChemicalProfile.setUltraVioletReducingScale(48.0);
		starToChemicalProfile.setWeightDuringAnalysis(18.0);
		starToAtmosphere.get(StarFactory.WHIT_GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Helium);
		starToChemicalProfile.setUltraVioletReducingScale(8.0);
		starToChemicalProfile.setWeightDuringAnalysis(72.0);
		starToAtmosphere.get(StarFactory.WHIT_GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Hydrogen);
		starToChemicalProfile.setUltraVioletReducingScale(4.0);
		starToChemicalProfile.setWeightDuringAnalysis(99.0);
		starToAtmosphere.get(StarFactory.WHIT_GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Neon);
		starToChemicalProfile.setUltraVioletReducingScale(52.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.WHIT_GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Nitrogen);
		starToChemicalProfile.setUltraVioletReducingScale(10.0);
		starToChemicalProfile.setWeightDuringAnalysis(86.0);
		starToAtmosphere.get(StarFactory.WHIT_GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Oxygen);
		starToChemicalProfile.setUltraVioletReducingScale(22.0);
		starToChemicalProfile.setWeightDuringAnalysis(20.0);
		starToAtmosphere.get(StarFactory.WHIT_GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Silicon);
		starToChemicalProfile.setUltraVioletReducingScale(30.0);
		starToChemicalProfile.setWeightDuringAnalysis(10.0);
		starToAtmosphere.get(StarFactory.WHIT_GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Water);
		starToChemicalProfile.setUltraVioletReducingScale(34.0);
		starToChemicalProfile.setWeightDuringAnalysis(6.0);
		starToAtmosphere.get(StarFactory.WHIT_GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.CarbonDioxide);
		starToChemicalProfile.setUltraVioletReducingScale(4.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.WHIT_GI_I).add(starToChemicalProfile);

		starToAtmosphere.put(StarFactory.YELO_GI_II, new ArrayList<StarToChemicalProfile>());
		// YELO_GI_II

		// uv and reducing: 01 is extreme UV and 99 is extreme reducing

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Argon);
		starToChemicalProfile.setUltraVioletReducingScale(58.0);
		starToChemicalProfile.setWeightDuringAnalysis(10.0); // high rates more
																// likely
		starToAtmosphere.get(StarFactory.YELO_GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Carbon);
		starToChemicalProfile.setUltraVioletReducingScale(36.0);
		starToChemicalProfile.setWeightDuringAnalysis(13.0);
		starToAtmosphere.get(StarFactory.YELO_GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Helium);
		starToChemicalProfile.setUltraVioletReducingScale(14.0);
		starToChemicalProfile.setWeightDuringAnalysis(75.0);
		starToAtmosphere.get(StarFactory.YELO_GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Hydrogen);
		starToChemicalProfile.setUltraVioletReducingScale(12.0);
		starToChemicalProfile.setWeightDuringAnalysis(97.0);
		starToAtmosphere.get(StarFactory.YELO_GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Neon);
		starToChemicalProfile.setUltraVioletReducingScale(48.0);
		starToChemicalProfile.setWeightDuringAnalysis(8.0);
		starToAtmosphere.get(StarFactory.YELO_GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Nitrogen);
		starToChemicalProfile.setUltraVioletReducingScale(22.0);
		starToChemicalProfile.setWeightDuringAnalysis(90.0);
		starToAtmosphere.get(StarFactory.YELO_GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Oxygen);
		starToChemicalProfile.setUltraVioletReducingScale(33.0);
		starToChemicalProfile.setWeightDuringAnalysis(35.0);
		starToAtmosphere.get(StarFactory.YELO_GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Silicon);
		starToChemicalProfile.setUltraVioletReducingScale(42.0);
		starToChemicalProfile.setWeightDuringAnalysis(8.0);
		starToAtmosphere.get(StarFactory.YELO_GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Water);
		starToChemicalProfile.setUltraVioletReducingScale(44.0);
		starToChemicalProfile.setWeightDuringAnalysis(14.0);
		starToAtmosphere.get(StarFactory.YELO_GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Potassium);
		starToChemicalProfile.setUltraVioletReducingScale(5.0);
		starToChemicalProfile.setWeightDuringAnalysis(6.0);
		starToAtmosphere.get(StarFactory.YELO_GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sodium);
		starToChemicalProfile.setUltraVioletReducingScale(5.0);
		starToChemicalProfile.setWeightDuringAnalysis(6.0);
		starToAtmosphere.get(StarFactory.YELO_GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sulfur);
		starToChemicalProfile.setUltraVioletReducingScale(5.0);
		starToChemicalProfile.setWeightDuringAnalysis(6.0);
		starToAtmosphere.get(StarFactory.YELO_GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.SulfuricAcid);
		starToChemicalProfile.setUltraVioletReducingScale(5.0);
		starToChemicalProfile.setWeightDuringAnalysis(6.0);
		starToAtmosphere.get(StarFactory.YELO_GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.CarbonDioxide);
		starToChemicalProfile.setUltraVioletReducingScale(5.0);
		starToChemicalProfile.setWeightDuringAnalysis(15.0);
		starToAtmosphere.get(StarFactory.YELO_GI_II).add(starToChemicalProfile);

		starToAtmosphere.put(StarFactory.YELO_GI_I, new ArrayList<StarToChemicalProfile>());
		// YELO_GI_I

		// uv and reducing: 01 is extreme UV and 99 is extreme reducing

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Argon);
		starToChemicalProfile.setUltraVioletReducingScale(58.0);
		starToChemicalProfile.setWeightDuringAnalysis(10.0); // high rates more
																// likely
		starToAtmosphere.get(StarFactory.YELO_GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Carbon);
		starToChemicalProfile.setUltraVioletReducingScale(36.0);
		starToChemicalProfile.setWeightDuringAnalysis(13.0);
		starToAtmosphere.get(StarFactory.YELO_GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Helium);
		starToChemicalProfile.setUltraVioletReducingScale(14.0);
		starToChemicalProfile.setWeightDuringAnalysis(75.0);
		starToAtmosphere.get(StarFactory.YELO_GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Hydrogen);
		starToChemicalProfile.setUltraVioletReducingScale(12.0);
		starToChemicalProfile.setWeightDuringAnalysis(97.0);
		starToAtmosphere.get(StarFactory.YELO_GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Neon);
		starToChemicalProfile.setUltraVioletReducingScale(48.0);
		starToChemicalProfile.setWeightDuringAnalysis(8.0);
		starToAtmosphere.get(StarFactory.YELO_GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Nitrogen);
		starToChemicalProfile.setUltraVioletReducingScale(22.0);
		starToChemicalProfile.setWeightDuringAnalysis(90.0);
		starToAtmosphere.get(StarFactory.YELO_GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Oxygen);
		starToChemicalProfile.setUltraVioletReducingScale(33.0);
		starToChemicalProfile.setWeightDuringAnalysis(35.0);
		starToAtmosphere.get(StarFactory.YELO_GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Silicon);
		starToChemicalProfile.setUltraVioletReducingScale(42.0);
		starToChemicalProfile.setWeightDuringAnalysis(8.0);
		starToAtmosphere.get(StarFactory.YELO_GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Water);
		starToChemicalProfile.setUltraVioletReducingScale(44.0);
		starToChemicalProfile.setWeightDuringAnalysis(14.0);
		starToAtmosphere.get(StarFactory.YELO_GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Potassium);
		starToChemicalProfile.setUltraVioletReducingScale(5.0);
		starToChemicalProfile.setWeightDuringAnalysis(6.0);
		starToAtmosphere.get(StarFactory.YELO_GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sodium);
		starToChemicalProfile.setUltraVioletReducingScale(5.0);
		starToChemicalProfile.setWeightDuringAnalysis(6.0);
		starToAtmosphere.get(StarFactory.YELO_GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sulfur);
		starToChemicalProfile.setUltraVioletReducingScale(5.0);
		starToChemicalProfile.setWeightDuringAnalysis(6.0);
		starToAtmosphere.get(StarFactory.YELO_GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.SulfuricAcid);
		starToChemicalProfile.setUltraVioletReducingScale(5.0);
		starToChemicalProfile.setWeightDuringAnalysis(6.0);
		starToAtmosphere.get(StarFactory.YELO_GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.CarbonDioxide);
		starToChemicalProfile.setUltraVioletReducingScale(5.0);
		starToChemicalProfile.setWeightDuringAnalysis(15.0);
		starToAtmosphere.get(StarFactory.YELO_GI_I).add(starToChemicalProfile);
		
		starToAtmosphere.put(StarFactory.ORNG_GI_II, new ArrayList<StarToChemicalProfile>());
		// ORNG_GI_II

		// uv and reducing: 01 is extreme UV and 99 is extreme reducing
		
		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Argon);
		starToChemicalProfile.setUltraVioletReducingScale(60.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0); // high rates more
															// higher
															// probability
		starToAtmosphere.get(StarFactory.ORNG_GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Carbon);
		starToChemicalProfile.setUltraVioletReducingScale(47.0);
		starToChemicalProfile.setWeightDuringAnalysis(15.0);
		starToAtmosphere.get(StarFactory.ORNG_GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Helium);
		starToChemicalProfile.setUltraVioletReducingScale(4.0);
		starToChemicalProfile.setWeightDuringAnalysis(68.0);
		starToAtmosphere.get(StarFactory.ORNG_GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Hydrogen);
		starToChemicalProfile.setUltraVioletReducingScale(1.0);
		starToChemicalProfile.setWeightDuringAnalysis(98.0);
		starToAtmosphere.get(StarFactory.ORNG_GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Neon);
		starToChemicalProfile.setUltraVioletReducingScale(52.0);
		starToChemicalProfile.setWeightDuringAnalysis(2.0);
		starToAtmosphere.get(StarFactory.ORNG_GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Nitrogen);
		starToChemicalProfile.setUltraVioletReducingScale(6.0);
		starToChemicalProfile.setWeightDuringAnalysis(88.0);
		starToAtmosphere.get(StarFactory.ORNG_GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Oxygen);
		starToChemicalProfile.setUltraVioletReducingScale(18.0);
		starToChemicalProfile.setWeightDuringAnalysis(15.0);
		starToAtmosphere.get(StarFactory.ORNG_GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Silicon);
		starToChemicalProfile.setUltraVioletReducingScale(30.0);
		starToChemicalProfile.setWeightDuringAnalysis(10.0);
		starToAtmosphere.get(StarFactory.ORNG_GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Water);
		starToChemicalProfile.setUltraVioletReducingScale(30.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.ORNG_GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Potassium);
		starToChemicalProfile.setUltraVioletReducingScale(2.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.ORNG_GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sodium);
		starToChemicalProfile.setUltraVioletReducingScale(2.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.ORNG_GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sulfur);
		starToChemicalProfile.setUltraVioletReducingScale(2.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.ORNG_GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.SulfuricAcid);
		starToChemicalProfile.setUltraVioletReducingScale(2.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.ORNG_GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.CarbonDioxide);
		starToChemicalProfile.setUltraVioletReducingScale(2.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.ORNG_GI_II).add(starToChemicalProfile);

		starToAtmosphere.put(StarFactory.ORNG_GI_I, new ArrayList<StarToChemicalProfile>());
		// ORNG_GI_I

		// uv and reducing: 01 is extreme UV and 99 is extreme reducing
		
		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Argon);
		starToChemicalProfile.setUltraVioletReducingScale(60.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0); // high rates more
															// higher
															// probability
		starToAtmosphere.get(StarFactory.ORNG_GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Carbon);
		starToChemicalProfile.setUltraVioletReducingScale(47.0);
		starToChemicalProfile.setWeightDuringAnalysis(15.0);
		starToAtmosphere.get(StarFactory.ORNG_GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Helium);
		starToChemicalProfile.setUltraVioletReducingScale(4.0);
		starToChemicalProfile.setWeightDuringAnalysis(68.0);
		starToAtmosphere.get(StarFactory.ORNG_GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Hydrogen);
		starToChemicalProfile.setUltraVioletReducingScale(1.0);
		starToChemicalProfile.setWeightDuringAnalysis(98.0);
		starToAtmosphere.get(StarFactory.ORNG_GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Neon);
		starToChemicalProfile.setUltraVioletReducingScale(52.0);
		starToChemicalProfile.setWeightDuringAnalysis(2.0);
		starToAtmosphere.get(StarFactory.ORNG_GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Nitrogen);
		starToChemicalProfile.setUltraVioletReducingScale(6.0);
		starToChemicalProfile.setWeightDuringAnalysis(88.0);
		starToAtmosphere.get(StarFactory.ORNG_GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Oxygen);
		starToChemicalProfile.setUltraVioletReducingScale(18.0);
		starToChemicalProfile.setWeightDuringAnalysis(15.0);
		starToAtmosphere.get(StarFactory.ORNG_GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Silicon);
		starToChemicalProfile.setUltraVioletReducingScale(30.0);
		starToChemicalProfile.setWeightDuringAnalysis(10.0);
		starToAtmosphere.get(StarFactory.ORNG_GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Water);
		starToChemicalProfile.setUltraVioletReducingScale(30.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.ORNG_GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Potassium);
		starToChemicalProfile.setUltraVioletReducingScale(2.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.ORNG_GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sodium);
		starToChemicalProfile.setUltraVioletReducingScale(2.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.ORNG_GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sulfur);
		starToChemicalProfile.setUltraVioletReducingScale(2.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.ORNG_GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.SulfuricAcid);
		starToChemicalProfile.setUltraVioletReducingScale(2.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.ORNG_GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.CarbonDioxide);
		starToChemicalProfile.setUltraVioletReducingScale(2.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.ORNG_GI_I).add(starToChemicalProfile);

		starToAtmosphere.put(StarFactory.RED__GI_II, new ArrayList<StarToChemicalProfile>());
		// RED__GI_II

		// uv and reducing: 01 is extreme UV and 99 is extreme reducing

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Argon);
		starToChemicalProfile.setUltraVioletReducingScale(62.0);
		starToChemicalProfile.setWeightDuringAnalysis(8.0); // high means
															// increased
															// probability
		starToAtmosphere.get(StarFactory.RED__GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Carbon);
		starToChemicalProfile.setUltraVioletReducingScale(44.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.RED__GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Helium);
		starToChemicalProfile.setUltraVioletReducingScale(10.0);
		starToChemicalProfile.setWeightDuringAnalysis(70.0);
		starToAtmosphere.get(StarFactory.RED__GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Hydrogen);
		starToChemicalProfile.setUltraVioletReducingScale(7.0);
		starToChemicalProfile.setWeightDuringAnalysis(99.0);
		starToAtmosphere.get(StarFactory.RED__GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Neon);
		starToChemicalProfile.setUltraVioletReducingScale(54.0);
		starToChemicalProfile.setWeightDuringAnalysis(4.0);
		starToAtmosphere.get(StarFactory.RED__GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Nitrogen);
		starToChemicalProfile.setUltraVioletReducingScale(10.0);
		starToChemicalProfile.setWeightDuringAnalysis(90.0);
		starToAtmosphere.get(StarFactory.RED__GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Oxygen);
		starToChemicalProfile.setUltraVioletReducingScale(22.0);
		starToChemicalProfile.setWeightDuringAnalysis(20.0);
		starToAtmosphere.get(StarFactory.RED__GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Silicon);
		starToChemicalProfile.setUltraVioletReducingScale(36.0);
		starToChemicalProfile.setWeightDuringAnalysis(2.0);
		starToAtmosphere.get(StarFactory.RED__GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Water);
		starToChemicalProfile.setUltraVioletReducingScale(35.0);
		starToChemicalProfile.setWeightDuringAnalysis(22.0);
		starToAtmosphere.get(StarFactory.RED__GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Potassium);
		starToChemicalProfile.setUltraVioletReducingScale(25.0);
		starToChemicalProfile.setWeightDuringAnalysis(10.0);
		starToAtmosphere.get(StarFactory.RED__GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sodium);
		starToChemicalProfile.setUltraVioletReducingScale(25.0);
		starToChemicalProfile.setWeightDuringAnalysis(10.0);
		starToAtmosphere.get(StarFactory.RED__GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sulfur);
		starToChemicalProfile.setUltraVioletReducingScale(25.0);
		starToChemicalProfile.setWeightDuringAnalysis(20.0);
		starToAtmosphere.get(StarFactory.RED__GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.SulfuricAcid);
		starToChemicalProfile.setUltraVioletReducingScale(22.0);
		starToChemicalProfile.setWeightDuringAnalysis(15.0);
		starToAtmosphere.get(StarFactory.RED__GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.CarbonDioxide);
		starToChemicalProfile.setUltraVioletReducingScale(10.0);
		starToChemicalProfile.setWeightDuringAnalysis(20.0);
		starToAtmosphere.get(StarFactory.RED__GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Methane);
		starToChemicalProfile.setUltraVioletReducingScale(25.0);
		starToChemicalProfile.setWeightDuringAnalysis(20.0);
		starToAtmosphere.get(StarFactory.RED__GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Ethane);
		starToChemicalProfile.setUltraVioletReducingScale(26.0);
		starToChemicalProfile.setWeightDuringAnalysis(8.0);
		starToAtmosphere.get(StarFactory.RED__GI_II).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile
				.setAtmosphereParts(AtmosphereParts.HydrogenSulfide);
		starToChemicalProfile.setUltraVioletReducingScale(42.0);
		starToChemicalProfile.setWeightDuringAnalysis(8.0);
		starToAtmosphere.get(StarFactory.RED__GI_II).add(starToChemicalProfile);
		
		starToAtmosphere.put(StarFactory.RED__GI_I, new ArrayList<StarToChemicalProfile>());
		// RED__GI_I

		// uv and reducing: 01 is extreme UV and 99 is extreme reducing

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Argon);
		starToChemicalProfile.setUltraVioletReducingScale(62.0);
		starToChemicalProfile.setWeightDuringAnalysis(8.0); // high means
															// increased
															// probability
		starToAtmosphere.get(StarFactory.RED__GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Carbon);
		starToChemicalProfile.setUltraVioletReducingScale(44.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.RED__GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Helium);
		starToChemicalProfile.setUltraVioletReducingScale(10.0);
		starToChemicalProfile.setWeightDuringAnalysis(70.0);
		starToAtmosphere.get(StarFactory.RED__GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Hydrogen);
		starToChemicalProfile.setUltraVioletReducingScale(7.0);
		starToChemicalProfile.setWeightDuringAnalysis(99.0);
		starToAtmosphere.get(StarFactory.RED__GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Neon);
		starToChemicalProfile.setUltraVioletReducingScale(54.0);
		starToChemicalProfile.setWeightDuringAnalysis(4.0);
		starToAtmosphere.get(StarFactory.RED__GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Nitrogen);
		starToChemicalProfile.setUltraVioletReducingScale(10.0);
		starToChemicalProfile.setWeightDuringAnalysis(90.0);
		starToAtmosphere.get(StarFactory.RED__GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Oxygen);
		starToChemicalProfile.setUltraVioletReducingScale(22.0);
		starToChemicalProfile.setWeightDuringAnalysis(20.0);
		starToAtmosphere.get(StarFactory.RED__GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Silicon);
		starToChemicalProfile.setUltraVioletReducingScale(36.0);
		starToChemicalProfile.setWeightDuringAnalysis(2.0);
		starToAtmosphere.get(StarFactory.RED__GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Water);
		starToChemicalProfile.setUltraVioletReducingScale(35.0);
		starToChemicalProfile.setWeightDuringAnalysis(22.0);
		starToAtmosphere.get(StarFactory.RED__GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Potassium);
		starToChemicalProfile.setUltraVioletReducingScale(25.0);
		starToChemicalProfile.setWeightDuringAnalysis(10.0);
		starToAtmosphere.get(StarFactory.RED__GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sodium);
		starToChemicalProfile.setUltraVioletReducingScale(25.0);
		starToChemicalProfile.setWeightDuringAnalysis(10.0);
		starToAtmosphere.get(StarFactory.RED__GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sulfur);
		starToChemicalProfile.setUltraVioletReducingScale(25.0);
		starToChemicalProfile.setWeightDuringAnalysis(20.0);
		starToAtmosphere.get(StarFactory.RED__GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.SulfuricAcid);
		starToChemicalProfile.setUltraVioletReducingScale(22.0);
		starToChemicalProfile.setWeightDuringAnalysis(15.0);
		starToAtmosphere.get(StarFactory.RED__GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.CarbonDioxide);
		starToChemicalProfile.setUltraVioletReducingScale(10.0);
		starToChemicalProfile.setWeightDuringAnalysis(20.0);
		starToAtmosphere.get(StarFactory.RED__GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Methane);
		starToChemicalProfile.setUltraVioletReducingScale(25.0);
		starToChemicalProfile.setWeightDuringAnalysis(20.0);
		starToAtmosphere.get(StarFactory.RED__GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Ethane);
		starToChemicalProfile.setUltraVioletReducingScale(26.0);
		starToChemicalProfile.setWeightDuringAnalysis(8.0);
		starToAtmosphere.get(StarFactory.RED__GI_I).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile
				.setAtmosphereParts(AtmosphereParts.HydrogenSulfide);
		starToChemicalProfile.setUltraVioletReducingScale(42.0);
		starToChemicalProfile.setWeightDuringAnalysis(8.0);
		starToAtmosphere.get(StarFactory.RED__GI_I).add(starToChemicalProfile);
		
		starToAtmosphere.put(StarFactory.BLUE_SUBGI, new ArrayList<StarToChemicalProfile>());
		// uv and reducing: 01 is extreme UV and 99 is extreme reducing

		// BLUE_SUBGI
		
		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Argon);
		starToChemicalProfile.setUltraVioletReducingScale(60.0);
		starToChemicalProfile.setWeightDuringAnalysis(8.0); // high means
															// greater
															// probability
		starToAtmosphere.get(StarFactory.BLUE_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Carbon);
		starToChemicalProfile.setUltraVioletReducingScale(40.0);
		starToChemicalProfile.setWeightDuringAnalysis(12.0);
		starToAtmosphere.get(StarFactory.BLUE_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Helium);
		starToChemicalProfile.setUltraVioletReducingScale(10.0);
		starToChemicalProfile.setWeightDuringAnalysis(75.0);
		starToAtmosphere.get(StarFactory.BLUE_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Hydrogen);
		starToChemicalProfile.setUltraVioletReducingScale(6.0);
		starToChemicalProfile.setWeightDuringAnalysis(96.0);
		starToAtmosphere.get(StarFactory.BLUE_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Neon);
		starToChemicalProfile.setUltraVioletReducingScale(54.0);
		starToChemicalProfile.setWeightDuringAnalysis(3.0);
		starToAtmosphere.get(StarFactory.BLUE_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Nitrogen);
		starToChemicalProfile.setUltraVioletReducingScale(10.0);
		starToChemicalProfile.setWeightDuringAnalysis(90.0);
		starToAtmosphere.get(StarFactory.BLUE_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Oxygen);
		starToChemicalProfile.setUltraVioletReducingScale(22.0);
		starToChemicalProfile.setWeightDuringAnalysis(12.0);
		starToAtmosphere.get(StarFactory.BLUE_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Silicon);
		starToChemicalProfile.setUltraVioletReducingScale(36.0);
		starToChemicalProfile.setWeightDuringAnalysis(15.0);
		starToAtmosphere.get(StarFactory.BLUE_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Water);
		starToChemicalProfile.setUltraVioletReducingScale(35.0);
		starToChemicalProfile.setWeightDuringAnalysis(7.0);
		starToAtmosphere.get(StarFactory.BLUE_SUBGI).add(starToChemicalProfile);

		starToAtmosphere.put(StarFactory.LTBL_SUBGI, new ArrayList<StarToChemicalProfile>());
		// LTBL_SUBGI

		// uv and reducing: 01 is extreme UV and 99 is extreme reducing

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Argon);
		starToChemicalProfile.setUltraVioletReducingScale(62.0);
		starToChemicalProfile.setWeightDuringAnalysis(6.0); // high rates more
		starToAtmosphere.get(StarFactory.LTBL_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Carbon);
		starToChemicalProfile.setUltraVioletReducingScale(45.0);
		starToChemicalProfile.setWeightDuringAnalysis(18.0);
		starToAtmosphere.get(StarFactory.LTBL_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Helium);
		starToChemicalProfile.setUltraVioletReducingScale(10.0);
		starToChemicalProfile.setWeightDuringAnalysis(70.0);
		starToAtmosphere.get(StarFactory.LTBL_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Hydrogen);
		starToChemicalProfile.setUltraVioletReducingScale(6.0);
		starToChemicalProfile.setWeightDuringAnalysis(98.0);
		starToAtmosphere.get(StarFactory.LTBL_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Neon);
		starToChemicalProfile.setUltraVioletReducingScale(54.0);
		starToChemicalProfile.setWeightDuringAnalysis(6.0);
		starToAtmosphere.get(StarFactory.LTBL_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Nitrogen);
		starToChemicalProfile.setUltraVioletReducingScale(8.0);
		starToChemicalProfile.setWeightDuringAnalysis(90.0);
		starToAtmosphere.get(StarFactory.LTBL_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Oxygen);
		starToChemicalProfile.setUltraVioletReducingScale(24.0);
		starToChemicalProfile.setWeightDuringAnalysis(18.0);
		starToAtmosphere.get(StarFactory.LTBL_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Silicon);
		starToChemicalProfile.setUltraVioletReducingScale(38.0);
		starToChemicalProfile.setWeightDuringAnalysis(12.0);
		starToAtmosphere.get(StarFactory.LTBL_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Water);
		starToChemicalProfile.setUltraVioletReducingScale(35.0);
		starToChemicalProfile.setWeightDuringAnalysis(6.0);
		starToAtmosphere.get(StarFactory.LTBL_SUBGI).add(starToChemicalProfile);

		starToAtmosphere.put(StarFactory.WHIT_SUBGI, new ArrayList<StarToChemicalProfile>());
		// WHIT_SUBGI

		// uv and reducing: 01 is extreme UV and 99 is extreme reducing

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Argon);
		starToChemicalProfile.setUltraVioletReducingScale(58.0);
		starToChemicalProfile.setWeightDuringAnalysis(9.0); // high rates more
															// probable
		starToAtmosphere.get(StarFactory.WHIT_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Carbon);
		starToChemicalProfile.setUltraVioletReducingScale(50.0);
		starToChemicalProfile.setWeightDuringAnalysis(20.0);
		starToAtmosphere.get(StarFactory.WHIT_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Helium);
		starToChemicalProfile.setUltraVioletReducingScale(10.0);
		starToChemicalProfile.setWeightDuringAnalysis(74.0);
		starToAtmosphere.get(StarFactory.WHIT_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Hydrogen);
		starToChemicalProfile.setUltraVioletReducingScale(6.0);
		starToChemicalProfile.setWeightDuringAnalysis(99.0);
		starToAtmosphere.get(StarFactory.WHIT_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Neon);
		starToChemicalProfile.setUltraVioletReducingScale(54.0);
		starToChemicalProfile.setWeightDuringAnalysis(7.0);
		starToAtmosphere.get(StarFactory.WHIT_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Nitrogen);
		starToChemicalProfile.setUltraVioletReducingScale(12.0);
		starToChemicalProfile.setWeightDuringAnalysis(86.0);
		starToAtmosphere.get(StarFactory.WHIT_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Oxygen);
		starToChemicalProfile.setUltraVioletReducingScale(25.0);
		starToChemicalProfile.setWeightDuringAnalysis(22.0);
		starToAtmosphere.get(StarFactory.WHIT_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Silicon);
		starToChemicalProfile.setUltraVioletReducingScale(32.0);
		starToChemicalProfile.setWeightDuringAnalysis(10.0);
		starToAtmosphere.get(StarFactory.WHIT_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Water);
		starToChemicalProfile.setUltraVioletReducingScale(36.0);
		starToChemicalProfile.setWeightDuringAnalysis(8.0);
		starToAtmosphere.get(StarFactory.WHIT_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.CarbonDioxide);
		starToChemicalProfile.setUltraVioletReducingScale(6.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.WHIT_SUBGI).add(starToChemicalProfile);
		
		starToAtmosphere.put(StarFactory.PYEL_SUBGI, new ArrayList<StarToChemicalProfile>());
		// PYEL_SUBGI

		// uv and reducing: 01 is extreme UV and 99 is extreme reducing

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Argon);
		starToChemicalProfile.setUltraVioletReducingScale(60.0);
		starToChemicalProfile.setWeightDuringAnalysis(12.0); // high rates more
																// likely
		starToAtmosphere.get(StarFactory.PYEL_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Carbon);
		starToChemicalProfile.setUltraVioletReducingScale(38.0);
		starToChemicalProfile.setWeightDuringAnalysis(15.0);
		starToAtmosphere.get(StarFactory.PYEL_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Helium);
		starToChemicalProfile.setUltraVioletReducingScale(18.0);
		starToChemicalProfile.setWeightDuringAnalysis(78.0);
		starToAtmosphere.get(StarFactory.PYEL_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Hydrogen);
		starToChemicalProfile.setUltraVioletReducingScale(18.0);
		starToChemicalProfile.setWeightDuringAnalysis(97.0);
		starToAtmosphere.get(StarFactory.PYEL_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Neon);
		starToChemicalProfile.setUltraVioletReducingScale(50.0);
		starToChemicalProfile.setWeightDuringAnalysis(8.0);
		starToAtmosphere.get(StarFactory.PYEL_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Nitrogen);
		starToChemicalProfile.setUltraVioletReducingScale(26.0);
		starToChemicalProfile.setWeightDuringAnalysis(92.0);
		starToAtmosphere.get(StarFactory.PYEL_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Oxygen);
		starToChemicalProfile.setUltraVioletReducingScale(38.0);
		starToChemicalProfile.setWeightDuringAnalysis(38.0);
		starToAtmosphere.get(StarFactory.PYEL_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Silicon);
		starToChemicalProfile.setUltraVioletReducingScale(42.0);
		starToChemicalProfile.setWeightDuringAnalysis(6.0);
		starToAtmosphere.get(StarFactory.PYEL_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Water);
		starToChemicalProfile.setUltraVioletReducingScale(44.0);
		starToChemicalProfile.setWeightDuringAnalysis(14.0);
		starToAtmosphere.get(StarFactory.PYEL_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Potassium);
		starToChemicalProfile.setUltraVioletReducingScale(5.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.PYEL_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sodium);
		starToChemicalProfile.setUltraVioletReducingScale(5.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.PYEL_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sulfur);
		starToChemicalProfile.setUltraVioletReducingScale(10.0);
		starToChemicalProfile.setWeightDuringAnalysis(8.0);
		starToAtmosphere.get(StarFactory.PYEL_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.SulfuricAcid);
		starToChemicalProfile.setUltraVioletReducingScale(5.0);
		starToChemicalProfile.setWeightDuringAnalysis(7.0);
		starToAtmosphere.get(StarFactory.PYEL_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.CarbonDioxide);
		starToChemicalProfile.setUltraVioletReducingScale(9.0);
		starToChemicalProfile.setWeightDuringAnalysis(19.0);
		starToAtmosphere.get(StarFactory.PYEL_SUBGI).add(starToChemicalProfile);

		
		starToAtmosphere.put(StarFactory.YELO_SUBGI, new ArrayList<StarToChemicalProfile>());
		// YELO_SUBGI

		// uv and reducing: 01 is extreme UV and 99 is extreme reducing

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Argon);
		starToChemicalProfile.setUltraVioletReducingScale(60.0);
		starToChemicalProfile.setWeightDuringAnalysis(12.0); // high rates more
																// likely
		starToAtmosphere.get(StarFactory.YELO_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Carbon);
		starToChemicalProfile.setUltraVioletReducingScale(38.0);
		starToChemicalProfile.setWeightDuringAnalysis(15.0);
		starToAtmosphere.get(StarFactory.YELO_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Helium);
		starToChemicalProfile.setUltraVioletReducingScale(18.0);
		starToChemicalProfile.setWeightDuringAnalysis(78.0);
		starToAtmosphere.get(StarFactory.YELO_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Hydrogen);
		starToChemicalProfile.setUltraVioletReducingScale(18.0);
		starToChemicalProfile.setWeightDuringAnalysis(97.0);
		starToAtmosphere.get(StarFactory.YELO_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Neon);
		starToChemicalProfile.setUltraVioletReducingScale(50.0);
		starToChemicalProfile.setWeightDuringAnalysis(8.0);
		starToAtmosphere.get(StarFactory.YELO_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Nitrogen);
		starToChemicalProfile.setUltraVioletReducingScale(26.0);
		starToChemicalProfile.setWeightDuringAnalysis(92.0);
		starToAtmosphere.get(StarFactory.YELO_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Oxygen);
		starToChemicalProfile.setUltraVioletReducingScale(38.0);
		starToChemicalProfile.setWeightDuringAnalysis(38.0);
		starToAtmosphere.get(StarFactory.YELO_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Silicon);
		starToChemicalProfile.setUltraVioletReducingScale(42.0);
		starToChemicalProfile.setWeightDuringAnalysis(6.0);
		starToAtmosphere.get(StarFactory.YELO_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Water);
		starToChemicalProfile.setUltraVioletReducingScale(44.0);
		starToChemicalProfile.setWeightDuringAnalysis(14.0);
		starToAtmosphere.get(StarFactory.YELO_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Potassium);
		starToChemicalProfile.setUltraVioletReducingScale(5.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.YELO_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sodium);
		starToChemicalProfile.setUltraVioletReducingScale(5.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.YELO_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sulfur);
		starToChemicalProfile.setUltraVioletReducingScale(10.0);
		starToChemicalProfile.setWeightDuringAnalysis(8.0);
		starToAtmosphere.get(StarFactory.YELO_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.SulfuricAcid);
		starToChemicalProfile.setUltraVioletReducingScale(5.0);
		starToChemicalProfile.setWeightDuringAnalysis(7.0);
		starToAtmosphere.get(StarFactory.YELO_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.CarbonDioxide);
		starToChemicalProfile.setUltraVioletReducingScale(9.0);
		starToChemicalProfile.setWeightDuringAnalysis(19.0);
		starToAtmosphere.get(StarFactory.YELO_SUBGI).add(starToChemicalProfile);

		starToAtmosphere.put(StarFactory.ORNG_SUBGI, new ArrayList<StarToChemicalProfile>());
		// ORNG_SUBGI

		// uv and reducing: 01 is extreme UV and 99 is extreme reducing

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Argon);
		starToChemicalProfile.setUltraVioletReducingScale(70.0);
		starToChemicalProfile.setWeightDuringAnalysis(8.0); // high rates more
															// higher
															// probability
		starToAtmosphere.get(StarFactory.ORNG_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Carbon);
		starToChemicalProfile.setUltraVioletReducingScale(52.0);
		starToChemicalProfile.setWeightDuringAnalysis(20.0);
		starToAtmosphere.get(StarFactory.ORNG_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Helium);
		starToChemicalProfile.setUltraVioletReducingScale(20.0);
		starToChemicalProfile.setWeightDuringAnalysis(75.0);
		starToAtmosphere.get(StarFactory.ORNG_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Hydrogen);
		starToChemicalProfile.setUltraVioletReducingScale(16.0);
		starToChemicalProfile.setWeightDuringAnalysis(98.0);
		starToAtmosphere.get(StarFactory.ORNG_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Neon);
		starToChemicalProfile.setUltraVioletReducingScale(58.0);
		starToChemicalProfile.setWeightDuringAnalysis(7.0);
		starToAtmosphere.get(StarFactory.ORNG_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Nitrogen);
		starToChemicalProfile.setUltraVioletReducingScale(18.0);
		starToChemicalProfile.setWeightDuringAnalysis(92.0);
		starToAtmosphere.get(StarFactory.ORNG_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Oxygen);
		starToChemicalProfile.setUltraVioletReducingScale(29.0);
		starToChemicalProfile.setWeightDuringAnalysis(24.0);
		starToAtmosphere.get(StarFactory.ORNG_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Silicon);
		starToChemicalProfile.setUltraVioletReducingScale(34.0);
		starToChemicalProfile.setWeightDuringAnalysis(8.0);
		starToAtmosphere.get(StarFactory.ORNG_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Water);
		starToChemicalProfile.setUltraVioletReducingScale(39.0);
		starToChemicalProfile.setWeightDuringAnalysis(19.0);
		starToAtmosphere.get(StarFactory.ORNG_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Potassium);
		starToChemicalProfile.setUltraVioletReducingScale(35.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.ORNG_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sodium);
		starToChemicalProfile.setUltraVioletReducingScale(35.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.ORNG_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sulfur);
		starToChemicalProfile.setUltraVioletReducingScale(36.0);
		starToChemicalProfile.setWeightDuringAnalysis(16.0);
		starToAtmosphere.get(StarFactory.ORNG_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.SulfuricAcid);
		starToChemicalProfile.setUltraVioletReducingScale(16.0);
		starToChemicalProfile.setWeightDuringAnalysis(2.0);
		starToAtmosphere.get(StarFactory.ORNG_SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.CarbonDioxide);
		starToChemicalProfile.setUltraVioletReducingScale(18.0);
		starToChemicalProfile.setWeightDuringAnalysis(10.0);
		starToAtmosphere.get(StarFactory.ORNG_SUBGI).add(starToChemicalProfile);
		
		starToAtmosphere.put(StarFactory.RED__SUBGI, new ArrayList<StarToChemicalProfile>());
		// RED__SUBGI

		// uv and reducing: 01 is extreme UV and 99 is extreme reducing

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Argon);
		starToChemicalProfile.setUltraVioletReducingScale(72.0);
		starToChemicalProfile.setWeightDuringAnalysis(10.0); // high means
																// increased
																// probability
		starToAtmosphere.get(StarFactory.RED__SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Carbon);
		starToChemicalProfile.setUltraVioletReducingScale(50.0);
		starToChemicalProfile.setWeightDuringAnalysis(8.0);
		starToAtmosphere.get(StarFactory.RED__SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Helium);
		starToChemicalProfile.setUltraVioletReducingScale(8.0);
		starToChemicalProfile.setWeightDuringAnalysis(74.0);
		starToAtmosphere.get(StarFactory.RED__SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Hydrogen);
		starToChemicalProfile.setUltraVioletReducingScale(5.0);
		starToChemicalProfile.setWeightDuringAnalysis(99.0);
		starToAtmosphere.get(StarFactory.RED__SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Neon);
		starToChemicalProfile.setUltraVioletReducingScale(50.0);
		starToChemicalProfile.setWeightDuringAnalysis(4.0);
		starToAtmosphere.get(StarFactory.RED__SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Nitrogen);
		starToChemicalProfile.setUltraVioletReducingScale(8.0);
		starToChemicalProfile.setWeightDuringAnalysis(92.0);
		starToAtmosphere.get(StarFactory.RED__SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Oxygen);
		starToChemicalProfile.setUltraVioletReducingScale(15.0);
		starToChemicalProfile.setWeightDuringAnalysis(28.0);
		starToAtmosphere.get(StarFactory.RED__SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Silicon);
		starToChemicalProfile.setUltraVioletReducingScale(7.0);
		starToChemicalProfile.setWeightDuringAnalysis(6.0);
		starToAtmosphere.get(StarFactory.RED__SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Water);
		starToChemicalProfile.setUltraVioletReducingScale(4.0);
		starToChemicalProfile.setWeightDuringAnalysis(29.0);
		starToAtmosphere.get(StarFactory.RED__SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Potassium);
		starToChemicalProfile.setUltraVioletReducingScale(25.0);
		starToChemicalProfile.setWeightDuringAnalysis(10.0);
		starToAtmosphere.get(StarFactory.RED__SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sodium);
		starToChemicalProfile.setUltraVioletReducingScale(25.0);
		starToChemicalProfile.setWeightDuringAnalysis(10.0);
		starToAtmosphere.get(StarFactory.RED__SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sulfur);
		starToChemicalProfile.setUltraVioletReducingScale(25.0);
		starToChemicalProfile.setWeightDuringAnalysis(20.0);
		starToAtmosphere.get(StarFactory.RED__SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.SulfuricAcid);
		starToChemicalProfile.setUltraVioletReducingScale(22.0);
		starToChemicalProfile.setWeightDuringAnalysis(15.0);
		starToAtmosphere.get(StarFactory.RED__SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.CarbonDioxide);
		starToChemicalProfile.setUltraVioletReducingScale(10.0);
		starToChemicalProfile.setWeightDuringAnalysis(20.0);
		starToAtmosphere.get(StarFactory.RED__SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Methane);
		starToChemicalProfile.setUltraVioletReducingScale(20.0);
		starToChemicalProfile.setWeightDuringAnalysis(29.0);
		starToAtmosphere.get(StarFactory.RED__SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Ethane);
		starToChemicalProfile.setUltraVioletReducingScale(26.0);
		starToChemicalProfile.setWeightDuringAnalysis(28.0);
		starToAtmosphere.get(StarFactory.RED__SUBGI).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile
				.setAtmosphereParts(AtmosphereParts.HydrogenSulfide);
		starToChemicalProfile.setUltraVioletReducingScale(42.0);
		starToChemicalProfile.setWeightDuringAnalysis(8.0);
		starToAtmosphere.get(StarFactory.RED__SUBGI).add(starToChemicalProfile);

		starToAtmosphere.put(StarFactory.BLUE_MAINS, new ArrayList<StarToChemicalProfile>());
		// BLUE_MAINS

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Argon);
		starToChemicalProfile.setUltraVioletReducingScale(62.0);
		starToChemicalProfile.setWeightDuringAnalysis(8.0); // high means
															// greater
															// probability
		starToAtmosphere.get(StarFactory.BLUE_MAINS).add(starToChemicalProfile);

		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Carbon);
		starToChemicalProfile.setUltraVioletReducingScale(42.0);
		starToChemicalProfile.setWeightDuringAnalysis(12.0);
		starToAtmosphere.get(StarFactory.BLUE_MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Helium);
		starToChemicalProfile.setUltraVioletReducingScale(8.0);
		starToChemicalProfile.setWeightDuringAnalysis(75.0);
		starToAtmosphere.get(StarFactory.BLUE_MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Hydrogen);
		starToChemicalProfile.setUltraVioletReducingScale(8.0);
		starToChemicalProfile.setWeightDuringAnalysis(96.0);
		starToAtmosphere.get(StarFactory.BLUE_MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Neon);
		starToChemicalProfile.setUltraVioletReducingScale(50.0);
		starToChemicalProfile.setWeightDuringAnalysis(3.0);
		starToAtmosphere.get(StarFactory.BLUE_MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Nitrogen);
		starToChemicalProfile.setUltraVioletReducingScale(12.0);
		starToChemicalProfile.setWeightDuringAnalysis(90.0);
		starToAtmosphere.get(StarFactory.BLUE_MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Oxygen);
		starToChemicalProfile.setUltraVioletReducingScale(22.0);
		starToChemicalProfile.setWeightDuringAnalysis(12.0);
		starToAtmosphere.get(StarFactory.BLUE_MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Silicon);
		starToChemicalProfile.setUltraVioletReducingScale(31.0);
		starToChemicalProfile.setWeightDuringAnalysis(15.0);
		starToAtmosphere.get(StarFactory.BLUE_MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Water);
		starToChemicalProfile.setUltraVioletReducingScale(33.0);
		starToChemicalProfile.setWeightDuringAnalysis(7.0);
		starToAtmosphere.get(StarFactory.BLUE_MAINS).add(starToChemicalProfile);
		
		starToAtmosphere.put(StarFactory.LTBL_MAINS, new ArrayList<StarToChemicalProfile>());

		// LTBL_MAINS

		// uv and reducing: 01 is extreme UV and 99 is extreme reducing

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Argon);
		starToChemicalProfile.setUltraVioletReducingScale(62.0);
		starToChemicalProfile.setWeightDuringAnalysis(6.0); // high rates more
		starToAtmosphere.get(StarFactory.LTBL_MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Carbon);
		starToChemicalProfile.setUltraVioletReducingScale(46.0);
		starToChemicalProfile.setWeightDuringAnalysis(20.0);
		starToAtmosphere.get(StarFactory.LTBL_MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Helium);
		starToChemicalProfile.setUltraVioletReducingScale(8.0);
		starToChemicalProfile.setWeightDuringAnalysis(72.0);
		starToAtmosphere.get(StarFactory.LTBL_MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Hydrogen);
		starToChemicalProfile.setUltraVioletReducingScale(4.0);
		starToChemicalProfile.setWeightDuringAnalysis(98.0);
		starToAtmosphere.get(StarFactory.LTBL_MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Neon);
		starToChemicalProfile.setUltraVioletReducingScale(50.0);
		starToChemicalProfile.setWeightDuringAnalysis(6.0);
		starToAtmosphere.get(StarFactory.LTBL_MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Nitrogen);
		starToChemicalProfile.setUltraVioletReducingScale(6.0);
		starToChemicalProfile.setWeightDuringAnalysis(90.0);
		starToAtmosphere.get(StarFactory.LTBL_MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Oxygen);
		starToChemicalProfile.setUltraVioletReducingScale(20.0);
		starToChemicalProfile.setWeightDuringAnalysis(20.0);
		starToAtmosphere.get(StarFactory.LTBL_MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Silicon);
		starToChemicalProfile.setUltraVioletReducingScale(38.0);
		starToChemicalProfile.setWeightDuringAnalysis(12.0);
		starToAtmosphere.get(StarFactory.LTBL_MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Water);
		starToChemicalProfile.setUltraVioletReducingScale(30.0);
		starToChemicalProfile.setWeightDuringAnalysis(8.0);
		starToAtmosphere.get(StarFactory.LTBL_MAINS).add(starToChemicalProfile);

		starToAtmosphere.put(StarFactory.WHIT_MAINS, new ArrayList<StarToChemicalProfile>());
		// WHIT_MAINS

		// uv and reducing: 01 is extreme UV and 99 is extreme reducing

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Argon);
		starToChemicalProfile.setUltraVioletReducingScale(58.0);
		starToChemicalProfile.setWeightDuringAnalysis(9.0); // high rates more
															// probable
		starToAtmosphere.get(StarFactory.WHIT_MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Carbon);
		starToChemicalProfile.setUltraVioletReducingScale(50.0);
		starToChemicalProfile.setWeightDuringAnalysis(20.0);
		starToAtmosphere.get(StarFactory.WHIT_MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Helium);
		starToChemicalProfile.setUltraVioletReducingScale(10.0);
		starToChemicalProfile.setWeightDuringAnalysis(74.0);
		starToAtmosphere.get(StarFactory.WHIT_MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Hydrogen);
		starToChemicalProfile.setUltraVioletReducingScale(6.0);
		starToChemicalProfile.setWeightDuringAnalysis(99.0);
		starToAtmosphere.get(StarFactory.WHIT_MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Neon);
		starToChemicalProfile.setUltraVioletReducingScale(54.0);
		starToChemicalProfile.setWeightDuringAnalysis(7.0);
		starToAtmosphere.get(StarFactory.WHIT_MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Nitrogen);
		starToChemicalProfile.setUltraVioletReducingScale(12.0);
		starToChemicalProfile.setWeightDuringAnalysis(86.0);
		starToAtmosphere.get(StarFactory.WHIT_MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Oxygen);
		starToChemicalProfile.setUltraVioletReducingScale(25.0);
		starToChemicalProfile.setWeightDuringAnalysis(22.0);
		starToAtmosphere.get(StarFactory.WHIT_MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Silicon);
		starToChemicalProfile.setUltraVioletReducingScale(32.0);
		starToChemicalProfile.setWeightDuringAnalysis(10.0);
		starToAtmosphere.get(StarFactory.WHIT_MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Water);
		starToChemicalProfile.setUltraVioletReducingScale(36.0);
		starToChemicalProfile.setWeightDuringAnalysis(8.0);
		starToAtmosphere.get(StarFactory.WHIT_MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.CarbonDioxide);
		starToChemicalProfile.setUltraVioletReducingScale(6.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.WHIT_MAINS).add(starToChemicalProfile);

		starToAtmosphere.put(StarFactory.PYEL_MAINS, new ArrayList<StarToChemicalProfile>());
		// PYEL_MAINS

		// uv and reducing: 01 is extreme UV and 99 is extreme reducing

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Argon);
		starToChemicalProfile.setUltraVioletReducingScale(45.0);
		starToChemicalProfile.setWeightDuringAnalysis(9.0); // high rates more
															// probable
		starToAtmosphere.get(StarFactory.PYEL_MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Carbon);
		starToChemicalProfile.setUltraVioletReducingScale(40.0);
		starToChemicalProfile.setWeightDuringAnalysis(20.0);
		starToAtmosphere.get(StarFactory.PYEL_MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Helium);
		starToChemicalProfile.setUltraVioletReducingScale(8.0);
		starToChemicalProfile.setWeightDuringAnalysis(78.0);
		starToAtmosphere.get(StarFactory.PYEL_MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Hydrogen);
		starToChemicalProfile.setUltraVioletReducingScale(5.0);
		starToChemicalProfile.setWeightDuringAnalysis(99.0);
		starToAtmosphere.get(StarFactory.PYEL_MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Neon);
		starToChemicalProfile.setUltraVioletReducingScale(50.0);
		starToChemicalProfile.setWeightDuringAnalysis(7.0);
		starToAtmosphere.get(StarFactory.PYEL_MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Nitrogen);
		starToChemicalProfile.setUltraVioletReducingScale(8.0);
		starToChemicalProfile.setWeightDuringAnalysis(88.0);
		starToAtmosphere.get(StarFactory.PYEL_MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Oxygen);
		starToChemicalProfile.setUltraVioletReducingScale(20.0);
		starToChemicalProfile.setWeightDuringAnalysis(22.0);
		starToAtmosphere.get(StarFactory.PYEL_MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Silicon);
		starToChemicalProfile.setUltraVioletReducingScale(30.0);
		starToChemicalProfile.setWeightDuringAnalysis(10.0);
		starToAtmosphere.get(StarFactory.PYEL_MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Water);
		starToChemicalProfile.setUltraVioletReducingScale(30.0);
		starToChemicalProfile.setWeightDuringAnalysis(10.0);
		starToAtmosphere.get(StarFactory.PYEL_MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.CarbonDioxide);
		starToChemicalProfile.setUltraVioletReducingScale(5.0);
		starToChemicalProfile.setWeightDuringAnalysis(7.0);
		starToAtmosphere.get(StarFactory.PYEL_MAINS).add(starToChemicalProfile);
		
		starToAtmosphere.put(StarFactory.YELO_MAINS, new ArrayList<StarToChemicalProfile>());
		// YELO_MAINS

		// uv and reducing: 01 is extreme UV and 99 is extreme reducing

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Argon);
		starToChemicalProfile.setUltraVioletReducingScale(40.0);
		starToChemicalProfile.setWeightDuringAnalysis(12.0); // high rates more
																// likely
		starToAtmosphere.get(StarFactory.YELO_MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Carbon);
		starToChemicalProfile.setUltraVioletReducingScale(30.0);
		starToChemicalProfile.setWeightDuringAnalysis(15.0);
		starToAtmosphere.get(StarFactory.YELO_MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Helium);
		starToChemicalProfile.setUltraVioletReducingScale(10.0);
		starToChemicalProfile.setWeightDuringAnalysis(78.0);
		starToAtmosphere.get(StarFactory.YELO_MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Hydrogen);
		starToChemicalProfile.setUltraVioletReducingScale(10.0);
		starToChemicalProfile.setWeightDuringAnalysis(98.0);
		starToAtmosphere.get(StarFactory.YELO_MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Neon);
		starToChemicalProfile.setUltraVioletReducingScale(45.0);
		starToChemicalProfile.setWeightDuringAnalysis(4.0);
		starToAtmosphere.get(StarFactory.YELO_MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Nitrogen);
		starToChemicalProfile.setUltraVioletReducingScale(20.0);
		starToChemicalProfile.setWeightDuringAnalysis(95.0);
		starToAtmosphere.get(StarFactory.YELO_MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Oxygen);
		starToChemicalProfile.setUltraVioletReducingScale(30.0);
		starToChemicalProfile.setWeightDuringAnalysis(42.0);
		starToAtmosphere.get(StarFactory.YELO_MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Silicon);
		starToChemicalProfile.setUltraVioletReducingScale(40.0);
		starToChemicalProfile.setWeightDuringAnalysis(6.0);
		starToAtmosphere.get(StarFactory.YELO_MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Water);
		starToChemicalProfile.setUltraVioletReducingScale(35.0);
		starToChemicalProfile.setWeightDuringAnalysis(18.0);
		starToAtmosphere.get(StarFactory.YELO_MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Potassium);
		starToChemicalProfile.setUltraVioletReducingScale(5.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.YELO_MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sodium);
		starToChemicalProfile.setUltraVioletReducingScale(5.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.YELO_MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sulfur);
		starToChemicalProfile.setUltraVioletReducingScale(10.0);
		starToChemicalProfile.setWeightDuringAnalysis(8.0);
		starToAtmosphere.get(StarFactory.YELO_MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.SulfuricAcid);
		starToChemicalProfile.setUltraVioletReducingScale(5.0);
		starToChemicalProfile.setWeightDuringAnalysis(7.0);
		starToAtmosphere.get(StarFactory.YELO_MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.CarbonDioxide);
		starToChemicalProfile.setUltraVioletReducingScale(7.0);
		starToChemicalProfile.setWeightDuringAnalysis(40.0);
		starToAtmosphere.get(StarFactory.YELO_MAINS).add(starToChemicalProfile);
		
		starToAtmosphere.put(StarFactory.ORNG_MAINS, new ArrayList<StarToChemicalProfile>());
		// ORNG_MAINS

		// uv and reducing: 01 is extreme UV and 99 is extreme reducing

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Argon);
		starToChemicalProfile.setUltraVioletReducingScale(75.0);
		starToChemicalProfile.setWeightDuringAnalysis(8.0); // high rates more
															// higher
															// probability
		starToAtmosphere.get(StarFactory.ORNG_MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Carbon);
		starToChemicalProfile.setUltraVioletReducingScale(60.0);
		starToChemicalProfile.setWeightDuringAnalysis(25.0);
		starToAtmosphere.get(StarFactory.ORNG_MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Helium);
		starToChemicalProfile.setUltraVioletReducingScale(15.0);
		starToChemicalProfile.setWeightDuringAnalysis(85.0);
		starToAtmosphere.get(StarFactory.ORNG_MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Hydrogen);
		starToChemicalProfile.setUltraVioletReducingScale(10.0);
		starToChemicalProfile.setWeightDuringAnalysis(99.0);
		starToAtmosphere.get(StarFactory.ORNG_MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Neon);
		starToChemicalProfile.setUltraVioletReducingScale(50.0);
		starToChemicalProfile.setWeightDuringAnalysis(4.0);
		starToAtmosphere.get(StarFactory.ORNG_MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Nitrogen);
		starToChemicalProfile.setUltraVioletReducingScale(18.0);
		starToChemicalProfile.setWeightDuringAnalysis(92.0);
		starToAtmosphere.get(StarFactory.ORNG_MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Oxygen);
		starToChemicalProfile.setUltraVioletReducingScale(20.0);
		starToChemicalProfile.setWeightDuringAnalysis(20.0);
		starToAtmosphere.get(StarFactory.ORNG_MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Silicon);
		starToChemicalProfile.setUltraVioletReducingScale(34.0);
		starToChemicalProfile.setWeightDuringAnalysis(8.0);
		starToAtmosphere.get(StarFactory.ORNG_MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Water);
		starToChemicalProfile.setUltraVioletReducingScale(35.0);
		starToChemicalProfile.setWeightDuringAnalysis(25.0);
		starToAtmosphere.get(StarFactory.ORNG_MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Potassium);
		starToChemicalProfile.setUltraVioletReducingScale(35.0);
		starToChemicalProfile.setWeightDuringAnalysis(2.0);
		starToAtmosphere.get(StarFactory.ORNG_MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sodium);
		starToChemicalProfile.setUltraVioletReducingScale(35.0);
		starToChemicalProfile.setWeightDuringAnalysis(2.0);
		starToAtmosphere.get(StarFactory.ORNG_MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sulfur);
		starToChemicalProfile.setUltraVioletReducingScale(30.0);
		starToChemicalProfile.setWeightDuringAnalysis(18.0);
		starToAtmosphere.get(StarFactory.ORNG_MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.SulfuricAcid);
		starToChemicalProfile.setUltraVioletReducingScale(16.0);
		starToChemicalProfile.setWeightDuringAnalysis(2.0);
		starToAtmosphere.get(StarFactory.ORNG_MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.CarbonDioxide);
		starToChemicalProfile.setUltraVioletReducingScale(16.0);
		starToChemicalProfile.setWeightDuringAnalysis(15.0);
		starToAtmosphere.get(StarFactory.ORNG_MAINS).add(starToChemicalProfile);

		starToAtmosphere.put(StarFactory.RED__MAINS, new ArrayList<StarToChemicalProfile>());

		// RED__MAINS

		// uv and reducing: 01 is extreme UV and 99 is extreme reducing
		
		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Argon);
		starToChemicalProfile.setUltraVioletReducingScale(74.0);
		starToChemicalProfile.setWeightDuringAnalysis(12.0); // high means
																// increased
																// probability
		starToAtmosphere.get(StarFactory.RED__MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Carbon);
		starToChemicalProfile.setUltraVioletReducingScale(50.0);
		starToChemicalProfile.setWeightDuringAnalysis(20.0);
		starToAtmosphere.get(StarFactory.RED__MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Helium);
		starToChemicalProfile.setUltraVioletReducingScale(86.0);
		starToChemicalProfile.setWeightDuringAnalysis(85.0);
		starToAtmosphere.get(StarFactory.RED__MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Hydrogen);
		starToChemicalProfile.setUltraVioletReducingScale(84.0);
		starToChemicalProfile.setWeightDuringAnalysis(99.0);
		starToAtmosphere.get(StarFactory.RED__MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Neon);
		starToChemicalProfile.setUltraVioletReducingScale(50.0);
		starToChemicalProfile.setWeightDuringAnalysis(4.0);
		starToAtmosphere.get(StarFactory.RED__MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Nitrogen);
		starToChemicalProfile.setUltraVioletReducingScale(16.0);
		starToChemicalProfile.setWeightDuringAnalysis(92.0);
		starToAtmosphere.get(StarFactory.RED__MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Oxygen);
		starToChemicalProfile.setUltraVioletReducingScale(10.0);
		starToChemicalProfile.setWeightDuringAnalysis(20.0);
		starToAtmosphere.get(StarFactory.RED__MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Silicon);
		starToChemicalProfile.setUltraVioletReducingScale(5.0);
		starToChemicalProfile.setWeightDuringAnalysis(3.0);
		starToAtmosphere.get(StarFactory.RED__MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Water);
		starToChemicalProfile.setUltraVioletReducingScale(33.0);
		starToChemicalProfile.setWeightDuringAnalysis(20.0);
		starToAtmosphere.get(StarFactory.RED__MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Potassium);
		starToChemicalProfile.setUltraVioletReducingScale(20.0);
		starToChemicalProfile.setWeightDuringAnalysis(8.0);
		starToAtmosphere.get(StarFactory.RED__MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sodium);
		starToChemicalProfile.setUltraVioletReducingScale(8.0);
		starToChemicalProfile.setWeightDuringAnalysis(8.0);
		starToAtmosphere.get(StarFactory.RED__MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sulfur);
		starToChemicalProfile.setUltraVioletReducingScale(20.0);
		starToChemicalProfile.setWeightDuringAnalysis(30.0);
		starToAtmosphere.get(StarFactory.RED__MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.SulfuricAcid);
		starToChemicalProfile.setUltraVioletReducingScale(20.0);
		starToChemicalProfile.setWeightDuringAnalysis(18.0);
		starToAtmosphere.get(StarFactory.RED__MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.CarbonDioxide);
		starToChemicalProfile.setUltraVioletReducingScale(8.0);
		starToChemicalProfile.setWeightDuringAnalysis(25.0);
		starToAtmosphere.get(StarFactory.RED__MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Methane);
		starToChemicalProfile.setUltraVioletReducingScale(60.0);
		starToChemicalProfile.setWeightDuringAnalysis(80.0);
		starToAtmosphere.get(StarFactory.RED__MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Ethane);
		starToChemicalProfile.setUltraVioletReducingScale(45.0);
		starToChemicalProfile.setWeightDuringAnalysis(40.0);
		starToAtmosphere.get(StarFactory.RED__MAINS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile
				.setAtmosphereParts(AtmosphereParts.HydrogenSulfide);
		starToChemicalProfile.setUltraVioletReducingScale(30.0);
		starToChemicalProfile.setWeightDuringAnalysis(18.0);
		starToAtmosphere.get(StarFactory.RED__MAINS).add(starToChemicalProfile);
		
		starToAtmosphere.put(StarFactory.BLUE_SUBDW, new ArrayList<StarToChemicalProfile>());
		// uv and reducing: 01 is extreme UV and 99 is extreme reducing

		// BLUE_SUBDW

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Argon);
		starToChemicalProfile.setUltraVioletReducingScale(58.0);
		starToChemicalProfile.setWeightDuringAnalysis(8.0); // high means
															// greater
															// probability
		starToAtmosphere.get(StarFactory.BLUE_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Carbon);
		starToChemicalProfile.setUltraVioletReducingScale(38.0);
		starToChemicalProfile.setWeightDuringAnalysis(12.0);
		starToAtmosphere.get(StarFactory.BLUE_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Helium);
		starToChemicalProfile.setUltraVioletReducingScale(7.0);
		starToChemicalProfile.setWeightDuringAnalysis(75.0);
		starToAtmosphere.get(StarFactory.BLUE_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Hydrogen);
		starToChemicalProfile.setUltraVioletReducingScale(7.0);
		starToChemicalProfile.setWeightDuringAnalysis(96.0);
		starToAtmosphere.get(StarFactory.BLUE_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Neon);
		starToChemicalProfile.setUltraVioletReducingScale(48.0);
		starToChemicalProfile.setWeightDuringAnalysis(3.0);
		starToAtmosphere.get(StarFactory.BLUE_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Nitrogen);
		starToChemicalProfile.setUltraVioletReducingScale(10.0);
		starToChemicalProfile.setWeightDuringAnalysis(90.0);
		starToAtmosphere.get(StarFactory.BLUE_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Oxygen);
		starToChemicalProfile.setUltraVioletReducingScale(20.0);
		starToChemicalProfile.setWeightDuringAnalysis(12.0);
		starToAtmosphere.get(StarFactory.BLUE_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Silicon);
		starToChemicalProfile.setUltraVioletReducingScale(28.0);
		starToChemicalProfile.setWeightDuringAnalysis(15.0);
		starToAtmosphere.get(StarFactory.BLUE_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Water);
		starToChemicalProfile.setUltraVioletReducingScale(30.0);
		starToChemicalProfile.setWeightDuringAnalysis(7.0);
		starToAtmosphere.get(StarFactory.BLUE_SUBDW).add(starToChemicalProfile);

		starToAtmosphere.put(StarFactory.LTBL_SUBDW, new ArrayList<StarToChemicalProfile>());

		// LTBL_SUBDW

		// uv and reducing: 01 is extreme UV and 99 is extreme reducing

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Argon);
		starToChemicalProfile.setUltraVioletReducingScale(58.0);
		starToChemicalProfile.setWeightDuringAnalysis(6.0); // high rates more
		starToAtmosphere.get(StarFactory.LTBL_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Carbon);
		starToChemicalProfile.setUltraVioletReducingScale(42.0);
		starToChemicalProfile.setWeightDuringAnalysis(20.0);
		starToAtmosphere.get(StarFactory.LTBL_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Helium);
		starToChemicalProfile.setUltraVioletReducingScale(6.0);
		starToChemicalProfile.setWeightDuringAnalysis(72.0);
		starToAtmosphere.get(StarFactory.LTBL_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Hydrogen);
		starToChemicalProfile.setUltraVioletReducingScale(4.0);
		starToChemicalProfile.setWeightDuringAnalysis(98.0);
		starToAtmosphere.get(StarFactory.LTBL_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Neon);
		starToChemicalProfile.setUltraVioletReducingScale(46.0);
		starToChemicalProfile.setWeightDuringAnalysis(6.0);
		starToAtmosphere.get(StarFactory.LTBL_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Nitrogen);
		starToChemicalProfile.setUltraVioletReducingScale(4.0);
		starToChemicalProfile.setWeightDuringAnalysis(90.0);
		starToAtmosphere.get(StarFactory.LTBL_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Oxygen);
		starToChemicalProfile.setUltraVioletReducingScale(18.0);
		starToChemicalProfile.setWeightDuringAnalysis(20.0);
		starToAtmosphere.get(StarFactory.LTBL_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Silicon);
		starToChemicalProfile.setUltraVioletReducingScale(32.0);
		starToChemicalProfile.setWeightDuringAnalysis(12.0);
		starToAtmosphere.get(StarFactory.LTBL_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Water);
		starToChemicalProfile.setUltraVioletReducingScale(26.0);
		starToChemicalProfile.setWeightDuringAnalysis(8.0);
		starToAtmosphere.get(StarFactory.LTBL_SUBDW).add(starToChemicalProfile);
		
		starToAtmosphere.put(StarFactory.WHIT_SUBDW, new ArrayList<StarToChemicalProfile>());

		// WHIT_SUBDW

		// uv and reducing: 01 is extreme UV and 99 is extreme reducing

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Argon);
		starToChemicalProfile.setUltraVioletReducingScale(54.0);
		starToChemicalProfile.setWeightDuringAnalysis(9.0); // high rates more
															// probable
		starToAtmosphere.get(StarFactory.WHIT_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Carbon);
		starToChemicalProfile.setUltraVioletReducingScale(48.0);
		starToChemicalProfile.setWeightDuringAnalysis(20.0);
		starToAtmosphere.get(StarFactory.WHIT_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Helium);
		starToChemicalProfile.setUltraVioletReducingScale(8.0);
		starToChemicalProfile.setWeightDuringAnalysis(74.0);
		starToAtmosphere.get(StarFactory.WHIT_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Hydrogen);
		starToChemicalProfile.setUltraVioletReducingScale(5.0);
		starToChemicalProfile.setWeightDuringAnalysis(99.0);
		starToAtmosphere.get(StarFactory.WHIT_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Neon);
		starToChemicalProfile.setUltraVioletReducingScale(50.0);
		starToChemicalProfile.setWeightDuringAnalysis(7.0);
		starToAtmosphere.get(StarFactory.WHIT_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Nitrogen);
		starToChemicalProfile.setUltraVioletReducingScale(12.0);
		starToChemicalProfile.setWeightDuringAnalysis(86.0);
		starToAtmosphere.get(StarFactory.WHIT_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Oxygen);
		starToChemicalProfile.setUltraVioletReducingScale(22.0);
		starToChemicalProfile.setWeightDuringAnalysis(22.0);
		starToAtmosphere.get(StarFactory.WHIT_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Silicon);
		starToChemicalProfile.setUltraVioletReducingScale(28.0);
		starToChemicalProfile.setWeightDuringAnalysis(10.0);
		starToAtmosphere.get(StarFactory.WHIT_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Water);
		starToChemicalProfile.setUltraVioletReducingScale(36.0);
		starToChemicalProfile.setWeightDuringAnalysis(8.0);
		starToAtmosphere.get(StarFactory.WHIT_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.CarbonDioxide);
		starToChemicalProfile.setUltraVioletReducingScale(5.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.WHIT_SUBDW).add(starToChemicalProfile);
		
		starToAtmosphere.put(StarFactory.PYEL_SUBDW, new ArrayList<StarToChemicalProfile>());

		// PYEL_SUBDW

		// uv and reducing: 01 is extreme UV and 99 is extreme reducing

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Argon);
		starToChemicalProfile.setUltraVioletReducingScale(40.0);
		starToChemicalProfile.setWeightDuringAnalysis(9.0); // high rates more
															// probable
		starToAtmosphere.get(StarFactory.PYEL_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Carbon);
		starToChemicalProfile.setUltraVioletReducingScale(30.0);
		starToChemicalProfile.setWeightDuringAnalysis(20.0);
		starToAtmosphere.get(StarFactory.PYEL_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Helium);
		starToChemicalProfile.setUltraVioletReducingScale(6.0);
		starToChemicalProfile.setWeightDuringAnalysis(78.0);
		starToAtmosphere.get(StarFactory.PYEL_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Hydrogen);
		starToChemicalProfile.setUltraVioletReducingScale(3.0);
		starToChemicalProfile.setWeightDuringAnalysis(99.0);
		starToAtmosphere.get(StarFactory.PYEL_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Neon);
		starToChemicalProfile.setUltraVioletReducingScale(40.0);
		starToChemicalProfile.setWeightDuringAnalysis(7.0);
		starToAtmosphere.get(StarFactory.PYEL_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Nitrogen);
		starToChemicalProfile.setUltraVioletReducingScale(5.0);
		starToChemicalProfile.setWeightDuringAnalysis(88.0);
		starToAtmosphere.get(StarFactory.PYEL_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Oxygen);
		starToChemicalProfile.setUltraVioletReducingScale(18.0);
		starToChemicalProfile.setWeightDuringAnalysis(22.0);
		starToAtmosphere.get(StarFactory.PYEL_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Silicon);
		starToChemicalProfile.setUltraVioletReducingScale(26.0);
		starToChemicalProfile.setWeightDuringAnalysis(10.0);
		starToAtmosphere.get(StarFactory.PYEL_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Water);
		starToChemicalProfile.setUltraVioletReducingScale(20.0);
		starToChemicalProfile.setWeightDuringAnalysis(10.0);
		starToAtmosphere.get(StarFactory.PYEL_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.CarbonDioxide);
		starToChemicalProfile.setUltraVioletReducingScale(5.0);
		starToChemicalProfile.setWeightDuringAnalysis(7.0);
		starToAtmosphere.get(StarFactory.PYEL_SUBDW).add(starToChemicalProfile);
		
		starToAtmosphere.put(StarFactory.YELO_SUBDW, new ArrayList<StarToChemicalProfile>());

		// YELO_SUBDW

		// uv and reducing: 01 is extreme UV and 99 is extreme reducing

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Argon);
		starToChemicalProfile.setUltraVioletReducingScale(32.0);
		starToChemicalProfile.setWeightDuringAnalysis(12.0); // high rates more
																// likely
		starToAtmosphere.get(StarFactory.YELO_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Carbon);
		starToChemicalProfile.setUltraVioletReducingScale(25.0);
		starToChemicalProfile.setWeightDuringAnalysis(15.0);
		starToAtmosphere.get(StarFactory.YELO_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Helium);
		starToChemicalProfile.setUltraVioletReducingScale(46.0);
		starToChemicalProfile.setWeightDuringAnalysis(78.0);
		starToAtmosphere.get(StarFactory.YELO_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Hydrogen);
		starToChemicalProfile.setUltraVioletReducingScale(75.0);
		starToChemicalProfile.setWeightDuringAnalysis(98.0);
		starToAtmosphere.get(StarFactory.YELO_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Neon);
		starToChemicalProfile.setUltraVioletReducingScale(40.0);
		starToChemicalProfile.setWeightDuringAnalysis(4.0);
		starToAtmosphere.get(StarFactory.YELO_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Nitrogen);
		starToChemicalProfile.setUltraVioletReducingScale(16.0);
		starToChemicalProfile.setWeightDuringAnalysis(95.0);
		starToAtmosphere.get(StarFactory.YELO_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Oxygen);
		starToChemicalProfile.setUltraVioletReducingScale(20.0);
		starToChemicalProfile.setWeightDuringAnalysis(42.0);
		starToAtmosphere.get(StarFactory.YELO_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Silicon);
		starToChemicalProfile.setUltraVioletReducingScale(38.0);
		starToChemicalProfile.setWeightDuringAnalysis(6.0);
		starToAtmosphere.get(StarFactory.YELO_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Water);
		starToChemicalProfile.setUltraVioletReducingScale(28.0);
		starToChemicalProfile.setWeightDuringAnalysis(18.0);
		starToAtmosphere.get(StarFactory.YELO_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Potassium);
		starToChemicalProfile.setUltraVioletReducingScale(4.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.YELO_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sodium);
		starToChemicalProfile.setUltraVioletReducingScale(4.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.YELO_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sulfur);
		starToChemicalProfile.setUltraVioletReducingScale(8.0);
		starToChemicalProfile.setWeightDuringAnalysis(8.0);
		starToAtmosphere.get(StarFactory.YELO_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.SulfuricAcid);
		starToChemicalProfile.setUltraVioletReducingScale(4.0);
		starToChemicalProfile.setWeightDuringAnalysis(7.0);
		starToAtmosphere.get(StarFactory.YELO_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.CarbonDioxide);
		starToChemicalProfile.setUltraVioletReducingScale(5.0);
		starToChemicalProfile.setWeightDuringAnalysis(40.0);
		starToAtmosphere.get(StarFactory.YELO_SUBDW).add(starToChemicalProfile);

		starToAtmosphere.put(StarFactory.ORNG_SUBDW, new ArrayList<StarToChemicalProfile>());

		// ORNG_SUBDW

		// uv and reducing: 01 is extreme UV and 99 is extreme reducing

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Argon);
		starToChemicalProfile.setUltraVioletReducingScale(70.0);
		starToChemicalProfile.setWeightDuringAnalysis(8.0); // high rates more
															// higher
															// probability
		starToAtmosphere.get(StarFactory.ORNG_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Carbon);
		starToChemicalProfile.setUltraVioletReducingScale(50.0);
		starToChemicalProfile.setWeightDuringAnalysis(25.0);
		starToAtmosphere.get(StarFactory.ORNG_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Helium);
		starToChemicalProfile.setUltraVioletReducingScale(40.0);
		starToChemicalProfile.setWeightDuringAnalysis(85.0);
		starToAtmosphere.get(StarFactory.ORNG_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Hydrogen);
		starToChemicalProfile.setUltraVioletReducingScale(68.0);
		starToChemicalProfile.setWeightDuringAnalysis(99.0);
		starToAtmosphere.get(StarFactory.ORNG_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Neon);
		starToChemicalProfile.setUltraVioletReducingScale(40.0);
		starToChemicalProfile.setWeightDuringAnalysis(4.0);
		starToAtmosphere.get(StarFactory.ORNG_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Nitrogen);
		starToChemicalProfile.setUltraVioletReducingScale(12.0);
		starToChemicalProfile.setWeightDuringAnalysis(92.0);
		starToAtmosphere.get(StarFactory.ORNG_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Oxygen);
		starToChemicalProfile.setUltraVioletReducingScale(16.0);
		starToChemicalProfile.setWeightDuringAnalysis(20.0);
		starToAtmosphere.get(StarFactory.ORNG_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Silicon);
		starToChemicalProfile.setUltraVioletReducingScale(28.0);
		starToChemicalProfile.setWeightDuringAnalysis(8.0);
		starToAtmosphere.get(StarFactory.ORNG_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Water);
		starToChemicalProfile.setUltraVioletReducingScale(28.0);
		starToChemicalProfile.setWeightDuringAnalysis(25.0);
		starToAtmosphere.get(StarFactory.ORNG_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Potassium);
		starToChemicalProfile.setUltraVioletReducingScale(30.0);
		starToChemicalProfile.setWeightDuringAnalysis(2.0);
		starToAtmosphere.get(StarFactory.ORNG_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sodium);
		starToChemicalProfile.setUltraVioletReducingScale(30.0);
		starToChemicalProfile.setWeightDuringAnalysis(2.0);
		starToAtmosphere.get(StarFactory.ORNG_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sulfur);
		starToChemicalProfile.setUltraVioletReducingScale(28.0);
		starToChemicalProfile.setWeightDuringAnalysis(18.0);
		starToAtmosphere.get(StarFactory.ORNG_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.SulfuricAcid);
		starToChemicalProfile.setUltraVioletReducingScale(16.0);
		starToChemicalProfile.setWeightDuringAnalysis(2.0);
		starToAtmosphere.get(StarFactory.ORNG_SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.CarbonDioxide);
		starToChemicalProfile.setUltraVioletReducingScale(10.0);
		starToChemicalProfile.setWeightDuringAnalysis(15.0);
		starToAtmosphere.get(StarFactory.ORNG_SUBDW).add(starToChemicalProfile);
		
		starToAtmosphere.put(StarFactory.RED__SUBDW, new ArrayList<StarToChemicalProfile>());

		// RED__SUBDW

		// uv and reducing: 01 is extreme UV and 99 is extreme reducing

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Argon);
		starToChemicalProfile.setUltraVioletReducingScale(74.0);
		starToChemicalProfile.setWeightDuringAnalysis(14.0); // high means
																// increased
																// probability
		starToAtmosphere.get(StarFactory.RED__SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Carbon);
		starToChemicalProfile.setUltraVioletReducingScale(48.0);
		starToChemicalProfile.setWeightDuringAnalysis(20.0);
		starToAtmosphere.get(StarFactory.RED__SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Helium);
		starToChemicalProfile.setUltraVioletReducingScale(84.0);
		starToChemicalProfile.setWeightDuringAnalysis(90.0);
		starToAtmosphere.get(StarFactory.RED__SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Hydrogen);
		starToChemicalProfile.setUltraVioletReducingScale(73.0);
		starToChemicalProfile.setWeightDuringAnalysis(99.0);
		starToAtmosphere.get(StarFactory.RED__SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Neon);
		starToChemicalProfile.setUltraVioletReducingScale(48.0);
		starToChemicalProfile.setWeightDuringAnalysis(4.0);
		starToAtmosphere.get(StarFactory.RED__SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Nitrogen);
		starToChemicalProfile.setUltraVioletReducingScale(4.0);
		starToChemicalProfile.setWeightDuringAnalysis(92.0);
		starToAtmosphere.get(StarFactory.RED__SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Oxygen);
		starToChemicalProfile.setUltraVioletReducingScale(8.0);
		starToChemicalProfile.setWeightDuringAnalysis(26.0);
		starToAtmosphere.get(StarFactory.RED__SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Silicon);
		starToChemicalProfile.setUltraVioletReducingScale(5.0);
		starToChemicalProfile.setWeightDuringAnalysis(3.0);
		starToAtmosphere.get(StarFactory.RED__SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Water);
		starToChemicalProfile.setUltraVioletReducingScale(53.0);
		starToChemicalProfile.setWeightDuringAnalysis(20.0);
		starToAtmosphere.get(StarFactory.RED__SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Potassium);
		starToChemicalProfile.setUltraVioletReducingScale(20.0);
		starToChemicalProfile.setWeightDuringAnalysis(8.0);
		starToAtmosphere.get(StarFactory.RED__SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sodium);
		starToChemicalProfile.setUltraVioletReducingScale(8.0);
		starToChemicalProfile.setWeightDuringAnalysis(8.0);
		starToAtmosphere.get(StarFactory.RED__SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sulfur);
		starToChemicalProfile.setUltraVioletReducingScale(22.0);
		starToChemicalProfile.setWeightDuringAnalysis(30.0);
		starToAtmosphere.get(StarFactory.RED__SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.SulfuricAcid);
		starToChemicalProfile.setUltraVioletReducingScale(20.0);
		starToChemicalProfile.setWeightDuringAnalysis(18.0);
		starToAtmosphere.get(StarFactory.RED__SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.CarbonDioxide);
		starToChemicalProfile.setUltraVioletReducingScale(6.0);
		starToChemicalProfile.setWeightDuringAnalysis(25.0);
		starToAtmosphere.get(StarFactory.RED__SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Methane);
		starToChemicalProfile.setUltraVioletReducingScale(48.0);
		starToChemicalProfile.setWeightDuringAnalysis(84.0);
		starToAtmosphere.get(StarFactory.RED__SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Ethane);
		starToChemicalProfile.setUltraVioletReducingScale(12.0);
		starToChemicalProfile.setWeightDuringAnalysis(40.0);
		starToAtmosphere.get(StarFactory.RED__SUBDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile
				.setAtmosphereParts(AtmosphereParts.HydrogenSulfide);
		starToChemicalProfile.setUltraVioletReducingScale(30.0);
		starToChemicalProfile.setWeightDuringAnalysis(18.0);
		starToAtmosphere.get(StarFactory.RED__SUBDW).add(starToChemicalProfile);

		starToAtmosphere.put(StarFactory.BLUE_DWARF, new ArrayList<StarToChemicalProfile>());

		// uv and reducing: 01 is extreme UV and 99 is extreme reducing

		// BLUE_DWARF

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Argon);
		starToChemicalProfile.setUltraVioletReducingScale(50.0);
		starToChemicalProfile.setWeightDuringAnalysis(8.0); // high means
															// greater
															// probability
		starToAtmosphere.get(StarFactory.BLUE_DWARF).add(starToChemicalProfile);

		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Carbon);
		starToChemicalProfile.setUltraVioletReducingScale(34.0);
		starToChemicalProfile.setWeightDuringAnalysis(12.0);
		starToAtmosphere.get(StarFactory.BLUE_DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Helium);
		starToChemicalProfile.setUltraVioletReducingScale(5.0);
		starToChemicalProfile.setWeightDuringAnalysis(80.0);
		starToAtmosphere.get(StarFactory.BLUE_DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Hydrogen);
		starToChemicalProfile.setUltraVioletReducingScale(5.0);
		starToChemicalProfile.setWeightDuringAnalysis(98.0);
		starToAtmosphere.get(StarFactory.BLUE_DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Neon);
		starToChemicalProfile.setUltraVioletReducingScale(42.0);
		starToChemicalProfile.setWeightDuringAnalysis(4.0);
		starToAtmosphere.get(StarFactory.BLUE_DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Nitrogen);
		starToChemicalProfile.setUltraVioletReducingScale(8.0);
		starToChemicalProfile.setWeightDuringAnalysis(90.0);
		starToAtmosphere.get(StarFactory.BLUE_DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Oxygen);
		starToChemicalProfile.setUltraVioletReducingScale(18.0);
		starToChemicalProfile.setWeightDuringAnalysis(12.0);
		starToAtmosphere.get(StarFactory.BLUE_DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Silicon);
		starToChemicalProfile.setUltraVioletReducingScale(26.0);
		starToChemicalProfile.setWeightDuringAnalysis(15.0);
		starToAtmosphere.get(StarFactory.BLUE_DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Water);
		starToChemicalProfile.setUltraVioletReducingScale(28.0);
		starToChemicalProfile.setWeightDuringAnalysis(9.0);
		starToAtmosphere.get(StarFactory.BLUE_DWARF).add(starToChemicalProfile);

		
		starToAtmosphere.put(StarFactory.LTBL_DWARF, new ArrayList<StarToChemicalProfile>());

		// LTBL_DWARF

		// uv and reducing: 01 is extreme UV and 99 is extreme reducing

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Argon);
		starToChemicalProfile.setUltraVioletReducingScale(53.0);
		starToChemicalProfile.setWeightDuringAnalysis(8.0); // high rates more
		starToAtmosphere.get(StarFactory.LTBL_DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Carbon);
		starToChemicalProfile.setUltraVioletReducingScale(40.0);
		starToChemicalProfile.setWeightDuringAnalysis(22.0);
		starToAtmosphere.get(StarFactory.LTBL_DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Helium);
		starToChemicalProfile.setUltraVioletReducingScale(4.0);
		starToChemicalProfile.setWeightDuringAnalysis(76.0);
		starToAtmosphere.get(StarFactory.LTBL_DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Hydrogen);
		starToChemicalProfile.setUltraVioletReducingScale(3.0);
		starToChemicalProfile.setWeightDuringAnalysis(99.0);
		starToAtmosphere.get(StarFactory.LTBL_DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Neon);
		starToChemicalProfile.setUltraVioletReducingScale(42.0);
		starToChemicalProfile.setWeightDuringAnalysis(8.0);
		starToAtmosphere.get(StarFactory.LTBL_DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Nitrogen);
		starToChemicalProfile.setUltraVioletReducingScale(4.0);
		starToChemicalProfile.setWeightDuringAnalysis(92.0);
		starToAtmosphere.get(StarFactory.LTBL_DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Oxygen);
		starToChemicalProfile.setUltraVioletReducingScale(16.0);
		starToChemicalProfile.setWeightDuringAnalysis(22.0);
		starToAtmosphere.get(StarFactory.LTBL_DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Silicon);
		starToChemicalProfile.setUltraVioletReducingScale(30.0);
		starToChemicalProfile.setWeightDuringAnalysis(12.0);
		starToAtmosphere.get(StarFactory.LTBL_DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Water);
		starToChemicalProfile.setUltraVioletReducingScale(24.0);
		starToChemicalProfile.setWeightDuringAnalysis(8.0);
		starToAtmosphere.get(StarFactory.LTBL_DWARF).add(starToChemicalProfile);


		starToAtmosphere.put(StarFactory.WHIT_DWARF, new ArrayList<StarToChemicalProfile>());

		// WHIT_DWARF

		// uv and reducing: 01 is extreme UV and 99 is extreme reducing

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Argon);
		starToChemicalProfile.setUltraVioletReducingScale(56.0);
		starToChemicalProfile.setWeightDuringAnalysis(8.0); // high rates more
															// probable
		starToAtmosphere.get(StarFactory.WHIT_DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Carbon);
		starToChemicalProfile.setUltraVioletReducingScale(50.0);
		starToChemicalProfile.setWeightDuringAnalysis(18.0);
		starToAtmosphere.get(StarFactory.WHIT_DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Helium);
		starToChemicalProfile.setUltraVioletReducingScale(5.0);
		starToChemicalProfile.setWeightDuringAnalysis(78.0);
		starToAtmosphere.get(StarFactory.WHIT_DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Hydrogen);
		starToChemicalProfile.setUltraVioletReducingScale(4.0);
		starToChemicalProfile.setWeightDuringAnalysis(99.0);
		starToAtmosphere.get(StarFactory.WHIT_DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Neon);
		starToChemicalProfile.setUltraVioletReducingScale(48.0);
		starToChemicalProfile.setWeightDuringAnalysis(8.0);
		starToAtmosphere.get(StarFactory.WHIT_DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Nitrogen);
		starToChemicalProfile.setUltraVioletReducingScale(10.0);
		starToChemicalProfile.setWeightDuringAnalysis(88.0);
		starToAtmosphere.get(StarFactory.WHIT_DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Oxygen);
		starToChemicalProfile.setUltraVioletReducingScale(20.0);
		starToChemicalProfile.setWeightDuringAnalysis(28.0);
		starToAtmosphere.get(StarFactory.WHIT_DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Silicon);
		starToChemicalProfile.setUltraVioletReducingScale(26.0);
		starToChemicalProfile.setWeightDuringAnalysis(12.0);
		starToAtmosphere.get(StarFactory.WHIT_DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Water);
		starToChemicalProfile.setUltraVioletReducingScale(32.0);
		starToChemicalProfile.setWeightDuringAnalysis(10.0);
		starToAtmosphere.get(StarFactory.WHIT_DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.CarbonDioxide);
		starToChemicalProfile.setUltraVioletReducingScale(4.0);
		starToChemicalProfile.setWeightDuringAnalysis(20.0);
		starToAtmosphere.get(StarFactory.WHIT_DWARF).add(starToChemicalProfile);

		starToAtmosphere.put(StarFactory.PYEL_DWARF, new ArrayList<StarToChemicalProfile>());

		// PYEL_DWARF

		// uv and reducing: 01 is extreme UV and 99 is extreme reducing

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Argon);
		starToChemicalProfile.setUltraVioletReducingScale(30.0);
		starToChemicalProfile.setWeightDuringAnalysis(11.0); // high rates more
																// probable
		starToAtmosphere.get(StarFactory.PYEL_DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Carbon);
		starToChemicalProfile.setUltraVioletReducingScale(25.0);
		starToChemicalProfile.setWeightDuringAnalysis(25.0);
		starToAtmosphere.get(StarFactory.PYEL_DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Helium);
		starToChemicalProfile.setUltraVioletReducingScale(4.0);
		starToChemicalProfile.setWeightDuringAnalysis(80.0);
		starToAtmosphere.get(StarFactory.PYEL_DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Hydrogen);
		starToChemicalProfile.setUltraVioletReducingScale(3.0);
		starToChemicalProfile.setWeightDuringAnalysis(99.0);
		starToAtmosphere.get(StarFactory.PYEL_DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Neon);
		starToChemicalProfile.setUltraVioletReducingScale(38.0);
		starToChemicalProfile.setWeightDuringAnalysis(7.0);
		starToAtmosphere.get(StarFactory.PYEL_DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Nitrogen);
		starToChemicalProfile.setUltraVioletReducingScale(4.0);
		starToChemicalProfile.setWeightDuringAnalysis(88.0);
		starToAtmosphere.get(StarFactory.PYEL_DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Oxygen);
		starToChemicalProfile.setUltraVioletReducingScale(16.0);
		starToChemicalProfile.setWeightDuringAnalysis(28.0);
		starToAtmosphere.get(StarFactory.PYEL_DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Silicon);
		starToChemicalProfile.setUltraVioletReducingScale(24.0);
		starToChemicalProfile.setWeightDuringAnalysis(10.0);
		starToAtmosphere.get(StarFactory.PYEL_DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Water);
		starToChemicalProfile.setUltraVioletReducingScale(18.0);
		starToChemicalProfile.setWeightDuringAnalysis(20.0);
		starToAtmosphere.get(StarFactory.PYEL_DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.CarbonDioxide);
		starToChemicalProfile.setUltraVioletReducingScale(4.0);
		starToChemicalProfile.setWeightDuringAnalysis(10.0);
		starToAtmosphere.get(StarFactory.PYEL_DWARF).add(starToChemicalProfile);

		starToAtmosphere.put(StarFactory.YELO_DWARF, new ArrayList<StarToChemicalProfile>());

		// YELO_DWARF

		// uv and reducing: 01 is extreme UV and 99 is extreme reducing

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Argon);
		starToChemicalProfile.setUltraVioletReducingScale(30.0);
		starToChemicalProfile.setWeightDuringAnalysis(12.0); // high rates more
																// likely
		starToAtmosphere.get(StarFactory.YELO_DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Carbon);
		starToChemicalProfile.setUltraVioletReducingScale(22.0);
		starToChemicalProfile.setWeightDuringAnalysis(15.0);
		starToAtmosphere.get(StarFactory.YELO_DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Helium);
		starToChemicalProfile.setUltraVioletReducingScale(84.0);
		starToChemicalProfile.setWeightDuringAnalysis(78.0);
		starToAtmosphere.get(StarFactory.YELO_DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Hydrogen);
		starToChemicalProfile.setUltraVioletReducingScale(84.0);
		starToChemicalProfile.setWeightDuringAnalysis(99.0);
		starToAtmosphere.get(StarFactory.YELO_DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Neon);
		starToChemicalProfile.setUltraVioletReducingScale(38.0);
		starToChemicalProfile.setWeightDuringAnalysis(4.0);
		starToAtmosphere.get(StarFactory.YELO_DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Nitrogen);
		starToChemicalProfile.setUltraVioletReducingScale(14.0);
		starToChemicalProfile.setWeightDuringAnalysis(95.0);
		starToAtmosphere.get(StarFactory.YELO_DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Oxygen);
		starToChemicalProfile.setUltraVioletReducingScale(16.0);
		starToChemicalProfile.setWeightDuringAnalysis(42.0);
		starToAtmosphere.get(StarFactory.YELO_DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Silicon);
		starToChemicalProfile.setUltraVioletReducingScale(36.0);
		starToChemicalProfile.setWeightDuringAnalysis(6.0);
		starToAtmosphere.get(StarFactory.YELO_DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Water);
		starToChemicalProfile.setUltraVioletReducingScale(26.0);
		starToChemicalProfile.setWeightDuringAnalysis(22.0);
		starToAtmosphere.get(StarFactory.YELO_DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Potassium);
		starToChemicalProfile.setUltraVioletReducingScale(4.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.YELO_DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sodium);
		starToChemicalProfile.setUltraVioletReducingScale(4.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.YELO_DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sulfur);
		starToChemicalProfile.setUltraVioletReducingScale(8.0);
		starToChemicalProfile.setWeightDuringAnalysis(8.0);
		starToAtmosphere.get(StarFactory.YELO_DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.SulfuricAcid);
		starToChemicalProfile.setUltraVioletReducingScale(4.0);
		starToChemicalProfile.setWeightDuringAnalysis(9.0);
		starToAtmosphere.get(StarFactory.YELO_DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.CarbonDioxide);
		starToChemicalProfile.setUltraVioletReducingScale(4.0);
		starToChemicalProfile.setWeightDuringAnalysis(45.0);
		starToAtmosphere.get(StarFactory.YELO_DWARF).add(starToChemicalProfile);

		starToAtmosphere.put(StarFactory.ORNG_DWARF, new ArrayList<StarToChemicalProfile>());

		// ORNG_DWARF

		// uv and reducing: 01 is extreme UV and 99 is extreme reducing

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Argon);
		starToChemicalProfile.setUltraVioletReducingScale(60.0);
		starToChemicalProfile.setWeightDuringAnalysis(8.0); // high rates more
															// higher
															// probability
		starToAtmosphere.get(StarFactory.ORNG_DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Carbon);
		starToChemicalProfile.setUltraVioletReducingScale(30.0);
		starToChemicalProfile.setWeightDuringAnalysis(28.0);
		starToAtmosphere.get(StarFactory.ORNG_DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Helium);
		starToChemicalProfile.setUltraVioletReducingScale(78.0);
		starToChemicalProfile.setWeightDuringAnalysis(89.0);
		starToAtmosphere.get(StarFactory.ORNG_DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Hydrogen);
		starToChemicalProfile.setUltraVioletReducingScale(76.0);
		starToChemicalProfile.setWeightDuringAnalysis(99.0);
		starToAtmosphere.get(StarFactory.ORNG_DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Neon);
		starToChemicalProfile.setUltraVioletReducingScale(34.0);
		starToChemicalProfile.setWeightDuringAnalysis(4.0);
		starToAtmosphere.get(StarFactory.ORNG_DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Nitrogen);
		starToChemicalProfile.setUltraVioletReducingScale(10.0);
		starToChemicalProfile.setWeightDuringAnalysis(96.0);
		starToAtmosphere.get(StarFactory.ORNG_DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Oxygen);
		starToChemicalProfile.setUltraVioletReducingScale(12.0);
		starToChemicalProfile.setWeightDuringAnalysis(26.0);
		starToAtmosphere.get(StarFactory.ORNG_DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Silicon);
		starToChemicalProfile.setUltraVioletReducingScale(28.0);
		starToChemicalProfile.setWeightDuringAnalysis(8.0);
		starToAtmosphere.get(StarFactory.ORNG_DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Water);
		starToChemicalProfile.setUltraVioletReducingScale(24.0);
		starToChemicalProfile.setWeightDuringAnalysis(28.0);
		starToAtmosphere.get(StarFactory.ORNG_DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Potassium);
		starToChemicalProfile.setUltraVioletReducingScale(26.0);
		starToChemicalProfile.setWeightDuringAnalysis(2.0);
		starToAtmosphere.get(StarFactory.ORNG_DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sodium);
		starToChemicalProfile.setUltraVioletReducingScale(26.0);
		starToChemicalProfile.setWeightDuringAnalysis(2.0);
		starToAtmosphere.get(StarFactory.ORNG_DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sulfur);
		starToChemicalProfile.setUltraVioletReducingScale(24.0);
		starToChemicalProfile.setWeightDuringAnalysis(18.0);
		starToAtmosphere.get(StarFactory.ORNG_DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.SulfuricAcid);
		starToChemicalProfile.setUltraVioletReducingScale(14.0);
		starToChemicalProfile.setWeightDuringAnalysis(2.0);
		starToAtmosphere.get(StarFactory.ORNG_DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.CarbonDioxide);
		starToChemicalProfile.setUltraVioletReducingScale(8.0);
		starToChemicalProfile.setWeightDuringAnalysis(18.0);
		starToAtmosphere.get(StarFactory.ORNG_DWARF).add(starToChemicalProfile);

		starToAtmosphere.put(StarFactory.RED__DWARF, new ArrayList<StarToChemicalProfile>());

		// RED__DWARF

		// uv and reducing: 01 is extreme UV and 99 is extreme reducing

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Argon);
		starToChemicalProfile.setUltraVioletReducingScale(60.0);
		starToChemicalProfile.setWeightDuringAnalysis(14.0); // high means
																// increased
																// probability
		starToAtmosphere.get(StarFactory.RED__DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Carbon);
		starToChemicalProfile.setUltraVioletReducingScale(42.0);
		starToChemicalProfile.setWeightDuringAnalysis(20.0);
		starToAtmosphere.get(StarFactory.RED__DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Helium);
		starToChemicalProfile.setUltraVioletReducingScale(93.0);
		starToChemicalProfile.setWeightDuringAnalysis(92.0);
		starToAtmosphere.get(StarFactory.RED__DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Hydrogen);
		starToChemicalProfile.setUltraVioletReducingScale(92.0);
		starToChemicalProfile.setWeightDuringAnalysis(99.0);
		starToAtmosphere.get(StarFactory.RED__DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Neon);
		starToChemicalProfile.setUltraVioletReducingScale(46.0);
		starToChemicalProfile.setWeightDuringAnalysis(4.0);
		starToAtmosphere.get(StarFactory.RED__DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Nitrogen);
		starToChemicalProfile.setUltraVioletReducingScale(34.0);
		starToChemicalProfile.setWeightDuringAnalysis(94.0);
		starToAtmosphere.get(StarFactory.RED__DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Oxygen);
		starToChemicalProfile.setUltraVioletReducingScale(26.0);
		starToChemicalProfile.setWeightDuringAnalysis(30.0);
		starToAtmosphere.get(StarFactory.RED__DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Silicon);
		starToChemicalProfile.setUltraVioletReducingScale(5.0);
		starToChemicalProfile.setWeightDuringAnalysis(3.0);
		starToAtmosphere.get(StarFactory.RED__DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Water);
		starToChemicalProfile.setUltraVioletReducingScale(52.0);
		starToChemicalProfile.setWeightDuringAnalysis(28.0);
		starToAtmosphere.get(StarFactory.RED__DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Potassium);
		starToChemicalProfile.setUltraVioletReducingScale(20.0);
		starToChemicalProfile.setWeightDuringAnalysis(8.0);
		starToAtmosphere.get(StarFactory.RED__DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sodium);
		starToChemicalProfile.setUltraVioletReducingScale(8.0);
		starToChemicalProfile.setWeightDuringAnalysis(8.0);
		starToAtmosphere.get(StarFactory.RED__DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sulfur);
		starToChemicalProfile.setUltraVioletReducingScale(20.0);
		starToChemicalProfile.setWeightDuringAnalysis(32.0);
		starToAtmosphere.get(StarFactory.RED__DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.SulfuricAcid);
		starToChemicalProfile.setUltraVioletReducingScale(20.0);
		starToChemicalProfile.setWeightDuringAnalysis(18.0);
		starToAtmosphere.get(StarFactory.RED__DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.CarbonDioxide);
		starToChemicalProfile.setUltraVioletReducingScale(4.0);
		starToChemicalProfile.setWeightDuringAnalysis(28.0);
		starToAtmosphere.get(StarFactory.RED__DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Methane);
		starToChemicalProfile.setUltraVioletReducingScale(66.0);
		starToChemicalProfile.setWeightDuringAnalysis(88.0);
		starToAtmosphere.get(StarFactory.RED__DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Ethane);
		starToChemicalProfile.setUltraVioletReducingScale(10.0);
		starToChemicalProfile.setWeightDuringAnalysis(48.0);
		starToAtmosphere.get(StarFactory.RED__DWARF).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile
				.setAtmosphereParts(AtmosphereParts.HydrogenSulfide);
		starToChemicalProfile.setUltraVioletReducingScale(28.0);
		starToChemicalProfile.setWeightDuringAnalysis(20.0);
		starToAtmosphere.get(StarFactory.RED__DWARF).add(starToChemicalProfile);

		starToAtmosphere.put(StarFactory.PURPLE_RED, new ArrayList<StarToChemicalProfile>());

		// PURPLE RED dwarf

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Methane);
		starToChemicalProfile.setUltraVioletReducingScale(82.0);
		starToChemicalProfile.setWeightDuringAnalysis(30.0);
		starToAtmosphere.get(StarFactory.PURPLE_RED).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Helium);
		starToChemicalProfile.setUltraVioletReducingScale(81.0);
		starToChemicalProfile.setWeightDuringAnalysis(50.0);
		starToAtmosphere.get(StarFactory.PURPLE_RED).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.CarbonDioxide);
		starToChemicalProfile.setUltraVioletReducingScale(2.0);
		starToChemicalProfile.setWeightDuringAnalysis(40.0);
		starToAtmosphere.get(StarFactory.PURPLE_RED).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Oxygen);
		starToChemicalProfile.setUltraVioletReducingScale(44.0);
		starToChemicalProfile.setWeightDuringAnalysis(30.0);
		starToAtmosphere.get(StarFactory.PURPLE_RED).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Water);
		starToChemicalProfile.setUltraVioletReducingScale(72.0);
		starToChemicalProfile.setWeightDuringAnalysis(30.0);
		starToAtmosphere.get(StarFactory.PURPLE_RED).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Ammonia);
		starToChemicalProfile.setUltraVioletReducingScale(52.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.PURPLE_RED).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Ethane);
		starToChemicalProfile.setUltraVioletReducingScale(32.0);
		starToChemicalProfile.setWeightDuringAnalysis(10.0);
		starToAtmosphere.get(StarFactory.PURPLE_RED).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Chlorine);
		starToChemicalProfile.setUltraVioletReducingScale(2.0);
		starToChemicalProfile.setWeightDuringAnalysis(20.0);
		starToAtmosphere.get(StarFactory.PURPLE_RED).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile
				.setAtmosphereParts(AtmosphereParts.Methlacetylene);
		starToChemicalProfile.setUltraVioletReducingScale(12.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.PURPLE_RED).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Ozone);
		starToChemicalProfile.setUltraVioletReducingScale(12.0);
		starToChemicalProfile.setWeightDuringAnalysis(10.0);
		starToAtmosphere.get(StarFactory.PURPLE_RED).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sodium);
		starToChemicalProfile.setUltraVioletReducingScale(12.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.PURPLE_RED).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sulfur);
		starToChemicalProfile.setUltraVioletReducingScale(42.0);
		starToChemicalProfile.setWeightDuringAnalysis(8.0);
		starToAtmosphere.get(StarFactory.PURPLE_RED).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Potassium);
		starToChemicalProfile.setUltraVioletReducingScale(2.0);
		starToChemicalProfile.setWeightDuringAnalysis(3.0);
		starToAtmosphere.get(StarFactory.PURPLE_RED).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile
				.setAtmosphereParts(AtmosphereParts.HydrogenSulfide);
		starToChemicalProfile.setUltraVioletReducingScale(42.0);
		starToChemicalProfile.setWeightDuringAnalysis(3.0);
		starToAtmosphere.get(StarFactory.PURPLE_RED).add(starToChemicalProfile);
		
		starToAtmosphere.put(StarFactory.BROWN_SUBS, new ArrayList<StarToChemicalProfile>());

		// BROWN_SUBS dwarf

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Methane);
		starToChemicalProfile.setUltraVioletReducingScale(92.0);
		starToChemicalProfile.setWeightDuringAnalysis(30.0);
		starToAtmosphere.get(StarFactory.BROWN_SUBS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Helium);
		starToChemicalProfile.setUltraVioletReducingScale(91.0);
		starToChemicalProfile.setWeightDuringAnalysis(50.0);
		starToAtmosphere.get(StarFactory.BROWN_SUBS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.CarbonDioxide);
		starToChemicalProfile.setUltraVioletReducingScale(42.0);
		starToChemicalProfile.setWeightDuringAnalysis(40.0);
		starToAtmosphere.get(StarFactory.BROWN_SUBS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Oxygen);
		starToChemicalProfile.setUltraVioletReducingScale(84.0);
		starToChemicalProfile.setWeightDuringAnalysis(30.0);
		starToAtmosphere.get(StarFactory.BROWN_SUBS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Water);
		starToChemicalProfile.setUltraVioletReducingScale(92.0);
		starToChemicalProfile.setWeightDuringAnalysis(30.0);
		starToAtmosphere.get(StarFactory.BROWN_SUBS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Ammonia);
		starToChemicalProfile.setUltraVioletReducingScale(92.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.BROWN_SUBS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Ethane);
		starToChemicalProfile.setUltraVioletReducingScale(72.0);
		starToChemicalProfile.setWeightDuringAnalysis(10.0);
		starToAtmosphere.get(StarFactory.BROWN_SUBS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Chlorine);
		starToChemicalProfile.setUltraVioletReducingScale(42.0);
		starToChemicalProfile.setWeightDuringAnalysis(20.0);
		starToAtmosphere.get(StarFactory.BROWN_SUBS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile
				.setAtmosphereParts(AtmosphereParts.Methlacetylene);
		starToChemicalProfile.setUltraVioletReducingScale(2.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.BROWN_SUBS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Ozone);
		starToChemicalProfile.setUltraVioletReducingScale(32.0);
		starToChemicalProfile.setWeightDuringAnalysis(10.0);
		starToAtmosphere.get(StarFactory.BROWN_SUBS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sodium);
		starToChemicalProfile.setUltraVioletReducingScale(12.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.BROWN_SUBS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sulfur);
		starToChemicalProfile.setUltraVioletReducingScale(12.0);
		starToChemicalProfile.setWeightDuringAnalysis(8.0);
		starToAtmosphere.get(StarFactory.BROWN_SUBS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Potassium);
		starToChemicalProfile.setUltraVioletReducingScale(12.0);
		starToChemicalProfile.setWeightDuringAnalysis(3.0);
		starToAtmosphere.get(StarFactory.BROWN_SUBS).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile
				.setAtmosphereParts(AtmosphereParts.HydrogenSulfide);
		starToChemicalProfile.setUltraVioletReducingScale(12.0);
		starToChemicalProfile.setWeightDuringAnalysis(3.0);
		starToAtmosphere.get(StarFactory.BROWN_SUBS).add(starToChemicalProfile);
		
		starToAtmosphere.put(StarFactory.DRKBRN_SDW, new ArrayList<StarToChemicalProfile>());

		// BROWN_SUBS dwarf

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Methane);
		starToChemicalProfile.setUltraVioletReducingScale(92.0);
		starToChemicalProfile.setWeightDuringAnalysis(30.0);
		starToAtmosphere.get(StarFactory.DRKBRN_SDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Helium);
		starToChemicalProfile.setUltraVioletReducingScale(91.0);
		starToChemicalProfile.setWeightDuringAnalysis(50.0);
		starToAtmosphere.get(StarFactory.DRKBRN_SDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.CarbonDioxide);
		starToChemicalProfile.setUltraVioletReducingScale(42.0);
		starToChemicalProfile.setWeightDuringAnalysis(40.0);
		starToAtmosphere.get(StarFactory.DRKBRN_SDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Oxygen);
		starToChemicalProfile.setUltraVioletReducingScale(84.0);
		starToChemicalProfile.setWeightDuringAnalysis(30.0);
		starToAtmosphere.get(StarFactory.DRKBRN_SDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Water);
		starToChemicalProfile.setUltraVioletReducingScale(92.0);
		starToChemicalProfile.setWeightDuringAnalysis(30.0);
		starToAtmosphere.get(StarFactory.DRKBRN_SDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Ammonia);
		starToChemicalProfile.setUltraVioletReducingScale(92.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.DRKBRN_SDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Ethane);
		starToChemicalProfile.setUltraVioletReducingScale(72.0);
		starToChemicalProfile.setWeightDuringAnalysis(10.0);
		starToAtmosphere.get(StarFactory.DRKBRN_SDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Chlorine);
		starToChemicalProfile.setUltraVioletReducingScale(42.0);
		starToChemicalProfile.setWeightDuringAnalysis(20.0);
		starToAtmosphere.get(StarFactory.DRKBRN_SDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile
				.setAtmosphereParts(AtmosphereParts.Methlacetylene);
		starToChemicalProfile.setUltraVioletReducingScale(2.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.DRKBRN_SDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Ozone);
		starToChemicalProfile.setUltraVioletReducingScale(32.0);
		starToChemicalProfile.setWeightDuringAnalysis(10.0);
		starToAtmosphere.get(StarFactory.DRKBRN_SDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sodium);
		starToChemicalProfile.setUltraVioletReducingScale(12.0);
		starToChemicalProfile.setWeightDuringAnalysis(5.0);
		starToAtmosphere.get(StarFactory.DRKBRN_SDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Sulfur);
		starToChemicalProfile.setUltraVioletReducingScale(12.0);
		starToChemicalProfile.setWeightDuringAnalysis(8.0);
		starToAtmosphere.get(StarFactory.DRKBRN_SDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile.setAtmosphereParts(AtmosphereParts.Potassium);
		starToChemicalProfile.setUltraVioletReducingScale(12.0);
		starToChemicalProfile.setWeightDuringAnalysis(3.0);
		starToAtmosphere.get(StarFactory.DRKBRN_SDW).add(starToChemicalProfile);

		starToChemicalProfile = new StarToChemicalProfile();
		starToChemicalProfile
				.setAtmosphereParts(AtmosphereParts.HydrogenSulfide);
		starToChemicalProfile.setUltraVioletReducingScale(12.0);
		starToChemicalProfile.setWeightDuringAnalysis(3.0);
		starToAtmosphere.get(StarFactory.DRKBRN_SDW).add(starToChemicalProfile);

	}
}
