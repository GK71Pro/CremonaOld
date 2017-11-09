package com.gkaraffa.cremona.common;

import com.gkaraffa.cremona.experimental.Frequency;
import com.gkaraffa.cremona.theoretical.TheoreticalObject;
import com.gkaraffa.cremona.theoretical.Tone;

public class Pitch extends TheoreticalObject {
  private Tone tone;
  private int range;
  private Frequency frequency;

  public Pitch(Pitch p) {
    super(p.getText());
    this.tone = p.getTone();
    this.range = p.getRange();
  }

  public Pitch(Tone tone, int range) {
    super(tone.getText() + " " + range);
    this.tone = tone;
    this.range = range;
  }

  public Tone getTone() {
    return this.tone;
  }

  public int getRange() {
    return this.range;
  }
  
  public Frequency getFrequency() {
    return this.frequency;
  }
}
