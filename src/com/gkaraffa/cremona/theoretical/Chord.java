package com.gkaraffa.cremona.theoretical;

import java.util.HashSet;

public abstract class Chord extends HarmonicCollection {
	private HarmonicTonality tonality;
	private Tone tonic;
	private HashSet<Integer> degreeSet;

	public Chord(String name, Tone[] tones, HarmonicTonality tonality) {
		super(name, tones);
		this.tonality = tonality;
		this.tonic = tones[0];
	}

	public Chord(String name, Tone[] tones, HarmonicTonality tonality,
			HashSet<Integer> degreeSet) {
		super(name, tones);
		this.tonality = tonality;
		this.tonic = tones[0];
		this.degreeSet = degreeSet;
	}

	public final HarmonicTonality getTonality() {
		return tonality;
	}

	public final Tone getTonic() {
		return tonic;
	}

	public final HashSet<Integer> getDegreeSet() {
		return degreeSet;
	}

}
