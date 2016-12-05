package com.gkaraffa.cremona.theoretical;

import java.util.HashMap;

public enum IntervalNumber {
	UNISON("Unison", "1st"),
	SECOND("Second", "2nd"),
	THIRD("Third", "3rd"),
	FOURTH("Fourth", "4th"),
	FIFTH("Fifth", "5th"),
	SIXTH("Sixth", "6th"),
	SEVENTH("Seventh", "7th"),
	EIGHTH("Eighth", "8th"),
	NINTH("Ninth", "9th"),
	TENTH("Tenth", "10th"),
	ELEVENTH("Eleventh", "11th"),
	TWELFTH("Twelfth", "12th"),
	THIRTEENTH("Thirteenth", "13th"),
	FOURTEENTH("Fourteenth", "14th"),
	FIFTEENTH("Fifteenth", "15th");
	
	private String text;
	private String abbrev;

	IntervalNumber(String text, String abbrev){
		this.text = text;
		this.abbrev = abbrev;
	}
	
	public final String getText() {
		return text;
	}

	public final String getAbbrev() {
		return abbrev;
	}
	
	public final String toString() {
		return text;
	}

}
