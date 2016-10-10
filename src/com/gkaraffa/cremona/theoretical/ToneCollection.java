package com.gkaraffa.cremona.theoretical;

public abstract class ToneCollection extends TheoreticalObject {
	private Tone[] tones = null;

	public ToneCollection(String name, Tone[] tones) {
		super(name);
		this.tones = tones;
	}
	
	public Tone[] getTones() {
		return tones;
	}
}
