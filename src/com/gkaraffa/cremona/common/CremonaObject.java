package com.gkaraffa.cremona.common;

public abstract class CremonaObject{
	private String name = null;
	private boolean defined = false;

	public CremonaObject() {
	}

	public String toString() {
		if (this.defined) {
			return (this.getClass().getName() + ": " + this.name);
		}
		else {
			return ("undefined");
		}
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final String getName() {
		return (name);
	}

	public final void setDefined(boolean b_set) {
		defined = b_set;
	}

	public final boolean getDefined() {
		return (defined);
	}
}
