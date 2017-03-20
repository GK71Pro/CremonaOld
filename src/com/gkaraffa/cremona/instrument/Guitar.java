package com.gkaraffa.cremona.instrument;

import java.util.ArrayList;

import com.gkaraffa.cremona.theoretical.TonalSpectrum;
import com.gkaraffa.cremona.theoretical.Tone;
import com.gkaraffa.cremona.theoretical.ToneCollection;

public class Guitar {
  private ArrayList<ArrayList<Tone>> strings = new ArrayList<ArrayList<Tone>>();
  private int numberFrets;

  public Guitar() {
    numberFrets = 24;
    strings.add(createStringNotes(Tone.E));
    strings.add(createStringNotes(Tone.A));
    strings.add(createStringNotes(Tone.D));
    strings.add(createStringNotes(Tone.G));
    strings.add(createStringNotes(Tone.B));
    strings.add(createStringNotes(Tone.E));
  }

  private ArrayList<Tone> createStringNotes(Tone tone) {
    ArrayList<Tone> stringTones = new ArrayList<Tone>();
    int index = 0;

    do {
      stringTones.add(tone);
      tone = TonalSpectrum.traverseDistance(tone, 1);
      index++;
    }
    while (index <= numberFrets);

    return stringTones;
  }

  @Override
  public String toString() {
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

  public Tone getTone(int numString, int numFret) {
    return ((Tone) strings.get(numString).get(numFret));
  }

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

  public String displayToneSeries(ToneCollection subjectCollection) {
    StringBuilder sb = new StringBuilder();
    int numStrings = strings.size();

    for (int index = 0; index <= numberFrets; index++) {
      for (int subindex = 0; subindex < numStrings; subindex++) {
        Tone currentNote = getTone(subindex, index);
        if (subjectCollection.contains(currentNote)) {
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

}
