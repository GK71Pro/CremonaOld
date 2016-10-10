package com.gkaraffa.cremona.theoretical;

public abstract class Scale extends MelodicCollection {
	private Tonality tonality;
	private Tone key;

	public Scale(String name, Tone[] tones, Tonality tonality) {
		super(name, tones);
		this.tonality = tonality;
		this.key = tones[0];
	}
	
	public Tonality getTonality(){
		return tonality;
	}
	
	public Tone getKey(){
		return this.key;
	}
}
