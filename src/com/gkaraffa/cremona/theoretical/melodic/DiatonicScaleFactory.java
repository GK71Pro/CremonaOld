package com.gkaraffa.cremona.theoretical.melodic;

import com.gkaraffa.cremona.theoretical.*;

public class DiatonicScaleFactory extends ScaleFactory {

	public DiatonicScaleFactory() {
	}

	@Override
	public Scale createScale(IntervalPattern intervalPattern, Tone key)
			throws IllegalArgumentException {
		if (!validateInputPattern(intervalPattern)) {
			throw new IllegalArgumentException("Input pattern is invalid.");
		}

		MelodicTonality tonality = evaluateTonality(intervalPattern);
		Tone[] tones = this.createToneArray(intervalPattern, key);

		return new DiatonicScale(key.getText() + " " + intervalPattern.getText(),
				tones, tonality);
	}

	private MelodicTonality evaluateTonality(IntervalPattern intervalPattern) {
		Interval thirdInterval = intervalPattern.getInterval(1);
		Interval fifthInterval = intervalPattern.getInterval(3);
		MelodicTonality tonality = null;

		System.out.println(thirdInterval);

		switch (thirdInterval) {
			case MINOR_THIRD:
				if (fifthInterval == Interval.AUGMENTED_FOURTH_DIMINISHED_FIFTH) {
					tonality = MelodicTonality.DIMINISHED;
				}
				else {
					tonality = MelodicTonality.MINOR;
				}
				break;

			case MAJOR_THIRD:
				if (fifthInterval == Interval.AUGMENTED_FIFTH_MINOR_SIXTH) {
					tonality = MelodicTonality.AUGMENTED;
				}
				else {
					tonality = MelodicTonality.MAJOR;
				}
				break;

			default:
				throw new IllegalArgumentException();
		}

		return tonality;
	}

	private Tone[] createToneArray(IntervalPattern intervalPattern, Tone key) {
		int toneCount = intervalPattern.getSize() + 1;
		Tone[] tones = new Tone[toneCount];

		tones[0] = key;

		for (int index = 1; index < toneCount; index++) {
			Tone cur = TonalSpectrum.traverseDistance(tones[0],
					intervalPattern.getInterval(index - 1).getOrdinal());
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
			"2,3,4,5,6/D7,7");
	public static IntervalPattern dorianPattern = new IntervalPattern("Dorian",
			"2,M3,4,5,6/D7,M7");
	public static IntervalPattern phrygianPattern = new IntervalPattern(
			"Phrygian", "M2,M3,4,5,A5/M6,M7");
	public static IntervalPattern lydianPattern = new IntervalPattern("Lydian",
			"2,3,A4/D5,5,6/D7,7");
	public static IntervalPattern mixolydianPattern = new IntervalPattern(
			"Mixolydian", "2,3,4,5,6/D7,M7");
	public static IntervalPattern aeolianPattern = new IntervalPattern("Aeolian",
			"2,M3,4,5,A5/M6,M7");
	public static IntervalPattern locrianPattern = new IntervalPattern("Locrian",
			"M2,M3,4,A4/D5,A5/M6,M7");
	public static IntervalPattern harmonicMinorPattern = new IntervalPattern("Harmonic Minor",
			"2,M3,4,5,A5/M6,7");
	
	


}