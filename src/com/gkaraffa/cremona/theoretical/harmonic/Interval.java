package com.gkaraffa.cremona.theoretical.harmonic;

import java.util.HashMap;

public enum Interval {
	UNISON(0, "Unison", "U"), 
	MINOR_SECOND(1, "Minor Second", "M2"), 
	MAJOR_SECOND(2, "Major Second", "2"), 
	MINOR_THIRD(3, "Minor Third", "M3"),
	MAJOR_THIRD(4, "Major Third", "3"),
	PERFECT_FOURTH(5, "Perfect Fourth", "4"),
	AUGMENTED_FOURTH_DIMINISHED_FIFTH(6, "Augmented Fourth / Diminished Fifth", "A4/D5"),
	PERFECT_FIFTH(7, "Perfect Fifth", "5"),
	AUGMENTED_FIFTH_MINOR_SIXTH(8, "Augmented Fifth / Minor Sixth", "A5/M6"),
	MAJOR_SIXTH_DIMINISHED_SEVENTH(9, "Major Sixth / Diminished Seventh", "6/D7"),
	MINOR_SEVENTH(10, "Minor Seventh", "M7"),
	MAJOR_SEVENTH(11, "Major Seventh", "7"),
	OCTAVE(12, "Octave", "O");
	
	private final int distance;
	private final String text;
	private final String abbrev;
	private final static HashMap<Integer, Interval> hashMap = new HashMap<Integer, Interval>();
	
	static{
		for (Interval interval: Interval.values()){
			hashMap.put(interval.distance, interval);
		}
	}
	
	Interval(int distance, String text, String abbrev){
		this.distance = distance;
		this.text = text;
		this.abbrev = abbrev;
	}

	public final int getDistance() {
		return distance;
	}

	public final String getText() {
		return text;
	}
	
	public final String getAbbrev() {
		return abbrev;
	}
	
	public static final Interval intToInterval(int input) throws IllegalArgumentException{
		Interval output = null;
		
		output = hashMap.get(input);
		if (output == null){
			throw new IllegalArgumentException ();
		}
		
		return output;
	}
}
