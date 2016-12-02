package com.gkaraffa.cremona.theoretical.harmonic;

import java.util.HashMap;

public enum HarmonicDegree {
	FIRST(0, "First", "1st"),
	SECOND(1, "Second", "2nd"),
	THIRD(2, "Third", "3rd"),
	FOURTH(3, "Fourth", "4th"),
	FIFTH(4, "Fifth", "5th"),
	SIXTH(5, "Sixth", "6th"),
	SEVENTH(6, "Seventh", "7th"),
	NINTH(8, "Ninth", "9th"),
	ELEVENTH(10, "Eleventh", "11th"),
	THIRTEENTH(12, "Thirteenth", "13th");	
	
	private int ordinal;
	private String text;
	private String abbrev;
	private final static HashMap<Integer, HarmonicDegree> hashMap = new HashMap<Integer, HarmonicDegree>();

	static {
		for (HarmonicDegree degree : HarmonicDegree.values()) {
			hashMap.put(degree.ordinal, degree);
		}
	}
	
	HarmonicDegree(int ordinal, String text, String abbrev){
		this.ordinal = ordinal;
		this.text = text;
		this.abbrev = abbrev;
	}
	
	public final int getOrdinal() {
		return ordinal;
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
