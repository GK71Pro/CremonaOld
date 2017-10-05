package com.gkaraffa.cremona.instrument;

import java.util.ArrayList;

import com.gkaraffa.cremona.theoretical.Tone;
import com.gkaraffa.cremona.theoretical.ToneCollection;

public class GuitarView extends InstrumentView {
  private ArrayList<ArrayList<Tone>> strings = new ArrayList<ArrayList<Tone>>();
  private int numberFrets;


  public GuitarView(ArrayList<ArrayList<Tone>> strings, int numberFrets) {
    super();
    this.strings = strings;
    this.numberFrets = numberFrets;
  }

  @Override
  public String getTextView() {
    StringBuilder sb = new StringBuilder();
    int numStrings = strings.size();

    for (int index = 0; index <= numberFrets; index++) {
      sb.append(index);
      sb.append("\t");
      for (int subindex = 0; subindex < numStrings; subindex++) {
        ArrayList<Tone> currentString = (ArrayList<Tone>) strings.get(subindex);
        Tone currentTone = (Tone) currentString.get(index);
        sb.append(currentTone.toString());
        sb.append("\t");
      }
      sb.append("\n");
    }

    return (sb.toString());
  }

  @Override
  public String getTextView(ToneCollection toneCollection) {
    StringBuilder sb = new StringBuilder();
    int numStrings = strings.size();

    for (int index = 0; index <= numberFrets; index++) {
      sb.append(index);
      sb.append("\t");
      for (int subindex = 0; subindex < numStrings; subindex++) {
        ArrayList<Tone> currentString = (ArrayList<Tone>) strings.get(subindex);
        Tone currentTone = (Tone) currentString.get(index);
        if (toneCollection.contains(currentTone)) {
          sb.append(currentTone.toString());
        }
        else {
          sb.append(" ");
        }
        sb.append("\t");
      }
      sb.append("\n");
    }

    return (sb.toString());
  }

  public Tone getTone(int numString, int numFret) {
    return ((Tone) strings.get(numString).get(numFret));
  }

  @Override
  public String getCSVView() {
    StringBuilder sb = new StringBuilder();
    int numStrings = strings.size();

    for (int index = 0; index <= numberFrets; index++) {
      for (int subindex = 0; subindex < numStrings; subindex++) {
        Tone currentNote = getTone(subindex, index);
        sb.append(currentNote.toString());
        sb.append(",");
      }
      sb.append("\n");
    }
    return (sb.toString());
  }

  @Override
  public String getCSVView(ToneCollection toneCollection) {
    StringBuilder sb = new StringBuilder();
    int numStrings = strings.size();

    for (int index = 0; index <= numberFrets; index++) {
      for (int subindex = 0; subindex < numStrings; subindex++) {
        Tone currentNote = getTone(subindex, index);
        if (toneCollection.contains(currentNote)) {
          sb.append(currentNote.toString());
        }
        else {
          sb.append(" ");
        }
        sb.append(",");
      }
      sb.append("\n");
    }
    return (sb.toString());
  }
  
  /*
  public ArrayList<Tone> getGuitarList(ToneCollection collection) {
    ArrayList<Tone> al = new ArrayList<Tone>();
    int numStrings = strings.size();
  
    for (int index = 0; index <= numberFrets; index++) {
      for (int subindex = 0; subindex < numStrings; subindex++) {
        Tone currentTone = getTone(subindex, index);
        if (collection.contains(currentTone)) {
          al.add(currentTone);
        }
        else {
          al.add(null);
        }
      }
    }
  
    return (al);
  }
  */
}
