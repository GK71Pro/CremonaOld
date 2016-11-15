package com.gkaraffa.cremona.theoretical;

public enum StepUnit {
	HALF_STEP(1, "Half Step", "H"),
	WHOLE_STEP(2, "Whole Step", "W"),
	HALF_AND_WHOLE_STEP(3, "Half & Whole Step", "HW");
	
	public final int steps;
	public final String text;
	public final String abbrev;
	
	StepUnit(int steps, String text, String abbrev){
		this.steps = steps;
		this.text = text;
		this.abbrev = abbrev;
	}

	public final int getSteps() {
		return steps;
	}

	public final String getText() {
		return text;
	}
	
	public final String getAbbrev() {
		return abbrev;
	}
}
