package com.gkaraffa.cremona.theoretical;

import com.gkaraffa.cremona.common.CremonaException;

public class DiatonicScale extends Scale implements Harmonizable {
	public static final int diatonicToneCount = 7;

	public DiatonicScale() throws CremonaException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void allocateToneSpace() {
		this.tones = new Tone[diatonicToneCount];		
	}

}
