package com.gkaraffa.cremona.workbench;

import java.util.ArrayList;

import com.gkaraffa.cremona.instrument.*;
import com.gkaraffa.cremona.theoretical.*;

public class Main {

  public Main() {}

  public static void main(String[] args) {
    try {
      ArrayList<Tone> guitarStringTones = new ArrayList<Tone>();
      int fretCount = 24;
      
      guitarStringTones.add(Tone.D);
      guitarStringTones.add(Tone.A);
      guitarStringTones.add(Tone.D);
      guitarStringTones.add(Tone.G);
      guitarStringTones.add(Tone.A);
      guitarStringTones.add(Tone.D);
      
      GuitarViewParameters gVP = new GuitarViewParameters();
      gVP.setNumberOfFrets(fretCount);
      gVP.setOpenStringTones(guitarStringTones);
      
      InstrumentViewFactory iVF = new GuitarViewFactory();
      InstrumentView iV = iVF.createInstrumentView(gVP);
      
      ScaleFactory scaleFactory = new DiatonicScaleFactory();
      Scale scale = scaleFactory.createScale(ScalarIntervalPattern.ionianPattern, Tone.C);
      
      System.out.println(iV.getCSVView());
      
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    
  }

}

