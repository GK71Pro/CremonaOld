package com.gkaraffa.cremona.theoretical;

import com.gkaraffa.cremona.common.CremonaException;

public abstract class ToneCollection extends TheoreticalObject
		implements Iterable<Tone> {
	private Tone[] tones = null;

	public ToneCollection(String name, Tone[] tones) {
		super(name);
		this.tones = tones;
	}

	public boolean contains(Tone target) {
		for (Tone tone : tones) {
			if (tone.equals(target)) {
				return true;
			}
		}

		return false;
	}

	public String getSpellingString() {
		StringBuilder sb = new StringBuilder();

		for (Tone tone : tones) {
			sb.append(tone.getText() + ", ");
		}

		sb.setLength(sb.length() - 2);

		return sb.toString();
	}

	public int getSize() {
		return tones.length;
	}

	public Tone getTone(int position) {
		if (position > (tones.length - 1)) {
			return tones[position - tones.length];
		}
		else {
			return tones[position];
		}
	}

	public int getPosition(Tone target) throws CremonaException {
		for (int i = 0; i < tones.length; i++) {
			if (this.tones[i].equals(target)) {
				return i;
			}
		}

		throw new CremonaException("Tone does not exist in this ToneCollection");
	}

}
