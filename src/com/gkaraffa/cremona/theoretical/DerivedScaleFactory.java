package com.gkaraffa.cremona.theoretical;

public class DerivedScaleFactory extends ScaleFactory {

  public DerivedScaleFactory() {
  }

  @Override
  public Scale createScale(ScalarIntervalPattern scalarIntervalPattern, Tone key)
      throws IllegalArgumentException {

    ScaleQuality scaleQuality = evaluateScaleQuality(scalarIntervalPattern);
    Tone[] tones = this.createToneArray(scalarIntervalPattern, key);

    return new DerivedScale(key.getText() + " " + scalarIntervalPattern.getText(), tones,
        scaleQuality);
  }

  @Override
  protected ScaleQuality evaluateScaleQuality(ScalarIntervalPattern scalarIntervalPattern) {
    Interval thirdInterval = scalarIntervalPattern.getIntervalByLocation(1);
    Interval fifthInterval = scalarIntervalPattern.getIntervalByLocation(3);
    ScaleQuality scaleQuality = null;

    switch (thirdInterval) {
      case MINOR_THIRD:
        if (fifthInterval == Interval.DIMINISHED_FIFTH) {
          scaleQuality = ScaleQuality.DIMINISHED;
        }
        else {
          scaleQuality = ScaleQuality.MINOR;
        }
        break;

      case MAJOR_THIRD:
        if (fifthInterval == Interval.AUGMENTED_FIFTH) {
          scaleQuality = ScaleQuality.AUGMENTED;
        }
        else {
          scaleQuality = ScaleQuality.MAJOR;
        }
        break;

      default:
        scaleQuality = ScaleQuality.UNDEFINED;
        throw new IllegalArgumentException();
    }

    return scaleQuality;
  }

  @Override
  protected boolean validateInputPattern(ScalarIntervalPattern scalarIntervalPattern) {
    return true;
  }
}
