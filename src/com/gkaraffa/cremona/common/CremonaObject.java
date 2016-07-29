package com.gkaraffa.cremona.common;

public abstract class CremonaObject {
	private String name = null;

	public CremonaObject(String name) {
		this.name = name;
	}

	public String toString() {
		return (this.getClass().getName() + ": " + this.name);
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final String getName() {
		return name;
	}
}
