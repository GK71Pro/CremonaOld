package com.gkaraffa.cremona.workbench;

import com.gkaraffa.cremona.theoretical.*;

public class Workbench {

	public Workbench() {
	}

	public static void main(String[] args) {
		try {
			ScaleFactory sF = new DiatonicScaleFactory();
			Scale s = sF.createScale(DiatonicScaleFactory.melodicMinorPattern, Tone.A);
			System.out.println(s);

			for (Tone t : s) {
				System.out.println(t);
			}

			System.out.println();

			if (s instanceof Harmonizable) {
				Harmonizable h = (Harmonizable) s;
				ChordFactory cF = new TriadFactory();
				
				for (int i = 1; i <= 7; i++){
					Chord c = cF.createChord(h, i);
					System.out.println(c);
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
