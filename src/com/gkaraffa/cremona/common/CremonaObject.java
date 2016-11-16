package com.gkaraffa.cremona.common;

public abstract class CremonaObject {
	private String text = null;

	public CremonaObject(String name) {
		this.text = name;
	}

	public String toString() {
		return (this.getClass().getName() + ": " + this.text);
	}

	/*
	public final void setText(String name) {
		this.text = name;
	}
	*/

	public final String getText() {
		return text;
	}
}
