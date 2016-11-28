package com.gkaraffa.cremona.theoretical.melodic;

import java.util.*;
import com.gkaraffa.cremona.theoretical.*;

public class StepDistancePattern extends TheoreticalObject implements Iterable<StepDistance>{
	private List<StepDistance> stepDistanceList = new ArrayList<StepDistance>();
	private static Map<String, StepDistance> lookup = new HashMap<String, StepDistance>();
	
	static {
		for (StepDistance currStepDistance : StepDistance.values()) {
			lookup.put(currStepDistance.abbrev, currStepDistance);
		}
	}

	public StepDistancePattern(String name, String inPatternString)
			throws IllegalArgumentException {
		super(name);

		String[] stepDistanceAbbrevArray = inPatternString.split(",");
		for (String stepDistanceAbbrev : stepDistanceAbbrevArray) {
			StepDistance currentStepDistance = lookup.get(stepDistanceAbbrev);
			if (currentStepDistance == null) {
				throw new IllegalArgumentException("Illegal pattern string.");
			}

			stepDistanceList.add(currentStepDistance);
		}
	}
	
	public StepDistance getStepDistance(int location) {
		return stepDistanceList.get(location);
	}

	public int getSize() {
		return stepDistanceList.size();
	}
	
	public Iterator<StepDistance> iterator() {
		return new StepDistanceIterator();
	}
	
	class StepDistanceIterator implements Iterator<StepDistance> {
		private int index = 0;

		public boolean hasNext() {
			return index < getSize();
		}

		public StepDistance next() {
			return getStepDistance(index++);
		}

		public void remove() {
			throw new UnsupportedOperationException("not supported yet");
		}
	}

}
