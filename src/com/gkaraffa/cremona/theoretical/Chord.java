package com.gkaraffa.cremona.theoretical;

import java.util.HashSet;

public abstract class Chord extends ToneCollection {
  private ChordQuality chordQuality;
  private HashSet<IntervalNumber> intervalNumberSet;

  public Chord(String name, Tone[] tones, ChordQuality chordQuality,
      HashSet<IntervalNumber> intervalNumberSet) {
    super(name, tones);
    this.chordQuality = chordQuality;
    this.intervalNumberSet = intervalNumberSet;
  }

  public final ChordQuality chordQuality() {
    return chordQuality;
  }

  public final HashSet<IntervalNumber> getIntervalNumberSet() {
    return intervalNumberSet;
  }

  public abstract Tone getToneByIntervalNumber(IntervalNumber intervalNumber);

}
