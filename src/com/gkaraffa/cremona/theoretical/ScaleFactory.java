package com.gkaraffa.cremona.theoretical;

public abstract class ScaleFactory {

	public ScaleFactory() {
		// TODO Auto-generated constructor stub
	}
	
	abstract public Scale createScale(StepPattern stepPattern, Tone key);
	abstract protected Tone[] createToneArray(StepPattern stepPattern, Tone key);

}
