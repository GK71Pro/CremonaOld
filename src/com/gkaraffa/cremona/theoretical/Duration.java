package com.gkaraffa.cremona.theoretical;

import com.gkaraffa.cremona.common.*;

public class Duration extends TheoreticalObject {
	private Fraction length;
		
	public Duration(Duration d){
		super(d.getName());
		this.length = d.getLength();
	}

	public Duration(Fraction length){
		super(length.getNumerator() + "/" + length.getDenominator());
		this.length = length;
	}
	
	public Fraction getLength() {
		return this.length;
	}
}
