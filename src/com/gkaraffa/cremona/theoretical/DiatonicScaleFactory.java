package com.gkaraffa.cremona.theoretical;

import java.util.*;

public class DiatonicScaleFactory extends ScaleFactory {

	public DiatonicScaleFactory() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Scale createScale(StepPattern stepPattern, Tone key) {
		Interval thirdInterval = Interval
				.intToInterval(stepPattern.getStepUnit(0).getSteps()
						+ stepPattern.getStepUnit(1).getSteps());

		Tonality tonality = null;
		switch (thirdInterval) {
			case MINOR_THIRD:
				tonality = Tonality.MINOR;
				break;
			case MAJOR_THIRD:
				tonality = Tonality.MAJOR;
				break;
			default:
				throw new IllegalArgumentException();
		}

		/*
		List<Tone> tones = new ArrayList<Tone>();
		tones.add(key);
		for (int index = 1; index < stepPattern.size(); index++) {
			tones.add(
					TonalSpectrum.traverseDistance(tones.get(index - 1),
							stepPattern.getStepUnit(index - 1).steps)); 
		}
		*/
		
		
		DiatonicScale diatonicScale = new DiatonicScale(stepPattern.getName(),
				tonality);
		diatonicScale.addTone(key);

		for (int index = 1; index < stepPattern.size(); index++) {
			diatonicScale.addTone(
					TonalSpectrum.traverseDistance(diatonicScale.getTone(index - 1),
							stepPattern.getStepUnit(index - 1).steps)); 
		}

		// TODO Auto-generated method stub
		return diatonicScale;
	}

}
