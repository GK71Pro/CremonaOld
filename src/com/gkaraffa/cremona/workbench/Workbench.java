package com.gkaraffa.cremona.workbench;

import com.gkaraffa.cremona.theoretical.*;
import com.gkaraffa.cremona.theoretical.melodic.*;

public class Workbench {

	public Workbench() {
	}

	public static void main(String[] args) {
		try {
			ScaleFactory sF = new DiatonicScaleFactory();
			Scale s = sF.createScale(DiatonicScaleFactory.ionianPattern, Tone.C);
			
			for(Tone t: s){
				System.out.println(t);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
