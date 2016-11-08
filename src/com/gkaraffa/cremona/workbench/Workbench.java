package com.gkaraffa.cremona.workbench;

import com.gkaraffa.cremona.theoretical.*;

public class Workbench {

	public Workbench() {
	}

	public static void main(String[] args) {
		ScaleFactory sF = new DiatonicScaleFactory();
		Scale sampleScale = sF.createScale(StepPattern.ionianPattern, Tone.C);
	
		sampleScale.getTone(-1);
		int ceiling = sampleScale.getSize();
		for (int i = 0; i < ceiling * 2; i++){
			System.out.println(sampleScale.getTone(i));
		}
	}
}
