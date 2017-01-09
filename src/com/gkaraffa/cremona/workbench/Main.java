package com.gkaraffa.cremona.workbench;

public class Main {

	public Main() {
	}

	public static void main(String[] args) {
		try {

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}

/*
 * try {
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
			
			Guitar g = new Guitar();
			System.out.println(g.displayToneSeries(new DiatonicScaleFactory().createScale(DiatonicScaleFactory.ionianPattern, Tone.C)));
			
			Keyboard k = new Keyboard();
			System.out.println(k.toCSV());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
 */
