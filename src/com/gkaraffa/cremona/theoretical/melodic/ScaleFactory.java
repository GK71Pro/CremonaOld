package com.gkaraffa.cremona.theoretical.melodic;

import com.gkaraffa.cremona.theoretical.StepPattern;
import com.gkaraffa.cremona.theoretical.Tone;

public abstract class ScaleFactory {

	public ScaleFactory() {
		// TODO Auto-generated constructor stub
	}
	
	abstract public Scale createScale(StepPattern stepPattern, Tone key) throws IllegalArgumentException;
	abstract protected Tone[] createToneArray(StepPattern stepPattern, Tone key);
	abstract protected boolean validateInputPattern(StepPattern stepPattern);


}
