package com.gkaraffa.cremona.theoretical;

public enum Step {
	HALF_STEP(1, "Half Step", "H"),
	WHOLE_STEP(2, "Whole Step", "W");
	
	private final int distance;
	private final String text;
	private final String abbrev;

	Step(int distance, String text, String abbrev){
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
}
