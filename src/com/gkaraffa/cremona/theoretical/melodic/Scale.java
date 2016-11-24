package com.gkaraffa.cremona.theoretical;

public abstract class Scale extends MelodicCollection {
	private MelodicTonality tonality;
	private Tone key;

	public Scale(String name, Tone[] tones, MelodicTonality tonality) {
		super(name, tones);
		this.tonality = tonality;
		this.key = tones[0];
	}
	
	public MelodicTonality getTonality(){
		return tonality;
	}
	
	public Tone getKey(){
		return this.key;
	}
}
