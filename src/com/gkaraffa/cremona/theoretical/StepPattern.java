package com.gkaraffa.cremona.theoretical;

import java.util.*;

public class StepPattern extends TheoreticalObject {
	private List<StepUnit> list = new ArrayList<StepUnit>();
	private static Set<Character> allowable = new TreeSet<Character>(
			Arrays.asList('W', 'w', 'H', 'h'));

	public StepPattern(String name, String patternString)
			throws IllegalArgumentException {
		super(name);
		char[] charArray = patternString.toCharArray();

		if (validateInputArray(charArray)) {
			for (char current : charArray) {
				switch (current) {
					case 'W':
					case 'w':
						list.add(StepUnit.WHOLE_STEP);
						break;
					case 'H':
					case 'h':
						list.add(StepUnit.HALF_STEP);
						break;
				}
			}
		}
		else {
			throw new IllegalArgumentException();
		}
	}

	private boolean validateInputArray(char[] inputArray) {
		for (char current : inputArray) {
			if (!allowable.contains(current)) {
				return false;
			}
		}

		return true;
	}
	
	public StepUnit getStepUnit(int location) {
		return list.get(location);
	}
	
	
	public int size(){
		return list.size();
	}

	public static StepPattern ionianPattern = new StepPattern("Ionian",
			"WWHWWWH");
	public static StepPattern dorianPattern = new StepPattern("Dorian",
			"WHWWWHW");
	public static StepPattern phrygianPattern = new StepPattern("Phrygian",
			"HWWWHWW");
	public static StepPattern lydianPattern = new StepPattern("Lydian",
			"WWWHWWH");
	public static StepPattern mixolydianPattern = new StepPattern("Mixolydian",
			"WWHWWHW");
	public static StepPattern aeolianPattern = new StepPattern("Aeolian",
			"WHWWHWW");
	public static StepPattern locrianPattern = new StepPattern("Locrian",
			"HWWHWWW");
}
