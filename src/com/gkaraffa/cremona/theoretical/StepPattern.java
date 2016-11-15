package com.gkaraffa.cremona.theoretical;

import java.util.*;

public class StepPattern extends TheoreticalObject {
	private List<StepUnit> stepList = new ArrayList<StepUnit>();
	private static Map<String, StepUnit> lookup = new HashMap<String, StepUnit>();

	static {
		for (StepUnit currUnit: StepUnit.values()){
			lookup.put(currUnit.abbrev, currUnit);
		}
	}

	public StepPattern(String name, String inPatternString)
			throws IllegalArgumentException {
		super(name);		
		
		String[] stepArray = inPatternString.split(",");
		for(String currentStep: stepArray){
			StepUnit currentUnit = lookup.get(currentStep);
			if (currentUnit == null){
				throw new IllegalArgumentException("Illegal pattern string.");
			}
			
			stepList.add(currentUnit);
		}
	}
	
	public StepUnit getStepUnit(int location) {
		return stepList.get(location);
	}
	
	
	public int size(){
		return stepList.size();
	}


	public static StepPattern harmonicMinorPattern = new StepPattern("Harmonic Minor",
			"W,H,W,W,H,HW,H");
			
}
