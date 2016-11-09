package com.gkaraffa.cremona.theoretical;

public enum HarmonicTonality {
	MAJOR("Major"), 
	MINOR("Minor"), 
	DIMINISHED("Diminished"), 
	AUGMENTED("Augmented"),
	MAJOR_SEVENTH("Major 7th"),
	MINOR_SEVENTH("Minor 7th"),
	DOMINANT_SEVENTH("7th"),
	MINOR_MAJOR_SEVENTH("MinMaj 7th"),
	DIMINISHED_SEVENTH("Dim 7th"),
	HALF_DIMINISHED_SEVENTH("HalfDim 7th");

	private final String text;

	HarmonicTonality(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
}
