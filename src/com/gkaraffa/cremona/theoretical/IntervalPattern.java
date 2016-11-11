package com.gkaraffa.cremona.theoretical;

import java.util.*;

public class IntervalPattern extends TheoreticalObject{
	//private List<Interval> list = new ArrayList<Interval>();
	private static Set<String> allowableStrings = new TreeSet<String>();
	//private static Set
	
	static{
		for (Interval curr: Interval.values()){
			allowableStrings.add(curr.getAbbrev());
		}
	}

	public IntervalPattern(String name, String patternString)
			throws IllegalArgumentException{
		super(name);
		

		//parse patternString
		String[] patternArray = patternString.split(",");
		
		if (validateInputArray(patternArray)){
		
			/*
			for (String current: patternArray){
				switch (current){
					case Interval.MAJOR_SECOND.getAbbrev():
						list.add(Interval.MAJOR_SECOND);
						break;
				}
			}
			*/
			
		}
		
	}
	
	private boolean validateInputArray(String[] inputArray){
		for (String current : inputArray) {
			if (!allowableStrings.contains(current)) {
				return false;
			}
		}

		return true;
	}

}
