package com.gkaraffa.cremona.theoretical.melodic;

import java.util.Iterator;
import com.gkaraffa.cremona.theoretical.*;

public class DiatonicScale extends Scale implements Harmonizable {

	public DiatonicScale(String name, Tone[] tones, MelodicTonality tonality) {
		super(name, tones, tonality);
	}

	private int calculateEndPoint(int startPoint, int offset) {
		if (startPoint > 6) {
			startPoint -= 6;
		}

		startPoint--;
		int endPoint = startPoint + offset;
		if (endPoint > 6) {
			endPoint -= 6;
		}

		return endPoint;
	}

	public Tone getFirst(int scaleDegree) {
		return getTone(scaleDegree - 1);
	}

	public Tone getThird(int scaleDegree) {
		return getTone(calculateEndPoint(scaleDegree, 2));
	}

	public Tone getFifth(int scaleDegree) {
		return getTone(calculateEndPoint(scaleDegree, 4));
	}

	public Tone getSeventh(int scaleDegree) {
		return getTone(calculateEndPoint(scaleDegree, 6));
	}

	public Tone getEleventh(int scaleDegree) {
		return getTone(calculateEndPoint(scaleDegree, 8));
	}

	public Tone getThirteenth(int scaleDegree) {
		return getTone(calculateEndPoint(scaleDegree, 10));
	}

	public Iterator<Tone> iterator() {
		return new ToneIterator();
	}

	class ToneIterator implements Iterator<Tone> {
		private int index = 0;

		public boolean hasNext() {
			return index <= getSize();
		}

		public Tone next() {
			if (index == getSize()) {
				index++;
				return getTone(0);
			}

			return getTone(index++);
		}

		public void remove() {
			throw new UnsupportedOperationException("not supported yet");
		}
	}

}
