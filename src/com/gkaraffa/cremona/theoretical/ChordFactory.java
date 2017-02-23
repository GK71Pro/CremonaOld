package com.gkaraffa.cremona.theoretical;

public abstract class ChordFactory {

	public ChordFactory() {
	}

	abstract public Chord createChord(ChordIntervalPattern intervalPattern,
			Tone tonic) throws IllegalArgumentException;

	abstract public Chord createChord(Harmonizable harmonizableScale,
			IntervalNumber intervalNumber) throws IllegalArgumentException;

}
