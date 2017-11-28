package com.gkaraffa.cremona.instrument.model;

import java.util.ArrayList;

import com.gkaraffa.cremona.common.Pitch;
import com.gkaraffa.cremona.common.PitchCollection;
import com.gkaraffa.cremona.theoretical.ToneCollection;

public class GuitarModel extends InstrumentModel implements InstrumentRow, InstrumentColumn {
  private ArrayList<ArrayList<Pitch>> strings = new ArrayList<ArrayList<Pitch>>();
  private int numberFrets;

  public GuitarModel(ArrayList<ArrayList<Pitch>> strings, int numberFrets) {
    super();
    this.strings = strings;
    this.numberFrets = numberFrets;
  }

  @Override
  public Pitch[] getRow(int row) {
    // check limits
    if (row > numberFrets) {
      throw new IllegalArgumentException();
    }

    // get row
    int numStrings = strings.size();
    Pitch[] targetPitchRow = new Pitch[numStrings];

    for (int index = 0; index < numStrings; index++) {
      targetPitchRow[index] = strings.get(index).get(row);
    }

    return targetPitchRow;
  }

  @Override
  public Pitch[] getFilteredRow(int row, ToneCollection toneFilter) {
    // check limits
    if (row > numberFrets) {
      throw new IllegalArgumentException();
    }

    // get row
    int numStrings = strings.size();
    Pitch[] targetPitchRow = new Pitch[numStrings];

    for (int index = 0; index < numStrings; index++) {
      Pitch pitch = strings.get(index).get(row);

      if (toneFilter.contains(pitch.getTone())) {
        targetPitchRow[index] = pitch;
      }
      else {
        targetPitchRow[index] = null;
      }
    }

    return targetPitchRow;
  }

  @Override
  public Pitch[] getFilteredRow(int row, PitchCollection pitchFilter) {
    // check limits
    if (row > numberFrets) {
      throw new IllegalArgumentException();
    }

    // get row
    int numStrings = strings.size();
    Pitch[] targetPitchRow = new Pitch[numStrings];

    for (int index = 0; index < numStrings; index++) {
      Pitch pitch = strings.get(index).get(row);

      if (pitchFilter.contains(pitch)) {
        targetPitchRow[index] = pitch;
      }
      else {
        targetPitchRow[index] = null;
      }
    }

    return targetPitchRow;
  }

  @Override
  public Pitch[] getColumn(int column) {
    // check limits
    if (column > (strings.size() - 1)) {
      throw new IllegalArgumentException();
    }
    
    // get column
    Pitch[] targetPitchColumn = new Pitch[numberFrets];
    targetPitchColumn = strings.get(column).toArray(targetPitchColumn);
    
    return targetPitchColumn;
  }

  @Override
  public Pitch[] getFilteredColumn(int column, ToneCollection toneFilter) {
    // check limits
    if (column > (strings.size() - 1)) {
      throw new IllegalArgumentException();
    }
    
    // get column
    Pitch[] targetPitchColumn = new Pitch[numberFrets];
    ArrayList<Pitch> tempPtr = strings.get(column);
    
    for (int index = 0; index < numberFrets; index++) {
      Pitch currentPitch = tempPtr.get(index);
      
      if (toneFilter.contains(currentPitch.getTone())){
        targetPitchColumn[index] = currentPitch;
      }
      else {
        targetPitchColumn[index] = null;
      }
    }

    return targetPitchColumn;
  }

  @Override
  public Pitch[] getFilteredColumn(int column, PitchCollection pitchFilter) {
    // check limits
    if (column > (strings.size() - 1)) {
      throw new IllegalArgumentException();
    }
    
    // get column
    Pitch[] targetPitchColumn = new Pitch[numberFrets];
    ArrayList<Pitch> tempPtr = strings.get(column);
    
    for (int index = 0; index < numberFrets; index++) {
      Pitch currentPitch = tempPtr.get(index);
      
      if (pitchFilter.contains(currentPitch)){
        targetPitchColumn[index] = currentPitch;
      }
      else {
        targetPitchColumn[index] = null;
      }
    }

    return targetPitchColumn;
  }

}
