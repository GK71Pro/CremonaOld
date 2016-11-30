package com.gkaraffa.cremona.theoretical.melodic;

import com.gkaraffa.cremona.theoretical.*;

public enum StepUnit {
	HALF_STEP(new Distance(1), "Half Step", "H"),
	WHOLE_STEP(new Distance(2), "Whole Step", "W"),
	HALF_WHOLE_STEP(new Distance(3), "Whole Step", "HW");
	
	private final Distance distance;
	private final String text;
	private final String abbrev;
	
	StepUnit(Distance distance, String text, String abbrev){
		this.distance = distance;
		this.text = text;
		this.abbrev = abbrev;
	}

	public final Distance getDistance() {
		return distance;
	}

	public final String getText() {
		return text;
	}
	
	public final String getAbbrev() {
		return abbrev;
	}
}
