package com.gkaraffa.cremona.workbench;

import com.gkaraffa.cremona.theoretical.*;

public class Workbench {

	public Workbench() {
	}

	public static void main(String[] args) {
		try {
			ScaleFactory sF = new PentatonicScaleFactory();
			Scale s = sF.createScale(PentatonicScaleFactory.pentatonicMajorPattern, Tone.C);
			System.out.println(s + ", " + "a " + s.getScaleQuality() + " scale.");

			for (Tone t : s) {
				System.out.println(t);
			}

			System.out.println();

			if (s instanceof Harmonizable) {
				Harmonizable h = (Harmonizable) s;
				ChordFactory cF = new TriadFactory();
				
				/*
				for (int i = 1; i <= 7; i++){
					Chord c = cF.createChord(h, i);
					System.out.println(c);
				}
				*/
				
				for (int i = 0; i <= 6; i++){
					Chord c = cF.createChord(h, IntervalNumber.integerToIntervalNumber(i));
					System.out.println(c);
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
