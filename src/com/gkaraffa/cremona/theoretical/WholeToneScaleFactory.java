package com.gkaraffa.cremona.theoretical;

public class WholeToneScaleFactory extends SymmetricScaleFactory {

  public WholeToneScaleFactory() {
    // TODO Auto-generated constructor stub
  }

  @Override
  public Scale createScale(ScalarIntervalPattern scalarIntervalPattern, Tone key)
      throws IllegalArgumentException {
    if (!(validateInputPattern(scalarIntervalPattern))) {
      throw new IllegalArgumentException("Incorrect Pattern for this Factory.");
    }

    ScaleQuality scaleQuality = ScaleQuality.WHOLE_TONE;
    Tone tones[] = this.createToneArray(scalarIntervalPattern, key);

    return new WholeToneScale(key.getText() + " " + scalarIntervalPattern.getText(), tones,
        scaleQuality);
  }

  @Override
  protected ScaleQuality evaluateScaleQuality(ScalarIntervalPattern scaleIntervalPattern) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  protected boolean validateInputPattern(ScalarIntervalPattern scaleIntervalPattern) {
    // TODO Auto-generated method stub
    if (!(scaleIntervalPattern.getText().contains("Whole Tone"))) {
      return false;
    }
    return true;
  }


}
