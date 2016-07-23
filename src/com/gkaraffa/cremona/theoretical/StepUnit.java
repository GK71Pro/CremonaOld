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
	
	public final char abbrev() {
		return abbrev;
	}
	
	public static final StepUnit charToStepUnit(char input) throws IllegalArgumentException{
		input = Character.toUpperCase(input);

		if (input == 'H'){
			return StepUnit.HALF_STEP;
		}
		else if (input == 'W'){
			return StepUnit.WHOLE_STEP;
		}
		else{
			throw new IllegalArgumentException();
		}		
	}
	
	public static final StepUnit intToStepUnit(int input) throws IllegalArgumentException{
		if (input == 1){
			return StepUnit.HALF_STEP;
		}
		else if (input == 2){
			return StepUnit.WHOLE_STEP;
		}
		else{
			throw new IllegalArgumentException();
		}
	}
}
