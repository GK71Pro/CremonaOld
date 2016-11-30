package com.gkaraffa.cremona.theoretical.melodic;

public enum StepUnit {
	HALF_STEP(1, "Half Step", "H"),
	WHOLE_STEP(2, "Whole Step", "W"),
	HALF_WHOLE_STEP(3, "Whole Step", "HW");
	
	private final int distance;
	private final String text;
	private final String abbrev;
	
	StepUnit(int distance, String text, String abbrev){
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
