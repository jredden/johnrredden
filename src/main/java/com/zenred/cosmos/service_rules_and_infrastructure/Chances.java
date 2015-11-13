package com.zenred.cosmos.service_rules_and_infrastructure;

import com.zenred.util.GenRandomRolls;

public class Chances {
	
	public static Integer CHANCE_NITROGEN_DIOXIDE = 10;
	public static Integer CHANCE_CARBON_MONOXIDE = 8;
	public static Integer CHANCE_CHLORINE = 20;
	public static Integer CHANCE_HYDROCHLORIC_ACID = 5;
	public static Integer CHANCE_ETHANE = 5;
	public static Integer CHANCE_SULFUR = 5;
	public static Integer CHANCE_CARBON = 15;
	public static Integer CHANCE_HYDROGENSULFIDE = 5;
	public static Integer CHANCE_SULFURIC_ACID = 8;
	public static Integer CHANCE_CARBON_DIOXIDE = 8;
	public static Integer CHANCE_SODIUM = 10;
	public static Integer CHANCE_POTASSIUM = 8;
	public static Integer CHANCE_OZONE = 20;
	public static Integer CHANCE_SILICON = 8;
	public static Integer CHANCE_DICETYLENE = 3;
	public static Integer CHANCE_METHCETYLENE = 3;
	public static Integer CHANCE_CYANOCETYLENE = 3;
	public static Integer CHANCE_HYDROGEN_CYANIDE = 3;






	public static Double BASE_AMOUNT = 80.0;
	public static Double BASE_CONSTANT = 20.0;
	
	public static Integer fetchChance(){
		Integer chance = GenRandomRolls.Instance().getD100();
		return chance;
	}
	
	public static Double fetchAmount(){
		Double chance = GenRandomRolls.Instance().getDraw(BASE_AMOUNT)+BASE_CONSTANT;
		return chance;
	}

}
