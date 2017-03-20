package com.gkaraffa.cremona.theoretical;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class TriadFactory extends ChordFactory {

  public TriadFactory() {
  }

  @Override
  public Chord createChordFromIntervalPattern(ChordIntervalPattern chordIntervalPattern, Tone tonic)
      throws IllegalArgumentException {

    Tone[] tones = intervalPatternAndTonicToToneArray(chordIntervalPattern, tonic);
    HarmonicProfile harmonicProfile = evaluateProfile(tones);

    return new Triad(tones[0].getText() + " " + harmonicProfile.chordQuality.getText(), tones,
        harmonicProfile.chordQuality, harmonicProfile.intervalNumberSet);
  }

  @Override
  public Chord createChordFromHarmonizable(Harmonizable harmonizableScale,
      IntervalNumber intervalNumber) throws IllegalArgumentException {

    Tone[] tones = harmonizableScaleAndIntervalNumberToToneArray(harmonizableScale, intervalNumber,
        3);
    HarmonicProfile harmonicProfile = evaluateProfile(tones);

    return new Triad(tones[0].getText() + " " + harmonicProfile.chordQuality.getText(), tones,
        harmonicProfile.chordQuality, harmonicProfile.intervalNumberSet);
  }

  @Override
  protected HarmonicProfile evaluateProfile(Tone[] toneArray) {
    HarmonicProfile harmonicProfile = new HarmonicProfile();
    HashSet<IntervalNumber> intervalNumber = new LinkedHashSet<IntervalNumber>();
    Interval[] intervalArray = this.convertToneArrayToIntervalArray(toneArray);

    if (intervalArray[0] == Interval.MAJOR_THIRD) {
      intervalNumber.add(IntervalNumber.THIRD);

      if (intervalArray[1] == Interval.PERFECT_FIFTH) {
        intervalNumber.add(IntervalNumber.FIFTH);
        harmonicProfile.chordQuality = ChordQuality.MAJOR;
        harmonicProfile.intervalNumberSet = intervalNumber;

        return harmonicProfile;
      }
      else {
        if (intervalArray[1] == Interval.AUGMENTED_FIFTH) {
          intervalNumber.add(IntervalNumber.FIFTH);
          harmonicProfile.chordQuality = ChordQuality.AUGMENTED;
          harmonicProfile.intervalNumberSet = intervalNumber;

          return harmonicProfile;
        }
      }
    }
    else {
      if (intervalArray[0] == Interval.MINOR_THIRD) {
        intervalNumber.add(IntervalNumber.THIRD);

        if (intervalArray[1] == Interval.PERFECT_FIFTH) {
          intervalNumber.add(IntervalNumber.FIFTH);
          harmonicProfile.chordQuality = ChordQuality.MINOR;
          harmonicProfile.intervalNumberSet = intervalNumber;

          return harmonicProfile;
        }
        else {
          if (intervalArray[1] == Interval.DIMINISHED_FIFTH) {
            intervalNumber.add(IntervalNumber.FIFTH);
            harmonicProfile.chordQuality = ChordQuality.DIMINISHED;
            harmonicProfile.intervalNumberSet = intervalNumber;

            return harmonicProfile;
          }
        }
      }
      else {
        if (intervalArray[0] == Interval.PERFECT_FOURTH) {
          intervalNumber.add(IntervalNumber.FOURTH);

          if (intervalArray[1] == Interval.PERFECT_FIFTH) {
            intervalNumber.add(IntervalNumber.FIFTH);
            harmonicProfile.chordQuality = ChordQuality.SUSPENDED_FOURTH;
            harmonicProfile.intervalNumberSet = intervalNumber;

            return harmonicProfile;
          }
        }
      }
    }

    throw new IllegalArgumentException("Not valid triad intervals.");
  }

}
