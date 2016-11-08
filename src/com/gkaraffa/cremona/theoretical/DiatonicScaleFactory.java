package com.gkaraffa.cremona.theoretical;

public class DiatonicScaleFactory extends ScaleFactory {

	public DiatonicScaleFactory() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Scale createScale(StepPattern stepPattern, Tone key) {
		Tonality tonality = evaluateTonality(stepPattern);
		Tone[] tones = this.createToneArray(stepPattern, key);

		return new DiatonicScale(stepPattern.getName(), tones, tonality);
	}

	private Tonality evaluateTonality(StepPattern stepPattern) {
		Interval thirdInterval = Interval
				.intToInterval(stepPattern.getStepUnit(0).getSteps()
						+ stepPattern.getStepUnit(1).getSteps());

		Interval fifthInterval = Interval
				.intToInterval(stepPattern.getStepUnit(0).getSteps()
						+ stepPattern.getStepUnit(1).getSteps()
						+ stepPattern.getStepUnit(2).getSteps()
						+ stepPattern.getStepUnit(3).getSteps());

		Tonality tonality = null;

		switch (thirdInterval) {
			case MINOR_THIRD:
				if (fifthInterval == Interval.DIMINISHED_FIFTH) {
					tonality = Tonality.DIMINISHED;
				}
				else {
					tonality = Tonality.MINOR;
				}
				break;

			case MAJOR_THIRD:
				if (fifthInterval == Interval.AUGMENTED_FIFTH) {
					tonality = Tonality.AUGMENTED;
				}
				else {
					tonality = Tonality.MAJOR;
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
		int toneCount = stepPattern.size();
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

Tonality tonality = null;

switch (thirdInterval) {
	case MINOR_THIRD:
		if (fifthInterval == Interval.DIMINISHED_FIFTH){
			tonality = Tonality.DIMINISHED;
		}
		else{
			tonality = Tonality.MINOR;
		}
		break;

	case MAJOR_THIRD:
		if (fifthInterval == Interval.AUGMENTED_FIFTH){
			tonality = Tonality.AUGMENTED;
		}
		else{
			tonality = Tonality.MAJOR;
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
