package com.gkaraffa.cremona.theoretical.melodic;

import com.gkaraffa.cremona.theoretical.*;

public abstract class Scale extends ToneCollection {
	private MelodicTonality tonality;
	private Tone key;

	public Scale(String name, Tone[] tones, MelodicTonality tonality) {
		super(name, tones);
		this.tonality = tonality;
		this.key = tones[0];
	}

	public MelodicTonality getTonality() {
		return tonality;
	}

	public Tone getKey() {
		return this.key;
	}
}
