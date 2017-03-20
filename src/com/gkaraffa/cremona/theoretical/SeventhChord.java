package com.gkaraffa.cremona.theoretical;

import java.util.HashSet;

public class SeventhChord extends Chord {

  public SeventhChord(String name, Tone[] tones, ChordQuality chordQuality,
      HashSet<IntervalNumber> intervalNumberSet) {
    super(name, tones, chordQuality, intervalNumberSet);
  }

  @Override
  public Tone getToneByIntervalNumber(IntervalNumber intervalNumber) {
    if (intervalNumber == IntervalNumber.FIRST) {
      return getTone(0);
    }
    else {
      if (getIntervalNumberSet().contains(intervalNumber)) {
        switch (intervalNumber) {
          case THIRD:
          case FOURTH:
            return getTone(1);
          case FIFTH:
            return getTone(2);
          case SEVENTH:
            return getTone(3);
          default:
            return null;
        }
      }
      else {
        return null;
      }

    }

  }
}
