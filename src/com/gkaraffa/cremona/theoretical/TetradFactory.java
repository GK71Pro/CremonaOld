package com.gkaraffa.cremona.theoretical;

//import java.util.HashSet;
//import java.util.LinkedHashSet;

public class TetradFactory extends ChordFactory {

  public TetradFactory() {
  }

  @Override
  public Chord createChordFromIntervalPattern(ChordIntervalPattern chordIntervalPattern, Tone tonic)
      throws IllegalArgumentException {
	return null;
	/*
    Tone[] tones = intervalPatternAndTonicToToneArray(chordIntervalPattern, tonic);
    HarmonicProfile harmonicProfile = evaluateProfile(tones);

    return new SeventhChord(tones[0].getText() + " " + harmonicProfile.chordQuality.getText(),
        tones, harmonicProfile.chordQuality, harmonicProfile.intervalNumberSet);
    */
  }

  @Override
  public Chord createChordFromHarmonizable(Harmonizable harmonizableScale,
      IntervalNumber intervalNumber) throws IllegalArgumentException {
	return null;
	/*
    Tone[] tones = harmonizableScaleAndIntervalNumberToToneArray(harmonizableScale, intervalNumber,
        3);
    HarmonicProfile harmonicProfile = evaluateProfile(tones);

    return new SeventhChord(tones[0].getText() + " " + harmonicProfile.chordQuality.getText(),
        tones, harmonicProfile.chordQuality, harmonicProfile.intervalNumberSet);
    */
  }

  @Override
  protected HarmonicProfile evaluateProfile(Tone[] toneArray) {
    return null;
    /*
	HarmonicProfile harmonicProfile = new HarmonicProfile();
    HashSet<IntervalNumber> intervalNumber = new LinkedHashSet<IntervalNumber>();
    Interval[] intervalArray = this.convertToneArrayToIntervalArray(toneArray);
    
    if (intervalArray[0] == Interval.MAJOR_THIRD){
      intervalNumber.add(IntervalNumber.THIRD);
      
      if (intervalArray[1] == Interval.PERFECT_FIFTH){
        intervalNumber.add(IntervalNumber.FIFTH);
        
        if (intervalArray[2] == Interval.MAJOR_SEVENTH){
          //Major Seventh
          intervalNumber.add(IntervalNumber.SEVENTH);
        }
        else if (intervalArray[2] == Interval.MINOR_SEVENTH){
          //Dominant Seventh
          intervalNumber.add(IntervalNumber.SEVENTH);
        }
        else{
          //throw
        }
      }
      else{
        //throw
      }
    }
    else if (intervalArray[0] == Interval.MINOR_THIRD){
      if (intervalArray[1] == Interval.PERFECT_FIFTH){
        if (intervalArray[2] == Interval.MINOR_SEVENTH){
          //Minor Seventh
        }
        else{
          //throw
        }
      }
      else if (intervalArray[1] == Interval.DIMINISHED_FIFTH){
        if (intervalArray[2] == Interval.MINOR_SEVENTH){
          //Half Diminished Seventh
        }
        else if (intervalArray[2] == Interval.DIMINISHED_SEVENTH){
          //Diminished Seventh
        }
        else{
          //throw
        }
      }
      else{
        //throw
      }
    }
    else{
      //throw
    }
    /*
    intervalNumber.add(IntervalNumber.SEVENTH);

    harmonicProfile.chordQuality = ChordQuality.MAJOR_SEVENTH;
    harmonicProfile.intervalNumberSet = intervalNumber;
    */
    //return null;
  }
  

  
}
