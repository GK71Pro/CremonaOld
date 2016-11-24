package com.gkaraffa.cremona.theoretical;

import com.gkaraffa.cremona.theoretical.harmony.Interval;

public class DiatonicScaleFactory extends ScaleFactory {

	public DiatonicScaleFactory() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Scale createScale(StepPattern stepPattern, Tone key)
			throws IllegalArgumentException {
		if (!validateInputPattern(stepPattern)) {
			throw new IllegalArgumentException("Input pattern is invalid.");
		}

		MelodicTonality tonality = evaluateTonality(stepPattern);
		Tone[] tones = this.createToneArray(stepPattern, key);

		return new DiatonicScale(stepPattern.getText(), tones, tonality);
	}

	private MelodicTonality evaluateTonality(StepPattern stepPattern) {
		Interval thirdInterval = Interval
				.intToInterval(stepPattern.getStepUnit(0).getSteps()
						+ stepPattern.getStepUnit(1).getSteps());

		Interval fifthInterval = Interval
				.intToInterval(stepPattern.getStepUnit(0).getSteps()
						+ stepPattern.getStepUnit(1).getSteps()
						+ stepPattern.getStepUnit(2).getSteps()
						+ stepPattern.getStepUnit(3).getSteps());

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
		// TODO Auto-generated method stub
		int toneCount = stepPattern.getSize();
		Tone[] tones = new Tone[toneCount];

		// LinkedHashSet<Tone> lsh = new LinkedHashSet<Tone>();
		// lsh.add(key);
		tones[0] = key;
		// Tone last = key;

		for (int index = 1; index < toneCount; index++) {
			Tone cur = TonalSpectrum.traverseDistance(tones[index - 1],
					stepPattern.getStepUnit(index - 1).steps);

			tones[index] = cur;

			/*
			lsh.add(cur);
			last = cur;
			*/
		}
		return tones;
	}

	@Override
	protected boolean validateInputPattern(StepPattern stepPattern) {
		// check that there are 7 StepUnits
		int stepCount = stepPattern.getSize();
		if (stepCount != 7) {
			return false;
		}

		// check that there are no steps greater than whole
		for (int i = 0; i < stepPattern.getSize(); i++) {
			if (stepPattern.getStepUnit(i).getSteps() > 2) {
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

/*
public Scale createScale(StepPattern stepPattern, Tone key){
// measure interval of third
Interval thirdInterval = Interval
		.intToInterval(stepPattern.getStepUnit(0).getSteps()
				+ stepPattern.getStepUnit(1).getSteps());

Interval fifthInterval = Interval
		.intToInterval(stepPattern.getStepUnit(0).getSteps()
				+ stepPattern.getStepUnit(1).getSteps()
				+ stepPattern.getStepUnit(2).getSteps()
				+ stepPattern.getStepUnit(3).getSteps()
				);

MelodicTonality tonality = null;

switch (thirdInterval) {
	case MINOR_THIRD:
		if (fifthInterval == Interval.DIMINISHED_FIFTH){
			tonality = MelodicTonality.DIMINISHED;
		}
		else{
			tonality = MelodicTonality.MINOR;
		}
		break;

	case MAJOR_THIRD:
		if (fifthInterval == Interval.AUGMENTED_FIFTH){
			tonality = MelodicTonality.AUGMENTED;
		}
		else{
			tonality = MelodicTonality.MAJOR;
		}
		break;
		
	default:
		throw new IllegalArgumentException();
}

DiatonicScale diatonicScale = new DiatonicScale(stepPattern.getName(),
		tonality);
*/
/*
LinkedHashSet<Tone> lsh = new LinkedHashSet<Tone>();
lsh.add(key);
Tone last = key;

for (int index = 1; index < stepPattern.size(); index++) {
	Tone cur = TonalSpectrum.traverseDistance(last, 
			stepPattern.getStepUnit(index - 1).steps);
	lsh.add(cur);
	last = cur;
}

diatonicScale.setTones(lsh);
}
*/
