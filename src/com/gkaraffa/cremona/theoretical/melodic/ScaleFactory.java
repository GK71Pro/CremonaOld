package com.gkaraffa.cremona.theoretical.melodic;

import com.gkaraffa.cremona.theoretical.IntervalPattern;
import com.gkaraffa.cremona.theoretical.Tone;

public abstract class ScaleFactory {

	public ScaleFactory() {
	}
	
	abstract public Scale createScale(IntervalPattern intervalPattern, Tone key) throws IllegalArgumentException;

}
