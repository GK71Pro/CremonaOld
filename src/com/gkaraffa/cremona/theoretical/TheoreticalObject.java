package com.gkaraffa.cremona.theoretical;

public abstract class TheoreticalObject {
	private String name = null;

	public TheoreticalObject(String name) {
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
