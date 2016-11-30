package com.gkaraffa.cremona.theoretical.melodic;

import java.util.*;

import com.gkaraffa.cremona.theoretical.TheoreticalObject;

public class StepPattern extends TheoreticalObject
		implements Iterable<StepUnit> {
	private List<StepUnit> stepList = new ArrayList<StepUnit>();
	private static Map<String, StepUnit> lookup = new HashMap<String, StepUnit>();

	static {
		for (StepUnit currUnit : StepUnit.values()) {
			lookup.put(currUnit.getAbbrev(), currUnit);
		}
	}

	public StepPattern(String name, String inPatternString)
			throws IllegalArgumentException {
		super(name);

		String[] stepArray = inPatternString.split(",");
		for (String currentStep : stepArray) {
			StepUnit currentUnit = lookup.get(currentStep);
			if (currentUnit == null) {
				throw new IllegalArgumentException("Illegal pattern string.");
			}

			stepList.add(currentUnit);
		}
		
		//split by comma
		//loop elements
			//split element by single-length strings
			//loop single-length strings
				//validation
				//accrue distance
			
	}

	public StepUnit getStepUnit(int location) {
		return stepList.get(location);
	}

	public int getSize() {
		return stepList.size();
	}
	
	public Iterator<StepUnit> iterator() {
		return new StepUnitIterator();
	}
	
	class StepUnitIterator implements Iterator<StepUnit> {
		private int index = 0;

		public boolean hasNext() {
			return index < getSize();
		}

		public StepUnit next() {
			return getStepUnit(index++);
		}

		public void remove() {
			throw new UnsupportedOperationException("not supported yet");
		}
	}	

	public static StepPattern harmonicMinorPattern = new StepPattern(
			"Harmonic Minor", "W,H,W,W,H,HW,H");

}
