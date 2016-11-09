package com.gkaraffa.cremona.theoretical;

public abstract class ChordFactory {

	public ChordFactory() {
		// TODO Auto-generated constructor stub
	}

	abstract public Scale createChord(StepPattern stepPattern, Tone key);
	abstract protected Tone[] createToneArray(StepPattern stepPattern, Tone key);
	
}
