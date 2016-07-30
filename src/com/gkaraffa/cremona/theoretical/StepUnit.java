package com.gkaraffa.cremona.theoretical;

public enum StepUnit {
	HALF_STEP(1, "Half Step", 'H'),
	WHOLE_STEP(2, "Whole Step", 'W');
	
	public final int steps;
	public final String text;
	public final char abbrev;
	
	StepUnit(int steps, String text, char abbrev){
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
	
	public final char getAbbrev() {
		return abbrev;
	}
}
