package com.zenred.cosmos.service_rules_and_infrastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.zenred.cosmos.domain.Atmosphere;
import com.zenred.cosmos.domain.AtmosphereParts;
import com.zenred.cosmos.domain.Planetoid;
import com.zenred.cosmos.domain.Star;
import com.zenred.cosmos.domain.StarFactory;
import com.zenred.cosmos.domain.StarToChemicalProfile;
import com.zenred.util.GenRandomRolls;

/**
 * 
 * @author jredden
 *
 *
 *         key with three dimensions Star color Planetoid Temperature Planetoid
 *         Radius in kilometers
 *
 *
 */

public class GenAtmosphere {

	private static Logger logger = Logger.getLogger(GenAtmosphere.class);

	interface AtmosphereResolutionIF {
		List<Atmosphere> resolve(StarFactory starFactory);
	}

	class RadiusRange {
		Double radius; // planetoid start range
		String description; // planetoid description
		Integer key; // used later in triple key

		public RadiusRange(Double radius, String description, Integer key) {
			this.radius = radius;
			this.description = description;
			this.key = key;
		}
	}

	class TemperatureRange {
		Double temperature;
		String description;
		Integer key;

		public TemperatureRange(Double temperature, String description,
				Integer key) {
			this.temperature = temperature;
			this.description = description;
			this.key = key;
		}
	}

	private static List<Atmosphere> normalize(List<Atmosphere> atmospheres){
		
		Double divisor = 0.0;
		for(Atmosphere atmosphere : atmospheres){
			divisor += atmosphere.getPercentage();
		}
		for(Atmosphere atmosphere : atmospheres){
			atmosphere.setPercentage(atmosphere.getPercentage()/divisor);
		}
		return atmospheres;
	}
	
	private static List<Atmosphere> common(String operation, Double uvScalar,
			Double changeScalar, StarFactory starFactory) {
		List<Atmosphere> atmospheres = new ArrayList<Atmosphere>();
		List<StarToChemicalProfile> profileList = AtmosphereParts
				.starToAtmosphereList(starFactory);
		for (StarToChemicalProfile starToChemicalProfile : profileList) {
			Atmosphere atmosphere = new Atmosphere();
			if (operation.equals("LT")) {
				if (starToChemicalProfile.getUltraVioletReducingScale() < uvScalar) {
					Double newWeight = starToChemicalProfile
							.getWeightDuringAnalysis()
							* (100.0 + GenRandomRolls.Instance().getDraw(
									changeScalar));
					atmosphere.setPercentage(newWeight);
					atmosphere.setChem_name(starToChemicalProfile
							.getAtmosphereParts().name());
				} else {
					Double newWeight = starToChemicalProfile
							.getWeightDuringAnalysis()
							* GenRandomRolls.Instance().getDraw(100.0);
					atmosphere.setPercentage(newWeight);
					atmosphere.setChem_name(starToChemicalProfile
							.getAtmosphereParts().name());
				}

			} else {
				if (starToChemicalProfile.getUltraVioletReducingScale() >= uvScalar) {
					Double newWeight = starToChemicalProfile
							.getWeightDuringAnalysis()
							* (100.0 + GenRandomRolls.Instance().getDraw(
									changeScalar));
					atmosphere.setPercentage(newWeight);
					atmosphere.setChem_name(starToChemicalProfile
							.getAtmosphereParts().name());
				} else {
					Double newWeight = starToChemicalProfile
							.getWeightDuringAnalysis()
							* GenRandomRolls.Instance().getDraw(100.0);
					atmosphere.setPercentage(newWeight);
					atmosphere.setChem_name(starToChemicalProfile
							.getAtmosphereParts().name());
				}
			}

			atmospheres.add(atmosphere);
		}
		return normalize(atmospheres);
	}
	
