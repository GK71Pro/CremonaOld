package com.gkaraffa.cremona.theoretical;

public enum MelodicTonality {
	MAJOR("Major"), 
	MINOR("Minor"), 
	DIMINISHED("Diminished"), 
	AUGMENTED("Augmented");

	private final String text;

	MelodicTonality(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
	
	public final String toString() {
		return text;
	}

}
