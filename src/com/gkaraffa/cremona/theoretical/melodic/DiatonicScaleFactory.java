package com.gkaraffa.cremona.theoretical.melodic;

import com.gkaraffa.cremona.theoretical.*;
import com.gkaraffa.cremona.theoretical.harmonic.Interval;

public class DiatonicScaleFactory extends ScaleFactory {

	public DiatonicScaleFactory() {
	}

	@Override
	public Scale createScale(StepPattern stepPattern, Tone key)
			throws IllegalArgumentException {
		if (!validateInputPattern(stepPattern)) {
			throw new IllegalArgumentException("Input pattern is invalid.");
		}

		MelodicTonality tonality = evaluateTonality(stepPattern);
		Tone[] tones = this.createToneArray(stepPattern, key);

		return new DiatonicScale(key.getText() + " " + stepPattern.getText(), tones, tonality);
	}

	private MelodicTonality evaluateTonality(StepPattern stepPattern) {
		Interval thirdInterval = Interval
				.intToInterval(stepPattern.getStepUnit(0).getDistance()
						+ stepPattern.getStepUnit(1).getDistance());

		Interval fifthInterval = Interval
				.intToInterval(stepPattern.getStepUnit(0).getDistance()
						+ stepPattern.getStepUnit(1).getDistance()
						+ stepPattern.getStepUnit(2).getDistance()
						+ stepPattern.getStepUnit(3).getDistance());

		MelodicTonality tonality = null;

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

	@Override
	protected Tone[] createToneArray(StepPattern stepPattern, Tone key) {
		int toneCount = stepPattern.getSize();
		Tone[] tones = new Tone[toneCount];

		tones[0] = key;
		
		for (int index = 1; index < toneCount; index++) {
			Tone cur = TonalSpectrum.traverseDistance(tones[index - 1],
					stepPattern.getStepUnit(index - 1).getDistance());
			tones[index] = cur;
		}
		
		return tones;
	}

	@Override
	protected boolean validateInputPattern(StepPattern stepPattern) {
		int stepCount = stepPattern.getSize();
		
		if (stepCount != 7) {
			return false;
		}

		for (int i = 0; i < stepPattern.getSize(); i++) {
			if (stepPattern.getStepUnit(i).getDistance() > 2) {
				return false;
			}
		}
		
		return true;
	}

	public static StepPattern ionianPattern = new StepPattern("Ionian",
			"W,W,H,W,W,W,H");
	public static StepPattern dorianPattern = new StepPattern("Dorian",
			"W,H,W,W,W,H,W");
	public static StepPattern phrygianPattern = new StepPattern("Phrygian",
			"H,W,W,W,H,W,W");
	public static StepPattern lydianPattern = new StepPattern("Lydian",
			"W,W,W,H,W,W,H");
	public static StepPattern mixolydianPattern = new StepPattern("Mixolydian",
			"W,W,H,W,W,H,W");
	public static StepPattern aeolianPattern = new StepPattern("Aeolian",
			"W,H,W,W,H,W,W");
	public static StepPattern locrianPattern = new StepPattern("Locrian",
			"H,W,W,H,W,W,W");

}