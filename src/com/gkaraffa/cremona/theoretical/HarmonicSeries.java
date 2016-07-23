package com.gkaraffa.cremona.theoretical;

import com.gkaraffa.cremona.common.*;

public abstract class HarmonicSeries extends TheoreticalSeries{

	public HarmonicSeries() throws CremonaException{
		this.allocateToneSpace();
		if (tones == null){
			throw (new CremonaException("Allocation incomplete."));
		}
	}
	
	public final void setFirst(Tone first){
		this.tones[0] = first; 
	}
	
	public final Tone getFirst(){
		return (this.tones[0]);
	}
	
	public final void setFifth(Tone fifth){
		this.tones[2] = fifth;
	}
	
	public final Tone getFifth(){
		return (this.tones[2]);
	}
}
