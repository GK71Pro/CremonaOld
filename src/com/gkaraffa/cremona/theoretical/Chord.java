package com.gkaraffa.cremona.theoretical;

public abstract class Chord extends HarmonicCollection{
	private HarmonicTonality tonality;
	private Tone tonic;
	
	public Chord(String name, Tone[] tones, HarmonicTonality tonality) {
		super(name, tones);
		this.tonality = tonality;
		this.tonic = tones[0];
	}

	
}
