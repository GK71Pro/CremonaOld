package com.gkaraffa.cremona.workbench;

import com.gkaraffa.cremona.theoretical.*;

public class Workbench {

	public Workbench() {
	}

	public static void main(String[] args) {

		try {
			ScaleFactory scaleFactory = new DiatonicScaleFactory();
			Scale ionianScale = scaleFactory.createScale(StepPattern.ionianPattern, Tone.C);
			System.out.println(ionianScale);
			System.out.println(ionianScale.getTonality());
			System.out.println(ionianScale.getTone(6));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}

