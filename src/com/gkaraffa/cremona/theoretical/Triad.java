package com.gkaraffa.cremona.theoretical;

import java.util.HashSet;

public class Triad extends Chord {
	public Triad(String name, Tone[] tones, HarmonicTonality tonality) {
		super(name, tones, tonality);
	}

	public Triad(String name, Tone[] tones, HarmonicTonality tonality,
			HashSet<Integer> degreeSet) {
		super(name, tones, tonality, degreeSet);
	}
}
