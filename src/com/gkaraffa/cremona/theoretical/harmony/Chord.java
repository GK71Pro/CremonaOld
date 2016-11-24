package com.gkaraffa.cremona.theoretical.harmony;

import java.util.HashSet;

import com.gkaraffa.cremona.theoretical.Tone;

public abstract class Chord extends HarmonicCollection {
	private HarmonicTonality tonality;
	private HashSet<Integer> degreeSet;

	public Chord(String name, Tone[] tones, HarmonicTonality tonality,
			HashSet<Integer> degreeSet) {
		super(name, tones);
		this.tonality = tonality;
		this.degreeSet = degreeSet;
	}

	public final HarmonicTonality getTonality() {
		return tonality;
	}

	public final HashSet<Integer> getDegreeSet() {
		return degreeSet;
	}
	
	public abstract Tone getToneByDegree(int degree);

}
