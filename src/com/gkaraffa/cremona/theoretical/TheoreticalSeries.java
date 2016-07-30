package com.gkaraffa.cremona.theoretical;

import java.util.*;

public abstract class TheoreticalSeries extends TheoreticalObject {
	private Tonality tonality = null;
	private List<Tone> tones = new ArrayList<Tone>();

	public TheoreticalSeries(String name, Tonality tonality) {
		super(name);
		this.tonality = tonality;
	}

	public final Tonality getTonality() {
		return this.tonality;
	}

	public final Tone getTone(int index){
		return tones.get(index);
	}
	
	public final void addTone(Tone tone){
		tones.add(tone);
	}	
}
