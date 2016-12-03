package com.gkaraffa.cremona.theoretical;

public abstract class ScaleFactory {

	public ScaleFactory() {
	}

	abstract public Scale createScale(IntervalPattern intervalPattern, Tone key)
			throws IllegalArgumentException;

}
