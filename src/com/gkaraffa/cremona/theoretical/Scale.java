package com.gkaraffa.cremona.theoretical;

public abstract class Scale extends MelodicCollection {
	private Tonality tonality;

	public Scale(String name, Tonality tonality) {
		super(name);
		this.tonality = tonality;
	}
}
