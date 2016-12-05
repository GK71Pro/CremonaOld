package com.gkaraffa.cremona.theoretical;

import java.util.HashSet;
import java.util.Iterator;
import com.gkaraffa.cremona.theoretical.*;

public abstract class Chord extends ToneCollection {
	private ChordQuality chordQuality;
	private HashSet<IntervalNumber> intervalNumberSet;
	
	public Chord(String name, Tone[] tones, ChordQuality chordQuality,
			HashSet<IntervalNumber> intervalNumberSet) {
		super(name, tones);
		this.chordQuality = chordQuality;
		this.intervalNumberSet = intervalNumberSet;
	}

	public final ChordQuality chordQuality() {
		return chordQuality;
	}

	public final HashSet<IntervalNumber> getIntervalNumberSet() {
		return intervalNumberSet;
	}

	public abstract Tone getToneByDegree(IntervalNumber degree);

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
