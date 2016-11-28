package com.gkaraffa.cremona.theoretical;

import com.gkaraffa.cremona.common.CremonaObject;

public class Distance extends CremonaObject{
	private int halfSteps;
	
	public Distance(int halfSteps) {
		super(Integer.toString(halfSteps));
		this.halfSteps = halfSteps;
	}

	public final int getHalfSteps() {
		return halfSteps;
	}
}
