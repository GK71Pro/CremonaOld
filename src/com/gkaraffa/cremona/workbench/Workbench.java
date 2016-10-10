package com.gkaraffa.cremona.workbench;

import com.gkaraffa.cremona.theoretical.*;

public class Workbench {

	public Workbench() {
	}

	public static void main(String[] args) {
		ScaleFactory sF = new DiatonicScaleFactory();
		Scale cIonian = sF.createScale(StepPattern.ionianPattern, Tone.C);
		Tone[] tones = cIonian.getTones();
		
		for (Tone tone : tones) {
			System.out.println(tone);
		}
		
		System.out.println(cIonian.getClass().getName());
	}
}
