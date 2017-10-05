package com.gkaraffa.cremona.instrument;

public abstract class InstrumentViewFactory {

  public InstrumentViewFactory() {}

  public abstract InstrumentView createInstrumentView();

  public abstract InstrumentView createInstrumentView(InstrumentViewParameters iVP);

}
