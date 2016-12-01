package com.gkaraffa.cremona.theoretical.harmonic;

import java.util.HashSet;
import java.util.Iterator;
import com.gkaraffa.cremona.theoretical.*;

public abstract class Chord extends ToneCollection {
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

	public Iterator<Tone> iterator() {
		return new ToneIterator();
	}

	class ToneIterator implements Iterator<Tone> {
		private int index = 0;

		public boolean hasNext() {
			return index < getSize();
		}

		public Tone next() {
			return getTone(index++);
		}

		public void remove() {
			throw new UnsupportedOperationException("not supported yet");
		}
	}

}
