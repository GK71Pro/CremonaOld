package com.gkaraffa.cremona.theoretical;

public abstract class TheoreticalObject {
  private String text = null;

  public TheoreticalObject(String name) {
    this.text = name;
  }

  public String toString() {
    return this.text;
  }

  public final String getText() {
    return this.text;
  }

}
