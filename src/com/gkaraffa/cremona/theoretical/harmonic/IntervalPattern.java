package com.gkaraffa.cremona.theoretical.harmonic;

import java.util.*;

import com.gkaraffa.cremona.theoretical.TheoreticalObject;

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

	public Interval getInterval(int location) {
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
			return getInterval(index++);
		}

		public void remove() {
			throw new UnsupportedOperationException("not supported yet");
		}
	}
}
