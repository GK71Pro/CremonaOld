package com.gkaraffa.cremona.theoretical;

public class Pitch extends TheoreticalObject {
	private Tone tone;
	private int range;

	public Tone getTone() {
		return tone;
	}

	public int getRange() {
		return range;
	}

	public Pitch() {
		super();
	}

	public Pitch(Pitch p) {
		super();
		this.setDefined(true);
		this.setName(p.getName());
		this.tone = p.getTone();
		this.range = p.getRange();
	}

	public Pitch(Tone tone, int range) {
		this.tone = tone;
		this.range = range;
		this.setName("(Tone: " + this.tone.getText() + ", range: " + this.range + ")");
		this.setDefined(true);
	}
}
