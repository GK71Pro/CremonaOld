package com.gkaraffa.cremona.workbench;

import com.gkaraffa.cremona.instrument.*;
import com.gkaraffa.cremona.theoretical.*;

public class Main {

  public Main() {}

  public static void main(String[] args) {

    try {

      InstrumentViewFactory iVF = new GuitarViewFactory();
      InstrumentView iV = iVF.createInstrumentView();
      ScaleFactory scaleFactory = new WholeToneScaleFactory();
      Scale scale = scaleFactory.createScale(ScalarIntervalPattern.wholeTonePattern, Tone.C);

      //System.out.println(iV.getCSVView(scale));
      System.out.println(iV.getTextView(scale));

      /*
      ArrayList<Tone> toneList = new ArrayList<Tone>();
      Tone startTone = Tone.C;
      Tone nextTone = startTone;
      boolean toggle = false;
      int count = 1;
      
      do {
        toneList.add(nextTone);
        
        if (toggle) {
          nextTone = TonalSpectrum.traverseDistance(nextTone, Interval.MINOR_SECOND.getHalfSteps());
          toggle = false;
        }
        else {
          nextTone = TonalSpectrum.traverseDistance(nextTone, Interval.MAJOR_SECOND.getHalfSteps());
          toggle = true;
        }
        
        count++;
      } while (!nextTone.equals(startTone));
      
      for (int index = 0; index <= 7; index++) {
        System.out.print(toneList.get(index));
        int halfSteps = TonalSpectrum.measureDistance(toneList.get(0), toneList.get(index));
        System.out.println("\t" + halfSteps);
        ArrayList<Interval> alIntervals = Interval.halfStepsToIntervalList(halfSteps);
          for(Interval interval: alIntervals) {
            System.out.println("\t" + interval);
          }
      }
      */

    }
    catch (Exception e) {
      e.printStackTrace();
    }

  }

}

