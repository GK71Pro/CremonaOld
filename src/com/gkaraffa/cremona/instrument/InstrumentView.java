package com.gkaraffa.cremona.instrument;

import com.gkaraffa.cremona.theoretical.ToneCollection;

public abstract class InstrumentView {

  public InstrumentView() {}

  public abstract String getTextView();

  public abstract String getTextView(ToneCollection toneCollection);

  public abstract String getCSVView();

  public abstract String getCSVView(ToneCollection toneCollection);

  @Override
  public String toString() {
    return getTextView();
  }

}
