package com.gkaraffa.cremona.theoretical;

public class DiatonicScale extends Scale implements Harmonizable {

  public DiatonicScale(String name, Tone[] tones, ScaleQuality scaleQuality) {
    super(name, tones, scaleQuality);
  }

  private int calculateLocation(int segment, int offset) {
    int location = segment + offset;
    int limit = IntervalNumber.EIGHTH.getPosition();

    if (location > limit) {
      location -= limit;
    }

    return location;
  }

  public Tone getToneAtRelativeInterval(IntervalNumber rootInterval,
      IntervalNumber offsetInterval) {
    return getTone(calculateLocation(rootInterval.getPosition(), offsetInterval.getPosition()));
  }

}
