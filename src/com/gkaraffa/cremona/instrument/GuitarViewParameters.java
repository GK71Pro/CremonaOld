package com.gkaraffa.cremona.instrument;

import java.util.ArrayList;

import com.gkaraffa.cremona.theoretical.Tone;

public class GuitarViewParameters extends InstrumentViewParameters {
  private int numberOfFrets;
  private ArrayList<Tone> openStringTones = new ArrayList<Tone>();

  public GuitarViewParameters() {
    super();
  }
    
  public int getNumberOfFrets() {
    return numberOfFrets;
  }

  public void setNumberOfFrets(int numberOfFrets) {
    this.numberOfFrets = numberOfFrets;
  }

  public ArrayList<Tone> getOpenStringTones() {
    return openStringTones;
  }

  public void setOpenStringTones(ArrayList<Tone> openStringTones) {
    this.openStringTones = openStringTones;
  }



}
