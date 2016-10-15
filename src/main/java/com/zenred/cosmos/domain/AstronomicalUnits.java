package com.zenred.cosmos.domain;

public interface AstronomicalUnits {

    static public final Double HALFPSEC = 5.952e12;
    static public final Double PARSEC = HALFPSEC + HALFPSEC;
    static public final Double THIRD_PARSEC = PARSEC/3.0;
    static public final Double FOURTH_PARSEC = PARSEC/4.0;
    
    static public final Double AstronomicalUnit = 149597871.0;	// kilometers
    static public final Double PARSEC_METERS = 3.08567758e16; 
    static public final Double PARSEC_KILOMETERS = PARSEC_METERS/1000.0;
    static public final Double MOON_UNIT = 3.84400e5;	// distance of earth to earths moon.
    static public final Double MINIMUM_RADIUS_FOR_MOONS = 2000.0;		// radius less than mars (3390 kloms), mercury (2440 kloms) of mooned planet
    static public final Double SMALL_MOON_RADIUS = 500.0; 	// smallest moon
	static public final Double EARTH_MASS = 5.9736e24;
	static public final Double EARTH_RADIUS = 12742.0/2.0;
	static public final Double SOLAR_MASS = 1.98555*10e30;

}