	private static Map<String, AtmosphereResolutionIF> ruleMap = new HashMap<String, GenAtmosphere.AtmosphereResolutionIF>();
	static {
		// a cryogenic dwarf planetoid with Blue Super Giant
		ruleMap.put("BLUE_SG_II" + "0" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 25.0, 5.0, starFactory);
			}
		});
		// ice dwarf planetoid with Blue Super Giant
		ruleMap.put("BLUE_SG_II" + "0" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 30.0, 6.0, starFactory);
			}
		});
		// rocky dwarf palentoid with Blue Super Giant
		ruleMap.put("BLUE_SG_II" + "0" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 30.0, 6.0, starFactory);
			}
		});
		// cythinan dwarf planetoid with Blue Super Giant
		ruleMap.put("BLUE_SG_II" + "0" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 32.0, 10.0, starFactory);
			}
		});
		// molten dwarf planetoid with Blue Super Giant
		ruleMap.put("BLUE_SG_II" + "0" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 50.0, 2.0, starFactory);
			}
		});

		ruleMap.put("BLUE_SG_II" + "0" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				throw new RuntimeException("Cannot be ...");
			}
		});
		// cryogenic mini planetoid with Blue Super Giant 
		ruleMap.put("BLUE_SG_II" + "1" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 25.0, 8.0, starFactory);
			}
		});
		// ice mini planetoid with Blue Super Giant
		ruleMap.put("BLUE_SG_II" + "1" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 28.0, 10.0, starFactory);
			}
		});
		// rocky mini planetoid with Blue Super Giant
		ruleMap.put("BLUE_SG_II" + "1" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 30.0, 11.0, starFactory);
			}
		});
		// cythian mini planetoid with Blue Super Giant
		ruleMap.put("BLUE_SG_II" + "1" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 35.0, 12.0, starFactory);
			}
		});
		// molten mini planetoid with Blue Super Giant
		ruleMap.put("BLUE_SG_II" + "1" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 40.0, 15.0, starFactory);
			}
		});

		ruleMap.put("BLUE_SG_II" + "1" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				throw new RuntimeException("Cannot be ...");
			}
		});
		// cryogenic terran planetoid with Blue Super Giant
		ruleMap.put("BLUE_SG_II" + "2" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 15.0, 10.0, starFactory);
			}
		});
		// ice terran planetoid with Blue Super Giant 
		ruleMap.put("BLUE_SG_II" + "2" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 20.0, 15.0, starFactory);
			}
		});
		// rocky terran planetoid witih Blue Super Giant
		ruleMap.put("BLUE_SG_II" + "2" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 40.0, 5.0, starFactory);
			}
		});
		// cythian terran planetoid with Blue Super Giant
		ruleMap.put("BLUE_SG_II" + "2" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 45.0, 4.0, starFactory);
			}
		});
		// molten terran planetoid with Blue Super Giant
		ruleMap.put("BLUE_SG_II" + "2" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 5.0, 20.0, starFactory);
			}
		});

		ruleMap.put("BLUE_SG_II" + "2" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				throw new RuntimeException("Cannot be ...");
			}
		});
		// cryogenic super terran  giant with Blue Super Giant
		ruleMap.put("BLUE_SG_II" + "3" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 58.0, 40.0, starFactory);
			}
		});
		// ice super terran with Blue Super Giant
		ruleMap.put("BLUE_SG_II" + "3" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 55.0, 35.0, starFactory);
			}
		});
		//  super terran with Blue Super Giant
		ruleMap.put("BLUE_SG_II" + "3" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 50.0, 20.0, starFactory);
			}
		});
		// super terran with Blue Super Giant
		ruleMap.put("BLUE_SG_II" + "3" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 45.0, 10.0, starFactory);
			}
		});
		// molten super terran with Blue Super Giant
		ruleMap.put("BLUE_SG_II" + "3" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 40.0, 10.0, starFactory);
			}
		});

		ruleMap.put("BLUE_SG_II" + "3" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				throw new RuntimeException("This cannot be ...");
			}
		});
		// cryoggenic mini gas giant with Blue Super Giant
		ruleMap.put("BLUE_SG_II" + "4" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 3.0, 5.0, starFactory);
			}
		});
		// ice mini gas giant with Blue Super Giant
		ruleMap.put("BLUE_SG_II" + "4" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 5.0, 8.0, starFactory);
			}
		});
		// terran mini gas giant / super terran with Blue Super Giant
		ruleMap.put("BLUE_SG_II" + "4" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 60.0, 10.0, starFactory);
			}
		});
		// mini gas giant with Blue Super Giant
		ruleMap.put("BLUE_SG_II" + "4" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 7.0, 20.0, starFactory);
			}
		});
		// hot mini gas giant with Blue Super Giant
		ruleMap.put("BLUE_SG_II" + "4" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 5.0, 25.0, starFactory);
			}
		});

		ruleMap.put("BLUE_SG_II" + "4" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				throw new RuntimeException("Cannot be ...");
			}
		});
		// cryogenic gas giant with Blue Super Giant
		ruleMap.put("BLUE_SG_II" + "5" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 5.0, 30.0, starFactory);
			}
		});
		// ice gas giant with Blue Super Giant
		ruleMap.put("BLUE_SG_II" + "5" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 6.0, 20.0, starFactory);
			}
		});
		// super super terran or puffy gas giant
		ruleMap.put("BLUE_SG_II" + "5" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 20.0, 10.0, starFactory);
			}
		});
		// hot gas giant
		ruleMap.put("BLUE_SG_II" + "5" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 6.0, 20.0, starFactory);
			}
		});
		// very hot gas giant
		ruleMap.put("BLUE_SG_II" + "5" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SG_II" + "5" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				throw new RuntimeException("this can't be ...");
			}
		});
		// cryogenic super gas giant
		ruleMap.put("BLUE_SG_II" + "6" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 30.0, 10.0, starFactory);
			}
		});
		// ice suoer gas giant
		ruleMap.put("BLUE_SG_II" + "6" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 25.0, 10.0, starFactory);
			}
		});
		// puffy super gas giant 
		ruleMap.put("BLUE_SG_II" + "6" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 40.0, 10.0, starFactory);
			}
		});
		// hot super gas giant 
		ruleMap.put("BLUE_SG_II" + "6" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 5.0, 30.0, starFactory);
			}
		});
		// super hot super gas giant
		ruleMap.put("BLUE_SG_II" + "6" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 5.0, 40.0, starFactory);
			}
		});
		
		ruleMap.put("BLUE_SG_II" + "6" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				throw new RuntimeException("this cannot be ...");
			}
		});
		// cryogenic dwarf
		ruleMap.put("LTBL_SG_II" + "0" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 25.0, 7.0, starFactory);
			}
		});
		// ice dwarf
		ruleMap.put("LTBL_SG_II" + "0" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 30.0, 9.0, starFactory);
			}
		});
		// rocky dwarf
		ruleMap.put("LTBL_SG_II" + "0" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 30.0, 9.0, starFactory);
			}
		});
		// cythian dwarf
		ruleMap.put("LTBL_SG_II" + "0" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 32.0, 11.0, starFactory);
			}
		});
		// molten dwarf
		ruleMap.put("LTBL_SG_II" + "0" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 52.0, 3.0, starFactory);
			}
		});

		ruleMap.put("LTBL_SG_II" + "0" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				throw new RuntimeException("this cannot be ...");
			}
		});
		// cryogenic mini planetoid
		ruleMap.put("LTBL_SG_II" + "1" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 27.0, 8.0, starFactory);
			}
		});
		// ice mini planetoid
		ruleMap.put("LTBL_SG_II" + "1" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 30.0, 12.0, starFactory);
			}
		});
		// rock mini planetoid
		ruleMap.put("LTBL_SG_II" + "1" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 34.0, 14.0, starFactory);
			}
		});
		// cythian mini planetoid
		ruleMap.put("LTBL_SG_II" + "1" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 40.0, 15.0, starFactory);
			}
		});
		// molten mini planetoid 
		ruleMap.put("LTBL_SG_II" + "1" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 45.0, 17.0, starFactory);
			}
		});

		ruleMap.put("LTBL_SG_II" + "1" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				throw new RuntimeException("cannot be ...");
			}
		});
		// cryogenic terran planetoid
		ruleMap.put("LTBL_SG_II" + "2" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 15.0, 11.0, starFactory);
			}
		});
		// ice terran planetoid
		ruleMap.put("LTBL_SG_II" + "2" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 25.0, 15.0, starFactory);
			}
		});
		// rock terran plaentoid
		ruleMap.put("LTBL_SG_II" + "2" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 45.0, 7.0, starFactory);
			}
		});
		// cythian terran planetoid
		ruleMap.put("LTBL_SG_II" + "2" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 50.0, 5.0, starFactory);
			}
		});
		// molten terran planetoid
		ruleMap.put("LTBL_SG_II" + "2" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 5.0, 22.0, starFactory);
			}
		});

		ruleMap.put("LTBL_SG_II" + "2" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				throw new RuntimeException("can't be ...");
			}
		});
		// cryogenic super terran planetoid
		ruleMap.put("LTBL_SG_II" + "3" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 60.0, 42.0, starFactory);
			}
		});
		// ice super terran planetoid
		ruleMap.put("LTBL_SG_II" + "3" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 58.0, 38.0, starFactory);
			}
		});
		// rocky super terran planetoid
		ruleMap.put("LTBL_SG_II" + "3" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 54.0, 30.0, starFactory);
			}
		});
		// hot super terran planetoid
		ruleMap.put("LTBL_SG_II" + "3" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 45.0, 20.0, starFactory);
			}
		});
		// molten super terran planetoid
		ruleMap.put("LTBL_SG_II" + "3" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 40.0, 15.0, starFactory);
			}
		});

		ruleMap.put("LTBL_SG_II" + "3" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				throw new RuntimeException("can't be ...");
			}
		});
		// cryogenic mini gas giant
		ruleMap.put("LTBL_SG_II" + "4" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 3.0, 5.0, starFactory);
			}
		});
		// ice mini gas giant 
		ruleMap.put("LTBL_SG_II" + "4" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 5.0, 9.0, starFactory);
			}
		});
		// terran mini gas giant ; super terran planetoid
		ruleMap.put("LTBL_SG_II" + "4" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 60.0, 10.0, starFactory);
			}
		});
		// hot mini gas giant ; gas giant planetoid
		ruleMap.put("LTBL_SG_II" + "4" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 8.0, 25.0, starFactory);
			}
		});
		// utra hot mini gas giant; hot gas giant planetoid
		ruleMap.put("LTBL_SG_II" + "4" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 25.0, 7.0, starFactory);
			}
		});
		
		ruleMap.put("LTBL_SG_II" + "4" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				throw new RuntimeException(" cannot be ...");
			}
		});
		// cryogenic gas giant
		ruleMap.put("LTBL_SG_II" + "5" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 7.0, 30.0, starFactory);
			}
		});
		// ice gas giant
		ruleMap.put("LTBL_SG_II" + "5" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 9.0, 20.0, starFactory);
			}
		});
		// gas poor puffy gas giant or supper super terran
		ruleMap.put("LTBL_SG_II" + "5" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common(">", 5.0, 5.0, starFactory);
			}
		});
		// hot gas giant
		ruleMap.put("LTBL_SG_II" + "5" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 9.0, 20.0, starFactory);
			}
		});
		// very hot gas giant
		ruleMap.put("LTBL_SG_II" + "5" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 5.0, 35.0, starFactory);
			}
		});

		ruleMap.put("LTBL_SG_II" + "5" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				throw new RuntimeException("cannot be");
			}
		});
		// cryogenic super gas giant
		ruleMap.put("LTBL_SG_II" + "6" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 32.0, 12.0, starFactory);
			}
		});
		// ice super gas giant
		ruleMap.put("LTBL_SG_II" + "6" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 28.0, 12.0, starFactory);
			}
		});
		// gas poor super gas giant
		ruleMap.put("LTBL_SG_II" + "6" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common(">", 1.0, 5.0, starFactory);
			}
		});
		// hot super gas giant
		ruleMap.put("LTBL_SG_II" + "6" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 5.0, 32.0, starFactory);
			}
		});
		// very hot super gas giant
		ruleMap.put("LTBL_SG_II" + "6" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 4.0, 40.0, starFactory);
			}
		});

		ruleMap.put("LTBL_SG_II" + "6" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				throw new RuntimeException("cannot be ...");
			}
		});
		// cryogenic dwarf
		ruleMap.put("WHIT_SG_II" + "0" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 26.0, 8.0, starFactory);
			}
		});
		// ice dwarf
		ruleMap.put("WHIT_SG_II" + "0" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 32.0, 10.0, starFactory);
			}
		});
		// rocky dwarf
		ruleMap.put("WHIT_SG_II" + "0" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 34.0, 10.0, starFactory);
			}
		});
		// cythian dwarf
		ruleMap.put("WHIT_SG_II" + "0" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 35.0, 11.0, starFactory);
			}
		});
		// molten dwarf
		ruleMap.put("WHIT_SG_II" + "0" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common(">", 10.0, 4.0, starFactory);
			}
		});

		ruleMap.put("WHIT_SG_II" + "0" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				throw new RuntimeException("can't be ...");
			}
		});
		// cryogenic mini planetoid
		ruleMap.put("WHIT_SG_II" + "1" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 28.0, 8.0, starFactory);
			}
		});
		// ice mini planetoid
		ruleMap.put("WHIT_SG_II" + "1" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 31.0, 12.0, starFactory);
			}
		});
		// rock mini planetoid
		ruleMap.put("WHIT_SG_II" + "1" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 35.0, 14.0, starFactory);
			}
		});
		// cythian mini planetoid
		ruleMap.put("WHIT_SG_II" + "1" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common("<", 41.0, 16.0, starFactory);
			}
		});
		// molten mini planetoid
		ruleMap.put("WHIT_SG_II" + "1" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return common(">", 15.0, 9.0, starFactory);
			}
		});

		ruleMap.put("WHIT_SG_II" + "1" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				throw new RuntimeException("can't be ...");
			}
		});

		ruleMap.put("WHIT_SG_II" + "2" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_II" + "2" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_II" + "2" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_II" + "2" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_II" + "2" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_II" + "2" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_II" + "3" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_II" + "3" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_II" + "3" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_II" + "3" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_II" + "3" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_II" + "3" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_II" + "4" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_II" + "4" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_II" + "4" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_II" + "4" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_II" + "4" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_II" + "4" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_II" + "5" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_II" + "5" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_II" + "5" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_II" + "5" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_II" + "5" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_II" + "5" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_II" + "6" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_II" + "6" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_II" + "6" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_II" + "6" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_II" + "6" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_II" + "6" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_II" + "7" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_II" + "7" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_II" + "7" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_II" + "7" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_II" + "7" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_II" + "7" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_II" + "0" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_II" + "0" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_II" + "0" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_II" + "0" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_II" + "0" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_II" + "0" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_II" + "1" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_II" + "1" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_II" + "1" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_II" + "1" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_II" + "1" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_II" + "1" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_II" + "2" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_II" + "2" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_II" + "2" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_II" + "2" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_II" + "2" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_II" + "2" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_II" + "3" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_II" + "3" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_II" + "3" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_II" + "3" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_II" + "3" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_II" + "3" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_II" + "4" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_II" + "4" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_II" + "4" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_II" + "4" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_II" + "4" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_II" + "4" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_II" + "5" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_II" + "5" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_II" + "5" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_II" + "5" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_II" + "5" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_II" + "5" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_II" + "6" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_II" + "6" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_II" + "6" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_II" + "6" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_II" + "6" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_II" + "6" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_II" + "7" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_II" + "7" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_II" + "7" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_II" + "7" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_II" + "7" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_II" + "7" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_II" + "0" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_II" + "0" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_II" + "0" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_II" + "0" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_II" + "0" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_II" + "0" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_II" + "1" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_II" + "1" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_II" + "1" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_II" + "1" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_II" + "1" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_II" + "1" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_II" + "2" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_II" + "2" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_II" + "2" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_II" + "2" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_II" + "2" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_II" + "2" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_II" + "3" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_II" + "3" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_II" + "3" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_II" + "3" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_II" + "3" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_II" + "3" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_II" + "4" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_II" + "4" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_II" + "4" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_II" + "4" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_II" + "4" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_II" + "4" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_II" + "5" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_II" + "5" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_II" + "5" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_II" + "5" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_II" + "5" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_II" + "5" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_II" + "6" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_II" + "6" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_II" + "6" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_II" + "6" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_II" + "6" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_II" + "6" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_II" + "7" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_II" + "7" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_II" + "7" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_II" + "7" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_II" + "7" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_II" + "7" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_II" + "0" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_II" + "0" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_II" + "0" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_II" + "0" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_II" + "0" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_II" + "0" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_II" + "1" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_II" + "1" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_II" + "1" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_II" + "1" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_II" + "1" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_II" + "1" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_II" + "2" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_II" + "2" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_II" + "2" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_II" + "2" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_II" + "2" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_II" + "2" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_II" + "3" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_II" + "3" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_II" + "3" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_II" + "3" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_II" + "3" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_II" + "3" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_II" + "4" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_II" + "4" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_II" + "4" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_II" + "4" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_II" + "4" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_II" + "4" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_II" + "5" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_II" + "5" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_II" + "5" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_II" + "5" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_II" + "5" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_II" + "5" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_II" + "6" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_II" + "6" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_II" + "6" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_II" + "6" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_II" + "6" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_II" + "6" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_II" + "7" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_II" + "7" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_II" + "7" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_II" + "7" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_II" + "7" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_II" + "7" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_II" + "0" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_II" + "0" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_II" + "0" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_II" + "0" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_II" + "0" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_II" + "0" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_II" + "1" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_II" + "1" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_II" + "1" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_II" + "1" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_II" + "1" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_II" + "1" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_II" + "2" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_II" + "2" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_II" + "2" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_II" + "2" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_II" + "2" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_II" + "2" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_II" + "3" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_II" + "3" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_II" + "3" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_II" + "3" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_II" + "3" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_II" + "3" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_II" + "4" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_II" + "4" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_II" + "4" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_II" + "4" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_II" + "4" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_II" + "4" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_II" + "5" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_II" + "5" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_II" + "5" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_II" + "5" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_II" + "5" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_II" + "5" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_II" + "6" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_II" + "6" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_II" + "6" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_II" + "6" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_II" + "6" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_II" + "6" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_II" + "7" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_II" + "7" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_II" + "7" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_II" + "7" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_II" + "7" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_II" + "7" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SG_I" + "0" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SG_I" + "0" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SG_I" + "0" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SG_I" + "0" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SG_I" + "0" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SG_I" + "0" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SG_I" + "1" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SG_I" + "1" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SG_I" + "1" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SG_I" + "1" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SG_I" + "1" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SG_I" + "1" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SG_I" + "2" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SG_I" + "2" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SG_I" + "2" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SG_I" + "2" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SG_I" + "2" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SG_I" + "2" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SG_I" + "3" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SG_I" + "3" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SG_I" + "3" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SG_I" + "3" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SG_I" + "3" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SG_I" + "3" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SG_I" + "4" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SG_I" + "4" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SG_I" + "4" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SG_I" + "4" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SG_I" + "4" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SG_I" + "4" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SG_I" + "5" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SG_I" + "5" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SG_I" + "5" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SG_I" + "5" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SG_I" + "5" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SG_I" + "5" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SG_I" + "6" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SG_I" + "6" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SG_I" + "6" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SG_I" + "6" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SG_I" + "6" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SG_I" + "6" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SG_I" + "7" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SG_I" + "7" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SG_I" + "7" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SG_I" + "7" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SG_I" + "7" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SG_I" + "7" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SG_I" + "0" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SG_I" + "0" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SG_I" + "0" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SG_I" + "0" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SG_I" + "0" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SG_I" + "0" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SG_I" + "1" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SG_I" + "1" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SG_I" + "1" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SG_I" + "1" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SG_I" + "1" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SG_I" + "1" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SG_I" + "2" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SG_I" + "2" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SG_I" + "2" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SG_I" + "2" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SG_I" + "2" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SG_I" + "2" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SG_I" + "3" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SG_I" + "3" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SG_I" + "3" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SG_I" + "3" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SG_I" + "3" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SG_I" + "3" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SG_I" + "4" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SG_I" + "4" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SG_I" + "4" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SG_I" + "4" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SG_I" + "4" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SG_I" + "4" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SG_I" + "5" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SG_I" + "5" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SG_I" + "5" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SG_I" + "5" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SG_I" + "5" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SG_I" + "5" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SG_I" + "6" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SG_I" + "6" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SG_I" + "6" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SG_I" + "6" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SG_I" + "6" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SG_I" + "6" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SG_I" + "7" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SG_I" + "7" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SG_I" + "7" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SG_I" + "7" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SG_I" + "7" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SG_I" + "7" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_I" + "0" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_I" + "0" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_I" + "0" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_I" + "0" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_I" + "0" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_I" + "0" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_I" + "1" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_I" + "1" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_I" + "1" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_I" + "1" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_I" + "1" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_I" + "1" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_I" + "2" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_I" + "2" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_I" + "2" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_I" + "2" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_I" + "2" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_I" + "2" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_I" + "3" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_I" + "3" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_I" + "3" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_I" + "3" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_I" + "3" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_I" + "3" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_I" + "4" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_I" + "4" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_I" + "4" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_I" + "4" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_I" + "4" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_I" + "4" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_I" + "5" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_I" + "5" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_I" + "5" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_I" + "5" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_I" + "5" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_I" + "5" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_I" + "6" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_I" + "6" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_I" + "6" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_I" + "6" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_I" + "6" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_I" + "6" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_I" + "7" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_I" + "7" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_I" + "7" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_I" + "7" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_I" + "7" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SG_I" + "7" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_I" + "0" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_I" + "0" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_I" + "0" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_I" + "0" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_I" + "0" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_I" + "0" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_I" + "1" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_I" + "1" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_I" + "1" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_I" + "1" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_I" + "1" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_I" + "1" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_I" + "2" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_I" + "2" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_I" + "2" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_I" + "2" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_I" + "2" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_I" + "2" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_I" + "3" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_I" + "3" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_I" + "3" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_I" + "3" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_I" + "3" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_I" + "3" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_I" + "4" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_I" + "4" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_I" + "4" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_I" + "4" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_I" + "4" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_I" + "4" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_I" + "5" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_I" + "5" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_I" + "5" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_I" + "5" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_I" + "5" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_I" + "5" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_I" + "6" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_I" + "6" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_I" + "6" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_I" + "6" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_I" + "6" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_I" + "6" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_I" + "7" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_I" + "7" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_I" + "7" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_I" + "7" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_I" + "7" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SG_I" + "7" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_I" + "0" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_I" + "0" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_I" + "0" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_I" + "0" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_I" + "0" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_I" + "0" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_I" + "1" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_I" + "1" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_I" + "1" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_I" + "1" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_I" + "1" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_I" + "1" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_I" + "2" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_I" + "2" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_I" + "2" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_I" + "2" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_I" + "2" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_I" + "2" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_I" + "3" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_I" + "3" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_I" + "3" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_I" + "3" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_I" + "3" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_I" + "3" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_I" + "4" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_I" + "4" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_I" + "4" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_I" + "4" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_I" + "4" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_I" + "4" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_I" + "5" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_I" + "5" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_I" + "5" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_I" + "5" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_I" + "5" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_I" + "5" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_I" + "6" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_I" + "6" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_I" + "6" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_I" + "6" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_I" + "6" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_I" + "6" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_I" + "7" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_I" + "7" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_I" + "7" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_I" + "7" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_I" + "7" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SG_I" + "7" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_I" + "0" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_I" + "0" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_I" + "0" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_I" + "0" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_I" + "0" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_I" + "0" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_I" + "1" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_I" + "1" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_I" + "1" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_I" + "1" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_I" + "1" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_I" + "1" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_I" + "2" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_I" + "2" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_I" + "2" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_I" + "2" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_I" + "2" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_I" + "2" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_I" + "3" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_I" + "3" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_I" + "3" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_I" + "3" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_I" + "3" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_I" + "3" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_I" + "4" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_I" + "4" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_I" + "4" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_I" + "4" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_I" + "4" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_I" + "4" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_I" + "5" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_I" + "5" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_I" + "5" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_I" + "5" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_I" + "5" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_I" + "5" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_I" + "6" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_I" + "6" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_I" + "6" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_I" + "6" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_I" + "6" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_I" + "6" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_I" + "7" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_I" + "7" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_I" + "7" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_I" + "7" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_I" + "7" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SG_I" + "7" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_I" + "0" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_I" + "0" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_I" + "0" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_I" + "0" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_I" + "0" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_I" + "0" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_I" + "1" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_I" + "1" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_I" + "1" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_I" + "1" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_I" + "1" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_I" + "1" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_I" + "2" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_I" + "2" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_I" + "2" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_I" + "2" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_I" + "2" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_I" + "2" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_I" + "3" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_I" + "3" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_I" + "3" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_I" + "3" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_I" + "3" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_I" + "3" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_I" + "4" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_I" + "4" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_I" + "4" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_I" + "4" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_I" + "4" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_I" + "4" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_I" + "5" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_I" + "5" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_I" + "5" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_I" + "5" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_I" + "5" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_I" + "5" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_I" + "6" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_I" + "6" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_I" + "6" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_I" + "6" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_I" + "6" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_I" + "6" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_I" + "7" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_I" + "7" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_I" + "7" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_I" + "7" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_I" + "7" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SG_I" + "7" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_II" + "0" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_II" + "0" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_II" + "0" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_II" + "0" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_II" + "0" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_II" + "0" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_II" + "1" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_II" + "1" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_II" + "1" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_II" + "1" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_II" + "1" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_II" + "1" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_II" + "2" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_II" + "2" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_II" + "2" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_II" + "2" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_II" + "2" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_II" + "2" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_II" + "3" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_II" + "3" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_II" + "3" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_II" + "3" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_II" + "3" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_II" + "3" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_II" + "4" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_II" + "4" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_II" + "4" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_II" + "4" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_II" + "4" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_II" + "4" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_II" + "5" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_II" + "5" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_II" + "5" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_II" + "5" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_II" + "5" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_II" + "5" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_II" + "6" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_II" + "6" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_II" + "6" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_II" + "6" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_II" + "6" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_II" + "6" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_II" + "7" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_II" + "7" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_II" + "7" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_II" + "7" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_II" + "7" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_II" + "7" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_II" + "0" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_II" + "0" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_II" + "0" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_II" + "0" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_II" + "0" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_II" + "0" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_II" + "1" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_II" + "1" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_II" + "1" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_II" + "1" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_II" + "1" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_II" + "1" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_II" + "2" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_II" + "2" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_II" + "2" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_II" + "2" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_II" + "2" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_II" + "2" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_II" + "3" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_II" + "3" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_II" + "3" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_II" + "3" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_II" + "3" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_II" + "3" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_II" + "4" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_II" + "4" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_II" + "4" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_II" + "4" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_II" + "4" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_II" + "4" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_II" + "5" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_II" + "5" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_II" + "5" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_II" + "5" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_II" + "5" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_II" + "5" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_II" + "6" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_II" + "6" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_II" + "6" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_II" + "6" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_II" + "6" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_II" + "6" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_II" + "7" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_II" + "7" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_II" + "7" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_II" + "7" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_II" + "7" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_II" + "7" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_II" + "0" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_II" + "0" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_II" + "0" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_II" + "0" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_II" + "0" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_II" + "0" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_II" + "1" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_II" + "1" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_II" + "1" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_II" + "1" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_II" + "1" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_II" + "1" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_II" + "2" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_II" + "2" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_II" + "2" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_II" + "2" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_II" + "2" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_II" + "2" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_II" + "3" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_II" + "3" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_II" + "3" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_II" + "3" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_II" + "3" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_II" + "3" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_II" + "4" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_II" + "4" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_II" + "4" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_II" + "4" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_II" + "4" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_II" + "4" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_II" + "5" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_II" + "5" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_II" + "5" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_II" + "5" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_II" + "5" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_II" + "5" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_II" + "6" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_II" + "6" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_II" + "6" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_II" + "6" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_II" + "6" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_II" + "6" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_II" + "7" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_II" + "7" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_II" + "7" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_II" + "7" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_II" + "7" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_II" + "7" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_II" + "0" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_II" + "0" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_II" + "0" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_II" + "0" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_II" + "0" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_II" + "0" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_II" + "1" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_II" + "1" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_II" + "1" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_II" + "1" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_II" + "1" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_II" + "1" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_II" + "2" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_II" + "2" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_II" + "2" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_II" + "2" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_II" + "2" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_II" + "2" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_II" + "3" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_II" + "3" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_II" + "3" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_II" + "3" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_II" + "3" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_II" + "3" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_II" + "4" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_II" + "4" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_II" + "4" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_II" + "4" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_II" + "4" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_II" + "4" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_II" + "5" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_II" + "5" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_II" + "5" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_II" + "5" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_II" + "5" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_II" + "5" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_II" + "6" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_II" + "6" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_II" + "6" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_II" + "6" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_II" + "6" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_II" + "6" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_II" + "7" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_II" + "7" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_II" + "7" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_II" + "7" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_II" + "7" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_II" + "7" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_II" + "0" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_II" + "0" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_II" + "0" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_II" + "0" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_II" + "0" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_II" + "0" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_II" + "1" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_II" + "1" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_II" + "1" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_II" + "1" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_II" + "1" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_II" + "1" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_II" + "2" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_II" + "2" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_II" + "2" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_II" + "2" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_II" + "2" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_II" + "2" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_II" + "3" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_II" + "3" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_II" + "3" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_II" + "3" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_II" + "3" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_II" + "3" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_II" + "4" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_II" + "4" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_II" + "4" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_II" + "4" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_II" + "4" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_II" + "4" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_II" + "5" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_II" + "5" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_II" + "5" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_II" + "5" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_II" + "5" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_II" + "5" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_II" + "6" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_II" + "6" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_II" + "6" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_II" + "6" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_II" + "6" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_II" + "6" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_II" + "7" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_II" + "7" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_II" + "7" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_II" + "7" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_II" + "7" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_II" + "7" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_II" + "0" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_II" + "0" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_II" + "0" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_II" + "0" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_II" + "0" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_II" + "0" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_II" + "1" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_II" + "1" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_II" + "1" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_II" + "1" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_II" + "1" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_II" + "1" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_II" + "2" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_II" + "2" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_II" + "2" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_II" + "2" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_II" + "2" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_II" + "2" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_II" + "3" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_II" + "3" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_II" + "3" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_II" + "3" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_II" + "3" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_II" + "3" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_II" + "4" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_II" + "4" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_II" + "4" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_II" + "4" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_II" + "4" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_II" + "4" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_II" + "5" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_II" + "5" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_II" + "5" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_II" + "5" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_II" + "5" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_II" + "5" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_II" + "6" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_II" + "6" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_II" + "6" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_II" + "6" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_II" + "6" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_II" + "6" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_II" + "7" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_II" + "7" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_II" + "7" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_II" + "7" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_II" + "7" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_II" + "7" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_II" + "0" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_II" + "0" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_II" + "0" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_II" + "0" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_II" + "0" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_II" + "0" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_II" + "1" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_II" + "1" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_II" + "1" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_II" + "1" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_II" + "1" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_II" + "1" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_II" + "2" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_II" + "2" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_II" + "2" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_II" + "2" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_II" + "2" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_II" + "2" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_II" + "3" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_II" + "3" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_II" + "3" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_II" + "3" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_II" + "3" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_II" + "3" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_II" + "4" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_II" + "4" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_II" + "4" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_II" + "4" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_II" + "4" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_II" + "4" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_II" + "5" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_II" + "5" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_II" + "5" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_II" + "5" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_II" + "5" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_II" + "5" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_II" + "6" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_II" + "6" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_II" + "6" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_II" + "6" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_II" + "6" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_II" + "6" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_II" + "7" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_II" + "7" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_II" + "7" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_II" + "7" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_II" + "7" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_II" + "7" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_I" + "0" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_I" + "0" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_I" + "0" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_I" + "0" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_I" + "0" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_I" + "0" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_I" + "1" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_I" + "1" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_I" + "1" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_I" + "1" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_I" + "1" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_I" + "1" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_I" + "2" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_I" + "2" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_I" + "2" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_I" + "2" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_I" + "2" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_I" + "2" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_I" + "3" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_I" + "3" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_I" + "3" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_I" + "3" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_I" + "3" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_I" + "3" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_I" + "4" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_I" + "4" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_I" + "4" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_I" + "4" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_I" + "4" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_I" + "4" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_I" + "5" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_I" + "5" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_I" + "5" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_I" + "5" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_I" + "5" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_I" + "5" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_I" + "6" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_I" + "6" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_I" + "6" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_I" + "6" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_I" + "6" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_I" + "6" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_I" + "7" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_I" + "7" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_I" + "7" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_I" + "7" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_I" + "7" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_GI_I" + "7" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_I" + "0" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_I" + "0" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_I" + "0" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_I" + "0" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_I" + "0" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_I" + "0" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_I" + "1" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_I" + "1" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_I" + "1" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_I" + "1" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_I" + "1" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_I" + "1" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_I" + "2" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_I" + "2" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_I" + "2" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_I" + "2" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_I" + "2" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_I" + "2" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_I" + "3" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_I" + "3" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_I" + "3" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_I" + "3" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_I" + "3" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_I" + "3" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_I" + "4" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_I" + "4" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_I" + "4" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_I" + "4" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_I" + "4" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_I" + "4" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_I" + "5" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_I" + "5" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_I" + "5" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_I" + "5" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_I" + "5" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_I" + "5" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_I" + "6" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_I" + "6" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_I" + "6" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_I" + "6" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_I" + "6" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_I" + "6" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_I" + "7" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_I" + "7" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_I" + "7" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_I" + "7" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_I" + "7" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_GI_I" + "7" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_I" + "0" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_I" + "0" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_I" + "0" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_I" + "0" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_I" + "0" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_I" + "0" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_I" + "1" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_I" + "1" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_I" + "1" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_I" + "1" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_I" + "1" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_I" + "1" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_I" + "2" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_I" + "2" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_I" + "2" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_I" + "2" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_I" + "2" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_I" + "2" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_I" + "3" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_I" + "3" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_I" + "3" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_I" + "3" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_I" + "3" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_I" + "3" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_I" + "4" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_I" + "4" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_I" + "4" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_I" + "4" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_I" + "4" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_I" + "4" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_I" + "5" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_I" + "5" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_I" + "5" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_I" + "5" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_I" + "5" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_I" + "5" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_I" + "6" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_I" + "6" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_I" + "6" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_I" + "6" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_I" + "6" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_I" + "6" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_I" + "7" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_I" + "7" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_I" + "7" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_I" + "7" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_I" + "7" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_GI_I" + "7" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_I" + "0" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_I" + "0" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_I" + "0" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_I" + "0" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_I" + "0" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_I" + "0" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_I" + "1" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_I" + "1" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_I" + "1" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_I" + "1" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_I" + "1" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_I" + "1" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_I" + "2" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_I" + "2" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_I" + "2" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_I" + "2" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_I" + "2" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_I" + "2" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_I" + "3" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_I" + "3" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_I" + "3" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_I" + "3" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_I" + "3" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_I" + "3" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_I" + "4" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_I" + "4" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_I" + "4" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_I" + "4" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_I" + "4" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_I" + "4" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_I" + "5" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_I" + "5" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_I" + "5" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_I" + "5" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_I" + "5" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_I" + "5" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_I" + "6" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_I" + "6" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_I" + "6" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_I" + "6" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_I" + "6" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_I" + "6" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_I" + "7" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_I" + "7" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_I" + "7" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_I" + "7" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_I" + "7" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_GI_I" + "7" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_I" + "0" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_I" + "0" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_I" + "0" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_I" + "0" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_I" + "0" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_I" + "0" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_I" + "1" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_I" + "1" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_I" + "1" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_I" + "1" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_I" + "1" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_I" + "1" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_I" + "2" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_I" + "2" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_I" + "2" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_I" + "2" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_I" + "2" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_I" + "2" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_I" + "3" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_I" + "3" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_I" + "3" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_I" + "3" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_I" + "3" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_I" + "3" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_I" + "4" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_I" + "4" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_I" + "4" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_I" + "4" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_I" + "4" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_I" + "4" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_I" + "5" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_I" + "5" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_I" + "5" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_I" + "5" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_I" + "5" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_I" + "5" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_I" + "6" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_I" + "6" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_I" + "6" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_I" + "6" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_I" + "6" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_I" + "6" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_I" + "7" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_I" + "7" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_I" + "7" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_I" + "7" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_I" + "7" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_GI_I" + "7" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_I" + "0" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_I" + "0" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_I" + "0" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_I" + "0" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_I" + "0" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_I" + "0" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_I" + "1" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_I" + "1" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_I" + "1" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_I" + "1" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_I" + "1" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_I" + "1" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_I" + "2" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_I" + "2" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_I" + "2" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_I" + "2" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_I" + "2" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_I" + "2" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_I" + "3" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_I" + "3" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_I" + "3" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_I" + "3" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_I" + "3" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_I" + "3" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_I" + "4" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_I" + "4" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_I" + "4" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_I" + "4" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_I" + "4" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_I" + "4" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_I" + "5" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_I" + "5" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_I" + "5" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_I" + "5" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_I" + "5" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_I" + "5" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_I" + "6" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_I" + "6" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_I" + "6" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_I" + "6" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_I" + "6" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_I" + "6" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_I" + "7" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_I" + "7" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_I" + "7" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_I" + "7" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_I" + "7" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_GI_I" + "7" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_I" + "0" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_I" + "0" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_I" + "0" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_I" + "0" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_I" + "0" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_I" + "0" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_I" + "1" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_I" + "1" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_I" + "1" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_I" + "1" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_I" + "1" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_I" + "1" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_I" + "2" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_I" + "2" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_I" + "2" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_I" + "2" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_I" + "2" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_I" + "2" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_I" + "3" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_I" + "3" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_I" + "3" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_I" + "3" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_I" + "3" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_I" + "3" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_I" + "4" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_I" + "4" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_I" + "4" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_I" + "4" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_I" + "4" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_I" + "4" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_I" + "5" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_I" + "5" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_I" + "5" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_I" + "5" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_I" + "5" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_I" + "5" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_I" + "6" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_I" + "6" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_I" + "6" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_I" + "6" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_I" + "6" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_I" + "6" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_I" + "7" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_I" + "7" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_I" + "7" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_I" + "7" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_I" + "7" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__GI_I" + "7" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBGI" + "0" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBGI" + "0" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBGI" + "0" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBGI" + "0" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBGI" + "0" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBGI" + "0" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBGI" + "1" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBGI" + "1" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBGI" + "1" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBGI" + "1" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBGI" + "1" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBGI" + "1" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBGI" + "2" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBGI" + "2" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBGI" + "2" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBGI" + "2" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBGI" + "2" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBGI" + "2" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBGI" + "3" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBGI" + "3" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBGI" + "3" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBGI" + "3" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBGI" + "3" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBGI" + "3" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBGI" + "4" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBGI" + "4" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBGI" + "4" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBGI" + "4" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBGI" + "4" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBGI" + "4" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBGI" + "5" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBGI" + "5" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBGI" + "5" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBGI" + "5" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBGI" + "5" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBGI" + "5" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBGI" + "6" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBGI" + "6" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBGI" + "6" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBGI" + "6" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBGI" + "6" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBGI" + "6" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBGI" + "7" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBGI" + "7" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBGI" + "7" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBGI" + "7" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBGI" + "7" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBGI" + "7" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBGI" + "0" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBGI" + "0" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBGI" + "0" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBGI" + "0" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBGI" + "0" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBGI" + "0" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBGI" + "1" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBGI" + "1" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBGI" + "1" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBGI" + "1" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBGI" + "1" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBGI" + "1" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBGI" + "2" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBGI" + "2" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBGI" + "2" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBGI" + "2" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBGI" + "2" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBGI" + "2" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBGI" + "3" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBGI" + "3" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBGI" + "3" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBGI" + "3" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBGI" + "3" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBGI" + "3" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBGI" + "4" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBGI" + "4" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBGI" + "4" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBGI" + "4" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBGI" + "4" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBGI" + "4" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBGI" + "5" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBGI" + "5" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBGI" + "5" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBGI" + "5" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBGI" + "5" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBGI" + "5" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBGI" + "6" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBGI" + "6" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBGI" + "6" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBGI" + "6" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBGI" + "6" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBGI" + "6" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBGI" + "7" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBGI" + "7" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBGI" + "7" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBGI" + "7" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBGI" + "7" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBGI" + "7" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBGI" + "0" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBGI" + "0" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBGI" + "0" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBGI" + "0" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBGI" + "0" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBGI" + "0" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBGI" + "1" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBGI" + "1" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBGI" + "1" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBGI" + "1" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBGI" + "1" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBGI" + "1" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBGI" + "2" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBGI" + "2" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBGI" + "2" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBGI" + "2" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBGI" + "2" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBGI" + "2" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBGI" + "3" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBGI" + "3" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBGI" + "3" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBGI" + "3" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBGI" + "3" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBGI" + "3" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBGI" + "4" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBGI" + "4" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBGI" + "4" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBGI" + "4" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBGI" + "4" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBGI" + "4" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBGI" + "5" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBGI" + "5" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBGI" + "5" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBGI" + "5" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBGI" + "5" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBGI" + "5" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBGI" + "6" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBGI" + "6" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBGI" + "6" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBGI" + "6" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBGI" + "6" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBGI" + "6" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBGI" + "7" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBGI" + "7" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBGI" + "7" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBGI" + "7" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBGI" + "7" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBGI" + "7" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBGI" + "0" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBGI" + "0" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBGI" + "0" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBGI" + "0" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBGI" + "0" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBGI" + "0" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBGI" + "1" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBGI" + "1" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBGI" + "1" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBGI" + "1" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBGI" + "1" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBGI" + "1" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBGI" + "2" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBGI" + "2" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBGI" + "2" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBGI" + "2" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBGI" + "2" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBGI" + "2" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBGI" + "3" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBGI" + "3" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBGI" + "3" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBGI" + "3" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBGI" + "3" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBGI" + "3" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBGI" + "4" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBGI" + "4" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBGI" + "4" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBGI" + "4" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBGI" + "4" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBGI" + "4" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBGI" + "5" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBGI" + "5" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBGI" + "5" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBGI" + "5" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBGI" + "5" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBGI" + "5" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBGI" + "6" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBGI" + "6" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBGI" + "6" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBGI" + "6" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBGI" + "6" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBGI" + "6" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBGI" + "7" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBGI" + "7" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBGI" + "7" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBGI" + "7" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBGI" + "7" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBGI" + "7" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBGI" + "0" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBGI" + "0" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBGI" + "0" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBGI" + "0" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBGI" + "0" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBGI" + "0" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBGI" + "1" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBGI" + "1" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBGI" + "1" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBGI" + "1" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBGI" + "1" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBGI" + "1" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBGI" + "2" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBGI" + "2" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBGI" + "2" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBGI" + "2" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBGI" + "2" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBGI" + "2" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBGI" + "3" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBGI" + "3" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBGI" + "3" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBGI" + "3" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBGI" + "3" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBGI" + "3" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBGI" + "4" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBGI" + "4" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBGI" + "4" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBGI" + "4" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBGI" + "4" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBGI" + "4" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBGI" + "5" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBGI" + "5" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBGI" + "5" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBGI" + "5" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBGI" + "5" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBGI" + "5" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBGI" + "6" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBGI" + "6" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBGI" + "6" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBGI" + "6" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBGI" + "6" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBGI" + "6" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBGI" + "7" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBGI" + "7" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBGI" + "7" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBGI" + "7" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBGI" + "7" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBGI" + "7" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBGI" + "0" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBGI" + "0" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBGI" + "0" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBGI" + "0" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBGI" + "0" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBGI" + "0" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBGI" + "1" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBGI" + "1" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBGI" + "1" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBGI" + "1" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBGI" + "1" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBGI" + "1" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBGI" + "2" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBGI" + "2" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBGI" + "2" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBGI" + "2" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBGI" + "2" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBGI" + "2" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBGI" + "3" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBGI" + "3" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBGI" + "3" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBGI" + "3" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBGI" + "3" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBGI" + "3" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBGI" + "4" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBGI" + "4" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBGI" + "4" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBGI" + "4" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBGI" + "4" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBGI" + "4" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBGI" + "5" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBGI" + "5" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBGI" + "5" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBGI" + "5" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBGI" + "5" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBGI" + "5" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBGI" + "6" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBGI" + "6" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBGI" + "6" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBGI" + "6" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBGI" + "6" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBGI" + "6" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBGI" + "7" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBGI" + "7" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBGI" + "7" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBGI" + "7" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBGI" + "7" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBGI" + "7" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBGI" + "0" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBGI" + "0" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBGI" + "0" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBGI" + "0" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBGI" + "0" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBGI" + "0" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBGI" + "1" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBGI" + "1" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBGI" + "1" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBGI" + "1" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBGI" + "1" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBGI" + "1" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBGI" + "2" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBGI" + "2" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBGI" + "2" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBGI" + "2" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBGI" + "2" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBGI" + "2" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBGI" + "3" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBGI" + "3" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBGI" + "3" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBGI" + "3" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBGI" + "3" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBGI" + "3" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBGI" + "4" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBGI" + "4" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBGI" + "4" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBGI" + "4" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBGI" + "4" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBGI" + "4" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBGI" + "5" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBGI" + "5" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBGI" + "5" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBGI" + "5" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBGI" + "5" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBGI" + "5" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBGI" + "6" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBGI" + "6" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBGI" + "6" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBGI" + "6" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBGI" + "6" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBGI" + "6" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBGI" + "7" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBGI" + "7" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBGI" + "7" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBGI" + "7" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBGI" + "7" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBGI" + "7" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_MAINS" + "0" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_MAINS" + "0" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_MAINS" + "0" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_MAINS" + "0" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_MAINS" + "0" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_MAINS" + "0" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_MAINS" + "1" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_MAINS" + "1" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_MAINS" + "1" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_MAINS" + "1" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_MAINS" + "1" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_MAINS" + "1" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_MAINS" + "2" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_MAINS" + "2" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_MAINS" + "2" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_MAINS" + "2" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_MAINS" + "2" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_MAINS" + "2" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_MAINS" + "3" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_MAINS" + "3" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_MAINS" + "3" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_MAINS" + "3" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_MAINS" + "3" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_MAINS" + "3" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_MAINS" + "4" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_MAINS" + "4" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_MAINS" + "4" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_MAINS" + "4" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_MAINS" + "4" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_MAINS" + "4" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_MAINS" + "5" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_MAINS" + "5" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_MAINS" + "5" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_MAINS" + "5" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_MAINS" + "5" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_MAINS" + "5" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_MAINS" + "6" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_MAINS" + "6" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_MAINS" + "6" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_MAINS" + "6" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_MAINS" + "6" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_MAINS" + "6" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_MAINS" + "7" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_MAINS" + "7" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_MAINS" + "7" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_MAINS" + "7" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_MAINS" + "7" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_MAINS" + "7" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_MAINS" + "0" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_MAINS" + "0" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_MAINS" + "0" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_MAINS" + "0" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_MAINS" + "0" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_MAINS" + "0" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_MAINS" + "1" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_MAINS" + "1" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_MAINS" + "1" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_MAINS" + "1" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_MAINS" + "1" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_MAINS" + "1" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_MAINS" + "2" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_MAINS" + "2" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_MAINS" + "2" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_MAINS" + "2" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_MAINS" + "2" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_MAINS" + "2" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_MAINS" + "3" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_MAINS" + "3" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_MAINS" + "3" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_MAINS" + "3" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_MAINS" + "3" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_MAINS" + "3" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_MAINS" + "4" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_MAINS" + "4" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_MAINS" + "4" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_MAINS" + "4" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_MAINS" + "4" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_MAINS" + "4" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_MAINS" + "5" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_MAINS" + "5" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_MAINS" + "5" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_MAINS" + "5" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_MAINS" + "5" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_MAINS" + "5" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_MAINS" + "6" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_MAINS" + "6" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_MAINS" + "6" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_MAINS" + "6" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_MAINS" + "6" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_MAINS" + "6" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_MAINS" + "7" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_MAINS" + "7" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_MAINS" + "7" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_MAINS" + "7" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_MAINS" + "7" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_MAINS" + "7" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_MAINS" + "0" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_MAINS" + "0" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_MAINS" + "0" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_MAINS" + "0" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_MAINS" + "0" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_MAINS" + "0" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_MAINS" + "1" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_MAINS" + "1" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_MAINS" + "1" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_MAINS" + "1" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_MAINS" + "1" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_MAINS" + "1" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_MAINS" + "2" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_MAINS" + "2" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_MAINS" + "2" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_MAINS" + "2" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_MAINS" + "2" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_MAINS" + "2" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_MAINS" + "3" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_MAINS" + "3" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_MAINS" + "3" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_MAINS" + "3" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_MAINS" + "3" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_MAINS" + "3" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_MAINS" + "4" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_MAINS" + "4" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_MAINS" + "4" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_MAINS" + "4" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_MAINS" + "4" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_MAINS" + "4" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_MAINS" + "5" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_MAINS" + "5" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_MAINS" + "5" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_MAINS" + "5" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_MAINS" + "5" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_MAINS" + "5" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_MAINS" + "6" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_MAINS" + "6" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_MAINS" + "6" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_MAINS" + "6" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_MAINS" + "6" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_MAINS" + "6" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_MAINS" + "7" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_MAINS" + "7" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_MAINS" + "7" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_MAINS" + "7" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_MAINS" + "7" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_MAINS" + "7" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_MAINS" + "0" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_MAINS" + "0" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_MAINS" + "0" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_MAINS" + "0" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_MAINS" + "0" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_MAINS" + "0" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_MAINS" + "1" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_MAINS" + "1" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_MAINS" + "1" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_MAINS" + "1" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_MAINS" + "1" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_MAINS" + "1" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_MAINS" + "2" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_MAINS" + "2" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_MAINS" + "2" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_MAINS" + "2" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_MAINS" + "2" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_MAINS" + "2" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_MAINS" + "3" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_MAINS" + "3" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_MAINS" + "3" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_MAINS" + "3" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_MAINS" + "3" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_MAINS" + "3" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_MAINS" + "4" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_MAINS" + "4" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_MAINS" + "4" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_MAINS" + "4" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_MAINS" + "4" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_MAINS" + "4" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_MAINS" + "5" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_MAINS" + "5" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_MAINS" + "5" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_MAINS" + "5" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_MAINS" + "5" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_MAINS" + "5" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_MAINS" + "6" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_MAINS" + "6" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_MAINS" + "6" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_MAINS" + "6" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_MAINS" + "6" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_MAINS" + "6" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_MAINS" + "7" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_MAINS" + "7" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_MAINS" + "7" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_MAINS" + "7" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_MAINS" + "7" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_MAINS" + "7" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_MAINS" + "0" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_MAINS" + "0" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_MAINS" + "0" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_MAINS" + "0" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_MAINS" + "0" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_MAINS" + "0" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_MAINS" + "1" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_MAINS" + "1" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_MAINS" + "1" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_MAINS" + "1" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_MAINS" + "1" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_MAINS" + "1" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_MAINS" + "2" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_MAINS" + "2" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_MAINS" + "2" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_MAINS" + "2" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_MAINS" + "2" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_MAINS" + "2" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_MAINS" + "3" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_MAINS" + "3" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_MAINS" + "3" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_MAINS" + "3" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_MAINS" + "3" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_MAINS" + "3" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_MAINS" + "4" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_MAINS" + "4" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_MAINS" + "4" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_MAINS" + "4" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_MAINS" + "4" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_MAINS" + "4" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_MAINS" + "5" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_MAINS" + "5" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_MAINS" + "5" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_MAINS" + "5" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_MAINS" + "5" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_MAINS" + "5" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_MAINS" + "6" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_MAINS" + "6" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_MAINS" + "6" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_MAINS" + "6" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_MAINS" + "6" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_MAINS" + "6" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_MAINS" + "7" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_MAINS" + "7" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_MAINS" + "7" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_MAINS" + "7" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_MAINS" + "7" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_MAINS" + "7" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_MAINS" + "0" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_MAINS" + "0" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_MAINS" + "0" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_MAINS" + "0" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_MAINS" + "0" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_MAINS" + "0" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_MAINS" + "1" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_MAINS" + "1" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_MAINS" + "1" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_MAINS" + "1" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_MAINS" + "1" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_MAINS" + "1" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_MAINS" + "2" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_MAINS" + "2" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_MAINS" + "2" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_MAINS" + "2" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_MAINS" + "2" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_MAINS" + "2" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_MAINS" + "3" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_MAINS" + "3" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_MAINS" + "3" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_MAINS" + "3" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_MAINS" + "3" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_MAINS" + "3" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_MAINS" + "4" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_MAINS" + "4" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_MAINS" + "4" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_MAINS" + "4" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_MAINS" + "4" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_MAINS" + "4" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_MAINS" + "5" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_MAINS" + "5" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_MAINS" + "5" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_MAINS" + "5" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_MAINS" + "5" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_MAINS" + "5" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_MAINS" + "6" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_MAINS" + "6" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_MAINS" + "6" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_MAINS" + "6" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_MAINS" + "6" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_MAINS" + "6" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_MAINS" + "7" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_MAINS" + "7" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_MAINS" + "7" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_MAINS" + "7" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_MAINS" + "7" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_MAINS" + "7" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__MAINS" + "0" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__MAINS" + "0" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__MAINS" + "0" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__MAINS" + "0" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__MAINS" + "0" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__MAINS" + "0" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__MAINS" + "1" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__MAINS" + "1" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__MAINS" + "1" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__MAINS" + "1" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__MAINS" + "1" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__MAINS" + "1" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__MAINS" + "2" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__MAINS" + "2" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__MAINS" + "2" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__MAINS" + "2" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__MAINS" + "2" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__MAINS" + "2" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__MAINS" + "3" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__MAINS" + "3" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__MAINS" + "3" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__MAINS" + "3" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__MAINS" + "3" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__MAINS" + "3" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__MAINS" + "4" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__MAINS" + "4" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__MAINS" + "4" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__MAINS" + "4" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__MAINS" + "4" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__MAINS" + "4" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__MAINS" + "5" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__MAINS" + "5" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__MAINS" + "5" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__MAINS" + "5" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__MAINS" + "5" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__MAINS" + "5" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__MAINS" + "6" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__MAINS" + "6" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__MAINS" + "6" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__MAINS" + "6" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__MAINS" + "6" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__MAINS" + "6" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__MAINS" + "7" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__MAINS" + "7" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__MAINS" + "7" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__MAINS" + "7" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__MAINS" + "7" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__MAINS" + "7" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBDW" + "0" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBDW" + "0" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBDW" + "0" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBDW" + "0" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBDW" + "0" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBDW" + "0" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBDW" + "1" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBDW" + "1" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBDW" + "1" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBDW" + "1" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBDW" + "1" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBDW" + "1" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBDW" + "2" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBDW" + "2" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBDW" + "2" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBDW" + "2" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBDW" + "2" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBDW" + "2" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBDW" + "3" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBDW" + "3" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBDW" + "3" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBDW" + "3" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBDW" + "3" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBDW" + "3" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBDW" + "4" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBDW" + "4" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBDW" + "4" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBDW" + "4" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBDW" + "4" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBDW" + "4" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBDW" + "5" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBDW" + "5" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBDW" + "5" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBDW" + "5" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBDW" + "5" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBDW" + "5" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBDW" + "6" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBDW" + "6" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBDW" + "6" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBDW" + "6" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBDW" + "6" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBDW" + "6" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBDW" + "7" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBDW" + "7" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBDW" + "7" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBDW" + "7" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBDW" + "7" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_SUBDW" + "7" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBDW" + "0" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBDW" + "0" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBDW" + "0" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBDW" + "0" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBDW" + "0" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBDW" + "0" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBDW" + "1" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBDW" + "1" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBDW" + "1" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBDW" + "1" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBDW" + "1" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBDW" + "1" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBDW" + "2" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBDW" + "2" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBDW" + "2" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBDW" + "2" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBDW" + "2" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBDW" + "2" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBDW" + "3" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBDW" + "3" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBDW" + "3" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBDW" + "3" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBDW" + "3" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBDW" + "3" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBDW" + "4" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBDW" + "4" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBDW" + "4" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBDW" + "4" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBDW" + "4" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBDW" + "4" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBDW" + "5" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBDW" + "5" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBDW" + "5" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBDW" + "5" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBDW" + "5" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBDW" + "5" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBDW" + "6" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBDW" + "6" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBDW" + "6" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBDW" + "6" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBDW" + "6" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBDW" + "6" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBDW" + "7" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBDW" + "7" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBDW" + "7" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBDW" + "7" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBDW" + "7" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_SUBDW" + "7" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBDW" + "0" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBDW" + "0" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBDW" + "0" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBDW" + "0" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBDW" + "0" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBDW" + "0" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBDW" + "1" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBDW" + "1" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBDW" + "1" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBDW" + "1" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBDW" + "1" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBDW" + "1" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBDW" + "2" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBDW" + "2" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBDW" + "2" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBDW" + "2" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBDW" + "2" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBDW" + "2" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBDW" + "3" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBDW" + "3" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBDW" + "3" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBDW" + "3" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBDW" + "3" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBDW" + "3" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBDW" + "4" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBDW" + "4" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBDW" + "4" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBDW" + "4" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBDW" + "4" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBDW" + "4" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBDW" + "5" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBDW" + "5" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBDW" + "5" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBDW" + "5" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBDW" + "5" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBDW" + "5" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBDW" + "6" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBDW" + "6" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBDW" + "6" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBDW" + "6" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBDW" + "6" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBDW" + "6" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBDW" + "7" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBDW" + "7" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBDW" + "7" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBDW" + "7" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBDW" + "7" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_SUBDW" + "7" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBDW" + "0" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBDW" + "0" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBDW" + "0" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBDW" + "0" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBDW" + "0" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBDW" + "0" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBDW" + "1" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBDW" + "1" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBDW" + "1" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBDW" + "1" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBDW" + "1" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBDW" + "1" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBDW" + "2" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBDW" + "2" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBDW" + "2" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBDW" + "2" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBDW" + "2" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBDW" + "2" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBDW" + "3" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBDW" + "3" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBDW" + "3" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBDW" + "3" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBDW" + "3" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBDW" + "3" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBDW" + "4" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBDW" + "4" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBDW" + "4" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBDW" + "4" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBDW" + "4" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBDW" + "4" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBDW" + "5" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBDW" + "5" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBDW" + "5" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBDW" + "5" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBDW" + "5" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBDW" + "5" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBDW" + "6" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBDW" + "6" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBDW" + "6" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBDW" + "6" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBDW" + "6" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBDW" + "6" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBDW" + "7" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBDW" + "7" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBDW" + "7" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBDW" + "7" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBDW" + "7" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_SUBDW" + "7" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBDW" + "0" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBDW" + "0" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBDW" + "0" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBDW" + "0" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBDW" + "0" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBDW" + "0" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBDW" + "1" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBDW" + "1" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBDW" + "1" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBDW" + "1" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBDW" + "1" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBDW" + "1" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBDW" + "2" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBDW" + "2" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBDW" + "2" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBDW" + "2" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBDW" + "2" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBDW" + "2" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBDW" + "3" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBDW" + "3" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBDW" + "3" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBDW" + "3" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBDW" + "3" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBDW" + "3" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBDW" + "4" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBDW" + "4" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBDW" + "4" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBDW" + "4" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBDW" + "4" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBDW" + "4" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBDW" + "5" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBDW" + "5" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBDW" + "5" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBDW" + "5" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBDW" + "5" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBDW" + "5" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBDW" + "6" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBDW" + "6" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBDW" + "6" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBDW" + "6" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBDW" + "6" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBDW" + "6" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBDW" + "7" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBDW" + "7" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBDW" + "7" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBDW" + "7" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBDW" + "7" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_SUBDW" + "7" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBDW" + "0" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBDW" + "0" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBDW" + "0" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBDW" + "0" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBDW" + "0" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBDW" + "0" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBDW" + "1" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBDW" + "1" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBDW" + "1" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBDW" + "1" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBDW" + "1" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBDW" + "1" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBDW" + "2" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBDW" + "2" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBDW" + "2" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBDW" + "2" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBDW" + "2" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBDW" + "2" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBDW" + "3" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBDW" + "3" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBDW" + "3" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBDW" + "3" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBDW" + "3" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBDW" + "3" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBDW" + "4" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBDW" + "4" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBDW" + "4" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBDW" + "4" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBDW" + "4" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBDW" + "4" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBDW" + "5" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBDW" + "5" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBDW" + "5" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBDW" + "5" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBDW" + "5" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBDW" + "5" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBDW" + "6" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBDW" + "6" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBDW" + "6" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBDW" + "6" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBDW" + "6" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBDW" + "6" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBDW" + "7" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBDW" + "7" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBDW" + "7" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBDW" + "7" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBDW" + "7" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_SUBDW" + "7" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBDW" + "0" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBDW" + "0" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBDW" + "0" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBDW" + "0" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBDW" + "0" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBDW" + "0" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBDW" + "1" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBDW" + "1" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBDW" + "1" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBDW" + "1" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBDW" + "1" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBDW" + "1" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBDW" + "2" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBDW" + "2" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBDW" + "2" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBDW" + "2" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBDW" + "2" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBDW" + "2" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBDW" + "3" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBDW" + "3" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBDW" + "3" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBDW" + "3" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBDW" + "3" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBDW" + "3" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBDW" + "4" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBDW" + "4" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBDW" + "4" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBDW" + "4" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBDW" + "4" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBDW" + "4" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBDW" + "5" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBDW" + "5" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBDW" + "5" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBDW" + "5" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBDW" + "5" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBDW" + "5" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBDW" + "6" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBDW" + "6" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBDW" + "6" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBDW" + "6" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBDW" + "6" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBDW" + "6" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBDW" + "7" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBDW" + "7" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBDW" + "7" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBDW" + "7" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBDW" + "7" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__SUBDW" + "7" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_DWARF" + "0" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_DWARF" + "0" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_DWARF" + "0" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_DWARF" + "0" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_DWARF" + "0" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_DWARF" + "0" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_DWARF" + "1" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_DWARF" + "1" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_DWARF" + "1" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_DWARF" + "1" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_DWARF" + "1" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_DWARF" + "1" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_DWARF" + "2" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_DWARF" + "2" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_DWARF" + "2" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_DWARF" + "2" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_DWARF" + "2" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_DWARF" + "2" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_DWARF" + "3" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_DWARF" + "3" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_DWARF" + "3" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_DWARF" + "3" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_DWARF" + "3" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_DWARF" + "3" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_DWARF" + "4" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_DWARF" + "4" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_DWARF" + "4" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_DWARF" + "4" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_DWARF" + "4" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_DWARF" + "4" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_DWARF" + "5" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_DWARF" + "5" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_DWARF" + "5" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_DWARF" + "5" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_DWARF" + "5" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_DWARF" + "5" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_DWARF" + "6" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_DWARF" + "6" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_DWARF" + "6" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_DWARF" + "6" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_DWARF" + "6" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_DWARF" + "6" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_DWARF" + "7" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_DWARF" + "7" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_DWARF" + "7" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_DWARF" + "7" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_DWARF" + "7" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BLUE_DWARF" + "7" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_DWARF" + "0" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_DWARF" + "0" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_DWARF" + "0" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_DWARF" + "0" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_DWARF" + "0" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_DWARF" + "0" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_DWARF" + "1" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_DWARF" + "1" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_DWARF" + "1" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_DWARF" + "1" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_DWARF" + "1" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_DWARF" + "1" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_DWARF" + "2" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_DWARF" + "2" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_DWARF" + "2" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_DWARF" + "2" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_DWARF" + "2" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_DWARF" + "2" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_DWARF" + "3" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_DWARF" + "3" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_DWARF" + "3" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_DWARF" + "3" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_DWARF" + "3" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_DWARF" + "3" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_DWARF" + "4" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_DWARF" + "4" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_DWARF" + "4" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_DWARF" + "4" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_DWARF" + "4" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_DWARF" + "4" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_DWARF" + "5" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_DWARF" + "5" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_DWARF" + "5" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_DWARF" + "5" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_DWARF" + "5" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_DWARF" + "5" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_DWARF" + "6" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_DWARF" + "6" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_DWARF" + "6" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_DWARF" + "6" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_DWARF" + "6" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_DWARF" + "6" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_DWARF" + "7" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_DWARF" + "7" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_DWARF" + "7" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_DWARF" + "7" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_DWARF" + "7" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("LTBL_DWARF" + "7" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_DWARF" + "0" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_DWARF" + "0" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_DWARF" + "0" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_DWARF" + "0" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_DWARF" + "0" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_DWARF" + "0" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_DWARF" + "1" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_DWARF" + "1" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_DWARF" + "1" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_DWARF" + "1" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_DWARF" + "1" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_DWARF" + "1" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_DWARF" + "2" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_DWARF" + "2" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_DWARF" + "2" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_DWARF" + "2" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_DWARF" + "2" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_DWARF" + "2" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_DWARF" + "3" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_DWARF" + "3" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_DWARF" + "3" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_DWARF" + "3" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_DWARF" + "3" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_DWARF" + "3" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_DWARF" + "4" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_DWARF" + "4" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_DWARF" + "4" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_DWARF" + "4" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_DWARF" + "4" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_DWARF" + "4" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_DWARF" + "5" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_DWARF" + "5" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_DWARF" + "5" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_DWARF" + "5" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_DWARF" + "5" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_DWARF" + "5" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_DWARF" + "6" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_DWARF" + "6" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_DWARF" + "6" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_DWARF" + "6" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_DWARF" + "6" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_DWARF" + "6" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_DWARF" + "7" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_DWARF" + "7" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_DWARF" + "7" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_DWARF" + "7" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_DWARF" + "7" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("WHIT_DWARF" + "7" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_DWARF" + "0" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_DWARF" + "0" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_DWARF" + "0" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_DWARF" + "0" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_DWARF" + "0" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_DWARF" + "0" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_DWARF" + "1" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_DWARF" + "1" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_DWARF" + "1" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_DWARF" + "1" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_DWARF" + "1" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_DWARF" + "1" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_DWARF" + "2" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_DWARF" + "2" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_DWARF" + "2" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_DWARF" + "2" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_DWARF" + "2" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_DWARF" + "2" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_DWARF" + "3" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_DWARF" + "3" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_DWARF" + "3" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_DWARF" + "3" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_DWARF" + "3" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_DWARF" + "3" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_DWARF" + "4" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_DWARF" + "4" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_DWARF" + "4" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_DWARF" + "4" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_DWARF" + "4" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_DWARF" + "4" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_DWARF" + "5" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_DWARF" + "5" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_DWARF" + "5" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_DWARF" + "5" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_DWARF" + "5" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_DWARF" + "5" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_DWARF" + "6" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_DWARF" + "6" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_DWARF" + "6" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_DWARF" + "6" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_DWARF" + "6" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_DWARF" + "6" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_DWARF" + "7" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_DWARF" + "7" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_DWARF" + "7" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_DWARF" + "7" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_DWARF" + "7" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PYEL_DWARF" + "7" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_DWARF" + "0" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_DWARF" + "0" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_DWARF" + "0" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_DWARF" + "0" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_DWARF" + "0" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_DWARF" + "0" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_DWARF" + "1" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_DWARF" + "1" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_DWARF" + "1" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_DWARF" + "1" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_DWARF" + "1" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_DWARF" + "1" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_DWARF" + "2" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_DWARF" + "2" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_DWARF" + "2" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_DWARF" + "2" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_DWARF" + "2" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_DWARF" + "2" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_DWARF" + "3" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_DWARF" + "3" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_DWARF" + "3" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_DWARF" + "3" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_DWARF" + "3" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_DWARF" + "3" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_DWARF" + "4" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_DWARF" + "4" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_DWARF" + "4" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_DWARF" + "4" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_DWARF" + "4" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_DWARF" + "4" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_DWARF" + "5" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_DWARF" + "5" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_DWARF" + "5" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_DWARF" + "5" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_DWARF" + "5" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_DWARF" + "5" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_DWARF" + "6" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_DWARF" + "6" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_DWARF" + "6" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_DWARF" + "6" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_DWARF" + "6" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_DWARF" + "6" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_DWARF" + "7" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_DWARF" + "7" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_DWARF" + "7" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_DWARF" + "7" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_DWARF" + "7" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("YELO_DWARF" + "7" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_DWARF" + "0" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_DWARF" + "0" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_DWARF" + "0" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_DWARF" + "0" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_DWARF" + "0" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_DWARF" + "0" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_DWARF" + "1" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_DWARF" + "1" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_DWARF" + "1" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_DWARF" + "1" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_DWARF" + "1" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_DWARF" + "1" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_DWARF" + "2" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_DWARF" + "2" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_DWARF" + "2" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_DWARF" + "2" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_DWARF" + "2" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_DWARF" + "2" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_DWARF" + "3" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_DWARF" + "3" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_DWARF" + "3" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_DWARF" + "3" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_DWARF" + "3" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_DWARF" + "3" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_DWARF" + "4" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_DWARF" + "4" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_DWARF" + "4" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_DWARF" + "4" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_DWARF" + "4" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_DWARF" + "4" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_DWARF" + "5" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_DWARF" + "5" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_DWARF" + "5" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_DWARF" + "5" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_DWARF" + "5" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_DWARF" + "5" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_DWARF" + "6" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_DWARF" + "6" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_DWARF" + "6" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_DWARF" + "6" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_DWARF" + "6" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_DWARF" + "6" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_DWARF" + "7" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_DWARF" + "7" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_DWARF" + "7" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_DWARF" + "7" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_DWARF" + "7" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("ORNG_DWARF" + "7" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__DWARF" + "0" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__DWARF" + "0" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__DWARF" + "0" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__DWARF" + "0" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__DWARF" + "0" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__DWARF" + "0" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__DWARF" + "1" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__DWARF" + "1" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__DWARF" + "1" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__DWARF" + "1" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__DWARF" + "1" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__DWARF" + "1" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__DWARF" + "2" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__DWARF" + "2" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__DWARF" + "2" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__DWARF" + "2" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__DWARF" + "2" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__DWARF" + "2" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__DWARF" + "3" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__DWARF" + "3" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__DWARF" + "3" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__DWARF" + "3" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__DWARF" + "3" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__DWARF" + "3" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__DWARF" + "4" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__DWARF" + "4" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__DWARF" + "4" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__DWARF" + "4" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__DWARF" + "4" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__DWARF" + "4" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__DWARF" + "5" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__DWARF" + "5" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__DWARF" + "5" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__DWARF" + "5" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__DWARF" + "5" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__DWARF" + "5" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__DWARF" + "6" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__DWARF" + "6" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__DWARF" + "6" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__DWARF" + "6" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__DWARF" + "6" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__DWARF" + "6" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__DWARF" + "7" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__DWARF" + "7" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__DWARF" + "7" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__DWARF" + "7" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__DWARF" + "7" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("RED__DWARF" + "7" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PURPLE_RED" + "0" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PURPLE_RED" + "0" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PURPLE_RED" + "0" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PURPLE_RED" + "0" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PURPLE_RED" + "0" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PURPLE_RED" + "0" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PURPLE_RED" + "1" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PURPLE_RED" + "1" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PURPLE_RED" + "1" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PURPLE_RED" + "1" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PURPLE_RED" + "1" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PURPLE_RED" + "1" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PURPLE_RED" + "2" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PURPLE_RED" + "2" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PURPLE_RED" + "2" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PURPLE_RED" + "2" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PURPLE_RED" + "2" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PURPLE_RED" + "2" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PURPLE_RED" + "3" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PURPLE_RED" + "3" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PURPLE_RED" + "3" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PURPLE_RED" + "3" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PURPLE_RED" + "3" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PURPLE_RED" + "3" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PURPLE_RED" + "4" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PURPLE_RED" + "4" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PURPLE_RED" + "4" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PURPLE_RED" + "4" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PURPLE_RED" + "4" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PURPLE_RED" + "4" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PURPLE_RED" + "5" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PURPLE_RED" + "5" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PURPLE_RED" + "5" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PURPLE_RED" + "5" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PURPLE_RED" + "5" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PURPLE_RED" + "5" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PURPLE_RED" + "6" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PURPLE_RED" + "6" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PURPLE_RED" + "6" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PURPLE_RED" + "6" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PURPLE_RED" + "6" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PURPLE_RED" + "6" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PURPLE_RED" + "7" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PURPLE_RED" + "7" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PURPLE_RED" + "7" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PURPLE_RED" + "7" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PURPLE_RED" + "7" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("PURPLE_RED" + "7" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BROWN_SUBS" + "0" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BROWN_SUBS" + "0" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BROWN_SUBS" + "0" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BROWN_SUBS" + "0" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BROWN_SUBS" + "0" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BROWN_SUBS" + "0" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BROWN_SUBS" + "1" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BROWN_SUBS" + "1" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BROWN_SUBS" + "1" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BROWN_SUBS" + "1" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BROWN_SUBS" + "1" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BROWN_SUBS" + "1" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BROWN_SUBS" + "2" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BROWN_SUBS" + "2" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BROWN_SUBS" + "2" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BROWN_SUBS" + "2" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BROWN_SUBS" + "2" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BROWN_SUBS" + "2" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BROWN_SUBS" + "3" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BROWN_SUBS" + "3" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BROWN_SUBS" + "3" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BROWN_SUBS" + "3" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BROWN_SUBS" + "3" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BROWN_SUBS" + "3" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BROWN_SUBS" + "4" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BROWN_SUBS" + "4" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BROWN_SUBS" + "4" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BROWN_SUBS" + "4" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BROWN_SUBS" + "4" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BROWN_SUBS" + "4" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BROWN_SUBS" + "5" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BROWN_SUBS" + "5" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BROWN_SUBS" + "5" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BROWN_SUBS" + "5" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BROWN_SUBS" + "5" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BROWN_SUBS" + "5" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BROWN_SUBS" + "6" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BROWN_SUBS" + "6" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BROWN_SUBS" + "6" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BROWN_SUBS" + "6" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BROWN_SUBS" + "6" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BROWN_SUBS" + "6" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BROWN_SUBS" + "7" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BROWN_SUBS" + "7" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BROWN_SUBS" + "7" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BROWN_SUBS" + "7" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BROWN_SUBS" + "7" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("BROWN_SUBS" + "7" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("DRKBRN_SDW" + "0" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("DRKBRN_SDW" + "0" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("DRKBRN_SDW" + "0" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("DRKBRN_SDW" + "0" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("DRKBRN_SDW" + "0" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("DRKBRN_SDW" + "0" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("DRKBRN_SDW" + "1" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("DRKBRN_SDW" + "1" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("DRKBRN_SDW" + "1" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("DRKBRN_SDW" + "1" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("DRKBRN_SDW" + "1" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("DRKBRN_SDW" + "1" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("DRKBRN_SDW" + "2" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("DRKBRN_SDW" + "2" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("DRKBRN_SDW" + "2" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("DRKBRN_SDW" + "2" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("DRKBRN_SDW" + "2" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("DRKBRN_SDW" + "2" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("DRKBRN_SDW" + "3" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("DRKBRN_SDW" + "3" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("DRKBRN_SDW" + "3" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("DRKBRN_SDW" + "3" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("DRKBRN_SDW" + "3" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("DRKBRN_SDW" + "3" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("DRKBRN_SDW" + "4" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("DRKBRN_SDW" + "4" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("DRKBRN_SDW" + "4" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("DRKBRN_SDW" + "4" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("DRKBRN_SDW" + "4" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("DRKBRN_SDW" + "4" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("DRKBRN_SDW" + "5" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("DRKBRN_SDW" + "5" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("DRKBRN_SDW" + "5" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("DRKBRN_SDW" + "5" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("DRKBRN_SDW" + "5" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("DRKBRN_SDW" + "5" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("DRKBRN_SDW" + "6" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("DRKBRN_SDW" + "6" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("DRKBRN_SDW" + "6" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("DRKBRN_SDW" + "6" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("DRKBRN_SDW" + "6" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("DRKBRN_SDW" + "6" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("DRKBRN_SDW" + "7" + "0", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("DRKBRN_SDW" + "7" + "1", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("DRKBRN_SDW" + "7" + "2", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("DRKBRN_SDW" + "7" + "3", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("DRKBRN_SDW" + "7" + "4", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

		ruleMap.put("DRKBRN_SDW" + "7" + "5", new AtmosphereResolutionIF() {
			public List<Atmosphere> resolve(StarFactory starFactory) {
				return null;
			}
		});

	}

	private static GenAtmosphere genAtmosphere = new GenAtmosphere();
	private static List<RadiusRange> planetsRadius = new ArrayList<RadiusRange>();
	static {
		planetsRadius.add(genAtmosphere.new RadiusRange(new Double(300.0),
				"dwarf planetoid", 0)); // dwarf planetoid start range
		planetsRadius.add(genAtmosphere.new RadiusRange(new Double(1500.0),
				"mini planetoid", 1)); // mini planetoid start range
		planetsRadius.add(genAtmosphere.new RadiusRange(new Double(2500.0),
				"terran planetoid", 2)); // terran planetoid start range
		planetsRadius.add(genAtmosphere.new RadiusRange(new Double(6000.0),
				"super terran planetoid", 3)); // super terran planetoid start
												// range
		planetsRadius.add(genAtmosphere.new RadiusRange(new Double(10000.0),
				"mini gas giant planetoid", 4)); // mini gas giant planetoid
													// start range
		planetsRadius.add(genAtmosphere.new RadiusRange(new Double(30000.0),
				"gas giant planetoid", 5)); // gas giant planetoid start range
		planetsRadius.add(genAtmosphere.new RadiusRange(new Double(65000.0),
				"super gas giant planetoid", 6)); // super gas giant planetoid
													// start range
		planetsRadius.add(genAtmosphere.new RadiusRange(new Double(
				Double.MAX_VALUE), "end", 7));
	}

	private static List<TemperatureRange> temperaturesRange = new ArrayList<TemperatureRange>();
	static {
		temperaturesRange.add(genAtmosphere.new TemperatureRange(
				new Double(0.0), "cyrogenic", 0)); // cryogenic start range
		temperaturesRange.add(genAtmosphere.new TemperatureRange(new Double(
				41.0), "ice", 1)); // ice start range
		temperaturesRange.add(genAtmosphere.new TemperatureRange(new Double(
				101.0), "rock", 2)); // rock, terran like range
		temperaturesRange.add(genAtmosphere.new TemperatureRange(new Double(
				701.0), "hot", 3)); // cythian, or hot gas
		temperaturesRange.add(genAtmosphere.new TemperatureRange(new Double(
				900.0), "molten", 4)); // gaseous metals ...
		temperaturesRange.add(genAtmosphere.new TemperatureRange(
				Double.MAX_VALUE, "end", 5));
	}

	List<Atmosphere> persistAtmosphere(Star star, Planetoid planetoid) {
		List<Atmosphere> atmospheres = null;

		StarFactory starFactory = StarFactory.accessByString(star
				.getStar_color());
		Double planetoidTemperature = planetoid.getTemperature();
		Double planetoidRadius = planetoid.getRadius();
		Integer radiusKey = null;
		for (int idex = 0;; idex++) {
			if (planetoidRadius >= planetsRadius.get(idex).radius
					&& planetoidRadius < planetsRadius.get(idex + 1).radius) {
				radiusKey = planetsRadius.get(idex).key;
				break;
			}
		}
		Integer temperatureKey = null;
		for (int idex = 0;; idex++) {
			if (planetoidTemperature >= temperaturesRange.get(idex).temperature
					&& planetoidTemperature < temperaturesRange.get(idex + 1).temperature) {
				temperatureKey = temperaturesRange.get(idex).key;
				break;
			}
		}

		String key = StarFactory.getRead(starFactory) + radiusKey
				+ temperatureKey;

		atmospheres = ruleMap.get(key).resolve(starFactory);
		return atmospheres;
	}
}