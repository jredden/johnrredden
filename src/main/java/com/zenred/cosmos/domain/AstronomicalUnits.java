package com.zenred.cosmos.domain;

public interface AstronomicalUnits {

    static public final double HALFPSEC = 5.952e12;
    static public final double PARSEC = HALFPSEC + HALFPSEC;
    static public final double THIRD_PARSEC = PARSEC/3.0;
    static public final double FOURTH_PARSEC = PARSEC/4.0;
    
    static public final double AstronomicalUnit = 149597871;	// kilometers
    static public final double PARSEC_METERS = 3.08567758e16; 
    static public final double PARSEC_KILOMETERS = PARSEC_METERS/1000.0;
    static public final double MOON_UNIT = 3.84400e5;	// distance of earth to earths moon.
    static public final double MINIMUM_RADIUS_FOR_MOONS = 2000;		// radius less than mars (3390 kloms), mercury (2440 kloms) of mooned planet
    static public final double SMALL_MOON_RADIUS = 500; 	// smallest moon
}
