package com.gkaraffa.cremona.theoretical;

import com.gkaraffa.math.*;

public class Duration extends TheoreticalObject {
	private Fraction length;
	//private int wholeNoteBeats;
	//private Fraction beats = null;
	
	public Fraction getLength() {
		return this.length;
	}
	
	/*
	public int getWholeNoteBeats() {
		return this.wholeNoteBeats;
	}
	*/
	
	public Duration() {
		super();
	}
	
	public Duration(Duration d){
		super();
		this.length = d.getLength();
		this.setName(d.getName());
		this.setDefined(true);
	}

	public Duration(Fraction length){
		super();
		this.length = length;
		this.setName("(" + "length: " + length.getNumerator() + "/" + length.getDenominator() + ")");
		this.setDefined(true);
	}
	/*
	public Duration(Fraction length, int wholeNoteBeats){
		//"(" + "length: " + length.getNumerator + "/" + length.getDenominator() + ", wholeNoteBeats: " + wholeNoteBeats + ")" 
		super(("(" + "length: " + length.getNumerator() + "/" + length.getDenominator() + ", wholeNoteBeats: " + wholeNoteBeats + ")" ),
				true
				);
		this.length = length;
		this.wholeNoteBeats = wholeNoteBeats;
	}
	*/
	
	/*
	public Fraction getBeats(){
		if (beats == null){
			beats = length.multiply(new Fraction(wholeNoteBeats, 1));
		}
		return this.beats;
	}
	*/
}
