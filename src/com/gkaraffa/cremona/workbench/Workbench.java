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

			for (int i = 1; i <= 7; i++){
				System.out.println(i + ": " + c.getToneByDegree(i));
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
