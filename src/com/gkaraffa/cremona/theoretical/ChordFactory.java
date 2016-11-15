package com.gkaraffa.cremona.theoretical;

public abstract class ChordFactory {

	public ChordFactory() {
		// TODO Auto-generated constructor stub
	}

	abstract public Chord createChord(IntervalPattern intervalPattern, Tone key) throws IllegalArgumentException;
	abstract protected Tone[] createToneArray(IntervalPattern intervalPattern, Tone key);
	abstract protected boolean validateInputPattern(IntervalPattern intervalPattern);
	
}
