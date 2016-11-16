package com.gkaraffa.cremona.workbench;

import com.gkaraffa.cremona.theoretical.*;

public class Workbench {

	public Workbench() {
	}

	public static void main(String[] args) {
		try {
			ScaleFactory sF = new DiatonicScaleFactory();
			ChordFactory cF = new TriadFactory();
			Scale sampleScale = sF.createScale(DiatonicScaleFactory.aeolianPattern, Tone.A);
			Chord sampleChord = cF.createChord(TriadFactory.suspendedFourthPattern, Tone.E);
			System.out.println(sampleChord);
			/*
			sampleScale.getTone(-1);
			*/

			/*
			int ceiling = sampleScale.getSize();
			for (int i = 0; i < ceiling * 2; i++){
				System.out.println(sampleScale.getTone(i));
			}
			*/

			/*
			Tone[] copy = sampleScale.getToneArrayCopy();
			for (Tone cur: copy){
				System.out.println(cur);
			}
			*/

			/*
			System.out.println(sampleScale.getSpellingString());
			*/

			/*
			System.out.println(sampleScale.contains(Tone.C));
			
			System.out.println(sampleScale.contains(Tone.CSHARP_DFLAT));
			
			System.out.println(sampleScale.getPosition(Tone.D));
			
			System.out.println(sampleScale.getPosition(Tone.CSHARP_DFLAT));
			*/

			for (Tone tone : sampleScale) {
				System.out.println(tone.getText());
			}
			
			for (Tone tone : sampleChord) {
				System.out.println(tone.getText());
			}

			Harmonizable h = (Harmonizable) sampleScale;
			System.out.println(h.getThird(5));
			
			System.out.println(cF.createChord(h, 1));
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
