package com.gkaraffa.cremona.theoretical.harmonic;

import com.gkaraffa.cremona.theoretical.Harmonizable;
import com.gkaraffa.cremona.theoretical.IntervalPattern;
import com.gkaraffa.cremona.theoretical.Tone;

public abstract class ChordFactory {

	public ChordFactory() {
		// TODO Auto-generated constructor stub
	}

	abstract public Chord createChord(IntervalPattern intervalPattern, Tone tonic) throws IllegalArgumentException;
	abstract public Chord createChord(Harmonizable harmonizableScale, int scaleDegree) throws IllegalArgumentException;

	
}
