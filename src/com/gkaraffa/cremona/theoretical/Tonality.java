package com.gkaraffa.cremona.theoretical;

public enum Tonality {
	MAJOR("Major"), 
	MINOR("Minor"), 
	DIMINISHED("Diminished"), 
	AUGMENTED("Augmented");

	private final String text;

	Tonality(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
}
