package com.gkaraffa.cremona.workbench;

import com.gkaraffa.cremona.theoretical.*;

public class Workbench {

	public Workbench() {
	}

	public static void main(String[] args) {
		try {
			ChordFactory cF = new TriadFactory();
			Chord c = cF.createChord(TriadFactory.suspendedFourthPattern, Tone.C);
			System.out.println(c);

			for (Tone t : c) {
				System.out.println(t);
			}

			for (Integer i : c.getDegreeSet()) {
				System.out.println(i);
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
