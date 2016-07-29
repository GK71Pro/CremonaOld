package com.gkaraffa.cremona.theoretical;

public class Pitch extends TheoreticalObject {
	private Tone tone;
	private int range;
	
	public Pitch(Pitch p) {
		super(p.getName());
		this.setName(p.getName());
		this.tone = p.getTone();
		this.range = p.getRange();
	}

	public Pitch(Tone tone, int range) {
		super(tone.getText() + " " + range);
		this.tone = tone;
		this.range = range;
	}

	public Tone getTone() {
		return tone;
	}

	public int getRange() {
		return range;
	}
}
