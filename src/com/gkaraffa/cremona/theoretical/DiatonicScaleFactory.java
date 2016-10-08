package com.gkaraffa.cremona.theoretical;

import java.util.*;

public class DiatonicScaleFactory extends ScaleFactory {

	public DiatonicScaleFactory() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Scale createScale(StepPattern stepPattern, Tone key) {
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

		return diatonicScale;
	}

}
