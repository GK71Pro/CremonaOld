package com.gkaraffa.cremona.theoretical.harmonic;

import java.util.HashSet;

import com.gkaraffa.cremona.theoretical.Tone;

public class Triad extends Chord {
	public Triad(String name, Tone[] tones, HarmonicTonality tonality,
			HashSet<Integer> degreeSet) {
		super(name, tones, tonality, degreeSet);
	}

	public Tone getToneByDegree(int degree) {
		if (degree == 1) {
			return getTone(0);
		}
		else {
			if (getDegreeSet().contains(degree)) {
				switch (degree) {
					case 3:
					case 4:
						return getTone(1);
					case 5:
						return getTone(2);
					default:
						return null;
				}
			}
			else {
				return null;
			}
		}
	}
}
