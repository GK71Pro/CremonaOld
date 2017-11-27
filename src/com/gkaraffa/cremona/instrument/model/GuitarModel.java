package com.gkaraffa.cremona.instrument.model;

import java.util.ArrayList;

import com.gkaraffa.cremona.common.Pitch;

public class GuitarModel extends InstrumentModel {
  private ArrayList<ArrayList<Pitch>> strings = new ArrayList<ArrayList<Pitch>>();
  private int numberFrets;

  public GuitarModel(ArrayList<ArrayList<Pitch>> strings, int numberFrets) {
    super();
    this.strings = strings;
    this.numberFrets = numberFrets;
  }
  
  public Pitch getPitch(int numString, int numFret) {
    if ((numFret > 0) && 
      (numFret <= numberFrets) &&
      (numString > 0) &&
      (numString <= strings.size())){
        return ((Pitch) strings.get(numString).get(numFret));
    }
    
    throw new IllegalArgumentException();
  }

}
