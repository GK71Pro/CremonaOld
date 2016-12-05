package com.gkaraffa.cremona.theoretical;

public class DiatonicScaleFactory extends ScaleFactory {

	public DiatonicScaleFactory() {
	}

	@Override
	public Scale createScale(IntervalPattern intervalPattern, Tone key)
			throws IllegalArgumentException {
		if (!validateInputPattern(intervalPattern)) {
			throw new IllegalArgumentException("Input pattern is invalid.");
		}

		ScaleQuality scaleQuality = evaluateScaleQuality(intervalPattern);
		Tone[] tones = this.createToneArray(intervalPattern, key);

		return new DiatonicScale(key.getText() + " " + intervalPattern.getText(),
				tones, scaleQuality);
	}

	private ScaleQuality evaluateScaleQuality(IntervalPattern intervalPattern) {
		Interval thirdInterval = intervalPattern.getInterval(1);
		Interval fifthInterval = intervalPattern.getInterval(3);
		ScaleQuality scaleQuality = null;

		System.out.println(thirdInterval);

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
				throw new IllegalArgumentException();
		}

		return scaleQuality;
	}

	private Tone[] createToneArray(IntervalPattern intervalPattern, Tone key) {
		int toneCount = intervalPattern.getSize() + 1;
		Tone[] tones = new Tone[toneCount];

		tones[0] = key;

		for (int index = 1; index < toneCount; index++) {
			Tone cur = TonalSpectrum.traverseDistance(tones[0],
					intervalPattern.getInterval(index - 1).getHalfSteps());
			tones[index] = cur;
		}

		return tones;
	}

	private boolean validateInputPattern(IntervalPattern intervalPattern) {
		int stepCount = intervalPattern.getSize();

		if (stepCount != 6) {
			return false;
		}

		return true;
	}

	
	public static IntervalPattern ionianPattern = new IntervalPattern("Ionian",
			"M2,M3,P4,P5,M6,M7");
	public static IntervalPattern dorianPattern = new IntervalPattern("Dorian",
			"M2,m3,P4,P5,M6,m7");
	public static IntervalPattern phrygianPattern = new IntervalPattern(
			"Phrygian", "m2,m3,P4,P5,m6,m7");
	public static IntervalPattern lydianPattern = new IntervalPattern("Lydian",
			"M2,M3,A4,P5,M6,M7");
	public static IntervalPattern mixolydianPattern = new IntervalPattern(
			"Mixolydian", "M2,M3,P4,P5,M6,m7");
	public static IntervalPattern aeolianPattern = new IntervalPattern("Aeolian",
			"M2,m3,P4,P5,m6,m7");
	public static IntervalPattern locrianPattern = new IntervalPattern("Locrian",
			"m2,m3,P4,d5,m6,m7");
	public static IntervalPattern harmonicMinorPattern = new IntervalPattern("Harmonic Minor",
			"M2,m3,P4,P5,m6,M7");
	public static IntervalPattern melodicMinorPattern = new IntervalPattern("Melodic Minor",
			"M2,m3,P4,P5,M6,M7");
	
	


}