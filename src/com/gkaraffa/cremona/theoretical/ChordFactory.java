package com.gkaraffa.cremona.theoretical;

import java.util.LinkedHashSet;

import com.gkaraffa.cremona.common.CremonaException;

public class ChordFactory {

  public ChordFactory() {}

  /*
  abstract public Chord createChordFromIntervalPattern(ChordIntervalPattern intervalPattern,
      Tone tonic) throws IllegalArgumentException;
  
  
  abstract public Chord createChordFromHarmonizable(Harmonizable harmonizableScale, HarmonicPreference preference,
      IntervalNumber intervalNumber) throws IllegalArgumentException;
  
  abstract protected HarmonicProfile evaluateProfile(Tone[] toneArray, HarmonicPreference preference);
  */

  public Chord createChordFromHarmonizable(Harmonizable harmonizableScale,
      HarmonicPreference preference, IntervalNumber intervalNumber) throws CremonaException {

    Tone[] tones = harmonizableScaleAndIntervalNumberToToneArray(harmonizableScale, intervalNumber,
        preference, 3);
    HarmonicProfile harmonicProfile = evaluateProfile(tones, preference);

    return new Chord(tones[0].getText() + " " + harmonicProfile.chordQuality.getText(), tones,
        harmonicProfile.chordQuality, harmonicProfile.intervalNumberSet);
  }

  private Tone[] harmonizableScaleAndIntervalNumberToToneArray(Harmonizable harmonizableScale,
      IntervalNumber sourceInterval, HarmonicPreference preference, int limit) {
    Tone[] toneArray = new Tone[limit];

    for (int index = 0, offset = 0; index < limit; index++, offset += preference.getOffset()) {
      toneArray[index] = harmonizableScale.getToneAtRelativeIntervalNumber(sourceInterval,
          IntervalNumber.values()[offset]);
    }

    return toneArray;
  }

  private HarmonicProfile evaluateProfile(Tone[] toneArray, HarmonicPreference preference)
      throws CremonaException {
    Interval[] intervalArray = this.convertToneArrayToIntervalArray(toneArray, preference);


    /*
    switch (preference) {
      case TERTIARY:
        return renderTertiaryProfile(intervalArray);
      case QUARTAL:
        break;
      case QUINTAL:
        break;
    }
    */

    return renderTertiaryProfile(intervalArray);
  }

  private HarmonicProfile renderTertiaryProfile(Interval[] intervalArray) throws CremonaException {
    HarmonicProfile harmonicProfile = new HarmonicProfile();
    LinkedHashSet<IntervalNumber> intervalNumberSet = new LinkedHashSet<IntervalNumber>();

    if (intervalArray[0] == Interval.MAJOR_THIRD) {
      intervalNumberSet.add(IntervalNumber.THIRD);

      if (intervalArray[1] == Interval.PERFECT_FIFTH) {
        intervalNumberSet.add(IntervalNumber.FIFTH);
        harmonicProfile.chordQuality = ChordQuality.MAJOR;
        harmonicProfile.intervalNumberSet = intervalNumberSet;

        return harmonicProfile;
      }
      else {
        if (intervalArray[1] == Interval.AUGMENTED_FIFTH) {
          intervalNumberSet.add(IntervalNumber.FIFTH);
          harmonicProfile.chordQuality = ChordQuality.AUGMENTED;
          harmonicProfile.intervalNumberSet = intervalNumberSet;

          return harmonicProfile;
        }
      }
    }
    else {
      if (intervalArray[0] == Interval.MINOR_THIRD) {
        intervalNumberSet.add(IntervalNumber.THIRD);

        if (intervalArray[1] == Interval.PERFECT_FIFTH) {
          intervalNumberSet.add(IntervalNumber.FIFTH);
          harmonicProfile.chordQuality = ChordQuality.MINOR;
          harmonicProfile.intervalNumberSet = intervalNumberSet;

          return harmonicProfile;
        }
        else {
          if (intervalArray[1] == Interval.DIMINISHED_FIFTH) {
            intervalNumberSet.add(IntervalNumber.FIFTH);
            harmonicProfile.chordQuality = ChordQuality.DIMINISHED;
            harmonicProfile.intervalNumberSet = intervalNumberSet;

            return harmonicProfile;
          }
        }
      }
    }

    throw new CremonaException("Intervals invalid");
  }

  private Interval[] convertToneArrayToIntervalArray(Tone[] toneArray,
      HarmonicPreference preference) throws IllegalArgumentException {
    Interval[] intervalArray = new Interval[toneArray.length - 1];
    int offset = preference.getOffset();

    for (int index = 0, segment = 0; index < intervalArray.length; index++, segment += offset) {
      intervalArray[index] = Interval.halfStepsAndIntervalNumberToInterval(
          TonalSpectrum.measureDistance(toneArray[0], toneArray[index + 1]),
          IntervalNumber.values()[segment + offset]);
    }

    return intervalArray;
  }

  /*
  private Tone[] intervalPatternAndTonicToToneArray(ChordIntervalPattern chordIntervalPattern,
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
  */

  class HarmonicProfile {
    ChordQuality chordQuality = null;
    LinkedHashSet<IntervalNumber> intervalNumberSet = null;
  }

}
