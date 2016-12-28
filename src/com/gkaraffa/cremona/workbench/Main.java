package com.gkaraffa.cremona.workbench;

import com.gkaraffa.cremona.theoretical.Chord;
import com.gkaraffa.cremona.theoretical.ChordFactory;
import com.gkaraffa.cremona.theoretical.DiatonicScaleFactory;
import com.gkaraffa.cremona.theoretical.Harmonizable;
import com.gkaraffa.cremona.theoretical.IntervalNumber;
import com.gkaraffa.cremona.theoretical.Scale;
import com.gkaraffa.cremona.theoretical.ScaleFactory;
import com.gkaraffa.cremona.theoretical.Tone;
import com.gkaraffa.cremona.theoretical.ToneCollection;
import com.gkaraffa.cremona.theoretical.TriadFactory;

public class Main {

	public Main() {
	}

	public static void main(String[] args) {
		System.out.println("This is the hotfix");
		try {
			ScaleFactory sF = new DiatonicScaleFactory();
			Scale cScale = sF.createScale(DiatonicScaleFactory.ionianPattern, Tone.C);
			Scale gScale = sF.createScale(DiatonicScaleFactory.ionianPattern, Tone.G);
			System.out.println(cScale + ", " + "a " + cScale.getScaleQuality() + " scale.");

			for (Tone t : cScale) {
				System.out.println(t);
			}

			System.out.println();

			if (gScale instanceof Harmonizable) {
				Harmonizable h = (Harmonizable) gScale;
				ChordFactory cF = new TriadFactory();
				
				for (int i = 0; i <= 6; i++){
					Chord c = cF.createChord(h, IntervalNumber.integerToIntervalNumber(i));
					System.out.println(c + " " + cScale.contains(c));
				}
			}
						
			ToneCollection tC = cScale.intersection(gScale);
			for(Tone tone: tC){
				System.out.println(tone);
			}
			System.out.println(tC);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
