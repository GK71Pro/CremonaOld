package com.gkaraffa.cremona.instrument;

import java.util.ArrayList;

import com.gkaraffa.cremona.theoretical.TonalSpectrum;
import com.gkaraffa.cremona.theoretical.Tone;

public class GuitarViewFactory extends InstrumentViewFactory {

  public GuitarViewFactory() {
    super();
  }

  @Override
  public InstrumentView createInstrumentView() {
    int fretCount = 24;
    ArrayList<ArrayList<Tone>> guitarStrings = new ArrayList<ArrayList<Tone>>();
    
    guitarStrings.add(createStringNotes(Tone.E, fretCount));
    guitarStrings.add(createStringNotes(Tone.A, fretCount));
    guitarStrings.add(createStringNotes(Tone.D, fretCount));
    guitarStrings.add(createStringNotes(Tone.G, fretCount));
    guitarStrings.add(createStringNotes(Tone.B, fretCount));
    guitarStrings.add(createStringNotes(Tone.E, fretCount));

    return new GuitarView(guitarStrings, fretCount);
  }

  @Override
  public InstrumentView createInstrumentView(InstrumentViewParameters iVP) {
    int fretCount;
    ArrayList<Tone> parmOpenStringTones = new ArrayList<Tone>();

    if (iVP instanceof GuitarViewParameters) {
      GuitarViewParameters gVP = (GuitarViewParameters) iVP;
      fretCount = gVP.getNumberOfFrets();
      parmOpenStringTones = gVP.getOpenStringTones();
    }
    else {
      throw new IllegalArgumentException();
    }

    // build
    ArrayList<ArrayList<Tone>> guitarStrings = new ArrayList<ArrayList<Tone>>();
    int stringCount = parmOpenStringTones.size();
    for (int index = 0; index < stringCount; index++) {
      guitarStrings.add(createStringNotes(parmOpenStringTones.get(index), fretCount));
    }
    
    return new GuitarView(guitarStrings, fretCount);
  }

  private ArrayList<Tone> createStringNotes(Tone tone, int numberFrets) {
    ArrayList<Tone> stringTones = new ArrayList<Tone>();
    int index = 0;

    do {
      stringTones.add(tone);
      tone = TonalSpectrum.traverseDistance(tone, 1);
      index++;
    } while (index <= numberFrets);

    return stringTones;
  }
}
