package com.gkaraffa.cremona.theoretical;

import com.gkaraffa.cremona.common.*;

public class Triad extends HarmonicSeries {

	//default constructor
	public Triad() throws CremonaException{
		super();
	}

	//copy constructor
	public Triad(Triad t) throws CremonaException{
		super();
		this.setDefined(true);
		this.setName(t.getName());
		System.arraycopy(t.getTones(), 0, this.tones, 0, t.getTones().length);
	}
	
	public final void setThird(Tone third){
		this.tones[1] = third;
	}
	
	public final Tone getThird(){
		return (this.tones[1]);
	}

	@Override
	protected void allocateToneSpace() {
		this.tones = new Tone[3];
	}
}
