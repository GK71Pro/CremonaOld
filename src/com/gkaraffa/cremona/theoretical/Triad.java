package com.gkaraffa.cremona.theoretical;

import java.util.HashSet;

public class Triad extends Chord {
	public Triad(String name, Tone[] tones, ChordQuality chordQuality,
			HashSet<IntervalNumber> intervalNumberSet) {
		super(name, tones, chordQuality, intervalNumberSet);
	}

	public Tone getToneByIntervalNumber(IntervalNumber intervalNumber) {
		if (intervalNumber == IntervalNumber.FIRST) {
			return getTone(0);
		}
		else {
			if (getIntervalNumberSet().contains(intervalNumber)) {
				switch (intervalNumber) {
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
