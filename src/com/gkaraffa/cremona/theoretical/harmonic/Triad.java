package com.gkaraffa.cremona.theoretical.harmonic;

import java.util.HashSet;

import com.gkaraffa.cremona.theoretical.Tone;

public class Triad extends Chord {
	public Triad(String name, Tone[] tones, HarmonicTonality tonality,
			HashSet<HarmonicDegree> degreeSet) {
		super(name, tones, tonality, degreeSet);
	}

	public Tone getToneByDegree(HarmonicDegree degree) {
		if (degree == HarmonicDegree.FIRST) {
			return getTone(0);
		}
		else {
			if (getDegreeSet().contains(degree)) {
				switch (degree) {
					case THIRD:
					case FOURTH:
						return getTone(1);
					case FIFTH:
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
