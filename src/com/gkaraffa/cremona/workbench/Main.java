package com.gkaraffa.cremona.workbench;

import com.gkaraffa.cremona.theoretical.*;

public class Main {

  public Main() {
  }

  public static void main(String[] args) {
    try {
      ScaleFactory scaleFactory = new DiatonicScaleFactory();
      Scale scale = scaleFactory.createScale(ScalarIntervalPattern.ionianPattern, Tone.C);
      
      for(int number = 0; number < scale.getSize(); number++){
        Interval interval = Interval.halfStepsAndIntervalNumberToInterval(TonalSpectrum.measureDistance(scale.getTone(0), scale.getTone(number)),
            IntervalNumber.integerToIntervalNumber(number));
        System.out.println("::" + scale.getTone(number) + ":" + interval);
      }
    }
    catch (Exception e) {
    }
  }
}

