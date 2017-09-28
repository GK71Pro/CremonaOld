package com.gkaraffa.cremona.theoretical;

import java.util.HashSet;

public abstract class ChordFactory {

  public ChordFactory() {
  }

  abstract public Chord createChordFromIntervalPattern(ChordIntervalPattern intervalPattern,
      Tone tonic) throws IllegalArgumentException;

  abstract public Chord createChordFromHarmonizable(Harmonizable harmonizableScale,
      IntervalNumber intervalNumber) throws IllegalArgumentException;

  abstract protected HarmonicProfile evaluateProfile(Tone[] toneArray);

  protected Tone[] intervalPatternAndTonicToToneArray(ChordIntervalPattern chordIntervalPattern,
      Tone tonic) {
    int toneCount = chordIntervalPattern.getSize() + 1;
    Tone[] tones = new Tone[toneCount];

    tones[0] = tonic;

    for (int index = 1; index < toneCount; index++) {
      Tone cur = TonalSpectrum.traverseDistance(tones[0],
          chordIntervalPattern.getIntervalByLocation(index - 1).getHalfSteps());

      tones[index] = cur;
    }

    return tones;
  }
  
  protected Tone[] harmonizableScaleAndIntervalNumberToToneArray(Harmonizable harmonizableScale,
      IntervalNumber sourceInterval, int harmonicBase, int limit) {
    Tone[] toneArray = new Tone[limit];

    System.out.println(harmonizableScale);
    for (int index = 0, offset = 0; index < limit; index++, offset+=harmonicBase) {
      toneArray[index] = harmonizableScale.getToneAtRelativeInterval(sourceInterval,
          IntervalNumber.values()[offset]);
    }

    return toneArray;
  }

  protected Interval[] convertToneArrayToIntervalArray(Tone[] toneArray)
      throws IllegalArgumentException {
    Interval[] intervalArray = new Interval[toneArray.length - 1];

    for (int index = 0; index < intervalArray.length; index++) {
      intervalArray[index] = Interval.halfStepsAndIntervalNumberToInterval(
          TonalSpectrum.measureDistance(toneArray[0], toneArray[index + 1]),
          IntervalNumber.values()[(index + 1) * 2]);

      if ((intervalArray[index].getIntervalQuality() == IntervalQuality.AUGMENTED)
          && (index == 0)) {
        intervalArray[0] = Interval.halfStepsAndIntervalNumberToInterval(
            TonalSpectrum.measureDistance(toneArray[0], toneArray[1]), IntervalNumber.FOURTH);
      }
    }

    return intervalArray;
  }

  class HarmonicProfile {
    ChordQuality chordQuality = null;
    HashSet<IntervalNumber> intervalNumberSet = null;
  }

}
