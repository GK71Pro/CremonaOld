package com.gkaraffa.cremona.theoretical;

import com.gkaraffa.cremona.common.*;

public abstract class MelodicSeries extends TheoreticalSeries{	
	
	public MelodicSeries() throws CremonaException{
		this.allocateToneSpace();
		if (tones == null){
			throw (new CremonaException("Allocation incomplete."));
		}
	}

}
