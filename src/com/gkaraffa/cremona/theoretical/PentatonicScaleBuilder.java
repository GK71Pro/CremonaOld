package com.gkaraffa.cremona.theoretical;

public class PentatonicScaleBuilder extends ScaleBuilder {

	public PentatonicScaleBuilder() {
	}

	@Override
	public Scale createScale(IntervalPattern intervalPattern, Tone key)
			throws IllegalArgumentException {
		if (!validateInputPattern(intervalPattern)) {
			throw new IllegalArgumentException("Input pattern is invalid.");
		}

		ScaleQuality scaleQuality = evaluateScaleQuality(intervalPattern);
		Tone[] tones = this.createToneArray(intervalPattern, key);

		return new PentatonicScale(key.getText() + " " + intervalPattern.getText(),
				tones, scaleQuality);	
	}
	
	@Override
	protected ScaleQuality evaluateScaleQuality(IntervalPattern intervalPattern) {
		Interval thirdInterval = intervalPattern.getIntervalByIntervalNumber(IntervalNumber.THIRD);
		ScaleQuality scaleQuality = null;

		switch (thirdInterval) {
			case MINOR_THIRD:
				scaleQuality = ScaleQuality.MINOR;
				break;

			case MAJOR_THIRD:
				scaleQuality = ScaleQuality.MAJOR;
				break;

			default:
				throw new IllegalArgumentException();
		}

		return scaleQuality;
	}

	@Override
	protected boolean validateInputPattern(IntervalPattern intervalPattern) {
		return true;
	}	
	
	public static IntervalPattern pentatonicMajorPattern = new IntervalPattern("Pentatonic Major",
			"M2,M3,P5,M6");
	public static IntervalPattern pentatonicMinorPattern = new IntervalPattern("Pentatonic Minor",
			"m3,P4,P5,m7");
}
