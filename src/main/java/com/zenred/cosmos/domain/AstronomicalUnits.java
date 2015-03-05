package com.zenred.cosmos.domain;

public interface AstronomicalUnits {

    static public final double HALFPSEC = 5.952e12;
    static public final double PARSEC = HALFPSEC + HALFPSEC;
    static public final double THIRD_PARSEC = PARSEC/3.0;
    static public final double FOURTH_PARSEC = PARSEC/4.0;
    
    static public final double AstronomicalUnit = 149597871;	// kilometers
    static public final double PARSEC_METERS = 3.08567758e16; 
    static public final double PARSEC_KILOMETERS = PARSEC_METERS/1000.0;
}
