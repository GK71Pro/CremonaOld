package com.gkaraffa.cremona.theoretical;

import java.util.*;

public class IntervalPattern extends TheoreticalObject
		implements Iterable<Interval> {
	private List<Interval> intervalList = new ArrayList<Interval>();
	private static HashMap<String, Interval> lookup = new HashMap<String, Interval>();

	static {
		for (Interval currInterval : Interval.values()) {
			lookup.put(currInterval.getAbbrev(), currInterval);
		}
	}

	public IntervalPattern(String name, String inPatternString)
			throws IllegalArgumentException {
		super(name);

		String[] intervalArray = inPatternString.split(",");
		for (String currentIntervalString : intervalArray) {
			Interval currentIntervalUnit = lookup.get(currentIntervalString);
			if (currentIntervalUnit == null) {
				throw new IllegalArgumentException("Illegal pattern string.");
			}

			intervalList.add(currentIntervalUnit);
		}
	}

	public Interval getIntervalByIntervalNumber(IntervalNumber intervalNumber) {
		for (Interval interval : intervalList) {
			if (interval.getIntervalNumber().equals(intervalNumber)) {
				return interval;
			}
		}

		return null;
	}

	public Interval getIntervalByLocation(int location) {
		return intervalList.get(location);
	}

	public int getSize() {
		return intervalList.size();
	}

	public Iterator<Interval> iterator() {
		return new IntervalIterator();
	}

	class IntervalIterator implements Iterator<Interval> {
		private int index = 0;

		public boolean hasNext() {
			return index < getSize();
		}

		public Interval next() {
			return getIntervalByLocation(index++);
		}

		public void remove() {
			throw new UnsupportedOperationException("not supported yet");
		}
	}

	public static IntervalPattern ionianPattern = new IntervalPattern("Ionian",
			"M2,M3,P4,P5,M6,M7,P8");
	public static IntervalPattern dorianPattern = new IntervalPattern("Dorian",
			"M2,m3,P4,P5,M6,m7,P8");
	public static IntervalPattern phrygianPattern = new IntervalPattern(
			"Phrygian", "m2,m3,P4,P5,m6,m7,P8");
	public static IntervalPattern lydianPattern = new IntervalPattern("Lydian",
			"M2,M3,A4,P5,M6,M7,P8");
	public static IntervalPattern mixolydianPattern = new IntervalPattern(
			"Mixolydian", "M2,M3,P4,P5,M6,m7,P8");
	public static IntervalPattern aeolianPattern = new IntervalPattern("Aeolian",
			"M2,m3,P4,P5,m6,m7,P8");
	public static IntervalPattern locrianPattern = new IntervalPattern("Locrian",
			"m2,m3,P4,d5,m6,m7,P8");
	public static IntervalPattern harmonicMinorPattern = new IntervalPattern(
			"Harmonic Minor", "M2,m3,P4,P5,m6,M7,P8");
	public static IntervalPattern melodicMinorPattern = new IntervalPattern(
			"Melodic Minor", "M2,m3,P4,P5,M6,M7,P8");
}
