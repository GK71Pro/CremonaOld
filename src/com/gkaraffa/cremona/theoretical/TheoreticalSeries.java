package com.gkaraffa.cremona.theoretical;

public abstract class TheoreticalSeries extends TheoreticalObject {
	private Tonality tonality = null;
	protected Tone[] tones = null;

	public TheoreticalSeries() {
		// TODO Auto-generated constructor stub
	}
	
	public final Tonality getTonality() {
		return (this.tonality);
	}

	public final void setTonality(Tonality tonality) {
		this.tonality = tonality;
	}
	
	public final Tone[] getTones(){
		return (this.tones);
	}
	
	protected abstract void allocateToneSpace();
}
