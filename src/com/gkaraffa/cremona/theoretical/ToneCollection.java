package com.gkaraffa.cremona.theoretical;

public abstract class ToneCollection extends TheoreticalObject {
	private Tone[] tones = null;

	public ToneCollection(String name, Tone[] tones) {
		super(name);
		this.tones = tones;
	}

	/*
	public Tone[] getTones() {
		return tones;
	}
	*/

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
}
