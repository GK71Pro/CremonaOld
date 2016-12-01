package com.gkaraffa.cremona.workbench;

import com.gkaraffa.cremona.theoretical.*;
import com.gkaraffa.cremona.theoretical.melodic.*;
import com.gkaraffa.cremona.theoretical.harmonic.*;

public class Workbench {

	public Workbench() {
	}

	public static void main(String[] args) {
		try {
			ScaleFactory sF = new DiatonicScaleFactory();
			Scale s = sF.createScale(DiatonicScaleFactory.locrianPattern, Tone.B);
			System.out.println(s);

			for (Tone t : s) {
				System.out.println(t);
			}

			System.out.println();

			if (s instanceof Harmonizable) {
				Harmonizable h = (Harmonizable) s;
				ChordFactory cF = new TriadFactory();
				Chord c = cF.createChord(h, 1);
				System.out.println(c);

				for (Tone t : c) {
					System.out.println(t);
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
