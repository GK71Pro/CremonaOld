package com.gkaraffa.cremona.theoretical;

import java.util.HashMap;

public enum Interval {
	UNISON(0, "Unison"), 
	MINOR_SECOND(1, "Minor Second"), 
	MAJOR_SECOND(2, "Major Second"), 
	MINOR_THIRD(3, "Minor Third"),
	MAJOR_THIRD(4, "Major Third"),
	PERFECT_FOURTH(5, "Perfect Fourth"),
	AUGMENTED_FOURTH(6, "Augmented Fourth"),
	DIMINISHED_FIFTH(6, "Diminished Fifth"),
	PERFECT_FIFTH(7, "Perfect Fifth"),
	AUGMENTED_FIFTH(8, "Augmented Fifth"),
	MINOR_SIXTH(8, "Minor Sixth"),
	MAJOR_SIXTH(9, "Major Sixth"),
	DIMINISHED_SEVENTH(9, "Diminished Seventh"),
	MINOR_SEVENTH(10, "Minor Seventh"),
	MAJOR_SEVENTH(11, "Major Seventh"),
	OCTAVE(12, "Octave");
	
	public final int steps;
	public final String text;
	private final static HashMap<Integer, Interval> hashMap = new HashMap<Integer, Interval>();
	
	static{
		for (Interval interval: Interval.values()){
			hashMap.put(interval.steps, interval);
		}
	}
	
	Interval(int steps, String text){
		this.steps = steps;
		this.text = text;
	}

	public final int getSteps() {
		return steps;
	}

	public final String getText() {
		return text;
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
