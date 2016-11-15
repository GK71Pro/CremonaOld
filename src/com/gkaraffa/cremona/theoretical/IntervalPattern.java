package com.gkaraffa.cremona.theoretical;

import java.util.*;

public class IntervalPattern extends TheoreticalObject{
	private List<Interval> intervalList = new ArrayList<Interval>();
	private static HashMap<String, Interval> lookup = new HashMap<String, Interval>();
	
	static{
		for (Interval currInterval: Interval.values()){
			lookup.put(currInterval.getAbbrev(), currInterval);
		}
	}

	public IntervalPattern(String name, String inPatternString)
			throws IllegalArgumentException {
		super(name);		
		
		String[] intervalArray = inPatternString.split(",");
		for(String currentIntervalString: intervalArray){
			Interval currentIntervalUnit = lookup.get(currentIntervalString);
			if (currentIntervalUnit == null){
				throw new IllegalArgumentException("Illegal pattern string.");
			}
			
			intervalList.add(currentIntervalUnit);
		}
	}
	

	public Interval getInterval(int location) {
		return intervalList.get(location);
	}
	
	
	public int size(){
		return intervalList.size();
	}
}
