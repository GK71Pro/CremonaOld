package com.gkaraffa.cremona.workbench;

import com.gkaraffa.cremona.theoretical.*;

public class Workbench {

	public Workbench() {
	}

	public static void main(String[] args) {

		try {
			//Chord c = new Triad(Tone.C, Tone.E, Tone.G, Tonality.MAJOR,
			//		Tone.C.getText() + " " + Tonality.MAJOR.getText());
			/*
			Triad c = new Triad();
			c.setFirst(Tone.C);
			c.setThird(Tone.E);
			c.setFifth(Tone.G);
			c.setTonality(Tonality.MAJOR);
			c.setName(Tone.C.getText() + " " + Tonality.MAJOR.getText());
			c.setDefined(true);
			System.out.println(c);
			System.out.println(c.getFirst());
			System.out.println(c.getThird());
			System.out.println(c.getFifth());

			System.out.println(Tone.C);*/
			
			Interval interval = TonalSpectrum.measureInterval(Tone.E, Tone.C);
			System.out.println(interval);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}

/*
Note n = new Note(new Pitch(Tone.C, 1),
		new Duration(new Fraction(1, 2)));
System.out.println(n);
*/