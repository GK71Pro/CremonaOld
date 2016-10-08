package com.gkaraffa.cremona.theoretical;

import java.util.*;

public abstract class ToneCollection extends TheoreticalObject {
	private Collection tones = null;

	public ToneCollection(String name) {
		super(name);
	}
	
	public Collection getTones() {
		return(tones);
	}
	
	public void setTones(Collection tones) {
		this.tones = tones;
	}
}
